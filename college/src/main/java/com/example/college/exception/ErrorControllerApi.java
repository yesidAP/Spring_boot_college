package com.example.college.exception;

import com.example.college.Enum.ErrorApi;

/**
 * Class exception for handling errors associated with the use of JPA.
 *
 * @author yfandica
 */
public class ErrorControllerApi extends RuntimeException {

    private ErrorApi errorApi;

    public ErrorControllerApi(ErrorApi errorApi) {

        super(errorApi.getMessage());
        this.errorApi = errorApi;
    }

    public int getCode(){
        return errorApi.getCode();
    }

    public String getMessage(){
        return errorApi.getMessage();
    }

}
