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
public class Traslado implements Serializable {
  private static final long serialVersionUID = -1258042238944783721L;

  @NonNull private BigDecimal base;
  @NonNull private String impuesto;
  @NonNull private String tipoFactor;
  private BigDecimal tasaOCuota;
  private BigDecimal importe;
}
