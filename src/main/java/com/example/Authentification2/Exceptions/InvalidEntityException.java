package com.example.Authentification2.Exceptions;

import lombok.Getter;

import java.util.List;

public class InvalidEntityException extends RuntimeException{
    @Getter
    private ErreurCodes erreurCodes;
    @Getter
    private List<String> erreurs;
    public InvalidEntityException(String message )
    {
        super(message);
    }
    public InvalidEntityException(String message ,Throwable cause)
    {
        super(message, cause);
    }
    public InvalidEntityException(String message ,Throwable cause,ErreurCodes erreurCodes)
    {
        super(message, cause);
        this.erreurCodes =erreurCodes;
    }
    public InvalidEntityException(String message ,ErreurCodes erreurCodes)
    {
        super(message);
        this.erreurCodes =erreurCodes;
    }
    public InvalidEntityException(String message ,ErreurCodes erreurCodes,List<String> erreurs)
    {
        super(message);
        this.erreurCodes =erreurCodes;
        this.erreurs =erreurs;
    }
}
