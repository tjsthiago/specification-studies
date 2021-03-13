package br.com.app.invoice.specification.impl;

import org.apache.log4j.Logger;

import br.com.app.invoice.Invoice;
import br.com.app.invoice.specification.Specification;

public class SpecificationTestClientOne implements Specification {

	private static Logger logger = Logger.getLogger(SpecificationTestClientOne.class);

	
	public boolean isSatifiedBy(Invoice invoice) {
		if(!isValid(invoice)) {
			logger.info("invoice is invalid after test SpecificationTestClientOne");
			return false;
		}
		
		return true;
	}

	private boolean isValid(Invoice invoice) {
		return invoice.getClient().getName().equalsIgnoreCase("client one");
	}
	
}
