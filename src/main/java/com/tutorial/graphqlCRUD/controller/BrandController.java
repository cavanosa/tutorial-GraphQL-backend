package com.tutorial.graphqlCRUD.controller;

import com.tutorial.graphqlCRUD.entity.Brand;
import com.tutorial.graphqlCRUD.entity.Model;
import com.tutorial.graphqlCRUD.enums.Country;
import com.tutorial.graphqlCRUD.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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

    @MutationMapping
    public Brand saveBrand(@Argument String name, @Argument Country country){
        return brandService.saveBrand(name, country);
    }

    @MutationMapping
    public Brand updateBrand(@Argument int id, @Argument String name, @Argument Country country){
        return brandService.updateBrand(id, name, country);
    }

    @MutationMapping
    public Brand deleteBrand(@Argument int id){
        return brandService.deleteBrand(id);
    }

    // MODEL

    @QueryMapping
    public List<Model> findAllModels(){
        return brandService.findAllModels();
    }

    @QueryMapping
    public Model findOneModel(@Argument int id){
        return brandService.findOneModel(id);
    }

    @MutationMapping
    public Model saveModel(@Argument int brand_id, @Argument String name){
        return brandService.saveModel(brand_id, name);
    }

    @MutationMapping
    public Model updateModel(@Argument int id, @Argument String name){
        return brandService.updateModel(id, name);
    }

    @MutationMapping
    public Model deleteModel(@Argument int id){
        return brandService.deleteModel(id);
    }
}
