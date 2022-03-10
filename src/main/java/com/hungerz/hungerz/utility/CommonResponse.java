package com.hungerz.hungerz.utility;


import lombok.Data;

@Data
public class CommonResponse {
    private Object payload;
    private Boolean status;
    private String message;
}
