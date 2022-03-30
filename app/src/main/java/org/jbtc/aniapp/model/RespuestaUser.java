package org.jbtc.aniapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data @EqualsAndHashCode(callSuper=false)
public class RespuestaUser extends  Respuesta{
    private User data;
}
