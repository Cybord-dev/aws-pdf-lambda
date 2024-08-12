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

@Jacksonized
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Parte implements Serializable {

  private static final long serialVersionUID = -113298243996456894L;

  @NonNull private InformacionAduanera informacionAduanera;
  private String noIdentificacion;
  @NonNull private String claveProdServ;
  @NonNull @Builder.Default private BigDecimal cantidad = BigDecimal.ONE;
  private String unidad;
  @NonNull private String descripcion;
  @Builder.Default private BigDecimal valorUnitario = BigDecimal.ONE;
  @Builder.Default private BigDecimal importe = BigDecimal.ONE;
}
