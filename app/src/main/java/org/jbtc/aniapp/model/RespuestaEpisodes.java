package org.jbtc.aniapp.model;

public class RespuestaEpisodes extends Respuesta {
  private  PaginationEpisodes data;

    public PaginationEpisodes getData() {
        return data;
    }

    public void setData(PaginationEpisodes data) {
        this.data = data;
    }
}
