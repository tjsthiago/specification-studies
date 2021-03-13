package br.com.app.invoice.specification.configuration;

import java.util.HashSet;
import java.util.Set;

import br.com.app.invoice.specification.Specification;
import br.com.app.invoice.specification.SpecificationBuilder;
import br.com.app.invoice.specification.impl.InvoiceDoesNotHaveSms;
import br.com.app.invoice.specification.impl.InvoiceHasValueGraterThanMinimumValue;
import br.com.app.invoice.specification.impl.InvoiceValueIsValid;
import br.com.app.invoice.specification.impl.SpecificationTestClientOne;

public class InvoiceSpeficificationsForClientOne implements SpecificationBuilder {
	
	private Set<Specification> specifications;
	
	public InvoiceSpeficificationsForClientOne() {
		specifications = new HashSet<>();
	}
	
	@Override
	public Set<Specification> getInvoiSpecifications() {
		specifications.add(new InvoiceDoesNotHaveSms());
		specifications.add(new InvoiceValueIsValid());
		specifications.add(new InvoiceHasValueGraterThanMinimumValue());
		specifications.add(new SpecificationTestClientOne());
		
		return specifications;
	}

}
