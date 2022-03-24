package org.jbtc.aniapp.model;

import lombok.Data;

@Data
public class Titles {
    private String rj;
    private String en;
    private String jp;
    private String it;




    public String getRj() {
        return rj;
    }

    public void setRj(String rj) {
        this.rj = rj;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getJp() {
        return jp;
    }

    public void setJp(String jp) {
        this.jp = jp;
    }

    public String getIt() {
        return it;
    }

    public void setIt(String it) {
        this.it = it;
    }
}

