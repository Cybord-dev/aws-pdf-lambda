package com.business.unknown.model.cfdi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Jacksonized
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cfdi implements Serializable {

  private static final long serialVersionUID = -303198243726456894L;

  @NonNull @Builder.Default private String version = "4.0";
  // autogenerado
  private String serie;
  // Ui
  private String folio;
  // autogenerado
  private String fecha;
  // stampHelper
  private String sello;
  // ui
  private String formaPago;
  // ui
  private String metodoPago;
  // s3
  private String noCertificado;
  // base
  private String certificado;
  // ui
  private String condicionesDePago;
  // ui
  @NonNull @Builder.Default private BigDecimal subtotal = BigDecimal.ZERO;
  // ui
  private BigDecimal descuento;
  // ui
  @NonNull @Builder.Default private BigDecimal total = BigDecimal.ZERO;
  // ui
  @NonNull private String moneda;
  // ui
  private BigDecimal tipoCambio;
  // ui
  @NonNull private String tipoDeComprobante;
  // ui
  @NonNull private String exportacion;
  // ui
  @NonNull private String lugarExpedicion;
  // ui
  private String confirmacion;
  // ui
  private InformacionGlobal informacionGlobal;
  // ui
  private CfdiRelacionados cfdiRelacionados;
  // ui
  @NonNull private Emisor emisor;
  // ui
  @NonNull private Receptor receptor;
  // ui
  @NonNull private List<Concepto> conceptos;
  //
  private List<Impuesto> impuestos;

}
