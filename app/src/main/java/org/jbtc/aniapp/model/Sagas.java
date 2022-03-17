package org.jbtc.aniapp.model;

import lombok.Data;

@Data
public class Sagas {
    private Descriptions titles;
    private Descriptions descriptions;
    private int episode_from;
    private int episode_to;
    private int episodes_count;
}
