package test;

import com.chy.carsale.config.ApplicationContextConfig;
import com.chy.carsale.service.SaleAchievementsService;
import com.chy.carsale.service.SaleCommissionService;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author YeHaocong
 * @decription TODO
 * @Date 2020/6/3 18:39
 */

public class TestDemo {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);

    @Test
    public void test(){
        SaleCommissionService saleCommissionService = (SaleCommissionService) context.getBean("saleCommissionService");
        SaleAchievementsService saleAchievementsService = (SaleAchievementsService) context.getBean("saleAchievementService");
        saleAchievementsService.calculateSaleAchievements("SUV");
        saleCommissionService.saleSaleCommission("SimpleCar");
    }
}
