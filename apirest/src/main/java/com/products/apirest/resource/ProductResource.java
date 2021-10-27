package com.products.apirest.resource;

import com.products.apirest.model.Product;
import com.products.apirest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*")
public class ProductResource {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/produtos")
    public List<Product> listProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/produtos/{id}")
    public Optional<Product> product(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    @DeleteMapping("/produtos/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @PostMapping("/produto")
    public Product saveProduct(@RequestBody @Validated Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/produto")
    public Product changeProduct(@RequestBody @Validated Product product) {
        return productRepository.save(product);
    }

}
