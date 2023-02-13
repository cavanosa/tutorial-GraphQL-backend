package com.tutorial.graphqlCRUD.repository;

import com.tutorial.graphqlCRUD.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
