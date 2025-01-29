package com.business.unknown.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvService {

    public CsvService() {
    }

    public Map<String, String> readCsvFile(String filePath) {
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
                dataList.put(values[0].trim(), values[1].trim());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV file: " + filePath, e);
        }

        return dataList;
    }

    public Map<String, String> getMonedaMap() {
        String filePath = getClass().getClassLoader().getResource("csv/c_Moneda.csv").getPath();
        return readCsvFile(filePath);
    }

    public Map<String, String> getMetodoPagoMap() {
        String filePath = getClass().getClassLoader().getResource("csv/c_MetodoPago.csv").getPath();
        return readCsvFile(filePath);
    }

    public Map<String, String> getFormaPagoMap() {
        String filePath = getClass().getClassLoader().getResource("csv/c_FormaPago.csv").getPath();
        return readCsvFile(filePath);
    }

    public Map<String, String> getUsoCfdiMap() {
        String filePath = getClass().getClassLoader().getResource("csv/c_UsoCFDI.csv").getPath();
        return readCsvFile(filePath);
    }

    public Map<String, String> getTipoDeComprobanteMap() {
        String filePath = getClass().getClassLoader().getResource("csv/c_TipoDeComprobante.csv").getPath();
        return readCsvFile(filePath);
    }

    public Map<String, String> getRegimenFiscalMap() {
        String filePath = getClass().getClassLoader().getResource("csv/c_RegimenFiscal.csv").getPath();
        return readCsvFile(filePath);
    }
}