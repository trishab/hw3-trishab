package edu.cmu.deiis.annotators;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.deiis.types.Question;
import edu.cmu.deiis.types.Answer;

public class QuestionAnnotator extends JCasAnnotator_ImplBase {
	//public void initialize(UimaContext aContext) throws ResourceInitializationException{
		//super.initializes(aContext);
		//System.out.println("QuestionAnnotator Initialize In-------------------!");

	private Pattern questionPattern= Pattern.compile ("Q\\s(.*)?");



	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub
		//System.out.println("QuestionAnnotator Process In-------------------!");
	String docText = aJCas.getDocumentText();
	
	Matcher matcher = questionPattern.matcher(docText);
	while (matcher.find()){
		// found one - create annotation
		Question questionAnnotation = new Question(aJCas);
		questionAnnotation .setBegin(matcher.start()+2);
		questionAnnotation .setEnd(matcher.end());
		questionAnnotation .setConfidence(1.0d);
		questionAnnotation .setCasProcessorId(this.getClass().toString());
		questionAnnotation .addToIndexes();
		
	}
	
	}

}
