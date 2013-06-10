package hu.bme.mit.incquery.ecorequeries.example.eobject;

import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.incquery.ecorequeries.example.EObject pattern, 
 * to be used in conjunction with {@link EObjectMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see EObjectMatcher
 * @see EObjectProcessor
 * 
 */
public abstract class EObjectMatch extends BasePatternMatch {
  private EObject fE;
  
  private static String[] parameterNames = {"E"};
  
  private EObjectMatch(final EObject pE) {
    this.fE = pE;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("E".equals(parameterName)) return this.fE;
    return null;
    
  }
  
  public EObject getE() {
    return this.fE;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("E".equals(parameterName) ) {
    	this.fE = (org.eclipse.emf.ecore.EObject) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setE(final EObject pE) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fE = pE;
    
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.incquery.ecorequeries.example.EObject";
    
  }
  
  @Override
  public String[] parameterNames() {
    return EObjectMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fE};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"E\"=" + prettyPrintValue(fE));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fE == null) ? 0 : fE.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof EObjectMatch)) { // this should be infrequent				
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!pattern().equals(otherSig.pattern()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    EObjectMatch other = (EObjectMatch) obj;
    if (fE == null) {if (other.fE != null) return false;}
    else if (!fE.equals(other.fE)) return false;
    return true;
  }
  
  @Override
  public Pattern pattern() {
    try {
    	return EObjectMatcher.factory().getPattern();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the matcher factory exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  static final class Mutable extends EObjectMatch {
    Mutable(final EObject pE) {
      super(pE);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  static final class Immutable extends EObjectMatch {
    Immutable(final EObject pE) {
      super(pE);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}