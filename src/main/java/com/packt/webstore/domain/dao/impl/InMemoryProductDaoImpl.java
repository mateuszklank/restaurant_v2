package com.packt.webstore.domain.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.webstore.domain.dao.ProductDao;
import org.springframework.stereotype.Repository;
import com.packt.webstore.domain.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class InMemoryProductDaoImpl implements ProductDao {

	private List<Product> listOfProducts = new ArrayList<Product>();
	
	public InMemoryProductDaoImpl() {
		
		Product lasagne = new Product("P1234", "Lasagne z warzywami", new BigDecimal(30));
		lasagne.setDescription("Z cukinią, batatem, sosem pomidorowym, kaszą jaglaną i serem wegańskim");
		lasagne.setCategory("Obiad");
//		lasagne.setUnitsInStock(100);
		
		Product spaghetti = new Product("P1235", "Spaghetti z pomidorami", new BigDecimal(25));
		spaghetti.setDescription("Makaron z sosem pomidorowym, papryką, cukinią i pomidorami");
		spaghetti.setCategory("Obiad");
//		spaghetti.setUnitsInStock(100);
		
		Product farfale = new Product("P1236", "Farfalle w sosie śmietanowo-brokułowym", new BigDecimal(29));
		farfale.setDescription("Makaron kokardki z brokułami i śmietaną");
		farfale.setCategory("Obiad");
//		farfale.setUnitsInStock(100);
		
		Product falafel = new Product("P1237", "Falafel z sałatką", new BigDecimal(32));
		falafel.setDescription("Kotlecik z cieciorki z przyprawami z surówką z majonezem wegańskim własnej roboty");
		falafel.setCategory("Obiad");
//		falafel.setUnitsInStock(100);
		
		Product gofr = new Product("P1238", "Gofr z jajkiem", new BigDecimal(15));
		gofr.setDescription("Gofr wytrawny z jajkiem sadzonym, szczypiorem i sosem majonezowym");
		gofr.setCategory("Sniadanie");
//		gofr.setUnitsInStock(100);
		
		Product jajecznica = new Product("P1239", "Jajecznica", new BigDecimal(12));
		jajecznica.setDescription("3 jajka z szynką, kiełkami, szczypiorkiem i masłem");
		jajecznica.setCategory("Sniadanie");
//		jajecznica.setUnitsInStock(100);
		
		Product hummus = new Product("P1240", "Hummus na ostro", new BigDecimal(19));
		hummus.setDescription("Z ciecierzycą, ostrą papryką, pesto, sałatą i warzywami");
		hummus.setCategory("Sniadanie");
//		hummus.setUnitsInStock(100);
		
		Product banan = new Product("P1241", "Bananowe szaleństwo", new BigDecimal(10));
		banan.setDescription("Z bananem z galaretką bez cukru, jogurtem naturalnym i konfiturą");
		banan.setCategory("Deser");
//		banan.setUnitsInStock(100);
		
		Product granola = new Product("P1242", "Granola (bezglutenowa)", new BigDecimal(10));
		granola.setDescription("Sałatka owocowa z miętą, jogurtem naturalnym i granolą");
		granola.setCategory("Deser");
//		granola.setUnitsInStock(100);
		
		Product rajskie = new Product("P1242", "Rajskie Bounty", new BigDecimal(10));
		rajskie.setDescription("Nasza wege czekolada z kaszą jaglaną, kokosem i rodzynkami");
		rajskie.setCategory("Deser");
//		rajskie.setUnitsInStock(100);
		
		listOfProducts.add(lasagne);
		listOfProducts.add(spaghetti);
		listOfProducts.add(farfale);
		listOfProducts.add(falafel);
		listOfProducts.add(gofr);
		listOfProducts.add(rajskie);
		listOfProducts.add(jajecznica);
		listOfProducts.add(granola);
		listOfProducts.add(hummus);
		listOfProducts.add(banan);
		
	}


	
	public List<Product> getAllProducts() {
		return listOfProducts;
	}
	
	public Product getProductById(String productId) {
		Product productById = null;
		for(Product product : listOfProducts) {
			if(product!=null && product.getProductId()!=null && product.getProductId().equals(productId)) {
				productById = product;
				break;
			}
		}
		if(productById == null) {
			throw new IllegalArgumentException("Brak produktu o wskazanym id: " + productId);
		}
		return productById;
	}
	
	public List<Product> getProductsByCategory(String category) {
		List<Product> productsByCategory = new ArrayList<Product>();
		for(Product product: listOfProducts) {
			if(category.equalsIgnoreCase(product.getCategory())) {
				productsByCategory.add(product);
			}
		}
		return productsByCategory;
	}
	
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		Set<Product> productsByBrand = new HashSet<Product>();
		Set<Product> productsByCategory = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();
		if(criterias.contains("brand")) {
			for(String brandName: filterParams.get("brand")) {
				for(Product product: listOfProducts) {
					//if(brandName.equalsIgnoreCase(product.getManufacturer())) {
					if(brandName.equalsIgnoreCase(product.getCategory())) {
						productsByBrand.add(product);
					}
				}
			}
		}
		if(criterias.contains("category")) {
			for(String category: filterParams.get("category")) {
				productsByCategory.addAll(this.getProductsByCategory(category));
			}
		}
		productsByCategory.retainAll(productsByBrand);
		return productsByCategory;
	}
	
	public void addProduct(Product product) {
		listOfProducts.add(product);
	}
	
}