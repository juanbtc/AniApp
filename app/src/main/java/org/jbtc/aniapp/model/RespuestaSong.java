package org.jbtc.aniapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data @EqualsAndHashCode(callSuper=false)
public class RespuestaSong extends  Respuesta{
    private  Song data;
}
