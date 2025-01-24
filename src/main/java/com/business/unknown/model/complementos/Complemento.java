package com.business.unknown.model.complementos;

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
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Complemento implements Serializable {

  private static final long serialVersionUID = 1L;

  
  private String version;

  private String uuid;

  private String fechaTimbrado;

  private String selloCFD;

  private String rfcProvCertif;

  private String selloSAT;

  private String noCertificadoSAT;

  private Totales totales;

  private List<Pago> pagos;

  @Jacksonized
  @Builder
  @Getter
  @Setter
  @ToString
  @AllArgsConstructor
  @NoArgsConstructor
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Totales implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal totalTrasladosBaseIVA16;

    private BigDecimal totalTrasladosImpuestoIVA16;

    private BigDecimal montoTotalPagos;
  }

  @Jacksonized
  @Builder
  @Getter
  @Setter
  @ToString
  @AllArgsConstructor
  @NoArgsConstructor
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Pago implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Relacionado> relacionados;

    private ImpuestosP impuestosP;

    private String fechaPago;

    private String formaDePagoP;

    private String monedaP;

    private String tipoCambioP;

    private BigDecimal monto;

    @Jacksonized
    @Builder
    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Relacionado implements Serializable {

      private static final long serialVersionUID = 1L;

      private ImpuestosDR impuestosDR;

      private String idDocumento;

      private String folio;

      private String monedaDR;

      private BigDecimal equivalenciaDR;

      private Integer numParcialidad;

      private BigDecimal impSaldoAnt;

      private BigDecimal impPagado;

      private BigDecimal impSaldoInsoluto;

      private String objetoImpDR;

      @Jacksonized
      @Builder
      @Getter
      @Setter
      @ToString
      @AllArgsConstructor
      @NoArgsConstructor
      @JsonInclude(JsonInclude.Include.NON_NULL)
      @JsonIgnoreProperties(ignoreUnknown = true)
      public static class ImpuestosDR implements Serializable {

        private static final long serialVersionUID = 1L;

        private TrasladosDR trasladosDR;

        @Jacksonized
        @Builder
        @Getter
        @Setter
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class TrasladosDR implements Serializable {

          private static final long serialVersionUID = 1L;

          private List<TrasladoDR> trasladoDR;

          @Jacksonized
          @Builder
          @Getter
          @Setter
          @ToString
          @AllArgsConstructor
          @NoArgsConstructor
          @JsonInclude(JsonInclude.Include.NON_NULL)
          @JsonIgnoreProperties(ignoreUnknown = true)
          public static class TrasladoDR implements Serializable {

            private static final long serialVersionUID = 1L;

            private BigDecimal baseDR;

            private String impuestoDR;

            private String tipoFactorDR;

            private BigDecimal tasaOCuotaDR;

            private BigDecimal importeDR;
          }
        }
      }
    }

    @Jacksonized
    @Builder
    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ImpuestosP implements Serializable {

      private static final long serialVersionUID = 1L;

      private TrasladosP trasladosP;

      @Jacksonized
      @Builder
      @Getter
      @Setter
      @ToString
      @AllArgsConstructor
      @NoArgsConstructor
      @JsonInclude(JsonInclude.Include.NON_NULL)
      @JsonIgnoreProperties(ignoreUnknown = true)
      public static class TrasladosP implements Serializable {

        private static final long serialVersionUID = 1L;

        private List<TrasladoP> trasladoP;

        @Jacksonized
        @Builder
        @Getter
        @Setter
        @ToString
        @AllArgsConstructor
        @NoArgsConstructor
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class TrasladoP implements Serializable {

          private static final long serialVersionUID = 1L;

          private BigDecimal baseP;

          private String impuestoP;

          private String tipoFactorP;

          private BigDecimal tasaOCuotaP;

          private BigDecimal importeP;
        }
      }
    }
  }
}
