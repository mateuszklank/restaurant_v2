package com.packt.webstore.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.packt.webstore.domain.dao.NewProductDao;
import com.packt.webstore.domain.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;

import com.packt.webstore.domain.entity2.Product;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.service.ProductService;

public class ProductIdValidator implements ConstraintValidator<ProductId, String>{

    @Autowired
    private ProductService productService;

    @Autowired
    private NewProductDao newProductDao;

    public void initialize(ProductId constraintAnnotation) {
        //??????????
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        ProductEntity product;
        try {
            product = newProductDao.findByProductId(value);
            //product = productService.getProductById(value);

        } catch (ProductNotFoundException e) {
            return true;
        }

        if(product!= null) {
            return false;
        }

        return true;
    }

}