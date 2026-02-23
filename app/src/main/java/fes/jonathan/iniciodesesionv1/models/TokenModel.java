package fes.jonathan.iniciodesesionv1.models;

import java.util.Date;

public class TokenModel {
    private String token;
    private Date fecha;

    public TokenModel(String token, Date fecha) {
        this.token = token;
        this.fecha = fecha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
