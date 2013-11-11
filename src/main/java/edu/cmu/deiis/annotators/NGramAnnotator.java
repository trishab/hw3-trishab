package edu.cmu.deiis.annotators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.deiis.types.Answer;
import edu.cmu.deiis.types.NGram;
import edu.cmu.deiis.types.Question;
import edu.cmu.deiis.types.Sentence;
import edu.cmu.deiis.types.Token;

public class NGramAnnotator extends JCasAnnotator_ImplBase {

  public int N;

  /**
   * initialization includes reading the config parameter value of N
   */
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    super.initialize(aContext);
    // Get config. parameter values
    Integer N = (Integer) aContext.getConfigParameterValue("N");
    this.N = N;
  }

  /**
   * process function can annotate the ngrams in an sentence using split method. Then the
   * corresponded sentence stores the index of each ngrams it has.
   */
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    // get document text
    String docText = aJCas.getDocumentText();
    // Question
    FSIndex SentenceIndex = aJCas.getAnnotationIndex(Sentence.type);
    Iterator SentenceIter = SentenceIndex.iterator();
    while (SentenceIter.hasNext()) {
      Sentence sentence = (Sentence) SentenceIter.next();
      FSArray tokenArray = sentence.getTokenArray();
      FSArray ngramArray = new FSArray(aJCas, tokenArray.size() * this.N - this.N * (this.N - 1)
              / 2);
      sentence.setNgramArray(ngramArray);

      int ngramCount = 0;

      for (int gramSize = 1; gramSize < this.N + 1; gramSize++) {
        for (int startPosition = 0; startPosition < tokenArray.size() - gramSize + 1; startPosition++) {
          NGram annotation = new NGram(aJCas);
          // indert tokens
          FSArray array = new FSArray(aJCas, gramSize);
          annotation.setElements(array);
          for (int i = 0; i < gramSize; i++) {
            Token token = (Token) tokenArray.get(startPosition + i);
            array.set(i, token);
          }
          annotation.setElements(array);
          Token beginToken = (Token) tokenArray.get(startPosition);
          Token endToken = (Token) tokenArray.get(startPosition + gramSize - 1);
          annotation.setBegin(beginToken.getBegin());
          annotation.setEnd(endToken.getEnd());
          annotation.setConfidence(1.0f);
          annotation.setCasProcessorId(this.getClass().toString());
          annotation.setElementType(Token.class.toString());
          annotation.addToIndexes();
          sentence.setNgramArray(ngramCount++, annotation);
        }
      }
    }

  }

}
