package org.jbtc.aniapp.model;

import lombok.Data;

@Data
public class RespuestaAnimes extends Respuesta{
    private PaginationAnimes data;
}
