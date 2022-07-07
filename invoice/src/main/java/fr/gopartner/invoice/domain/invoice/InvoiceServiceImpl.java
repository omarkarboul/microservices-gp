package fr.gopartner.invoice.domain.invoice;

import com.lowagie.text.DocumentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import org.thymeleaf.context.Context;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;


@Service
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {

    private final TemplateEngine templateEngine;

    public InvoiceServiceImpl(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public ByteArrayInputStream exportInvoicePdf(String templateName, Map<String, Object> data) {
        Context context = new Context();
        context.setVariables(data);
        String htmlContent = templateEngine.process(templateName, context);
        ByteArrayInputStream invoiceInputStream = createPDFFromTemplate(htmlContent);
        return invoiceInputStream;
    }

    private ByteArrayInputStream createPDFFromTemplate(String htmlContent) {
        ByteArrayInputStream templateInputStream = null;
        try(ByteArrayOutputStream invoicePDFOutputStream = new ByteArrayOutputStream()) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(invoicePDFOutputStream, false);
            renderer.finishPDF();
            templateInputStream = new ByteArrayInputStream(invoicePDFOutputStream.toByteArray());
        } catch (DocumentException | IOException e) {
            log.error("could not generate pdf from thymeleaf template" , e);
        }
        return templateInputStream;
    }
}
