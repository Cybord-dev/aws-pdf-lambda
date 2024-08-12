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
import java.util.List;

@Jacksonized
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Concepto implements Serializable {

  private static final long serialVersionUID = 1690079459401358817L;

  @NonNull private String claveProdServ;
  private String claveProdServDesc;
  private String noIdentificacion;
  @NonNull private BigDecimal cantidad;
  @NonNull private String claveUnidad;
  private String unidad;
  @NonNull private String descripcion;
  @NonNull private BigDecimal valorUnitario;
  @NonNull private BigDecimal importe;
  private BigDecimal descuento;
  @NonNull private String objetoImp;
  private List<ImpuestoConcepto> impuestos;
  private ACuentaTerceros aCuentaTerceros;
  private InformacionAduanera informacionAduanera;
  private CuentaPredial cuentaPredial;
  private Parte parte;
}
