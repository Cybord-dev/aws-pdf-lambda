package com.business.unknown.utils;

import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class PDFBuilder {


    public String buildPdf(String inputHTML) throws IOException {

        try ( ByteArrayOutputStream outputStream = new ByteArrayOutputStream()){
            ITextRenderer renderer = new ITextRenderer();
            SharedContext sharedContext = renderer.getSharedContext();
            sharedContext.setPrint(true);
            sharedContext.setInteractive(false);
            renderer.setDocumentFromString(inputHTML);
            renderer.layout();
            renderer.createPDF(outputStream);
            String result = new String(Base64.getEncoder().encode(outputStream.toByteArray()));
            System.out.println(result);
            return result;
        }
    }




}
