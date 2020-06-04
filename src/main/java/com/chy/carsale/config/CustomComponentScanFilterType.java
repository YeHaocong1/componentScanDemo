package com.chy.carsale.config;


import com.chy.carsale.annotations.Region;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.filter.AbstractTypeHierarchyTraversingFilter;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ClassUtils;
import org.springframework.util.PathMatcher;

import java.io.IOException;
import java.util.Properties;

/**
 * @author YeHaocong
 * @decription 自定义类型过滤器
 *
 */

public class CustomComponentScanFilterType extends AbstractTypeHierarchyTraversingFilter {


    //路径校验对象
    private PathMatcher pathMatcher;

    //地区名称
    private String regionName;

    //只扫描符合该表达式该包
    private static  String PACKAGE_PATTERN = ClassUtils.convertClassNameToResourcePath("com.chy.carsale.service.*.*");

    protected CustomComponentScanFilterType() throws IOException {
        //这两个参数考虑到是否要考虑父类和接口的信息，这里设置为false，都不考虑。
        super(false, false);
        pathMatcher = new AntPathMatcher();

        try {
            //载入配置文件，创建一个Properties对象
            Properties props = PropertiesLoaderUtils.loadAllProperties("region/region.properties");
            //获取配置文件配置的键为 region.name的值
            regionName = props.getProperty("region.name");
            if (regionName == null || regionName.isEmpty()){
                throw new RuntimeException("配置文件region/region.properties 的region.name 不存在");
            }
        }
        catch (RuntimeException e){
            throw e;
        }
    }


    /**
     *  因为该过滤器是排除过滤器，所以如果排除该类时，要返回true。扫描该类时，要返回false。
     * @param className
     * @return
     */
    @Override
    protected boolean matchClassName(String className) {
        //判断包名是否符合PACKAGE_PATTERN设置的表达式。
        boolean isMatchPackage = isMatchPackage(className);
        //不符合情况，返回true，不扫描该类。
        if (!isMatchPackage){
            return true;
        }
        try {
            //根据全限定名获取类的class对象。
            Class type = ClassUtils.forName(className, CustomComponentScanFilterType.class.getClassLoader());
            //获取该类上的Region注解
            Region region = (Region) type.getAnnotation(Region.class);
            if (region == null)
                //如果Region注解不存在，返回true，不扫描该类
                return true;

            //获取region注解上的value属性值。
            String value = region.value();
            if (regionName.equals(value)){
                //与配置文件配置的地区值一样时，返回false，扫描该类。
                return false;
            }
            //返回true，不扫描该类
            return true;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }

    }

    private boolean isMatchPackage(String className) {
        //将类全路径转为文件路径格式
        String path = ClassUtils.convertClassNameToResourcePath(className);
        boolean match =  pathMatcher.match(PACKAGE_PATTERN,path);
        return match;
    }
}
