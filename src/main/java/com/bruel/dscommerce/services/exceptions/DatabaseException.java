package com.bruel.dscommerce.services.exceptions;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String menssage){
        super(menssage);
    }
}
