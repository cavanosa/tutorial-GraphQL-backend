package com.tutorial.graphqlCRUD.controller;

import com.tutorial.graphqlCRUD.dto.BrandDto;
import com.tutorial.graphqlCRUD.dto.ModelDto;
import com.tutorial.graphqlCRUD.entity.Brand;
import com.tutorial.graphqlCRUD.entity.Model;
import com.tutorial.graphqlCRUD.enums.Country;
import com.tutorial.graphqlCRUD.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public Brand saveBrand(@Argument BrandDto dto){
        return brandService.saveBrand(dto);
    }

    @MutationMapping
    public Brand updateBrand(@Argument int id, @Argument BrandDto dto){
        return brandService.updateBrand(id,dto);
    }

    @MutationMapping
    public Brand deleteBrand(@Argument int id){
        return brandService.deleteBrand(id);
    }

    @SubscriptionMapping
    public Flux<Brand> findAllBrandsFlux(){
        return brandService.findAllBrandsFlux();
    }

    @SubscriptionMapping
    public Mono<Brand> findOneBrandsMono(@Argument int id){
        return brandService.findOneMono(id);
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
    public Model saveModel(@Argument ModelDto dto){
        return brandService.saveModel(dto);
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
