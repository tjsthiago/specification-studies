package br.com.app.invoice;

import java.util.List;

import br.com.app.client.Client;
import br.com.app.invoice.specification.SpecificationBuilder;

public class Invoice {

	private Client client;
	private Double value;
	private List<InvoiceEntry> entries;
	private SpecificationBuilder specificationConfiguration;
	
	public Invoice(Double value, List<InvoiceEntry> entries, Client client, SpecificationBuilder specificationConfiguration) {
		this.value = value;
		this.entries = entries;
		this.client = client;
		this.specificationConfiguration = specificationConfiguration;
	}

	public boolean validate() {
		return specificationConfiguration
				.getInvoiSpecifications()
				.stream()
				.allMatch(s -> s.isSatifiedBy(this));
	}
	
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public List<InvoiceEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<InvoiceEntry> entries) {
		this.entries = entries;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
