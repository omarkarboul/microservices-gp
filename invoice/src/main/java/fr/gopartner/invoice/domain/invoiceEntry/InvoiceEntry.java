package fr.gopartner.invoice.domain.invoiceEntry;

import fr.gopartner.invoice.domain.invoice.Invoice;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_invoice_entry")
@Data
public class InvoiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_activity_timesheet")
    private Long idActivityTimesheet;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}
