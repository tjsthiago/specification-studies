package br.com.app.invoice.specification.configuration;

import java.util.HashSet;
import java.util.Set;

import br.com.app.invoice.specification.Specification;
import br.com.app.invoice.specification.SpecificationBuilder;
import br.com.app.invoice.specification.impl.InvoiceHasValueGraterThanMinimumValue;
import br.com.app.invoice.specification.impl.InvoiceValueIsValid;

public class InvoiceSpeficificationsForClientThree implements SpecificationBuilder {
	
private Set<Specification> specifications;
	
	public InvoiceSpeficificationsForClientThree() {
		specifications = new HashSet<>();
	}
	
	@Override
	public Set<Specification> getInvoiSpecifications() {
		specifications.add(new InvoiceValueIsValid());
		specifications.add(new InvoiceHasValueGraterThanMinimumValue());
		
		return specifications;
	}

}
