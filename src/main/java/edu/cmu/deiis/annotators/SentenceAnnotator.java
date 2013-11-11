package edu.cmu.deiis.annotators;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;

import edu.cmu.deiis.types.Answer;
import edu.cmu.deiis.types.Question;
import edu.cmu.deiis.types.Sentence;


public class SentenceAnnotator extends JCasAnnotator_ImplBase {

  private Pattern mQuestionPattern = Pattern.compile("Q\\s(.+)\\?");

  /**
   * process function can annotate the sentences in an document using regular expression method.
   * Then the corresponded answer or question stores the index of each sentences it has.
   */
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    // get document text
    
    //for question
    FSIndex QuestionIndex = aJCas.getAnnotationIndex(Question.type);

    Iterator QuestionIter = QuestionIndex.iterator();

    while (QuestionIter.hasNext()) {
      Question question = (Question) QuestionIter.next();
      Sentence annotation = new Sentence(aJCas);
      annotation.setBegin(question.getBegin());
      annotation.setEnd(question.getEnd());
      annotation.setCasProcessorId(this.getClass().toString());
      annotation.setConfidence(1.0f);
      annotation.addToIndexes();

      FSArray sentenceArray = new FSArray(aJCas, 1);
      question.setSentenceArray(sentenceArray);
      question.setSentenceArray(0,annotation);
    }
    //for answer
    FSIndex AnswerIndex = aJCas.getAnnotationIndex(Answer.type);

    Iterator AnswerIter = AnswerIndex.iterator();

    while (AnswerIter.hasNext()) {
      Answer answer = (Answer) AnswerIter.next();
      Sentence annotation = new Sentence(aJCas);
      annotation.setBegin(answer.getBegin());
      annotation.setEnd(answer.getEnd());
      annotation.setCasProcessorId(this.getClass().toString());
      annotation.setConfidence(1.0f);
      annotation.addToIndexes();
      
      FSArray sentenceArray = new FSArray(aJCas, 1);
      answer.setSentenceArray(sentenceArray);
      answer.setSentenceArray(0,annotation);
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
