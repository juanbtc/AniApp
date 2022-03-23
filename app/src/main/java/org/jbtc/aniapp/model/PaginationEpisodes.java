package org.jbtc.aniapp.model;

import java.util.List;

import lombok.Data;

@Data
public class PaginationEpisodes extends  Pagination{
    private List<Episode> documents;

    public List<Episode> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Episode> documents) {
        this.documents = documents;
    }
}
