package rikkei.ss20_addtocart_session.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;


public class ProductRequest {
  private Integer id;
  private String name;
  private Integer categoryId;
  private Double price;
  private Integer stock;
  private Boolean status;
  private String image;

    public ProductRequest() {
    }

    public ProductRequest(Integer id, String name, Integer categoryId, Double price, Integer stock, Boolean status, String image) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
        this.stock = stock;
        this.status = status;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}