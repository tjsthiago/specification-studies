package specification.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.app.client.Client;
import br.com.app.invoice.Invoice;
import br.com.app.invoice.InvoiceEntry;
import br.com.app.invoice.specification.configuration.InvoiceSpeficificationsForClientOne;
import br.com.app.invoice.specification.configuration.InvoiceSpeficificationsForClientThree;
import br.com.app.invoice.specification.configuration.InvoiceSpeficificationsForClientTwo;

public class SpecificationTest {
	
	private static Logger logger = Logger.getLogger(SpecificationTest.class);

	@Test
	public void assertThatAnInvoiceIsValid() {
		logger.info("start assertThatAnInvoiceIsValid");
		
		InvoiceEntry callOne = new InvoiceEntry("call", 0.5);
		InvoiceEntry callTwo = new InvoiceEntry("call", 1.5);
		double invoiceValue = 2.0;
		
		Invoice invoice =  new Invoice(
			invoiceValue, 
			Arrays.asList(callOne, callTwo), 
			new Client("client one"),
			new InvoiceSpeficificationsForClientOne()
		);
		
		assertTrue(invoice.validate());
		
		logger.info("end assertThatAnInvoiceIsValid \n");
	}
	
	@Test
	public void assertThatAnInvoiceWithSmsEntryIsInvalid() {
		logger.info("start assertThatAnInvoiceWithSmsEntryIsInvalid");
		
		InvoiceEntry sms = new InvoiceEntry("sms", 0.5);
		InvoiceEntry call = new InvoiceEntry("call", 1.5);
		double invoiceValue = 2.0;

		Invoice invoice =  new Invoice(
			invoiceValue, 
			Arrays.asList(sms, call), 
			new Client("client one"),
			new InvoiceSpeficificationsForClientOne()
		);
		
		assertFalse(invoice.validate());
		
		logger.info("end assertThatAnInvoiceWithSmsEntryIsInvalid \n");
	}
	
	@Test
	public void assertThatAnInvoiceWithDiffBetweenInvoiceValueAndInvoiceEntriesAmountIsInvalid() {
		logger.info("start assertThatAnInvoiceWithDiffBetweenInvoiceValueAndInvoiceEntriesAmountIsInvalid");
		
		InvoiceEntry sms = new InvoiceEntry("call", 0.5);
		InvoiceEntry call = new InvoiceEntry("call", 1.0);
		double invoiceValue = 2.0;

		Invoice invoice =  new Invoice(
			invoiceValue, 
			Arrays.asList(sms, call), 
			new Client("client one"),
			new InvoiceSpeficificationsForClientOne()
		);
		
		assertFalse(invoice.validate());
		
		logger.info("end assertThatAnInvoiceWithDiffBetweenInvoiceValueAndInvoiceEntriesAmountIsInvalid \n");
	}
	
	@Test
	public void assertThatSpecificationConfigurationAreWorking() {
		logger.info("start assertThatSpecificationConfigurationAreWorking");
		
		InvoiceEntry sms = new InvoiceEntry("call", 0.5);
		InvoiceEntry call = new InvoiceEntry("call", 1.5);
		double invoiceValue = 2.0;
		
		Invoice invoiceOne =  new Invoice(
			invoiceValue, 
			Arrays.asList(sms, call), 
			new Client("client one"), 
			new InvoiceSpeficificationsForClientOne()
		);
		
		Invoice invoiceTwo =  new Invoice(
				invoiceValue, 
				Arrays.asList(sms, call), 
				new Client("client two"), 
				new InvoiceSpeficificationsForClientTwo()
			);
		
		assertTrue(invoiceOne.validate());
		assertTrue(invoiceTwo.validate());
		
		logger.info("end assertThatSpecificationConfigurationAreWorking \n");
	}
	
	@Test
	public void assertThatInvoicesOfClientThreeCanHaveSmsEntries() {
		logger.info("start assertThatInvoicesOfClientThreeCanHaveSmsEntries");
		
		InvoiceEntry sms = new InvoiceEntry("sms", 0.5);
		InvoiceEntry call = new InvoiceEntry("call", 1.5);
		double invoiceValue = 2.0;
		
		Invoice invoice =  new Invoice(
			invoiceValue, 
			Arrays.asList(sms, call), 
			new Client("client three"),
			new InvoiceSpeficificationsForClientThree()
		);
		
		assertTrue(invoice.validate());
		
		logger.info("end assertThatInvoicesOfClientThreeCanHaveSmsEntries \n");
	}
	
}
