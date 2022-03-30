package org.jbtc.aniapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data @EqualsAndHashCode(callSuper=false)
public class RespuestaSongs extends  Respuesta{
    private  PaginationSongs data;
}
