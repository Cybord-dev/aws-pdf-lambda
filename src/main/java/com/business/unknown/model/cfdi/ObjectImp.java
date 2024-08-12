package com.business.unknown.model.cfdi;

import lombok.Getter;

@Getter
public enum ObjectImp {
  NO_OBJETO_IMPUESTOS("01"),
  OBJETO_IMPUESTOS("02"),
  SI_OBJETO_NO_OBLIGADO("03");

  private final String valor;

  ObjectImp(String valor) {
    this.valor = valor;
  }
}
