package br.gov.sp.campinas.exception;

public class AuthenticationException extends  RuntimeException {

    public AuthenticationException(String message){
        super(message);
    }
}