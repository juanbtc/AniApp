package org.jbtc.aniapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data @EqualsAndHashCode(callSuper=false)
public class RespuestaAnimes extends Respuesta{
    private PaginationAnimes data;
}