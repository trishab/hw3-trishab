package edu.cmu.deiis.annotators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.deiis.types.Answer;
public class AnswerAnnotator extends JCasAnnotator_ImplBase {
	//public void initialize(UimaContext aContext) throws ResourceInitializationException{
		//super.initialize(aContext);
		//System.out.println("AnswerAnnotator Initialize In-------------------!");
private Pattern answerPattern= Pattern.compile("A\\s\\d\\s(.*).");


	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
	
//get document text
		String docText = aJCas.getDocumentText();
		// TODO Auto-generated method stub
		//System.out.println("AnswerAnnotator Process In-------------------!");
	Matcher	matcher = answerPattern.matcher(docText);
	while (matcher.find()){
		//find one - create annotation
	Answer answerAnnotation = new Answer(aJCas);
	answerAnnotation .setBegin(matcher.start()+4);
	answerAnnotation .setEnd(matcher.end());
	answerAnnotation .setConfidence(1.0d);
	answerAnnotation .setCasProcessorId(this.getClass().toString());

	char goldAnswerScore = matcher.group(0).charAt(2);
	 if (goldAnswerScore == '1'){
		 answerAnnotation .setIsCorrect(true);
	 }
	 else answerAnnotation .setIsCorrect(false);
	 answerAnnotation.addToIndexes();
	 }
	
	}


}