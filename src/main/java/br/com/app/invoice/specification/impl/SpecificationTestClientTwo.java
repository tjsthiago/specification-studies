package br.com.app.invoice.specification.impl;

import br.com.app.invoice.Invoice;
import br.com.app.invoice.specification.Specification;
import org.apache.log4j.Logger;

public class SpecificationTestClientTwo implements Specification {

	private static Logger logger = Logger.getLogger(SpecificationTestClientTwo.class);
	
	public boolean isSatifiedBy(Invoice invoice) {
		if(!isValid(invoice)) {
			logger.info("invoice is invalid after test SpecificationTestClientTwo");
			return false;
		}
		
		return true;
	}

	private boolean isValid(Invoice invoice) {
		return invoice.getClient().getName().equalsIgnoreCase("client two");
	}

}
