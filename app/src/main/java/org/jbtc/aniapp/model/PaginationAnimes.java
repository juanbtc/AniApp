package org.jbtc.aniapp.model;

import java.util.List;

import lombok.Data;

@Data
public class PaginationAnimes extends Pagination{
    private List<Anime> documents;
}
