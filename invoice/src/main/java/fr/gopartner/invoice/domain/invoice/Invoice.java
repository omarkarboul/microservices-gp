package fr.gopartner.invoice.domain.invoice;

import fr.gopartner.invoice.domain.invoiceEntry.InvoiceEntry;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "t_invoice")
@Data
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "client_id")
    private Long clientId ;

    @Column(name = "document_id")
    private Long documentId ;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private InvoiceEnum status ;

    @OneToMany(mappedBy = "invoice",cascade = CascadeType.REMOVE)
    private List<InvoiceEntry> invoiceEntries;

}
