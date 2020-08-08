package com.lti.test;

import org.junit.Test;

import com.lti.dao.ProductDao;
import com.lti.entity.Product;

public class ProductDaoTest {

	@Test
	public void add() {
		Product p = new Product();
		p.setId(999);
		p.setName("iPhone 99");
		p.setPrice(9999999);
		
		ProductDao dao = new ProductDao();
		dao.insert(p);
	}
}
