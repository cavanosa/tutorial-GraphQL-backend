package com.tutorial.graphqlCRUD.entity;

import com.tutorial.graphqlCRUD.enums.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    private Country country;
    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    List<Model> models;
}
