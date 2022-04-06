package org.jbtc.aniapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data @EqualsAndHashCode(callSuper=false) @NoArgsConstructor
public class RespuestaAnime extends Respuesta{
    @SerializedName("data")
    private Anime anime;
}