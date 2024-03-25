package com.example.Authentification2.Exceptions;

public enum ErreurCodes {
    USER_NOT_FOUND(200),
    RESERVATION_NOT_FOUND(100),
    PARKING_NOT_FOUND(50),
    VEHICULE_NOT_FOUND(60)
    ;
    private int code;
    ErreurCodes(int code )
    {
        this.code =code;
    }
    public int getCode()
    {
        return code;
    }
}
