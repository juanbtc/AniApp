package org.jbtc.aniapp.model;

import lombok.Data;

@Data
public class RespuesteUser extends  Respuesta{
    private User data;

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }
}
