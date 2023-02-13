package com.tutorial.graphqlCRUD.controller;

import com.tutorial.graphqlCRUD.entity.Brand;
import com.tutorial.graphqlCRUD.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BrandController {

    @Autowired
    BrandService brandService;

    @QueryMapping
    public List<Brand> findAllBrands(){
        return brandService.findAllBrands();
    }

    @QueryMapping
    public Brand findOneBrand(@Argument int id){
        return brandService.findOneBrand(id);
    }
}
