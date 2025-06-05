package com.smlee.AccountApp.dto;

import com.smlee.AccountApp.entity.User;

public class UserDto {

    public UserDto fromEntity(User _user) {
        UserDto dto = new UserDto();
        dto.setId(_user.getId());
        dto.setEmail(_user.getEmail());
        dto.setName(_user.getName());
        return dto;
    }

    public User toEntity()
    {
        User user = new User();
        user.setId(this.id);
        user.setEmail(this.email);
        user.setName(this.name);
        return user;
    }

    public UserDto() {}
    public UserDto(long _id, String _email, String _name) {
        this.id = _id;
        this.email = _email;
        this.name = _name;
    }

    public long getId() {
        return id;
    }

    public void setId(long _id) {
        this.id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String _email) {
        this.email = _email;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    private long id;
    private String email;
    private String name;
}
