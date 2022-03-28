package org.jbtc.aniapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(callSuper=false)
public class RespuestaSong extends  Respuesta{
    private  Song data;

    public Song getData() {
        return data;
    }

    public void setData(Song data) {
        this.data = data;
    }
}
