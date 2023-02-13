package com.tutorial.graphqlCRUD.repository;

import com.tutorial.graphqlCRUD.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
}
