package com.models;

import org.hibernate.annotations.Generated;

import javax.persistence.*;

@Entity
@Table(name="`orders`")
public class Order {
    @Id
   @Column(name = "order_id")
    private int orderId ;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "status")
    private boolean status;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

