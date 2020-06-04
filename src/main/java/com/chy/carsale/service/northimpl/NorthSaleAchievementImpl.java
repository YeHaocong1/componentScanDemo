package com.chy.carsale.service.northimpl;

import com.chy.carsale.annotations.Region;
import com.chy.carsale.service.SaleAchievementsService;
import org.springframework.stereotype.Service;

/**
 * @author YeHaocong
 * @decription 华北地区的绩效计算业务实现
 * @Date 2020/6/3 18:07
 */

@Service(value = "saleAchievementService")
@Region(value = "north")
public class NorthSaleAchievementImpl implements SaleAchievementsService {


    @Override
    public void calculateSaleAchievements(String carType) {
        if ("SUV".equalsIgnoreCase(carType)){
            System.out.println("华北地区卖出一辆"+ carType +"，绩效加10分");
        }else if ("SimpleCar".equalsIgnoreCase(carType)){
            System.out.println("华北地区卖出一辆"+ carType +"，绩效加8分");
        }
    }
}
