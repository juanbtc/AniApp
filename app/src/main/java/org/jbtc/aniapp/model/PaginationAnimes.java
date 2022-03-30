package org.jbtc.aniapp.model;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data @EqualsAndHashCode(callSuper=false)
public class PaginationAnimes extends Pagination{
    private List<Anime> documents;
}
