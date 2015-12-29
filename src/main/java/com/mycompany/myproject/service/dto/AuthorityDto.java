package com.mycompany.myproject.service.dto;

import org.dozer.Mapping;

public class AuthorityDto {

    @Mapping("id")
    private Long id;

    @Mapping("name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
