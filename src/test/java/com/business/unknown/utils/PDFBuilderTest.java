package com.business.unknown.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.thymeleaf.context.Context;

import com.business.unknown.model.FacturaCustom;
import com.fasterxml.jackson.databind.ObjectMapper;

class PDFBuilderTest {

    private final ObjectMapper objMapper = new ObjectMapper();
    private final PDFBuilder pdfBuilder = new PDFBuilder();

    @Test
    public void generateInvoicePdfTest() throws IOException {

        FacturaCustom invoice = objMapper.readValue(new File("./src/test/resources/json/fact2.json"),
                FacturaCustom.class);
        Context ctx = new Context();
        ctx.setVariable("invoice", invoice);
        writeFileToDisk("./src/test/resources/pdf/pue.pdf", pdfBuilder.buildPdf(ctx, "factura"));
    }

    @Test
    public void generateComplementPdfTest() throws IOException {

        FacturaCustom invoice = objMapper.readValue(new File("./src/test/resources/json/complement.json"),
                FacturaCustom.class);
        Context ctx = new Context();
        ctx.setVariable("invoice", invoice);
        writeFileToDisk("./src/test/resources/pdf/complement.pdf", pdfBuilder.buildPdf(ctx, "complemento"));
    }

    private void writeFileToDisk(String path, byte[] data) throws IOException {
        File file = new File(path);
        file.getParentFile().mkdirs(); // Create directories if they do not exist
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(data);
        }
    }

}