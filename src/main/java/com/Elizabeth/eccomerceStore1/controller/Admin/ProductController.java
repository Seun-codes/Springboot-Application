package com.Elizabeth.eccomerceStore1.controller.Admin;

import com.Elizabeth.eccomerceStore1.DTO.ProductDto;
import com.Elizabeth.eccomerceStore1.entitites.Product;
import com.Elizabeth.eccomerceStore1.exception.CustomAppException;
import com.Elizabeth.eccomerceStore1.repositories.ProductRepository;
import com.Elizabeth.eccomerceStore1.service.AdminService;
import com.Elizabeth.eccomerceStore1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ProductService productService;
    @Autowired
    private AdminService adminService;


    @GetMapping("/addProduct")
    public String adminAddProductView(Model model){
        model.addAttribute("product", new ProductDto());
        return "AdminAddProduct";
    }


    @PostMapping("/AdminAddProduct")
    public String adminAddProduct(@ModelAttribute("product")ProductDto productDto){
        adminService.createProducts(productDto);
        return "redirect:/viewProducts";
    }

    @GetMapping("/viewProducts")
    public ModelAndView viewProducts(){
        List<Product> listOfProducts = productRepository.findAll();
        ModelAndView mav = new ModelAndView("Products");
        mav.addObject("listOfProducts", listOfProducts);
        return mav;
    }

    @GetMapping("/editProductPage/{id}")
    public String renderEditPage(@PathVariable String id, Model model){
        Product product = productRepository.findById(Long.parseLong(id))
                .orElseThrow(()-> new CustomAppException("Product doesn't exit."));

        Product product1 = new Product();

        if (product != null) {
            product1.setProductId(product.getProductId());
            product1.setName(product.getName());
            product1.setCategory(product.getCategory());
            product1.setPrice(product.getPrice());
        }

        model.addAttribute("product", product1);
        return "editProductPage";
    }

    @PostMapping("/editProduct/{id}")
    public String editProduct(@ModelAttribute Product product, @PathVariable String id) {
        adminService.UpdateProducts(product, Long.parseLong(id));
        return "redirect:/viewProducts";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteAProduct(@PathVariable String id) {
        productService.deleteProduct(Long.parseLong(id));
        return "redirect:/Products";
    }
}
