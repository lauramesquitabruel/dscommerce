package com.bruel.dscommerce.dtos;

import java.time.Instant;

//customiza o json de resposta em caso de erro
public class CustomError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

    //como não existe os setters da classe, é interessante manter só o construtor com argumentos
    public CustomError(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}
