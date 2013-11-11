package edu.cmu.deiis.annotators;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;


import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.cas.FSArray;

import edu.cmu.deiis.types.Token;
import edu.cmu.deiis.types.NGram;


public class NGramAnnotator0 extends JCasAnnotator_ImplBase {
private String typeName = "Token";
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub
AnnotationIndex<?> index = aJCas.getAnnotationIndex(Token.type);
Token[] array = new Token[index.size()];
FSIterator<?> iterator = index.iterator();
for (int i= 0; i< index.size(); i++)
	array[i] = (Token) iterator.next();
for (int n =1; n <= 3; n++) {
	
	int lastNGramStart = index.size() - n +1;
	for (int offset = 0; offset < lastNGramStart;offset++) {
	FSArray elementsArray = new FSArray(aJCas, n);
	for (int i = 0; i < n; i++)
        elementsArray.set(i, array[offset + i]);
	Boolean T = true;
	
	for (int i = 0; i < n - 1 ; i++)
		if ((array[offset + i + 1].getBegin() - array[offset + i].getEnd()) != 1)
			T = false;
	if (T) {
		NGram a =new NGram(aJCas, array[offset].getBegin(), array[offset + n - 1].getEnd());
        a.setElementType(typeName);
        a.setElements(elementsArray);
        a.setCasProcessorId("NGramAnnotator");
        a.setConfidence(1);
        a.addToIndexes();
	}
	}
	}	
	}

}
