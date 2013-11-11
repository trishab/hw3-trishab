package edu.cmu.deiis.annotators;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;

import org.apache.uima.jcas.JCas;


import edu.cmu.deiis.types.Answer;
import edu.cmu.deiis.types.Question;
import edu.cmu.deiis.types.Token;



public class AllTokenAnnotator extends JCasAnnotator_ImplBase {

	private Pattern mQuestionPattern = Pattern.compile("Q (.*)?");
	
	private Pattern mAnswerPattern = Pattern.compile("A (\\d) .*.");
	
	
	@Override
	public void process(JCas aJCas)  {
		// TODO Auto-generated method stub
		//get document text
		
String docText = aJCas.getDocumentText();
		
//search for question text

Matcher matcher = mQuestionPattern.matcher(docText);
int pos = 0;
while (matcher.find(pos)){
	//found one - creates an annotation
	Token annotation = new Token(aJCas);
	annotation.setBegin(matcher.start()+2);
	annotation.setEnd(matcher.end());
	annotation.setCasProcessorId(this.getClass().toString());
	annotation.setConfidence(1.0);
	annotation.addToIndexes();
	pos = matcher.end();
}

//search for answer text
	matcher = mAnswerPattern.matcher(docText);
	pos = 0;
	while (matcher.find(pos)){
	//found one - creates an annotation
	Token annotation = new Token(aJCas);
	annotation.setBegin(matcher.start()+4);
	annotation.setEnd(matcher.end());
	annotation.setCasProcessorId(this.getClass().toString());
	annotation.setConfidence(1.0);
	annotation.addToIndexes();
	pos = matcher.end();
	}
	
	}
}

