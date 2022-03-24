package org.jbtc.aniapp.model;

import java.util.List;

public class PaginationUsers extends Pagination{
    private List<User> documents;

    public List<User> getDocuments() {
        return documents;
    }

    public void setDocuments(List<User> documents) {
        this.documents = documents;
    }
}
