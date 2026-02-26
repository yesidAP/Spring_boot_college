package com.example.college.Enum;

import lombok.Getter;

/**
 * Set of error message.
 *
 * @author yfandica
 */
@Getter
public enum ErrorApi {
    INVALID_INPUT(4001, "Error, input data is incorrect."),
    NOT_EXITS_DATA(4002, "Error, not data associate with the Id."),
    DATA_INTEGRITY(4003, "Error related to data integrity, check" +
            " that the data type is correct, or check if there are foreign dependencies in them."),
    NO_CHANGE_ID(4004, "Student ID or Subject ID cannot be changed.");

    private final int code;
    private final String message;

    ErrorApi(int code, String message){
        this.code = code;
        this.message = message;
    }

}



