package org.jbtc.aniapp.model;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(callSuper=false)
public class PaginationEpisodes extends  Pagination{
    private List<Episode> documents;
}
