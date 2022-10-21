package com.example.joole.controller;

import com.example.joole.model.*;
import com.example.joole.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SearchController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TechnicalDetailService technicalDetailService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private DescriptionService descriptionService;

    @Autowired
    private ProjectProductService projectProductService;

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

    @RequestMapping(path = "/getproductbybrand/{productBrand}")
    public ResponseEntity<?> getProductByBrand(@PathVariable String productBrand) {
        List<Product> productList = productService.findByProductBrand(productBrand);
        if (productList.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with brand does not exist!");
        return ResponseEntity.ok(productList);
    }

    @RequestMapping(path = "/getproductbycertification/{certification}")
    public ResponseEntity<?> getProductByCertification(@PathVariable String certification) {
        List<Product> productList = productService.findByProductCertification(certification);
        if (productList.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with certification does not exist!");
        return ResponseEntity.ok(productList);
    }

    @RequestMapping(path = "/getproductbyseries")
    public ResponseEntity<?> getBySeries(@RequestParam(name = "series") String series) {
        List<Description> descriptionList=descriptionService.findBySeries(series);

        if(descriptionList.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("series not found!");

        List<Product> productList= new ArrayList<>();

        for( Description description : descriptionList){
            Product product = productService.findProductByDescription(description);
            if (product != null) {
                productList.add(product);
            }
        }
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/getProductByDescriptionIdAndTechnicalDetailIdAndProductTypeId")
    public ResponseEntity<?> getProductByDescriptionAndTechnicalDetailAndProductType(@RequestParam(name = "descriptionId") Long descriptionId,
                                                                                     @RequestParam(name = "technicalDetailId") Long technicalDetailId,
                                                                                     @RequestParam(name = "productTypeId") Long productTypeId){
        Product product = productService.findProductByDescriptionIdAndTechnicalDetailIdAndProductTypeId(descriptionId, technicalDetailId, productTypeId);
        if (product == null){
            return new ResponseEntity<>(String.format("There is no product with descriptionId: %s, TechnicalDetailId: %s and ProductTypeId: %s", descriptionId, technicalDetailId, productTypeId), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //Status 500
    @GetMapping(path = "/getproductbyairflow")
    public ResponseEntity<?> getByAirflow(@RequestParam(name = "airflow") int airflow) {
        List<Product> productList=productService.findProducts();
        List<Product> returnList=new ArrayList<>();
        for(Product product:productList){
            if(product.getTechnicalDetails()!=null && product.getTechnicalDetails().getAirflow()==airflow) {
                returnList.add(product);
            }
        }

        return ResponseEntity.ok(returnList);
    }

    @RequestMapping(path = "/getproductbypower")
    public ResponseEntity<?> getByModel(@RequestParam(name = "power") int power) {
        List<Product> productList=productService.findProducts();
        List<Product> returnList=new ArrayList<>();
        for(Product product:productList){
            if(product.getTechnicalDetails()!=null && product.getTechnicalDetails().getPower()==power) {
                returnList.add(product);
            }
        }
        return ResponseEntity.ok(returnList);
    }

    //STATUS 500
    @RequestMapping(path = "/getproducttypebyyear")
    public ResponseEntity<?> getByYear(@RequestParam(name = "year") int year){
    List<Product> productList=productService.findProducts();
    List<Product> returnList=new ArrayList<>();
    for(Product product:productList){
            if(product.getTechnicalDetails()!=null && product.getProductType().getModelYear()==year) {
                returnList.add(product);
            }
        }
        return ResponseEntity.ok(returnList);
    }


    @RequestMapping(path = "/getprojectbyuser/{userId}")
    public ResponseEntity<?> getProjectByUser(@PathVariable long userId){
        if(userService.findUserById(userId)==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist!");
        if(userService.findUserById(userId).getUserProject()!=null) return ResponseEntity.ok(userService.findUserById(userId).getUserProject());
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project does not exist!");
    }

    @RequestMapping(path = "/getuserbyproject/{projectId}")
    public ResponseEntity<?> getUserByProject(@PathVariable long projectId) {
        if(projectService.findProjectById(projectId)==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project does not exist!");
        if(projectService.findProjectById(projectId).getUser()!=null) return ResponseEntity.ok(projectService.findProjectById(projectId).getUser());
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist!");
    }

    @RequestMapping(path = "/getproductsfromproject/{projectId}")
    public ResponseEntity<?> getProductListFromProject(@PathVariable long projectId){
        return ResponseEntity.ok(projectService.findProjectById(projectId));
    }

    @RequestMapping("/getprojectbyproductid/{productId}")
    public ResponseEntity<?> findProjectProductByProductId(@PathVariable long productId){
        ProjectProduct projectProduct=projectProductService.findProjectProductByProductId(productId);
        if(projectProduct!=null) return ResponseEntity.ok(projectProduct.getProject());
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }


}
