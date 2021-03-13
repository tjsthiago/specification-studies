package br.com.app.invoice.specification.impl;

import org.apache.log4j.Logger;

import br.com.app.invoice.Invoice;
import br.com.app.invoice.InvoiceEntry;
import br.com.app.invoice.specification.Specification;

public class InvoiceValueIsValid implements Specification{

	private static Logger logger = Logger.getLogger(InvoiceValueIsValid.class);
	
	public boolean isSatifiedBy(Invoice invoice) {
		if(!isValid(invoice)) {
			logger.info("invoice is invalid after test InvoiceValueIsValid");
			return false;
		}
		
		return true;
	}

	private boolean isValid(Invoice invoice) {
		return invoiceEntriesAmount(invoice).equals(invoice.getValue());
	}
	
	private Double invoiceEntriesAmount(Invoice invoice) {
		return invoice
				.getEntries()
				.stream()
				.map(InvoiceEntry::getValue)
				.reduce(0.0, Double::sum);
	}

}
