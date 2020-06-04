package com.chy.carsale.service.northimpl;

import com.chy.carsale.annotations.Region;
import com.chy.carsale.service.SaleCommissionService;
import org.springframework.stereotype.Service;

/**
 * @author YeHaocong
 * @decription 华北地区的提成计算业务实现
 * @Date 2020/6/3 18:30
 */

@Service(value = "saleCommissionService")
@Region(value = "north")
public class NorthSaleCommissionImpl implements SaleCommissionService {
    @Override
    public void saleSaleCommission(String carType) {
        if ("SUV".equalsIgnoreCase(carType)){
            System.out.println("华北地区卖出一辆"+ carType +"，获得提成2%");
        }else if ("SimpleCar".equalsIgnoreCase(carType)){
            System.out.println("华北地区卖出一辆"+ carType +"，绩效加1%");
        }
    }

}
