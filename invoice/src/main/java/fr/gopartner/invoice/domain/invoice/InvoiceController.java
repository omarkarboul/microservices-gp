package fr.gopartner.invoice.domain.invoice;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
public class InvoiceController {

    public static String TEMPLATE_NAME = "invoice" ;
    public static String CONTENT_TYPE = "application/octet-stream" ;
    public static String CONTENT_DISPOSITION = "Content-Disposition" ;
    public static String ATTACHMENT_FILENAME = "attachment; filename=invoice.pdf" ;


    private final InvoiceService invoiceService ;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoice")
    public void downloadReceipt(HttpServletResponse response) throws IOException {
        Map<String, Object> data = null ;
        response.setContentType(CONTENT_TYPE);
        response.setHeader(CONTENT_DISPOSITION, ATTACHMENT_FILENAME);
        IOUtils.copy(invoiceService.exportInvoicePdf(TEMPLATE_NAME, data), response.getOutputStream());
    }

}
