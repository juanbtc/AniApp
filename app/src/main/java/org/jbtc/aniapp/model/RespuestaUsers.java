package org.jbtc.aniapp.model;

import lombok.Data;

@Data
public class RespuestaUsers extends  Respuesta{
 private PaginationUsers data;

    public PaginationUsers getData() {
        return data;
    }

    public void setData(PaginationUsers data) {
        this.data = data;
    }
}
