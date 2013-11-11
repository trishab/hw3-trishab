package edu.cmu.deiis.annotators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.rmi.CORBA.Tie;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.deiis.types.AnswerScore;
import edu.cmu.deiis.types.Evaluation;
import edu.cmu.deiis.types.Question;

public class EvaluationAnnotator extends JCasAnnotator_ImplBase {

  public int N;
  

  /**
   * process function can sort the answer and get the Top-N precision
   */
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub

    Map<AnswerScore, Double> scoreMap = new HashMap<AnswerScore, Double>();
    // print question
    FSIndex QuestionIndex = aJCas.getAnnotationIndex(Question.type);
    Iterator QuestionIter = QuestionIndex.iterator();
    while (QuestionIter.hasNext()) {
      Question question = (Question) QuestionIter.next();
      System.out.println("Question: " + question.getCoveredText());
    }

    // sort answer
    FSIndex ScoreIndex = aJCas.getAnnotationIndex(AnswerScore.type);
    Iterator ScoreIter = ScoreIndex.iterator();
    while (ScoreIter.hasNext()) {
      AnswerScore score = (AnswerScore) ScoreIter.next();
      scoreMap.put(score, score.getScore());
    }
    ArrayList<Entry<AnswerScore, Double>> list = new ArrayList<Entry<AnswerScore, Double>>(
            scoreMap.entrySet());

    Collections.sort(list, new Comparator<Map.Entry<AnswerScore, Double>>() {
      public int compare(Map.Entry<AnswerScore, Double> o1, Map.Entry<AnswerScore, Double> o2) {
        return (int) (o2.getValue() * 100.0f - o1.getValue() * 100.0f);
      }
    });

    int precisionAtN = 0;
    
    for(int i=0;i<list.size();i++){
      if(list.get(i).getKey().getGoldStandard()==1){
        precisionAtN++;
      }
    }
    
    int correctAnswerCount = 0;
    // print answer
    for (int i = 0; i < list.size(); i++) {
      AnswerScore score = list.get(i).getKey();
      if (score.getGoldStandard() == 1.0f) {
        System.out.print("+ ");
        if (i < precisionAtN) {
          correctAnswerCount++;
        }
      } else {
        System.out.print("- ");
      }
      System.out.print(String.format("%.2f ", score.getScore()));
      System.out.println(score.getCoveredText());
    }
    // print precision

    String precision = String.format("%.2f ", (double) correctAnswerCount / (double) precisionAtN);
    System.out.println("Precision at " + precisionAtN + ": " + precision);

    Evaluation annotation = new Evaluation(aJCas);
    annotation.setBegin(0);
    annotation.setEnd(aJCas.getDocumentText().length());
    annotation.setN(this.N);
    annotation.setPerformance(Double.parseDouble(precision));
    annotation.setCasProcessorId(this.getClass().toString());
    annotation.setConfidence(1.0f);
    annotation.addToIndexes();
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
