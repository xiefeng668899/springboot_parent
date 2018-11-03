package com.atguigu.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Created by acer on 2018/10/14.
 */

@Configuration
@Component
public class DruidDatasource  implements EnvironmentAware {

    private Environment  env;

    @Bean
    public DruidDataSource druidDataSource(){
        DruidDataSource  druidDataSource=new DruidDataSource();
        druidDataSource.setUsername(env.getProperty("db_username"));
        System.out.println(env.getProperty("db_password"));
        druidDataSource.setUrl(env.getProperty("db_url"));
        druidDataSource.setDriverClassName(env.getProperty("db_driverclassname"));
        druidDataSource.setPassword(env.getProperty("db_password"));
         return  druidDataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DruidDataSource druidDataSource) throws Exception {
         SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
         sqlSessionFactoryBean.setDataSource(druidDataSource);

        // 配置mapper的扫描，找到所有的mapper.xml映射文件
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);

        /*// 加载全局的配置文件
        sqlSessionFactoryBean.setConfigLocation(
                new DefaultResourceLoader().getResource("classpath:mybatis/mybatis-config.xml"));*/

        return  sqlSessionFactoryBean.getObject();
    }

    @Bean
    public MapperScannerConfigurer  mapperScannerConfigurer(SqlSessionFactory sqlSessionFactory){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.atguigu.springboot.**.mapper");
        mapperScannerConfigurer.setSqlSessionFactory(sqlSessionFactory);
         return  mapperScannerConfigurer;
    }


    @Override
    public void setEnvironment(Environment environment) {
        this.env=environment;
    }
}
