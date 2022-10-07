package com.jnunes.springcloud.azure.functions.consts;

import com.jnunes.springcloud.suport.DateUtils;
import com.jnunes.springcloud.suport.Utils;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.Map;

import static com.jnunes.springcloud.azure.functions.consts.ConstsKeyMap.*;

public class FunctionConsts {
    private Map<String, String> map;

    private FunctionConsts(Map<String, String> map) {
        this.map = map;
    }

    public static FunctionConsts of(Map<String, String> map) {
        return new FunctionConsts(map);
    }

    public Long getIdReferencia() {
        return Utils.toLongOrNull(map.get(ID_REFERENCIA));
    }

    public Integer getNumeroRegistros() {
        return Utils.toIntOrNull(map.get(NUMERO_REGISTROS));
    }

    public LocalDate getDataInicioReferencia() {
        return DateUtils.toLocalDate(map.get(DATA_INICIO_REFERENCIA));
    }

    public LocalDate getDataFimReferencia() {
        return DateUtils.toLocalDate(map.get(DATA_FIM_REFERENCIA));
    }

    public String getTitulo() {
        return StringUtils.trimToNull(map.get(TITULO));
    }

    public String getNome() {
        return StringUtils.trimToNull(map.get(NOME));
    }

    public String getCurso() {
        return StringUtils.trimToNull(map.get(CURSO));
    }
}
