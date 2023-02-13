package com.tutorial.graphqlCRUD.service;

import com.tutorial.graphqlCRUD.entity.Brand;
import com.tutorial.graphqlCRUD.enums.Country;
import com.tutorial.graphqlCRUD.repository.BrandRepository;
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

    public List<Brand> findAllBrands(){
        return brandRepository.findAll();
    }

    public Brand findOneBrand(int id){
        return brandRepository.findById(id)
                .orElseThrow(()->new RuntimeException("id not exists"));
    }

    public Brand save(String name, Country country){
        Brand brand = Brand.builder().name(name).country(country).build();
        return brandRepository.save(brand);
    }

    @PostConstruct
    private void loadData(){
        save("Mercedes", Country.GER);
        save("BMW", Country.GER);
        save("Jaguar", Country.ENG);
    }
}
