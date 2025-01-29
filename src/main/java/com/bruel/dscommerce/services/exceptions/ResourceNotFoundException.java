package com.bruel.dscommerce.services.exceptions;

//a RuntimeException não exige o bloco de try-catch
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String menssage){
        super(menssage);
    }
}
