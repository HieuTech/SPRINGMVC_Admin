package rikkei.ss20_addtocart_session.models;


import java.time.LocalDate;

public class Orders {
    private int id;
    private int user_id;
    private LocalDate createAt;

    public Orders() {
    }

    public Orders(int id, int user_id, LocalDate createAt) {
        this.id = id;
        this.user_id = user_id;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }
}
