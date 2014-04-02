package hu.bme.mit.incquery.ecorequeries.example.util;

import com.google.common.collect.Sets;
import hu.bme.mit.incquery.ecorequeries.example.ECoreNamedElementNameMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedQuerySpecification;
import org.eclipse.incquery.runtime.context.EMFPatternMatcherContext;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.extensibility.IQuerySpecificationProvider;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.PQuery;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;

/**
 * A pattern-specific query specification that can instantiate ECoreNamedElementNameMatcher in a type-safe way.
 * 
 * @see ECoreNamedElementNameMatcher
 * @see ECoreNamedElementNameMatch
 * 
 */
@SuppressWarnings("all")
public final class ECoreNamedElementNameQuerySpecification extends BaseGeneratedQuerySpecification<ECoreNamedElementNameMatcher> {
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static ECoreNamedElementNameQuerySpecification instance() throws IncQueryException {
    try {
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	processInitializerError(err);
    	throw err;
    }
    
  }
  
  @Override
  protected ECoreNamedElementNameMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return ECoreNamedElementNameMatcher.on(engine);
  }
  
  @Override
  public String getFullyQualifiedName() {
    return "hu.bme.mit.incquery.ecorequeries.example.ECoreNamedElementName";
    
  }
  
  @Override
  public List<String> getParameterNames() {
    return Arrays.asList("Name");
  }
  
  @Override
  public List<PParameter> getParameters() {
    return Arrays.asList(new PParameter("Name", "java.lang.String"));
  }
  
  @Override
  public Set<PBody> doGetContainedBodies() throws IncQueryException {
    EMFPatternMatcherContext context = new EMFPatternMatcherContext();
    Set<PBody> bodies = Sets.newLinkedHashSet();
    {
      PBody body = new PBody(this);
      PVariable var_Name = body.getOrCreateVariableByName("Name");
      PVariable var_Element = body.getOrCreateVariableByName("Element");
      body.setExportedParameters(Arrays.<ExportedParameter>asList(
        new ExportedParameter(body, var_Name, "Name")
      ));
      
      new TypeBinary(body, context, var_Element, var_Name, getFeatureLiteral("http://www.eclipse.org/emf/2002/Ecore", "ENamedElement", "name"), "http://www.eclipse.org/emf/2002/Ecore/ENamedElement.name");
      bodies.add(body);
    }setStatus(PQuery.PQueryStatus.OK);
    return bodies;
  }
  
  private ECoreNamedElementNameQuerySpecification() throws IncQueryException {
    super();
    setStatus(PQuery.PQueryStatus.UNINITIALIZED);
  }
  
  @SuppressWarnings("all")
  public static class Provider implements IQuerySpecificationProvider<ECoreNamedElementNameQuerySpecification> {
    @Override
    public ECoreNamedElementNameQuerySpecification get() throws IncQueryException {
      return instance();
    }
  }
  
  
  @SuppressWarnings("all")
  private static class LazyHolder {
    private final static ECoreNamedElementNameQuerySpecification INSTANCE = make();
    
    public static ECoreNamedElementNameQuerySpecification make() {
      try {
      	return new ECoreNamedElementNameQuerySpecification();
      } catch (IncQueryException ex) {
      	throw new RuntimeException	(ex);
      }
      
    }
  }
  
}
