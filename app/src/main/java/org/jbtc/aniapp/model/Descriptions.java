package org.jbtc.aniapp.model;

import lombok.Data;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Data
@Entity

public class Descriptions {
    @PrimaryKey(autoGenerate = true)
    public long id;

    private String en;
    private String fr;
    private String it;

}