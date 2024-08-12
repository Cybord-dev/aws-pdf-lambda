package com.business.unknown.model.cfdi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
public class Impuesto implements Serializable {

  private static final long serialVersionUID = -5759374411200231323L;

  private List<Traslado> traslados;
  private List<Retencion> retenciones;
  private BigDecimal totalImpuestosTrasladados;
  private BigDecimal totalImpuestosRetenidos;
}
