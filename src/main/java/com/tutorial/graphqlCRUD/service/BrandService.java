package com.tutorial.graphqlCRUD.service;

import com.tutorial.graphqlCRUD.dto.BrandDto;
import com.tutorial.graphqlCRUD.dto.ModelDto;
import com.tutorial.graphqlCRUD.entity.Brand;
import com.tutorial.graphqlCRUD.entity.Model;
import com.tutorial.graphqlCRUD.enums.Country;
import com.tutorial.graphqlCRUD.repository.BrandRepository;
import com.tutorial.graphqlCRUD.repository.ModelRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    ModelRepository modelRepository;

    public List<Brand> findAllBrands(){
        return brandRepository.findAll();
    }

    public Brand findOneBrand(int id){
        return brandRepository.findById(id)
                .orElseThrow(()->new RuntimeException("id not exists"));
    }

    public Brand saveBrand(BrandDto dto){
        Brand brand = Brand.builder().name(dto.getName()).country(dto.getCountry()).build();
        return brandRepository.save(brand);
    }

    public Brand updateBrand(int id, BrandDto dto){
        Brand brand = brandRepository.findById(id)
                .orElseThrow(()->new RuntimeException("id not exists"));
        brand.setName(dto.getName());
        brand.setCountry(dto.getCountry());
        return brandRepository.save(brand);
    }

    public Brand deleteBrand(int id){
        Brand brand = brandRepository.findById(id)
                .orElseThrow(()->new RuntimeException("id not exists"));
        brandRepository.delete(brand);
        return brand;
    }

    // MODEL

    public List<Model> findAllModels(){
        return modelRepository.findAll();
    }

    public Model findOneModel(int id){
        return modelRepository.findById(id)
                .orElseThrow(()->new RuntimeException("id not exists"));
    }

    public Model saveModel(ModelDto dto){
        Brand brand = brandRepository.findById(dto.getBrand_id())
                .orElseThrow(()->new RuntimeException("id not exists"));
        return modelRepository.save(Model.builder().name(dto.getName()).brand(brand).build());
    }

    public Model updateModel(int id, String name){
        Model model = modelRepository.findById(id)
                .orElseThrow(()->new RuntimeException("id not exists"));
        model.setName(name);
        return modelRepository.save(model);
    }

    public Model deleteModel(int id){
        Model model = modelRepository.findById(id)
                .orElseThrow(()->new RuntimeException("id not exists"));
        modelRepository.delete(model);
        return model;
    }


    @PostConstruct
    private void loadData(){
        saveBrand(new BrandDto("Mercedes", Country.GER));
        saveBrand(new BrandDto("BMW", Country.GER));
        saveBrand(new BrandDto("Jaguar", Country.ENG));
        saveModel(new ModelDto(1, "Clase S"));
        saveModel(new ModelDto(2, "Serie 5"));
        saveModel(new ModelDto(3, "F Pace"));
    }
}
