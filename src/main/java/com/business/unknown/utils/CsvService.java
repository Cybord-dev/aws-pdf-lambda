package com.business.unknown.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.business.unknown.model.DataCsv;
import com.business.unknown.model.FacturaCustom;

public class CsvService {

public void CsvService() {
}
   
   public Map<String,String> readCsvFile(String filePath) {
    Map<String, String> dataList = new HashMap<>();
        File file = new File(filePath);

        if (!file.exists()) {
            throw new RuntimeException("File not found: " + filePath);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; 
                    continue;
                }

                String[] values = line.split(","); 
                DataCsv data = new DataCsv();
                data.setColumn1(values[0].trim());
                data.setColumn2(values[1].trim());

                dataList.put(values[0].trim(), values[1].trim());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV file: " + filePath, e);
        }

        return dataList;
    }
    public  Map<String, String> processAllCsvFromResources() {
       Map<String, String> allData = new HashMap<>();
    
        List<String> fileNames = new BufferedReader(new InputStreamReader(
            Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("csv/")))
        ).lines().collect(Collectors.toList());
    
        for (String fileName : fileNames) {
            if (fileName.endsWith(".csv")) { // Procesar solo archivos CSV
                String filePath = getClass().getClassLoader().getResource("csv/" + fileName).getPath();
                System.out.println("Processing file: " + filePath);
    
                Map<String, String> dataList = readCsvFile(filePath);
                System.out.println("Datos del archivo: " + fileName);
    
                allData.putAll(dataList);
            }
        }
        return allData;
    }
    
    public  Map<String, Object>  setData(FacturaCustom invoice) {
        Map<String, String> data = processAllCsvFromResources();
        Map<String, Object> invoiceData = new HashMap<>();
        invoiceData.put("moneda", data.get(invoice.getCfdi().getMoneda()));
        invoiceData.put("metodoPago", data.get(invoice.getCfdi().getMetodoPago()));
        invoiceData.put("formaPago", data.get(invoice.getCfdi().getFormaPago()));
      /*   invoiceData.put("formaPagoComplemento",
        ((Cfdi) ((FacturaCustom) invoice.getCfdi().getComplemento()).getPagos()).getFormaPago() + "-" +
         data.get(((Cfdi) ((FacturaCustom) invoice.getCfdi().getComplemento()).getPagos()).getFormaPago())); */
        invoiceData.put("usoCfdi", data.get(invoice.getCfdi().getReceptor().getUsoCfdi()));
        invoiceData.put("tipoDeComprobante", invoice.getCfdi().getTipoDeComprobante()+ " " +
        data.get(invoice.getCfdi().getTipoDeComprobante()) );
        invoiceData.put("regimenFiscal",invoice.getCfdi().getEmisor().getRegimenFiscal()+" "+ data.get(invoice.getCfdi().getEmisor().getRegimenFiscal()));
        invoiceData.put("regimenFiscalReceptor",invoice.getCfdi().getReceptor().getRegimenFiscalReceptor()
        +" "+ data.get(invoice.getCfdi().getReceptor().getRegimenFiscalReceptor()));

        return invoiceData;
    }
}

