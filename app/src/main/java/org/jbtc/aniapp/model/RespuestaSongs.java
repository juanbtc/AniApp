package org.jbtc.aniapp.model;

import lombok.Data;

@Data
public class RespuestaSongs extends  Respuesta{
    private  PaginationSongs data;

    public PaginationSongs getData() {
        return data;
    }

    public void setData(PaginationSongs data) {
        this.data = data;
    }
}
