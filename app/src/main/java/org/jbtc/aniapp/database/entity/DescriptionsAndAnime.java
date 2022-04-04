package org.jbtc.aniapp.database.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import org.jbtc.aniapp.model.Anime;
import org.jbtc.aniapp.model.Descriptions;

public class DescriptionsAndAnime {
    @Embedded
    public Descriptions descriptions;
    @Relation(
            parentColumn = "id",
            entityColumn = "descriptions_id"
    )
    public Anime anime;
}
