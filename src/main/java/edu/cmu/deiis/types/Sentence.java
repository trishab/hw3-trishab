

/* First created by JCasGen Sun Nov 10 18:39:38 EST 2013 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



import org.apache.uima.jcas.cas.FSArray;


/** 
 * Updated by JCasGen Sun Nov 10 18:47:29 EST 2013
 * XML source: C:/Users/trishab/git/hw3-trishab/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class Sentence extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Sentence.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Sentence() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Sentence(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Sentence(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Sentence(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
  //*--------------*
  //* Feature: ngramArray

  /** getter for ngramArray - gets 
   * @generated */
  public FSArray getNgramArray() {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_ngramArray == null)
      jcasType.jcas.throwFeatMissing("ngramArray", "edu.cmu.deiis.types.Sentence");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_ngramArray)));}
    
  /** setter for ngramArray - sets  
   * @generated */
  public void setNgramArray(FSArray v) {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_ngramArray == null)
      jcasType.jcas.throwFeatMissing("ngramArray", "edu.cmu.deiis.types.Sentence");
    jcasType.ll_cas.ll_setRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_ngramArray, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for ngramArray - gets an indexed value - 
   * @generated */
  public NGram getNgramArray(int i) {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_ngramArray == null)
      jcasType.jcas.throwFeatMissing("ngramArray", "edu.cmu.deiis.types.Sentence");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_ngramArray), i);
    return (NGram)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_ngramArray), i)));}

  /** indexed setter for ngramArray - sets an indexed value - 
   * @generated */
  public void setNgramArray(int i, NGram v) { 
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_ngramArray == null)
      jcasType.jcas.throwFeatMissing("ngramArray", "edu.cmu.deiis.types.Sentence");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_ngramArray), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_ngramArray), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: tokenArray

  /** getter for tokenArray - gets 
   * @generated */
  public FSArray getTokenArray() {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_tokenArray == null)
      jcasType.jcas.throwFeatMissing("tokenArray", "edu.cmu.deiis.types.Sentence");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_tokenArray)));}
    
  /** setter for tokenArray - sets  
   * @generated */
  public void setTokenArray(FSArray v) {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_tokenArray == null)
      jcasType.jcas.throwFeatMissing("tokenArray", "edu.cmu.deiis.types.Sentence");
    jcasType.ll_cas.ll_setRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_tokenArray, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for tokenArray - gets an indexed value - 
   * @generated */
  public Token getTokenArray(int i) {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_tokenArray == null)
      jcasType.jcas.throwFeatMissing("tokenArray", "edu.cmu.deiis.types.Sentence");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_tokenArray), i);
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_tokenArray), i)));}

  /** indexed setter for tokenArray - sets an indexed value - 
   * @generated */
  public void setTokenArray(int i, Token v) { 
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_tokenArray == null)
      jcasType.jcas.throwFeatMissing("tokenArray", "edu.cmu.deiis.types.Sentence");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_tokenArray), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Sentence_Type)jcasType).casFeatCode_tokenArray), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    