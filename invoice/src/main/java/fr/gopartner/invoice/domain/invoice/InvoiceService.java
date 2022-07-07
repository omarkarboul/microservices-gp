package fr.gopartner.invoice.domain.invoice;

import java.io.ByteArrayInputStream;
import java.util.Map;

public interface InvoiceService {
    ByteArrayInputStream exportInvoicePdf(String templateName, Map<String, Object> data);
}
