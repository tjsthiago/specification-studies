package br.com.app.invoice;

public class InvoiceEntry {

	private String descriprion;
	
	private Double value;
	
	public InvoiceEntry(String descriprion, Double value) {
		this.descriprion = descriprion;
		this.value = value;
	}

	public String getDescriprion() {
		return descriprion;
	}

	public void setDescriprion(String descriprion) {
		this.descriprion = descriprion;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
		
}
