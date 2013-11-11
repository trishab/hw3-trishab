package edu.cmu.deiis.annotators;

import java.util.Iterator;
import java.util.regex.Pattern;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.deiis.types.Answer;
import edu.cmu.deiis.types.Question;
import edu.cmu.deiis.types.Sentence;
import edu.cmu.deiis.types.Token;

public class TokenAnnotator extends JCasAnnotator_ImplBase {
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
// TODO Auto-generated method stub
//get document text
	String docText = aJCas.getDocumentText();
	//Question
	int sentenceNumber = 0;

    FSIndex AnswerIndex = aJCas.getAnnotationIndex(Answer.type);

    Iterator AnswerIter = AnswerIndex.iterator();
    
    FSIndex questionIndex = aJCas.getAnnotationIndex(Question.type);

    Iterator questionIter = questionIndex.iterator();

    while (AnswerIter.hasNext()) {
      Answer answer = (Answer) AnswerIter.next();

      String[] tokenStrings = answer.getCoveredText().substring(0, answer.getCoveredText().length()-1).split("\\s");

      int position = 0;
      int begin = answer.getBegin();

      FSArray array = new FSArray(aJCas, tokenStrings.length);
      for (int i = 0; i < tokenStrings.length; i++) {
        Token annotation = new Token(aJCas);
        annotation.setBegin(begin);
        annotation.setEnd(begin + tokenStrings[i].length());
        annotation.setConfidence(1.0f);
        annotation.setCasProcessorId(this.getClass().toString());
        annotation.addToIndexes();
        position++;
        begin += tokenStrings[i].length() + 1;
        array.set(i, annotation);
      }
      sentenceNumber++;
      ((Sentence)(answer.getSentenceArray().get(0))).setTokenArray(array);
    }
    
    while (questionIter.hasNext()) {
        Question question = (Question) questionIter.next();

        String[] tokenStrings = question.getCoveredText().substring(0, question.getCoveredText().length()-1).split("\\s");

        int position = 0;
        int begin = question.getBegin();

        FSArray array = new FSArray(aJCas, tokenStrings.length);
        for (int i = 0; i < tokenStrings.length; i++) {
          Token annotation = new Token(aJCas);
          annotation.setBegin(begin);
          annotation.setEnd(begin + tokenStrings[i].length());
          annotation.setConfidence(1.0f);
          annotation.setCasProcessorId(this.getClass().toString());
          annotation.addToIndexes();
          position++;
          begin += tokenStrings[i].length() + 1;
          array.set(i, annotation);
        }
        sentenceNumber++;
        ((Sentence)(question.getSentenceArray().get(0))).setTokenArray(array);
      }
  }


	
	}
