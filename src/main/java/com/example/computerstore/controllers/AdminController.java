package com.example.computerstore.controllers;

import com.example.computerstore.models.Product;
import com.example.computerstore.services.ProductService;
import com.example.computerstore.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {
    private static final Logger log = LoggerFactory.getLogger(AdminController.class);
    private final UserService userService;
    private final ProductService productService;
    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("users", userService.list());
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "admin";
    }
    @PostMapping("/admin/product/create")
    public String createProduct(@RequestParam("file1") MultipartFile file1,
                                @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3,
                                Product product) throws IOException {
        log.info("Creating product: {}", product.getTitle());
        productService.saveProduct(product, file1, file2, file3);
        return "redirect:/admin";
    }
    @PostMapping("/admin/product/delete")
    public String deleteProduct(Long id) {
        log.info("Deleting product with ID {}", id);
        productService.deleteProduct(id);
        return "redirect:/admin";
    }
}
