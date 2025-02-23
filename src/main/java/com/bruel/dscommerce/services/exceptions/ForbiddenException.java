package com.bruel.dscommerce.services.exceptions;

public class ForbiddenException extends RuntimeException{
    public ForbiddenException(String menssage){
        super(menssage);
    }
}
