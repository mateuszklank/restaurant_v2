package com.packt.webstore.controller;

import com.packt.webstore.domain.entity.ProductEntity;
import com.packt.webstore.exception.NoProductsFoundUnderCategoryException;
import com.packt.webstore.exception.ProductNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.packt.webstore.domain.entity2.Product;
import com.packt.webstore.service.ProductService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import com.packt.webstore.domain.dao.NewProductDao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import java.math.BigDecimal;
//import com.packt.webstore.domain.entity.Product;
//import com.packt.webstore.domain.repository.ProductRepository;

import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	//private ProductRepository productRepository;
	private ProductService productService;

	@Autowired
	private NewProductDao newProductDao;

	//list of products (not from database)
	@RequestMapping("/old")
	public String list(Model model) {
		//model.addAttribute("products", productRepository.getAllProducts());
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	//list of products (not from database)
	@RequestMapping("/all")
	public String allProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	/*
	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
		model.addAttribute("products", productService.getProductsByCategory(productCategory));
		return "products";
	}
	[Poprzednia implementacja metody]
	*/

	/*
	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
		List<Product> products = productService.getProductsByCategory(productCategory);
		if (products == null || products.isEmpty()) {
			throw new NoProductsFoundUnderCategoryException();
		}
		model.addAttribute("products", products);
		return "products";
	}
	*/

	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar="ByCriteria") Map<String, List<String>> filterParams, Model model) {
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		return "products";
	}

	/*
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}
	*/

	//edit product in database using form, get
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editProductByProductId(@RequestParam("id") Integer productId, Model model) {
		model.addAttribute("product", newProductDao.findById(productId));
		ProductEntity editProduct = new ProductEntity();
		model.addAttribute("editProduct", editProduct);
		return "editProduct";
	}

	//edit product in database using form, post
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String processEditNewProductForm(@ModelAttribute("editProduct") @Valid ProductEntity editProduct, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "editProduct";
		}
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Próba wiązania niedozwolonych pól: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		MultipartFile productImage = editProduct.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if (productImage!=null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(rootDirectory+"resources\\images\\" + editProduct.getProductId() + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("Niepowodzenie podczas próby zapisu obrazka produktu", e);
			}
		}
		newProductDao.save(editProduct); //save in database
//		productService.addProduct(editProduct); //old
		return "redirect:/panel/panelAdmin";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		ProductEntity newProduct = new ProductEntity();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}

	/*
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product newProduct, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "addProduct";
		}
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Próba wiązania niedozwolonych pól: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		MultipartFile productImage = newProduct.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if (productImage!=null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(rootDirectory+"resources\\images\\" + newProduct.getProductId() + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("Niepowodzenie podczas próby zapisu obrazka produktu", e);
			}
		}
		productService.addProduct(newProduct);
		return "redirect:/products";
	}
	*/

	@RequestMapping("/invalidPromoCode")
	public String invalidPromoCode() {
		return "invalidPromoCode";
	}

	///////////////////////////////////////////////DATABASE/////////////////////////////////////////////////////

	//create product in database
	@RequestMapping("/create")
	@ResponseBody
	public String create(String productId, String name, BigDecimal unitPrice, String description, String category, boolean vege) {
		ProductEntity product = null;
		try {
			product = new ProductEntity(productId, name, unitPrice, description, category, vege);
			newProductDao.save(product);
		}
		catch (Exception ex) {
			return "Error creating the product: " + ex.toString();
		}
		return "Product succesfully created! (id = " + product.getProductId() + ")";
	}

	//create product in database using form
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid ProductEntity newProduct, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "addProduct";
		}
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Próba wiązania niedozwolonych pól: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		MultipartFile productImage = newProduct.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if (productImage!=null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(rootDirectory+"resources\\images\\" + newProduct.getProductId() + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("Niepowodzenie podczas próby zapisu obrazka produktu", e);
			}
		}
		newProduct.setUnitsInOrder(1L);
		newProduct.setUnitsInStock(1L);
		newProductDao.save(newProduct); //save in database
//		productService.addProduct(newProduct); //old
		return "redirect:/panel/panelAdmin";
	}

	//delete product from database
	@RequestMapping("/delete")
	//@Transactional
	public String delete(Integer id) {
		try {
			ProductEntity product = new ProductEntity(id);
			newProductDao.delete(product);
		}
		catch (Exception ex) {
			return "Error deleting the product: " + ex.toString();
		}
		return "redirect:/panel/panelAdmin";
	}

	@RequestMapping("/get-by-name")
	@ResponseBody
	public String getByName(String name) {
		String productId;
		try {
			ProductEntity product = newProductDao.findByName(name);
			productId = String.valueOf(product.getProductId());
		}
		catch (Exception ex) {
			return "Product not found";
		}
		return "The product id is: " + productId;
	}

	//all products list from database
	@RequestMapping
	public String showAll(Model model) {
		model.addAttribute("products", newProductDao.findAll());
		return "products";
	}

    /*
	//details of product (old)
	@RequestMapping("/product")
	public String findByProductId(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", newProductDao.findByProductId(productId));
		return "product";
	}
    */

    //details of product (with working cart)
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String index(@RequestParam("id") String productId, ModelMap modelMap) {
        modelMap.put("product", newProductDao.findByProductId(productId));
        return "product/index";
    }

    /*
    //old cart
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		InMemoryProductDaoImpl InMemoryProductDaoImpl = new InMemoryProductDaoImpl();
		modelMap.put("listOfProducts", InMemoryProductDaoImpl.findAll());
		return "product/index";
	}
    */

    //show products by category
	@RequestMapping("/{category}")
	public String findByCategory(Model model, @PathVariable("category") String productCategory) {
		List<ProductEntity> products = newProductDao.findByCategory(productCategory);
		if (products == null || products.isEmpty()) {
			throw new NoProductsFoundUnderCategoryException();
		}
		model.addAttribute("products", products);
		return "products";
	}

	//update product from database
    @RequestMapping("/update")
    @ResponseBody
    public String updateProduct(String productId, String name, BigDecimal unitPrice, String description, String category, boolean vege) {
        try {
        	ProductEntity product = newProductDao.findByProductId(productId);
        	product.setName(name);
        	product.setUnitPrice(unitPrice);
        	product.setDescription(description);
        	product.setCategory(category);
        	product.setVege(vege);
        	newProductDao.save(product);
        }
        catch (Exception ex) {
            return "Error updating the product: " + ex.toString();
        }
        return "Product successfully updated!";
    }

	///////////////////////////////////////////////DATABASE/////////////////////////////////////////////////////
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidProductId", exception.getProductId());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
		mav.setViewName("productNotFound");
		return mav;
	}

}