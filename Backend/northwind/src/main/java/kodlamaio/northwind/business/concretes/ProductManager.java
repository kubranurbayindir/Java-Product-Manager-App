package kodlamaio.northwind.business.concretes;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResults;
import kodlamaio.northwind.core.utilities.results.Results;
import kodlamaio.northwind.core.utilities.results.SuccessDataResults;
import kodlamaio.northwind.core.utilities.results.SuccessResults;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

//productmanagerada service adlı anatosyın veriyoruz. yani bu class service görevi göreceğini tanıtıyoruz. 
@Service
public class ProductManager implements ProductService{

private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResults<List<Product>> getAll() {
		    
			return new SuccessDataResults<List<Product>>
			(this.productDao.findAll(),"Data listelendi");			
				
	}

	@Override
	public Results add(Product product) {
		this.productDao.save(product);
		return new SuccessResults("Ürün eklendi");
	}

	@Override
	public DataResults<Product> getByProductName(String productName) {
		return new SuccessDataResults<Product>
		(this.productDao.getByProductName(productName),"Data listelendi");	
	}

	@Override
	public DataResults<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		//business codes
		
		return new SuccessDataResults<Product>
		(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data listelendi");
	}

	@Override
	public DataResults<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResults<List<Product>>
		(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),"Data listelendi");
	}

	@Override
	public DataResults<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResults<List<Product>>
		(this.productDao.getByCategoryIn(categories),"Data listelendi");
	}

	@Override
	public DataResults<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResults<List<Product>>
		(this.productDao.getByProductNameContains(productName),"Data listelendi");
	}

	@Override
	public DataResults<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResults<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName),"Data listelendi");
	}

	@Override
	public DataResults<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResults<List<Product>>
		(this.productDao.getByNameAndCategory(productName,categoryId),"Data listelendi");
	}

	@Override
	public DataResults<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResults<List<Product>>
		(this.productDao.findAll(pageable).getContent());
	}

	@Override
	public DataResults<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"productName");
		return new SuccessDataResults<List<Product>>
		(this.productDao.findAll(sort),"Başarılı");
	}
	
	@Override
	public DataResults<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResults<List<ProductWithCategoryDto>>
		(this.productDao.getProductWithCategoryDetails(),"Data listelendi");		
	}



}
