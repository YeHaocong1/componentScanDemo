package com.chy.carsale.service.southimpl;

import com.chy.carsale.annotations.Region;
import com.chy.carsale.service.SaleCommissionService;
import org.springframework.stereotype.Service;

/**
 * @author YeHaocong
 * @decription 华南地区的提成计算业务实现
 * @Date 2020/6/3 18:30
 */

@Service(value = "saleCommissionService")
@Region(value = "south")
public class SouthSaleCommissionImpl implements SaleCommissionService {
    @Override
    public void saleSaleCommission(String carType) {
        if ("SUV".equalsIgnoreCase(carType)){
            System.out.println("华南地区卖出一辆"+ carType +"，获得提成1.5%");
        }else if ("SimpleCar".equalsIgnoreCase(carType)){
            System.out.println("华南地区卖出一辆"+ carType +"，提成加2%");
        }
    }

}
