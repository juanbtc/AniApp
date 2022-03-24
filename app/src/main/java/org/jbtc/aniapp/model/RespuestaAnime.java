package org.jbtc.aniapp.model;

import lombok.Data;

@Data
public class RespuestaAnime extends Respuesta{
    private Anime data;
    public Anime getData() {
        return data;
    }

    public void setData(Anime data) {
        this.data = data;
    }
}

