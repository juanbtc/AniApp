package org.jbtc.aniapp.model;

import java.util.List;

import lombok.Data;

@Data
public class PaginationUsers extends Pagination{
    private List<User> documents;
}
