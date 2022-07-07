package fr.gopartner.invoice.domain.invoiceEntry;

import fr.gopartner.invoice.domain.invoice.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceEntryRepository extends JpaRepository <InvoiceEntry , Long> {

    InvoiceEntry findByInvoice(Invoice invoice);
}
