package br.com.app.invoice.specification.impl;

import org.apache.log4j.Logger;

import br.com.app.invoice.Invoice;
import br.com.app.invoice.specification.Specification;

public class InvoiceHasValueGraterThanMinimumValue implements Specification {

	private static Logger logger = Logger.getLogger(InvoiceHasValueGraterThanMinimumValue.class);
	
	private Double minimumValue;
	
	public InvoiceHasValueGraterThanMinimumValue() {
		this.minimumValue = 1.0;
	}
	
	public boolean isSatifiedBy(Invoice invoice) {
		if(!isValid(invoice)) {
			logger.info("invoice is invalid after test InvoiceHasValueGraterThanMinimumValue");
			return false;
		}
		
		return true;
	}
	
	private boolean isValid(Invoice invoice) {
		return invoice.getValue() > minimumValue;
	}

}
