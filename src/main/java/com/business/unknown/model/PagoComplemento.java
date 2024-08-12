package com.business.unknown.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Date;

import static com.business.unknown.model.Constants.JSON_DATETIME_FORMAT;

@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PagoComplemento {

    private String idDocumento;
    private String folioOrigen;
    private String folio;
    private String equivalenciaDR;
    private String formaDePagoP;
    private String monedaDr;
    private int numeroParcialidad;
    private BigDecimal importeSaldoAnterior;
    private BigDecimal importePagado;
    private BigDecimal importeSaldoInsoluto;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JSON_DATETIME_FORMAT)
    private Date fechaPago;

    private boolean valido;
    private Integer statusFactura;
    private BigDecimal tipoCambioDr;
    private BigDecimal tipoCambio;
}
