package com.packt.webstore.controller;

import com.packt.webstore.domain.dao.NewProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/panel")
public class PanelController {

    @Autowired
    private NewProductDao newProductDao;

    @RequestMapping
    public String panel() {
        return "panel";
    }

    @RequestMapping("/panelAdmin")
    public String panelAdmin() {
        return "panelAdmin";
    }

    @RequestMapping("/panelCook")
    public String panelCook() {
        return "panelCook";
    }

    @RequestMapping("/panelWaiter")
    public String panelWaiter() {
        return "panelWaiter";
    }

    //all products list from database with delete option
    @RequestMapping("/panelProducts")
    public String showAll(Model model) {
        model.addAttribute("panelProducts", newProductDao.findAll());
        return "panelProducts";
    }

    //all products list from database with edit option
    @RequestMapping("/panelProductsEdit")
    public String displayAll(Model model) {
        model.addAttribute("panelProductsEdit", newProductDao.findAll());
        return "panelProductsEdit";
    }

}