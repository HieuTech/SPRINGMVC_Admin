package rikkei.ss20_addtocart_session.dto.response;

public class ShoppingCartResponse {
    private Integer id;
    private Integer productId;
    private Integer userId;

    private Integer quantity;

    public ShoppingCartResponse(Integer id, Integer productId, Integer userId, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
    }

    public ShoppingCartResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}