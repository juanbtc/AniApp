package org.jbtc.aniapp.model;

import lombok.Data;

@Data
public class Respuesta {
    private int status_code;
    private String message;
    //data
    private String version;
}
