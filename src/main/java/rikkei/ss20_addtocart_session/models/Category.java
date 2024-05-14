package rikkei.ss20_addtocart_session.models;

public class Category {
    private int id;
    private int productId ;
    private String categoryName;

    public Category() {
    }

    public Category(int id, int productId, String categoryName) {
        this.id = id;
        this.productId = productId;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
