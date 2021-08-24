package com.mbb.malmobrewbucket.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderProduct implements Serializable{

    @EmbeddedId
    private OrderProductPK pk;

    @Column(nullable = false, name = "quantity")
    private int quantity;

    public OrderProduct() {
    }

    public OrderProduct(Product product, Cart cart, int quantity) {
        pk = new OrderProductPK();
        pk.setProduct(product);
        pk.setCart(cart);
        this.quantity = quantity;
    }

    @Transient
    public Product getProduct() {
        return this.pk.getProduct();
    }

    @Transient
    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderProductPK getPk() {
        return pk;
    }

    public void setPk(OrderProductPK pk) {
        this.pk = pk;
    }
}
