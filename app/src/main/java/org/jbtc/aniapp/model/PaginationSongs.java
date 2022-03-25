package org.jbtc.aniapp.model;

import java.util.List;

import lombok.Data;

@Data
public class PaginationSongs extends  Pagination{
    private List<Song> documents;
}
