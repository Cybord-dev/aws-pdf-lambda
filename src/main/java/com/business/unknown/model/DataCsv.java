package com.business.unknown.model;

public class DataCsv {
    private String column1;
    private String column2;

    // Getters y Setters
    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "column1='" + column1 + '\'' +
                ", column2='" + column2 + '\'' +
                '}';
    }
}
