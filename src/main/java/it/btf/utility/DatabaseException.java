package it.btf.utility;

import org.springframework.http.ResponseEntity;

public class DatabaseException extends Exception {


    private ResponseEntity response;

    public DatabaseException(){


    }

    public DatabaseException(ResponseEntity status){
        this.response=status;
    }

    public ResponseEntity getResponse() {
        return response;
    }



}
