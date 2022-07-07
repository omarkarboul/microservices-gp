package fr.gopartner.invoice.invoiceEntry;

import fr.gopartner.invoice.domain.invoice.Invoice;
import fr.gopartner.invoice.domain.invoice.InvoiceRepository;
import fr.gopartner.invoice.domain.invoiceEntry.InvoiceEntry;
import fr.gopartner.invoice.domain.invoiceEntry.InvoiceEntryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static fr.gopartner.invoice.domain.invoice.InvoiceEnum.DELIVERED;

@SpringBootTest
public class InvoiceEntryRepositoryTest {

    @Autowired
    InvoiceRepository invoiceRepository ;

    @Autowired
    InvoiceEntryRepository invoiceEntryRepository ;

    @BeforeEach
    void
    setUp() {
        invoiceRepository.deleteAll();
        invoiceEntryRepository.deleteAll();
    }

    @Test
    void find_invoice_entry_by_invoice(){
        var invoice = new Invoice();
        invoiceRepository.save(invoice);
        var invoiceEntry = new InvoiceEntry();
        invoiceEntry.setInvoice(invoice);
        invoiceEntryRepository.save(invoiceEntry);
        var entryByInvoice = invoiceEntryRepository.findByInvoice(invoice);
        Assertions.assertEquals(entryByInvoice.getInvoice().getId() , invoice.getId());
    }

    @Test
    void GIVEN_valid_invoice_entry_WHEN_save_THEN_save_that_invoice_entry_on_database() {
        //given
        var invoice = new Invoice();
        invoiceRepository.save(invoice);
        var invoiceEntry = new InvoiceEntry();
        invoiceEntry.setIdActivityTimesheet(1L);
        invoiceEntry.setInvoice(invoice);

        //when
        var savedEntryInvoice = invoiceEntryRepository.save(invoiceEntry);

        //then
        Assertions.assertEquals(invoiceEntry.getIdActivityTimesheet(), savedEntryInvoice.getIdActivityTimesheet());
        Assertions.assertEquals(invoiceEntry.getInvoice(), savedEntryInvoice.getInvoice());
    }

    @Test
    void GIVEN_activity_WHEN_delete_THEN_delete_that_activity(){
        //given
        var invoice = new Invoice();
        invoice.setClientId(1L);
        invoice.setDocumentId(1L);
        invoice.setDate(LocalDate.of(2022,3,5));
        invoice.setStatus(DELIVERED);
        //when
        invoiceRepository.delete(invoice);
        //then
        Assertions.assertTrue(invoiceRepository.findAll().isEmpty());
    }
}
