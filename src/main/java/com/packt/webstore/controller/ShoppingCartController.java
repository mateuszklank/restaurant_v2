package com.packt.webstore.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.packt.webstore.domain.dao.CartDao;
import com.packt.webstore.domain.dao.CustomerDao;
import com.packt.webstore.domain.dao.NewProductDao;
import com.packt.webstore.domain.dao.OrderDao;
import com.packt.webstore.domain.entity.CartEntity;
import com.packt.webstore.domain.entity.CustomerEntity;
import com.packt.webstore.domain.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.packt.webstore.domain.entity2.Item;

@Controller
@RequestMapping(value = "cart")
public class ShoppingCartController {

    @Autowired
    private NewProductDao newProductDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CartDao cartDao;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "cart/index";
    }

    //order home form, get
    @RequestMapping(value = "indexDetails", method = RequestMethod.GET)
    public String indexDetailsGet(Model model) {
        CustomerEntity newCustomer = new CustomerEntity();
        model.addAttribute("newCustomer", newCustomer);
        return "cart/indexDetails";
    }

//    //order home form, post
//    @RequestMapping(value = "/indexDetails", method = RequestMethod.POST)
//    public String indexDetailsPost(@ModelAttribute("newCustomer") @Valid CustomerEntity newCustomer, BindingResult result, HttpServletRequest request) {
//        if(result.hasErrors()) {
//            return "newCustomer";
//        }
//        String[] suppressedFields = result.getSuppressedFields();
//        if (suppressedFields.length > 0) {
//            throw new RuntimeException("Próba wiązania niedozwolonych pól: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
//        }
//        customerDao.save(newCustomer);
//        return "redirect:/cart/bought";
//    }

    //order home form, post
    @RequestMapping(value = "/indexDetails", method = RequestMethod.POST)
    public String indexDetailsPost(@ModelAttribute("newCustomer") @Valid CustomerEntity newCustomer, BindingResult result, HttpServletRequest request, HttpSession session) {
        if(result.hasErrors()) {
            return "newCustomer";
        }
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Próba wiązania niedozwolonych pól: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        //customerDao.save(newCustomer);
        newCustomer = customerDao.save(newCustomer);

        List<Item> cart = (List<Item>) session.getAttribute("cart");
        session.setAttribute("cart", cart);

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCustomerByCustomerId(newCustomer);
        //orderEntity.setCustomerByCustomerId(customerDao.findById(1));
        orderDao.save(orderEntity);

        Iterator i = cart.iterator();
        while(i.hasNext()) {
            CartEntity cartEntity = new CartEntity();
            cartEntity.setQuantity(cart.size());
            cartEntity.setProductByProductId();
            cartEntity.setOrderByOrderId();
            cartDao.save(cartEntity);
        }
        return "redirect:/products";
    }

//    @RequestMapping(value = "bought")
//    public String bought(HttpSession session) {
//
//        List<Item> cart = (List<Item>) session.getAttribute("cart");
//        session.setAttribute("cart", cart);
//
//        Iterator i = cart.iterator();
//        OrderEntity orderEntity = new OrderEntity();
//        orderEntity.setCustomerByCustomerId();
//        orderDao.save(orderEntity);
//        while(i.hasNext()) {
//            cartDao.save(new CartEntity());
//        }
//        return "redirect:/products";
//    }

    @RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
    public String buy(@PathVariable("id") String id, HttpSession session) {
        //InMemoryProductDaoImpl InMemoryProductDaoImpl = new InMemoryProductDaoImpl();
        if (session.getAttribute("cart") == null) {
            List<Item> cart = new ArrayList<Item>();
            cart.add(new Item(newProductDao.findByProductId(id), 1));
            session.setAttribute("cart", cart);
        } else {
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int index = this.exists(id, cart);
            if (index == -1) {
                cart.add(new Item(newProductDao.findByProductId(id), 1));
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);
        }
        return "redirect:/cart/index";
    }

    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") String id, HttpSession session) {
        //InMemoryProductDaoImpl InMemoryProductDaoImpl = new InMemoryProductDaoImpl();
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int index = this.exists(id, cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        return "redirect:/cart/index";
    }

    private int exists(String id, List<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getProductId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
/*
    @RequestMapping(value = "/addOrder", method = RequestMethod.GET)
    public String getAddOrderForm(Model model) {
        Order newOrder = new Order();
        model.addAttribute("newOrder", newOrder);
        return "addOrder";
    }

    //create order in database using form
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public String processAddOrderForm(@ModelAttribute("newOrder") @Valid Order newOrder, BindingResult result, HttpServletRequest request) {
        if(result.hasErrors()) {
            return "addOrder";
        }
        String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Próba wiązania niedozwolonych pól: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        orderDao.save(newOrder);
        return "redirect:/products";
    }
*/
/*
    @RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
    public String buy(@PathVariable("id") String id, HttpSession session) {
        //InMemoryProductDaoImpl InMemoryProductDaoImpl = new InMemoryProductDaoImpl();
        Order newOrder = new Order();
        if (session.getAttribute("cart") == null) {
            List<Item> cart = new ArrayList<Item>();
            cart.add(new Item(newProductDao.findByProductId(id), 1));
            session.setAttribute("cart", cart);
        } else {
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            int index = this.exists(id, cart);
            if (index == -1) {
                cart.add(new Item(newProductDao.findByProductId(id), 1));
            } else {
                int quantity = cart.get(index).getQuantity() + 1;
                cart.get(index).setQuantity(quantity);
            }
            session.setAttribute("cart", cart);
        }
        newOrder.setPrice();
        return "redirect:/cart/index";
    }
*/
}