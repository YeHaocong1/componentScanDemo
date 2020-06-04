package com.chy.carsale.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author YeHaocong
 * @decription 配置类
 * @Date 2020/6/3 18:40
 */

@Configuration
@ComponentScan(basePackages = "com.chy.carsale",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM,classes = {CustomComponentScanFilterType.class})})
public class ApplicationContextConfig {
}
