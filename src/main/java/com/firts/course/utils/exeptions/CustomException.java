package com.firts.course.utils.exeptions;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomException extends RuntimeException{

    private final Date date;

    public CustomException(String message, Date date) {
        super(message);
        this.date = date;
    }
}
