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
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetencionConcepto implements Serializable {

  private static final long serialVersionUID = 4590109888394034653L;

  @NonNull private BigDecimal base;
  @NonNull private String impuesto;
  @NonNull private String tipoFactor;
  @NonNull private BigDecimal tasaOCuota;
  @NonNull private BigDecimal importe;
}
