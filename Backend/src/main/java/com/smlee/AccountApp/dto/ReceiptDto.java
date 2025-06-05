package com.smlee.AccountApp.dto;

public class ReceiptDto {

    public ReceiptDto() {}

    public ReceiptDto(long _id, String _title, String _content, String _date, String _categoryName, String _userEmail) {
        this.id = _id;
        this.title = _title;
        this.content = _content;
        this.date = _date;
        this.categoryName = _categoryName;
        this.userEmail = _userEmail;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long _id) {
        this.id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String _title) {
        this.title = _title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String _content) {
        this.content = _content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String _date) {
        this.date = _date;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String _categoryName) {
        this.categoryName = _categoryName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String _userEmail) {
        this.userEmail = _userEmail;
    }

    private long id;
    private String title;
    private String content;
    private String date;
    private String categoryName;
    private String userEmail;    
}
