package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResults;
import kodlamaio.northwind.core.utilities.results.Results;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	
	DataResults<List<Product>> getAll();
    DataResults<List<Product>> getAllSorted();
    DataResults<List<Product>> getAll(int pageNo, int pageSize);
    Results add(Product product);
   
    DataResults<Product> getByProductName(String productName);
	  
    DataResults<Product> getByProductNameAndCategoryId(String productName, int categoryId);
	  
    DataResults<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
	  
    DataResults<List<Product>> getByCategoryIdIn(List<Integer> categories);
	  
    DataResults<List<Product>> getByProductNameContains(String productName);
	  
    DataResults<List<Product>> getByProductNameStartsWith(String productName);

    DataResults<List<Product>> getByNameAndCategory(String productName, int categoryId);
    
    DataResults<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
    
 
    
	

}
