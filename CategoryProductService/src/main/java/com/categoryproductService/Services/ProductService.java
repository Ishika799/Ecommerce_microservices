package com.categoryproductService.Services;

import com.categoryproductService.Model.Category;
import com.categoryproductService.Model.Product;
import com.categoryproductService.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    // add product
    public Product createProduct(Product product){
        Product product1=productRepo.save(product);
        return product1;
    }

    // check product by id
    public boolean existsById(int id) {
        return productRepo.existsById(id);
    }

    // update product by id
    public Product updateProduct(int id, Product updating)  {
        Product existing = productRepo.findById(id).get();
        if (updating.getProduct_name() != null) {
            existing.setProduct_name(updating.getProduct_name());
        }
        if (updating.getDescription() != null) {
            existing.setDescription(updating.getDescription());
        }
        if(updating.getPrice()!=0){
            existing.setPrice(updating.getPrice());
        }
        return createProduct(existing);
    }

    // delete product by id
    public void deleteProduct(int id){
        productRepo.deleteById(id);
    }

    // adding category
    public Product addCategory(int product_id, Category category){
        Product product=productRepo.productById(product_id).get(product_id);
        product.addCategory(category);
        return productRepo.save(product);
    }

    // removing category
    public Product removeCategory(int product_id,Category category){
        Product product=productRepo.productById(product_id).get(product_id);
        product.removeCategory(category);
        return productRepo.save(product);
    }

    // get all category
    public List<Product>getAllProduct(){
        return productRepo.findAll();
    }

    // get category by id
    public List<Product>getProductById(int id){
        return productRepo.productById(id);
    }

    // get category by name
    public List<Product>getProductByName(String name){
        return productRepo.productByName(name);
    }

    // get category by price
    public List<Product>getProductByPrice(int price){
        return productRepo.productByPrice(price);
    }

    // get category by desc
    public List<Product>getProductByDesc(String desc){
        return productRepo.productByDesc(desc);
    }

}
