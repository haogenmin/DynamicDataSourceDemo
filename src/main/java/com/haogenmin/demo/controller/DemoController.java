package com.haogenmin.demo.controller;

import com.haogenmin.demo.handler.DynamicDataSourceHandler;
import com.haogenmin.demo.manager.DataSourceMap;
import com.haogenmin.demo.mapper.DataSourceInfoMapper;
import com.haogenmin.demo.mapper.ProductMapper;
import com.haogenmin.demo.model.DataSourceInfo;
import com.haogenmin.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    DataSourceInfoMapper dataSourceInfoMapper;

    @RequestMapping(value = "product",method = RequestMethod.GET)
    @ResponseBody
    public String product(Integer userId,Integer productId) {
        DataSourceMap.getInstance().setCurrentUserId(userId);
        Product product = productMapper.findProductById(productId);
        return product.toString();
    }

    @RequestMapping(value = "toAddDataSource")
    public String toAddDataSource () {
        return "addDataSource";
    }

    @RequestMapping(value = "addDataSource",method = RequestMethod.POST)
    @ResponseBody
    public String addDataSource(DataSourceInfo dataSourceInfo,Integer userId) {
        DataSourceMap.getInstance().setUserToDataSourceMap(userId,dataSourceInfo.getDatasourceKey());
        int result = dataSourceInfoMapper.addDataSourceInfo(dataSourceInfo);
        System.out.println("添加前dataSource数量:"+DynamicDataSourceHandler.getInstance().dataSourceCount());
        DynamicDataSourceHandler.getInstance().addDataSourceInfo(dataSourceInfo);
        System.out.println("添加后dataSource数量:"+DynamicDataSourceHandler.getInstance().dataSourceCount());
        return "OK";
    }

}
