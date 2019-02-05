package com.packt.webstore.domain.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "restaurant", catalog = "")
public class ProductEntity {
    private Integer id;
    private String name;
    private String description;
    private String category;
    private Boolean vege;
    private String productId;
    private BigDecimal unitPrice;
    private Long unitsInOrder;
    private Long unitsInStock;
    private Collection<CartEntity> cartsById;

    public ProductEntity() {
    }

    public ProductEntity(Integer id) {
        this.id = id;
    }

    public ProductEntity(String productId, String name, BigDecimal unitPrice, String description, String category, boolean vege) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.description = description;
        this.category = category;
        this.vege = vege;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "vege")
    public Boolean getVege() {
        return vege;
    }

    public void setVege(Boolean vege) {
        this.vege = vege;
    }

    @Basic
    @Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "unit_price")
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "units_in_order")
    public Long getUnitsInOrder() {
        return unitsInOrder;
    }

    public void setUnitsInOrder(Long unitsInOrder) {
        this.unitsInOrder = unitsInOrder;
    }

    @Basic
    @Column(name = "units_in_stock")
    public Long getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    @Transient
    private MultipartFile productImage;
    @Transient
    public MultipartFile getProductImage() {
        return productImage;
    }
    @Transient
    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(category, that.category) &&
                Objects.equals(vege, that.vege) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(unitPrice, that.unitPrice) &&
                Objects.equals(unitsInOrder, that.unitsInOrder) &&
                Objects.equals(unitsInStock, that.unitsInStock);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, category, vege, productId, unitPrice, unitsInOrder, unitsInStock);
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<CartEntity> getCartsById() {
        return cartsById;
    }

    public void setCartsById(Collection<CartEntity> cartsById) {
        this.cartsById = cartsById;
    }
}
