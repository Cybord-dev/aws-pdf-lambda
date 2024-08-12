package com.business.unknown.utils;

import com.business.unknown.model.FacturaCustom;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PDFBuilderTest {

    private final ObjectMapper objMapper = new ObjectMapper();
    private final PDFBuilder pdfBuilder = new PDFBuilder();

    @Test
    public void generatePdfTest() throws IOException {

        FacturaCustom invoice = objMapper.readValue(new File("./src/test/resources/json/pue.json"), FacturaCustom.class);
        Context ctx = new Context();
        ctx.setVariable("invoice", invoice);
        writeFileToDisk("./src/test/resources/pdf/pue.pdf",pdfBuilder.buildPdf(ctx));
    }

    private void writeFileToDisk(String path, byte[] data) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(data);
        }
    }

}