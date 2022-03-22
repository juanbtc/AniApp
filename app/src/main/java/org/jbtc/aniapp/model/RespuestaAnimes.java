package org.jbtc.aniapp.model;

import lombok.Data;

@Data
public class RespuestaAnimes extends Respuesta{
    private PaginationAnimes data;

    public PaginationAnimes getData() {
        return data;
    }

    public void setData(PaginationAnimes data) {
        this.data = data;
    }
}