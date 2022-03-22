package org.jbtc.aniapp.model;

import lombok.Data;

@Data
public class Pagination {
    private int current_page;
    private int count;
    //documents
    private int last_page;
}