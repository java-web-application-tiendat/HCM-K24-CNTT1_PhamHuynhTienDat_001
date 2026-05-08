package com.re.hackathon.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Book {
    private Long id;
    @Size(min=3,max=100,message = "Bắt buộc nhập, độ dài cho phép từ 3 đến 100 ký tự")
    private String title;
    @NotBlank(message = " Bắt buộc nhập, không được để khoảng trắng")
    private String author;
    private int quantity;
    private String coverImage;

    public Book(){}
    public Book(Long id, String title, String author, int quantity, String coverImage) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.coverImage = coverImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }
}
