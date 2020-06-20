package com.haogenmin.demo.mapper;


import com.haogenmin.demo.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author ：HaoGenmin
 * @Title :ProductMapper
 * @date ：Created in 2020/6/18 13:41
 * @description：
 */
@Mapper
@Component
public interface ProductMapper {
    @Select("select * from product where pid = #{pid}")
    Product findProductById(Integer pid);
}
