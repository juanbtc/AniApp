package org.jbtc.aniapp.model;

import java.util.List;

public class PaginationSongs extends  Pagination{
    private List<Song> documents;

    public List<Song> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Song> documents) {
        this.documents = documents;
    }

}
