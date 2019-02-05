package com.packt.webstore.domain.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

import java.util.List;

import com.packt.webstore.domain.entity.ProductEntity;
import com.packt.webstore.domain.entity2.Product;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface NewProductDao extends CrudRepository<ProductEntity, String> {

//    List<ProductEntity> findAll();
//
//    List<ProductEntity> findByCategory(String productCategory);
//
//    public ProductEntity findByName(String Name);
//
//    public ProductEntity findByProductId(String productId);

    List<ProductEntity> findAll();

    List<ProductEntity> findByCategory(String category);

    public ProductEntity findByName(String name);

    public ProductEntity findByProductId(String product_id);

    public ProductEntity findById(Integer id);

}