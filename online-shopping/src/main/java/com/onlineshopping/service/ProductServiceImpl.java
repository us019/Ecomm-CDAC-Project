package com.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.onlineshopping.dao.ProductDao;
import com.onlineshopping.model.Product;
import com.onlineshopping.utility.StorageService;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired 
	private ProductDao productDao;
	
	@Autowired
	private StorageService storageService;

	@Override
	public void addProduct(Product product, MultipartFile productImmage) {
		System.out.println("in product serviceImpprimgg ->"+productImmage);
		String productImageName = storageService.store(productImmage);
		System.out.println("productimagename"+productImageName);
		product.setImageName(productImageName);
		
		this.productDao.save(product);
	}

	
	@Override
	public void deleteProduct(Product product) {
	    // Delete the product image from the file system, if it exists
	    if (product.getImageName() != null) {
	        storageService.delete(product.getImageName());
	    }
	    
	    // Delete the product from the database
	    productDao.delete(product);
	}


	@Override
	public void updateProduct(Product product, MultipartFile image) {
	    if (!image.isEmpty()) {
	        // Store the new image and update the product's image name
	        String newImageName = storageService.store(image);
	        product.setImageName(newImageName);
	    }
	    
	    // Update the product's details
	    this.productDao.save(product);
	}



}
