package com.inventory.inventory.Controller;


import com.inventory.inventory.Model.*;
import com.inventory.inventory.Service.*;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@org.springframework.stereotype.Controller
public class Controller {

    Logger logger = LoggerFactory.getLogger(Logger.class);
    public Controller() {
    }

    public Controller(SaleService saleService) {
        this.saleService = saleService;
    }

    @Autowired
    private SaleService saleService;

    @Autowired
    private VendorService vendorService;
    public Controller(VendorService vendorService) {
        this.vendorService = vendorService;
    }


    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    public Controller(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Autowired
    private PurchaseService purchaseService;

    public Controller(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/")
    public String getAny(){
        return "Home";
    }

    @GetMapping(path = "/home")
    public String getHome(Model model){
        model.addAttribute("Product",productService.gettotalProductnum());
        model.addAttribute("Purchase",purchaseService.getPurchasenum());
        model.addAttribute("Sale",saleService.getProft());
        model.addAttribute("ProfitPer",saleService.getProfitPer());
        return "Home";
    }
    @GetMapping(path = "/Products")
    public String ListAllProducts(Model model){

    return findPaginated(0,model);
    }

    @GetMapping("/page/{pageno}")
    public String findPaginated(@PathVariable int pageno, Model m){

        Page<Product> plist= productService.getProdNyPaginate(pageno,10);
        m.addAttribute("Product",plist.get().toList());
        m.addAttribute("currentPage",pageno);
        m.addAttribute("totalPages",plist.getTotalPages());
       m.addAttribute("totalItem",plist.getTotalElements());
        return "Product";
    }



    @GetMapping(path = "/addProduct")
    public String addProduct(Model model){
        model.addAttribute("Product",new Product());
        return "addProduct";
    }

    @PostMapping(path = "/add")
    public String addProductfully(@Valid @ModelAttribute("Product") Product product, Errors errors){
        if(errors.hasErrors()){
            logger.error("Product Form Validation failed due to :"+errors.toString());
            return "addProduct";
        }
        if(productService.addProduct(product))
        return "redirect:/addProduct";
        else
            return "redirect:/addProduct";
    }

    @GetMapping(path = "/delete/{id}/Product")
    public String deleteProduct(@PathVariable int id){
        if(productService.deleteProduct(id))
            return "redirect:/Products";
        else
            return "redirect:/Products";
    }

    @GetMapping(path = "/Vendors")
    public String ListAllVendors(Model model){
        return findPaginatedV(0,model);
    }

    @GetMapping("/vpage/{pageno}")
    public String findPaginatedV(@PathVariable int pageno, Model m){

        Page<Vendor> vlist= vendorService.getVenNyPaginate(pageno,10);
        m.addAttribute("Vendor",vlist.get().toList());
        m.addAttribute("currentPage",pageno);
        m.addAttribute("totalPages",vlist.getTotalPages());
        m.addAttribute("totalItem",vlist.getTotalElements());
        return "Vendor";
    }



    @GetMapping(path = "/addVendor")
    public String Vendors(Model model){
        model.addAttribute("Vendor",new Vendor());
        return "addVendor";
    }


    @PostMapping(path = "/addven")
    public String addVendor(@Valid @ModelAttribute("Vendor") Vendor vendor,Errors errors){
        if(errors.hasErrors()){
            logger.error("Vendor Form Validation failed due to :"+errors.toString());
            return "addVendor";
        }
    if(vendorService.addVendor(vendor))
        return "redirect:/Vendors";
    else return "redirect:/Vendors";
    }


    @GetMapping(path = "/delete/{vid}/Vendor")
    public String deleteVendor(@PathVariable int vid){
        if(vendorService.deleteVendor(vid))
            return "redirect:/Vendors";
        else
            return "redirect:/Vendors";
    }

    @GetMapping(path = "/updateProductPage")
    public String updateProductPage(Model model){

        model.addAttribute("Product",productService.getAllProducts());
        return "updateProduct";
    }

    @PostMapping(path = "/updateProduct")
    public String updateProduct(@Valid @ModelAttribute("Product") Product product,Errors errors){
        if(errors.hasErrors()){
            logger.error("Product Update Form Validation failed due to :"+errors.toString());
            return "updateProduct";
        }
        if(productService.updateProduct(product)){
            return "redirect:/Products";
        }
        else
            return "redirect:/Products";
    }

    @GetMapping(path = "/updateVendorPage")
    public String updateVendorPage(Model model){
        model.addAttribute("Vendor",vendorService.getAllVendors());
        return "updateVendor";
    }

    @PostMapping(path = "/updateVendor")
    public String updateVendor(@Valid @ModelAttribute("Vendor") Vendor vendor,Errors errors){
        if(errors.hasErrors()){
            logger.error("Vendor Update Form Validation failed due to :"+errors.toString());
            return "updateVendor";
        }
        if(vendorService.updateVendor(vendor))
            return "redirect:/Vendors";
        else return "redirect:/Vendors";
    }

    @GetMapping(path = "/Customers")
    public String ListAllCustomers(Model model){

        return findPaginatedC(0,model);
    }


    @GetMapping("/cpage/{pageno}")
    public String findPaginatedC(@PathVariable int pageno, Model m){

        Page<Customer> clist= customerService.getCusNyPaginate(pageno,10);
        m.addAttribute("Customer",clist.get().toList());
        m.addAttribute("currentPage",pageno);
        m.addAttribute("totalPages",clist.getTotalPages());
        m.addAttribute("totalItem",clist.getTotalElements());
        return "Customer";
    }


    @GetMapping(path = "/addCustomerPage")
    public String addCustomerPage(Model model) {
        model.addAttribute("Customer",new Customer());
        return "addCustomer";
    }


    @PostMapping(path = "/addCustomer")
    public String addCustomer(@Valid @ModelAttribute("Customer") Customer customer,Errors errors){
        if(errors.hasErrors()){
            logger.error("Customer form validation failed due to "+errors.toString());
            return "addCustomer";
        }
        if(customerService.addCustomer(customer))
            return "redirect:/Customers";
        else return "redirect:/Customers";

    }

    @GetMapping(path = "/delete/{cid}/Customer")
    public String deleteCustomer(@PathVariable int cid){
        if(customerService.deleteCustomer(cid))
            return "redirect:/Customers";
        else return "redirect:/Customers";
    }


    @GetMapping(path = "/updateCustomerPage")
    public String updateCustomerPage(Model model){
        model.addAttribute("Customer",customerService.getAllCustomers());

        return "updateCustomer";
    }

    @PostMapping(path = "/updateCustomer")
    public String updateCustomer(@Valid @ModelAttribute("Customer") Customer customer,Errors errors){
        if(errors.hasErrors()){
            logger.error("Customer form validation failed due to "+errors.toString());
            return "updateCustomer";
        }

        if(customerService.updateCustomer(customer))
            return "redirect:/Customers";
        else return "redirect:/Customers";
    }


    @GetMapping(path = "/addPurchasePage")
    public String addPurchase(Model model){
        model.addAttribute("Product",productService.getAllProducts());
        model.addAttribute("Vendor",vendorService.getAllVendors());
        return "addPurchase";
    }


    @PostMapping(path = "/addPurchase")
    public String addPurchase(@Validated Purchase purchase){
        System.out.print(purchase);
    if(purchaseService.addPurchase(purchase))
        return "redirect:/Purchase";
    else return "redirect:/Purchase";

    }

    @GetMapping(path = "/Purchase")
    public String findAllPurchase(Model model){
        return findPaginatedPur(0,model);
    }

    @GetMapping("/purpage/{pageno}")
    public String findPaginatedPur(@PathVariable int pageno, Model m){

        Page<Purchase> purlist= purchaseService.getPurNyPaginate(pageno,10);
        m.addAttribute("Purchase",purlist.get().toList());
        m.addAttribute("currentPage",pageno);
        m.addAttribute("totalPages",purlist.getTotalPages());
        m.addAttribute("totalItem",purlist.getTotalElements());
        return "Purchase";
    }



    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception exception){
        ModelAndView errorPage=new ModelAndView();
        errorPage.setViewName("error");
        errorPage.addObject("errormsg",exception.getMessage());
        return errorPage;
    }

    @GetMapping(path = "/addSalePage")
    public String addSalePage(Model model){
        model.addAttribute("Product",productService.getAllProducts());
        model.addAttribute("Customer",customerService.getAllCustomers());
        return "addSales";
    }
    @PostMapping(path = "/addSale")
    public String addSale(Sale sale){
        if(saleService.addSales(sale))
        return "redirect:/Sale";
        else return "redirect:/Sale";
    }

    @GetMapping(path = "/Sale")
    public String findAllSale(Model model){
        return findPaginatedSale(0,model);
    }

    @GetMapping("/salepage/{pageno}")
    public String findPaginatedSale(@PathVariable int pageno, Model m){

        Page<Sale> salelist= saleService.getSaleNyPaginate(pageno,10);
        m.addAttribute("Sale",salelist.get().toList());
        m.addAttribute("currentPage",pageno);
        m.addAttribute("totalPages",salelist.getTotalPages());
        m.addAttribute("totalItem",salelist.getTotalElements());
        return "Sale";
    }


}
