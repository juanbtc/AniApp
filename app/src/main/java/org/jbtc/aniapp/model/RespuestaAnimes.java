package org.jbtc.aniapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.google.gson.annotations.SerializedName;
import lombok.NoArgsConstructor;

@Data @EqualsAndHashCode(callSuper=false) @NoArgsConstructor
public class RespuestaAnimes extends Respuesta{

    @SerializedName("data")
    private PaginationAnimes animes;
}