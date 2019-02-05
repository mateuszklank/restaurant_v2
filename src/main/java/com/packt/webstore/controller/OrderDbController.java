package com.packt.webstore.controller;

import com.packt.webstore.domain.entity.OrderEntity;
import com.packt.webstore.domain.entity2.Order;
import com.packt.webstore.domain.dao.OrderDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Controller
public class OrderDbController {

    @Autowired
    private OrderDao orderDao;

//    @RequestMapping("/create")
//    @ResponseBody
//    public String create(String city, String street, String house, String code, BigDecimal price) {
//        OrderEntity order = null;
//        try {
//            order = new OrderEntity(city, street, house, code, price);
//            orderDao.save(order);
//        }
//        catch (Exception ex) {
//            return "Error creating the order: " + ex.toString();
//        }
//        return "Order succesfully created! (id = " + order.getId_order() + ")";
//    }

//    @RequestMapping("/delete")
//    @ResponseBody
//    @Transactional
//    public String delete(Long id_order) {
//        try {
//            OrderEntity order = new OrderEntity(id_order);
//            orderDao.delete(order);
//        }
//        catch (Exception ex) {
//            return "Error deleting the order: " + ex.toString();
//        }
//        return "Order successfully deleted!";
//    }

//    @RequestMapping("/get-by-street")
//    @ResponseBody
//    public String getByStreet(String street) {
//        String id_order;
//        try {
//            Order order = orderDao.findByStreet(street);
//            id_order = String.valueOf(order.getId_order());
//        }
//        catch (Exception ex) {
//            return "Order not found";
//        }
//        return "The order id is: " + id_order;
//    }

    /*
    @RequestMapping("/update")
    @ResponseBody
    public String updateOrder(long id_order, String city, String street, String house, String code) {
        try {
            Order order = orderDao.findOne(id_order);
            order.setCity(city);
            order.setStreet(street);
            order.setHouse(house);
            order.setCode(code);
            orderDao.save(order);
        }
        catch (Exception ex) {
            return "Error updating the order: " + ex.toString();
        }
        return "Order successfully updated!";
    }
    */

}