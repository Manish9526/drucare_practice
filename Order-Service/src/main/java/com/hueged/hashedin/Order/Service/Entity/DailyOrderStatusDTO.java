package com.hueged.hashedin.Order.Service.Entity;

import java.util.List;

import com.hueged.hashedin.Order.Service.Feign.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyOrderStatusDTO {

    private String orderDay;
    private String status;
    private Long count;
    private String userId;
    private List <UserDto> userList;
   

    public DailyOrderStatusDTO(String orderDay, String status,  String userId,Long count) {
        this.orderDay = orderDay;
        this.status = status;
        this.count = count;
        this.userId = userId;
    }


    
}
