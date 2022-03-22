package org.jbtc.aniapp.model;

import lombok.Data;

@Data
public class Descriptions {
    private String en;
    private String fr;
    private String it;

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getIt() {
        return it;
    }

    public void setIt(String it) {
        this.it = it;
    }
}