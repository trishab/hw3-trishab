package edu.cmu.deiis.annotators;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;

import edu.cmu.deiis.types.Answer;
import edu.cmu.deiis.types.AnswerScore;
import edu.cmu.deiis.types.NGram;
import edu.cmu.deiis.types.Question;
import edu.cmu.deiis.types.Sentence;
import edu.cmu.deiis.types.Token;

public class AnswerScoreAnnotator extends JCasAnnotator_ImplBase {

  /**
   * process function can annotate the score for a given answer. This score will be calculated by token
   * overlap or ngram overlap.
   */
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    // get document text
    String docText = aJCas.getDocumentText();
    FSIndex QuestionIndex = aJCas.getAnnotationIndex(Question.type);
    Iterator QuestionIter = QuestionIndex.iterator();
    while (QuestionIter.hasNext()) {
      Question question = (Question) QuestionIter.next();
      FSIndex AnswerIndex = aJCas.getAnnotationIndex(Answer.type);
      Iterator AnswerIter = AnswerIndex.iterator();
      while (AnswerIter.hasNext()) {
        Answer answer = (Answer) AnswerIter.next();
        AnswerScore annotation = new AnswerScore(aJCas);
        annotation.setBegin(answer.getBegin());
        annotation.setEnd(answer.getEnd());
        annotation.setAnswer(answer);
        if (answer.getIsCorrect()) {
          annotation.setGoldStandard(1);
        } else {
          annotation.setGoldStandard(0);
        }
        annotation.setScore(getNGramOverlap(question, answer));
        annotation.setConfidence(1.0f);
        annotation.setCasProcessorId(this.getClass().toString());
        annotation.addToIndexes();
      }
    }

  }

  public static float getNGramOverlap(Question question, Answer answer) {
    float score = 0;
    Sentence questionSentence = (Sentence) question.getSentenceArray().get(0);
    Sentence answerSentence = (Sentence) answer.getSentenceArray().get(0);
    FSArray questionNgramArray = questionSentence.getNgramArray();
    FSArray answerNgramArray = answerSentence.getNgramArray();

    int overlapNumber = 0;
    for (int i = 0; i < questionNgramArray.size(); i++) {
      boolean isfound = false;
      for (int j = 0; j < answerNgramArray.size(); j++) {

        NGram questionToken = (NGram) questionNgramArray.get(i);
        NGram answerToken = (NGram) answerNgramArray.get(j);

        if (questionToken.getCoveredText().equals(answerToken.getCoveredText())) {
          isfound = true;
          break;
        }
      }
      if (isfound) {
        overlapNumber++;
      }
    }
    score = (float) overlapNumber / (float) answerNgramArray.size();

    return score;
  }

  public static float getTokenOverlap(Question question, Answer answer) {
    float score = 0;

    Sentence questionSentence = (Sentence) question.getSentenceArray().get(0);
    Sentence answerSentence = (Sentence) answer.getSentenceArray().get(0);
    FSArray questionTokenArray = questionSentence.getTokenArray();
    FSArray answerTokenArray = answerSentence.getTokenArray();

    int overlapNumber = 0;
    for (int i = 0; i < questionTokenArray.size(); i++) {
      boolean isfound = false;
      for (int j = 0; j < answerTokenArray.size(); j++) {

        Token questionToken = (Token) questionTokenArray.get(i);
        Token answerToken = (Token) answerTokenArray.get(j);

        if (questionToken.getCoveredText().equals(answerToken.getCoveredText())) {
          isfound = true;
          break;
        }
      }
      if (isfound) {
        overlapNumber++;
      }
    }
    score = (float) overlapNumber / (float) answerTokenArray.size();

    return score;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
