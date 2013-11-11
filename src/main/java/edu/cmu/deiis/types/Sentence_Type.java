
/* First created by JCasGen Sun Nov 10 18:39:38 EST 2013 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;

import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** 
 * Updated by JCasGen Sun Nov 10 18:47:29 EST 2013
 * @generated */
public class Sentence_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Sentence_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Sentence_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Sentence(addr, Sentence_Type.this);
  			   Sentence_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Sentence(addr, Sentence_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Sentence.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.deiis.types.Sentence");



  /** @generated */
  final Feature casFeat_ngramArray;
  /** @generated */
  final int     casFeatCode_ngramArray;
  /** @generated */ 
  public int getNgramArray(int addr) {
        if (featOkTst && casFeat_ngramArray == null)
      jcas.throwFeatMissing("ngramArray", "edu.cmu.deiis.types.Sentence");
    return ll_cas.ll_getRefValue(addr, casFeatCode_ngramArray);
  }
  /** @generated */    
  public void setNgramArray(int addr, int v) {
        if (featOkTst && casFeat_ngramArray == null)
      jcas.throwFeatMissing("ngramArray", "edu.cmu.deiis.types.Sentence");
    ll_cas.ll_setRefValue(addr, casFeatCode_ngramArray, v);}
    
   /** @generated */
  public int getNgramArray(int addr, int i) {
        if (featOkTst && casFeat_ngramArray == null)
      jcas.throwFeatMissing("ngramArray", "edu.cmu.deiis.types.Sentence");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ngramArray), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_ngramArray), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ngramArray), i);
  }
   
  /** @generated */ 
  public void setNgramArray(int addr, int i, int v) {
        if (featOkTst && casFeat_ngramArray == null)
      jcas.throwFeatMissing("ngramArray", "edu.cmu.deiis.types.Sentence");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ngramArray), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_ngramArray), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_ngramArray), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_tokenArray;
  /** @generated */
  final int     casFeatCode_tokenArray;
  /** @generated */ 
  public int getTokenArray(int addr) {
        if (featOkTst && casFeat_tokenArray == null)
      jcas.throwFeatMissing("tokenArray", "edu.cmu.deiis.types.Sentence");
    return ll_cas.ll_getRefValue(addr, casFeatCode_tokenArray);
  }
  /** @generated */    
  public void setTokenArray(int addr, int v) {
        if (featOkTst && casFeat_tokenArray == null)
      jcas.throwFeatMissing("tokenArray", "edu.cmu.deiis.types.Sentence");
    ll_cas.ll_setRefValue(addr, casFeatCode_tokenArray, v);}
    
   /** @generated */
  public int getTokenArray(int addr, int i) {
        if (featOkTst && casFeat_tokenArray == null)
      jcas.throwFeatMissing("tokenArray", "edu.cmu.deiis.types.Sentence");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_tokenArray), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_tokenArray), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_tokenArray), i);
  }
   
  /** @generated */ 
  public void setTokenArray(int addr, int i, int v) {
        if (featOkTst && casFeat_tokenArray == null)
      jcas.throwFeatMissing("tokenArray", "edu.cmu.deiis.types.Sentence");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_tokenArray), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_tokenArray), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_tokenArray), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Sentence_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_ngramArray = jcas.getRequiredFeatureDE(casType, "ngramArray", "uima.cas.FSArray", featOkTst);
    casFeatCode_ngramArray  = (null == casFeat_ngramArray) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ngramArray).getCode();

 
    casFeat_tokenArray = jcas.getRequiredFeatureDE(casType, "tokenArray", "uima.cas.FSArray", featOkTst);
    casFeatCode_tokenArray  = (null == casFeat_tokenArray) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_tokenArray).getCode();

  }
}



    