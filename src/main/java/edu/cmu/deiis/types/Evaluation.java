

/* First created by JCasGen Sun Nov 10 18:47:27 EST 2013 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** 
 * Updated by JCasGen Sun Nov 10 18:47:29 EST 2013
 * XML source: C:/Users/trishab/git/hw3-trishab/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class Evaluation extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Evaluation.class);
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
  protected Evaluation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Evaluation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Evaluation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Evaluation(JCas jcas, int begin, int end) {
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
  //* Feature: n

  /** getter for n - gets 
   * @generated */
  public int getN() {
    if (Evaluation_Type.featOkTst && ((Evaluation_Type)jcasType).casFeat_n == null)
      jcasType.jcas.throwFeatMissing("n", "edu.cmu.deiis.types.Evaluation");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Evaluation_Type)jcasType).casFeatCode_n);}
    
  /** setter for n - sets  
   * @generated */
  public void setN(int v) {
    if (Evaluation_Type.featOkTst && ((Evaluation_Type)jcasType).casFeat_n == null)
      jcasType.jcas.throwFeatMissing("n", "edu.cmu.deiis.types.Evaluation");
    jcasType.ll_cas.ll_setIntValue(addr, ((Evaluation_Type)jcasType).casFeatCode_n, v);}    
   
    
  //*--------------*
  //* Feature: performance

  /** getter for performance - gets 
   * @generated */
  public double getPerformance() {
    if (Evaluation_Type.featOkTst && ((Evaluation_Type)jcasType).casFeat_performance == null)
      jcasType.jcas.throwFeatMissing("performance", "edu.cmu.deiis.types.Evaluation");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Evaluation_Type)jcasType).casFeatCode_performance);}
    
  /** setter for performance - sets  
   * @generated */
  public void setPerformance(double v) {
    if (Evaluation_Type.featOkTst && ((Evaluation_Type)jcasType).casFeat_performance == null)
      jcasType.jcas.throwFeatMissing("performance", "edu.cmu.deiis.types.Evaluation");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Evaluation_Type)jcasType).casFeatCode_performance, v);}    
  }

    