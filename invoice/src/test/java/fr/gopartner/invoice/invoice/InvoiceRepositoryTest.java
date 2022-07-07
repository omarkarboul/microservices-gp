package fr.gopartner.invoice.invoice;

import fr.gopartner.invoice.domain.invoice.Invoice;
import fr.gopartner.invoice.domain.invoice.InvoiceRepository;
import fr.gopartner.invoice.domain.invoiceEntry.InvoiceEntry;
import fr.gopartner.invoice.domain.invoiceEntry.InvoiceEntryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static fr.gopartner.invoice.domain.invoice.InvoiceEnum.DELIVERED;

@SpringBootTest
public class InvoiceRepositoryTest {

    @Autowired
    InvoiceRepository invoiceRepository ;

    @BeforeEach
    void
    setUp() {
        invoiceRepository.deleteAll();
    }

    @Test
    void GIVEN_valid_invoice_WHEN_save_THEN_save_that_invoice_on_database() {
        //given
        var invoiceEntry = new InvoiceEntry();
        List<InvoiceEntry> listEntries = new ArrayList<>();
        listEntries.add(invoiceEntry);
        var invoice = new Invoice();
        invoice.setClientId(1L);
        invoice.setDocumentId(1L);
        invoice.setDate(LocalDate.of(2022,3,5));
        invoice.setStatus(DELIVERED);
        invoice.setInvoiceEntries(listEntries);

        //when
        var savedInvoice = invoiceRepository.save(invoice);
        //then
        Assertions.assertEquals(invoice.getClientId(), savedInvoice.getClientId());
        Assertions.assertEquals(invoice.getDate(), savedInvoice.getDate());
        Assertions.assertEquals(invoice.getDocumentId(), savedInvoice.getDocumentId());
        Assertions.assertEquals(invoice.getStatus(), savedInvoice.getStatus());
    }

    @Test
    void GIVEN_invoice_WHEN_delete_THEN_delete_that_invoice(){
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


//    @Test
//    @Transactional
//    void SaveValidInvoiceWithInvoiceEntry(){
//        var invoice = new Invoice();
//        invoice.setClientId(1L);
//        invoice.setDocumentId(1L);
//        invoice.setDate(LocalDate.of(2022,3,5));
//        invoice.setStatus(DELIVERED);
//
//        var invoiceEntry = new InvoiceEntry();
//        invoiceEntry.setIdActivityTimesheet(1L);
//        invoiceEntry.setInvoice(invoice);
//
//        var savedInvoice = invoiceRepository.save(invoice);
//        var savedEntryInvoice = invoiceEntryRepository.save(invoiceEntry);
//
//        Assertions.assertEquals(invoice.getClientId(), savedInvoice.getClientId());
//        Assertions.assertEquals(invoice.getDate(), savedInvoice.getDate());
//        Assertions.assertEquals(invoice.getDocumentId(), savedInvoice.getDocumentId());
//        Assertions.assertEquals(invoice.getStatus(), savedInvoice.getStatus());
//
//        Assertions.assertEquals(invoiceEntry.getIdActivityTimesheet(), savedEntryInvoice.getIdActivityTimesheet());
//        Assertions.assertEquals(invoiceEntry.getInvoice(), savedEntryInvoice.getInvoice());
//    }
//
//    @Test
//    void delete_invoice_then_invoice_entries_should_be_deleted(){
//        Assertions.assertEquals(0,invoiceRepository.findAll().size());
//        Assertions.assertEquals(0,invoiceEntryRepository.findAll().size());
//    }
}
