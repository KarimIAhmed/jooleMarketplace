package com.example.joole.controller;

import com.example.joole.model.Product;
import com.example.joole.model.ProductType;
import com.example.joole.model.Project;
import com.example.joole.model.User;
import com.example.joole.service.ProductService;
import com.example.joole.service.ProductTypeService;
import com.example.joole.service.ProjectService;
import com.example.joole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SearchController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/projects")
    public ResponseEntity<?> getProjects(){
        return ResponseEntity.ok(projectService.findProject());
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(productService.findProducts());
    }

    @GetMapping("/producttypes")
    public ResponseEntity<?> getProductTypes(){
        return ResponseEntity.ok(productTypeService.findProductTypes());
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok(userService.findUser());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        Product product = productService.findProductById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/producttypes/{id}")
    public ResponseEntity<ProductType> getProductTypeById(@PathVariable long id) {
        ProductType productType = productTypeService.findProductTypeById(id);
        return ResponseEntity.ok(productType);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getEmployeeById(@PathVariable long id) {
        User employee = userService.findUserById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable long id) {
        Project project = projectService.findProjectById(id);
        return ResponseEntity.ok(project);
    }

    @RequestMapping(path = "getproductbybrand/{productBrand}")
    public ResponseEntity<?> getProductByBrand(@PathVariable String productBrand) {
        List<Product> list=productService.findProducts();
        List<Product> returnList=new ArrayList<>();
        for(Product prod:list){
            if(prod.getProductBrand().equals(productBrand)) returnList.add(prod);
        }
        return ResponseEntity.ok(returnList);
    }

    @RequestMapping(path = "getproductbycertification/{certification}")
    public ResponseEntity<?> getProductByCertification(@PathVariable String certification) {
        List<Product> list=productService.findProducts();
        List<Product> returnList=new ArrayList<>();
        for(Product prod:list){
            if(prod.getCertification().equals(certification)) returnList.add(prod);
        }
        return ResponseEntity.ok(returnList);
    }
    @RequestMapping(path = "getproductbymanufacturer/{manufacturer}")
    public ResponseEntity<?> getByManufacturer(@PathVariable String manufacturer) {
        List<Product> list=productService.findProducts();
        List<Product> returnList=new ArrayList<>();
        for(Product prod:list){
            if(prod.getDescription().getManufacturer().equals(manufacturer)) returnList.add(prod);
        }
        return ResponseEntity.ok(returnList);
    }

    @RequestMapping(path = "getproductbyseries/{series}")
    public ResponseEntity<?> getBySeries(@PathVariable String series) {
        List<Product> list=productService.findProducts();
        List<Product> returnList=new ArrayList<>();
        for(Product prod:list){
            if(prod.getDescription().getSeries().equals(series)) returnList.add(prod);
        }
        return ResponseEntity.ok(returnList);
    }

    @RequestMapping(path = "getproductbymodel/{model}")
    public ResponseEntity<?> getByModel(@PathVariable String model) {
        List<Product> list=productService.findProducts();
        List<Product> returnList=new ArrayList<>();
        for(Product prod:list){
            if(prod.getDescription().getModel().equals(model)) returnList.add(prod);
        }
        return ResponseEntity.ok(returnList);
    }
    @RequestMapping(path = "getproductbyairflow/{airflow}")
    public ResponseEntity<?> getByAirflow(@PathVariable int airflow) {
        List<Product> list=productService.findProducts();
        List<Product> returnList=new ArrayList<>();
        for(Product prod:list){
            if(prod.getTechnicalDetails().getAirflow()==airflow) returnList.add(prod);
        }
        return ResponseEntity.ok(returnList);
    }

    @RequestMapping(path = "getproductbypower/{power}")
    public ResponseEntity<?> getByModel(@PathVariable int power) {
        List<Product> list=productService.findProducts();
        List<Product> returnList=new ArrayList<>();
        for(Product prod:list){
            if(prod.getTechnicalDetails().getPower()==power) returnList.add(prod);
        }
        return ResponseEntity.ok(returnList);
    }
    @RequestMapping(path = "getproducttypebyyear/{year}")
    public ResponseEntity<?> getByYear(@PathVariable int year) {
        List<ProductType> list=productTypeService.findProductTypes();
        List<ProductType> returnList=new ArrayList<>();
        for(ProductType prod:list){
            if(prod.getModelYear()==year) returnList.add(prod);
        }
        return ResponseEntity.ok(returnList);
    }
    @RequestMapping(path = "getprojectbyuser/{user}")
    public ResponseEntity<?> getProjectByUser(@PathVariable User user) {
        List<User> list=userService.findUser();
        for(User user1:list){
            if(user1==user) return ResponseEntity.ok(user1.getUserProject());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user does not exist");
    }

    @RequestMapping(path = "getuserbyproject/{project}")
    public ResponseEntity<?> getUserByProject(@PathVariable Project project) {
        List<Project> list=projectService.findProject();
        for(Project project1:list){
            if(project1==project) ResponseEntity.ok(project1.getUser());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project does not exist");
    }


    // getProductsByProductType
    // getProductsByAirFlow
    // getProductByDescritionStartsWith
    // advanceSearch(Description, ProductType, TechnicalDetail)
}
