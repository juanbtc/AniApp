package org.jbtc.aniapp.model;

import lombok.Data;

@Data
public class RespuestaEpisodes extends Respuesta {
  private  PaginationEpisodes data;
}
