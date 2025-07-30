package com.duende.cicero_app.dto.feat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeatCreateDTO {

    private Long id;
    private String name;
    private Integer cost;
    private String description;

}
