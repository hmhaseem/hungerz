package com.hungerz.hungerz.service;

import com.hungerz.hungerz.dto.DeliveryDto;
import com.hungerz.hungerz.entity.Delivery;
import com.hungerz.hungerz.repository.DeliveryRepo;
import com.hungerz.hungerz.utility.CommonResponse;
import com.hungerz.hungerz.utility.MessageStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ShippingService {

    @Autowired
    DeliveryRepo deliveryRepo;

    public CommonResponse saveDelivery(DeliveryDto deliveryDto) {
        CommonResponse commonResponse = new CommonResponse();

        Delivery delivery = new Delivery();
        delivery.setDistance(deliveryDto.getDistance());
        delivery.setFee(deliveryDto.getFee());
        delivery.setType(deliveryDto.getType());
        delivery.setName(deliveryDto.getName());
        deliveryRepo.save(delivery);
        commonResponse.setStatus(true);
        commonResponse.setMessage(MessageStatus.SUCCESS);
        return commonResponse;
    }

   public CommonResponse updateDelivery(DeliveryDto deliveryDto) {
        CommonResponse commonResponse = new CommonResponse();
        Optional<Delivery> delivery = deliveryRepo.findById(deliveryDto.getId());
        if (delivery.isPresent()) {
            Delivery deliveryUpdate = delivery.get();
            deliveryUpdate.setName(deliveryDto.getName());
            deliveryUpdate.setDistance(deliveryDto.getDistance());
            deliveryUpdate.setType(deliveryDto.getType());
            deliveryUpdate.setFee(deliveryDto.getFee());
            deliveryRepo.save(deliveryUpdate);
            commonResponse.setMessage(MessageStatus.SUCCESS);
            commonResponse.setStatus(true);
        } else {
            commonResponse.setStatus(false);
            commonResponse.setMessage(MessageStatus.FAIL);
        }
        return commonResponse;
    }

}
