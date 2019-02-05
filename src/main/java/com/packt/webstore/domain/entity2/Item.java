package com.packt.webstore.domain.entity2;

import com.packt.webstore.domain.entity.ProductEntity;

public class Item {

    private ProductEntity product;
    private int quantity;

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item() {
    }

    public Item(ProductEntity product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

}