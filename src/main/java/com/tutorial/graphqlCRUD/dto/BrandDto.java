package com.tutorial.graphqlCRUD.dto;

import com.tutorial.graphqlCRUD.enums.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BrandDto {
    private String name;
    private Country country;
}
