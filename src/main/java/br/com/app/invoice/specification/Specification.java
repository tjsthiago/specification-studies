package br.com.app.invoice.specification;

import br.com.app.invoice.Invoice;

public interface Specification {
	
	boolean isSatifiedBy(Invoice invoice);
	
}
