package com.smlee.AccountApp.dto;

public class CategoryDto {

    public CategoryDto() {}

    public CategoryDto(Long _id, String _name, String _description) {
        this.id = _id;
        this.name = _name;
        this.description = _description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long _id) {
        this.id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String _description) {
        this.description = _description;
    }
    
    private Long id;
    private String name;
    private String description;
}
