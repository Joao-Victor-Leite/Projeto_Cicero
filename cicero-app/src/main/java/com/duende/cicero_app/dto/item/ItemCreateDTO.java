package com.duende.cicero_app.dto.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCreateDTO {

    private String name;
    private Integer usesTotal;
    private Integer usesCurrent;
    private Integer size;

}
