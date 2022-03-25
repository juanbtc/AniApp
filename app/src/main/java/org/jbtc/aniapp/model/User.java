package org.jbtc.aniapp.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private int role;
    private int gender;
    private String avatar;
}
