package com.business.unknown.utils;

import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class PDFBuilder {


    public String buildPdf(String inputHTML) throws IOException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            ITextRenderer renderer = new ITextRenderer();
            SharedContext sharedContext = renderer.getSharedContext();
            sharedContext.setPrint(true);
            sharedContext.setInteractive(false);
            renderer.setDocumentFromString(inputHTML);
            renderer.layout();
            renderer.createPDF(outputStream);
            return new String(Base64.getEncoder().encode(outputStream.toByteArray()));
        } finally {
            outputStream.close();
        }
    }




}
