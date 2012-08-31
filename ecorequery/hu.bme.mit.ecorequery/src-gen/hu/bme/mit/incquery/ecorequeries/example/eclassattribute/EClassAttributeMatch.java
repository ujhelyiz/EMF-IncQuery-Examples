package hu.bme.mit.incquery.ecorequeries.example.eclassattribute;

import java.util.Arrays;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.viatra2.emf.incquery.runtime.api.IPatternMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra2.emf.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra2.patternlanguage.core.patternLanguage.Pattern;

/**
 * Pattern-specific match representation of the EClassAttribute pattern, 
 * to be used in conjunction with EClassAttributeMatcher.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see EClassAttributeMatcher
 * @see EClassAttributeProcessor
 * 
 */
public final class EClassAttributeMatch extends BasePatternMatch implements IPatternMatch {
  private EClass fE;
  
  private EStructuralFeature fAttr;
  
  private EClassifier fType;
  
  private static String[] parameterNames = {"E", "Attr", "Type"};
  
  EClassAttributeMatch(final EClass pE, final EStructuralFeature pAttr, final EClassifier pType) {
    this.fE = pE;
    this.fAttr = pAttr;
    this.fType = pType;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("E".equals(parameterName)) return this.fE;
    if ("Attr".equals(parameterName)) return this.fAttr;
    if ("Type".equals(parameterName)) return this.fType;
    return null;
    
  }
  
  public EClass getE() {
    return this.fE;
    
  }
  
  public EStructuralFeature getAttr() {
    return this.fAttr;
    
  }
  
  public EClassifier getType() {
    return this.fType;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if ("E".equals(parameterName) ) {
    	this.fE = (org.eclipse.emf.ecore.EClass) newValue;
    	return true;
    }
    if ("Attr".equals(parameterName) ) {
    	this.fAttr = (org.eclipse.emf.ecore.EStructuralFeature) newValue;
    	return true;
    }
    if ("Type".equals(parameterName) ) {
    	this.fType = (org.eclipse.emf.ecore.EClassifier) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setE(final EClass pE) {
    this.fE = pE;
    
  }
  
  public void setAttr(final EStructuralFeature pAttr) {
    this.fAttr = pAttr;
    
  }
  
  public void setType(final EClassifier pType) {
    this.fType = pType;
    
  }
  
  @Override
  public String patternName() {
    return "EClassAttribute";
    
  }
  
  @Override
  public String[] parameterNames() {
    return EClassAttributeMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fE, fAttr, fType};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"E\"=" + prettyPrintValue(fE) + ", ");
    result.append("\"Attr\"=" + prettyPrintValue(fAttr) + ", ");
    result.append("\"Type\"=" + prettyPrintValue(fType));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fE == null) ? 0 : fE.hashCode()); 
    result = prime * result + ((fAttr == null) ? 0 : fAttr.hashCode()); 
    result = prime * result + ((fType == null) ? 0 : fType.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (obj == null)
    	return false;
    if (!(obj instanceof IPatternMatch))
    	return false;
    IPatternMatch otherSig  = (IPatternMatch) obj;
    if (!pattern().equals(otherSig.pattern()))
    	return false;
    if (!EClassAttributeMatch.class.equals(obj.getClass()))
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    EClassAttributeMatch other = (EClassAttributeMatch) obj;
    if (fE == null) {if (other.fE != null) return false;}
    else if (!fE.equals(other.fE)) return false;
    if (fAttr == null) {if (other.fAttr != null) return false;}
    else if (!fAttr.equals(other.fAttr)) return false;
    if (fType == null) {if (other.fType != null) return false;}
    else if (!fType.equals(other.fType)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return EClassAttributeMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
}
