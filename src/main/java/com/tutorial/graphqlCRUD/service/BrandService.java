package com.tutorial.graphqlCRUD.service;

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

    public Brand saveBrand(String name, Country country){
        Brand brand = Brand.builder().name(name).country(country).build();
        return brandRepository.save(brand);
    }

    public Brand updateBrand(int id, String name, Country country){
        Brand brand = brandRepository.findById(id)
                .orElseThrow(()->new RuntimeException("id not exists"));
        brand.setName(name);
        brand.setCountry(country);
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

    public Model saveModel(int brand_id, String name){
        Brand brand = brandRepository.findById(brand_id)
                .orElseThrow(()->new RuntimeException("id not exists"));
        return modelRepository.save(Model.builder().name(name).brand(brand).build());
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
        saveBrand("Mercedes", Country.GER);
        saveBrand("BMW", Country.GER);
        saveBrand("Jaguar", Country.ENG);
        saveModel(1, "Clase S");
        saveModel(2, "Serie 5");
        saveModel(3, "F pace");
    }
}
