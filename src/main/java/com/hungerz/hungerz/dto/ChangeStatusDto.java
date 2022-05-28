package com.hungerz.hungerz.dto;

import lombok.Data;

@Data
public class ChangeStatusDto {
    private long orderId;
    private int orderStatus;
}
