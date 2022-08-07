package com.example;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

public class JieCode {
    public static void main(String[] args) {
        //新建一个代码生成器对象
        AutoGenerator autoGenerator=new AutoGenerator ();
        //配置策略

        //全局配置
        GlobalConfig globalConfig=new GlobalConfig ();
        globalConfig.setOutputDir ( "C:\\Java_project\\spring_project\\create_date\\src\\main\\java");
        globalConfig.setAuthor ( "杰哥" );
        globalConfig.setOpen ( false );//是否打开资源管理器
        globalConfig.setFileOverride ( false );
        globalConfig.setSwagger2 ( true );
        autoGenerator.setGlobalConfig ( globalConfig );
        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig ();
        dataSourceConfig.setUrl ( "jdbc:mysql://localhost:3306/car_data?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false" );
        dataSourceConfig.setDriverName ( "com.mysql.cj.jdbc.Driver" );
        dataSourceConfig.setUsername ( "wangjie" );
        dataSourceConfig.setPassword ( "19961016wj" );
        dataSourceConfig.setDbType ( DbType.MYSQL );
        autoGenerator.setDataSource ( dataSourceConfig );
        //包配置
//        PackageConfig packageConfig = new PackageConfig ();
////        packageConfig.setModuleName ("jie");
//        packageConfig.setParent ( "com.jie" );
//        packageConfig.setEntity ( "pojo" );
//        packageConfig.setMapper ( "mapper" );
//        packageConfig.setService ( "service" );
//        packageConfig.setController ( "controller" );
//        autoGenerator.setPackageInfo ( packageConfig );
        //策略配置
        StrategyConfig strategy = new StrategyConfig ();
        strategy.setInclude("user_data");
        strategy.setNaming( NamingStrategy.underline_to_camel);//下划线转驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);;
        strategy.setEntityLombokModel(true);//是否使用lombok开启注解
        strategy.setLogicDeleteFieldName ( "deleted" );//逻辑删除

        //自动填充配置
        TableFill createTime =new TableFill ( "create_time", FieldFill.INSERT );
        TableFill updateTime =new TableFill ( "update_time", FieldFill.INSERT_UPDATE );
        ArrayList<TableFill> tableFills = new ArrayList <> ();
        tableFills.add ( createTime );
        tableFills.add ( updateTime );
        strategy.setTableFillList (  tableFills);

        strategy.setVersionFieldName ( "version" );  //乐观锁配置
        autoGenerator.setStrategy ( strategy );
        //执行
        autoGenerator.execute ();
    }

}

