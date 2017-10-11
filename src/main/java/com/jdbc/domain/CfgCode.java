package com.jdbc.domain;

import java.io.Serializable;

public class CfgCode implements Serializable {

    private long codeId;
    private String tenantId;
    private String provCode;
    private String codeTypeCd;
    private String codeNm;

    public long getCodeId() {
        return codeId;
    }

    public void setCodeId(long codeId) {
        this.codeId = codeId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getProvCode() {
        return provCode;
    }

    public void setProvCode(String provCode) {
        this.provCode = provCode;
    }

    public String getCodeTypeCd() {
        return codeTypeCd;
    }

    public void setCodeTypeCd(String codeTypeCd) {
        this.codeTypeCd = codeTypeCd;
    }

    public String getCodeNm() {
        return codeNm;
    }

    public void setCodeNm(String codeNm) {
        this.codeNm = codeNm;
    }
}
