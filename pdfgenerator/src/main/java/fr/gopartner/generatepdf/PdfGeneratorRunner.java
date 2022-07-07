package fr.gopartner.generatepdf;

import fr.gopartner.generatepdf.service.PdfGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PdfGeneratorRunner implements CommandLineRunner {

    @Autowired
    private PdfGenerateService pdfGenerateService;

    @Override
    public void run(String... args) throws Exception {
        Map<String, Object> data = new HashMap<>();


        pdfGenerateService.generatePdfFile("invoice.html", data, "invoice.pdf");
    }
}
