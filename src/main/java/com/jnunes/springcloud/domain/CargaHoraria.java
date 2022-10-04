package com.jnunes.springcloud.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CargaHoraria {
    VINTE_HORAS("20HRS"),
    TRITA_HORAS("30HRS"),
    QUARENTA_HORAS("40HRS"),
    SESSENTA_HORAS("60HRS");

    private final String horas;

    CargaHoraria(String horas) {
        this.horas = horas;
    }

    @JsonValue
    public String getHoras() {
        return horas;
    }
}