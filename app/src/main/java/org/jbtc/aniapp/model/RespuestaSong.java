package org.jbtc.aniapp.model;

import lombok.Data;

@Data
public class RespuestaSong extends  Respuesta{
    private  Song data;

    public Song getData() {
        return data;
    }

    public void setData(Song data) {
        this.data = data;
    }
}
