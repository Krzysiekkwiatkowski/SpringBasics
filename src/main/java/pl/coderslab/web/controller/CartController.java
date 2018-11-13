package pl.coderslab.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("shopping")
public class CartController {
    private Cart cart;

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @RequestMapping("/addtocart/{id}/{quantity}")
    public String addtocart(HttpSession ses, @PathVariable("id") int id, @PathVariable("quantity") int quantity) {
        List<CartItem> shopping = (List<CartItem>)ses.getAttribute("shopping");
        Product product = ProduktDao.getList().get(id);
        int counter = 0;
        if(shopping == null){
            shopping = new ArrayList<>();
            CartItem cartItem = new CartItem(quantity, product);
            shopping.add(cartItem);
        } else {
            for (CartItem cartItem : shopping) {
                if(cartItem.getProduct().getId() == id){
                    cartItem.setQuantity(cartItem.getQuantity() + quantity);
                } else {
                    counter++;
                }
            }
        }
        if(counter == shopping.size()){
            CartItem cartitem = new CartItem(quantity, product);
            shopping.add(cartitem);
        }
        ses.setAttribute("shopping", shopping);
        return "AddToCart";
    }

    @RequestMapping("/cart")
    public String showAll(Model model, HttpSession session){
        List<CartItem> shopping = (List<CartItem>)session.getAttribute("shopping");
        if(shopping != null) {
            int sum = 0;
            double total = 0.0;
            for (CartItem cartItem : shopping) {
                sum += cartItem.getQuantity();
                total += cartItem.getProduct().getPrice() * cartItem.getQuantity();
            }
            model.addAttribute("size", shopping.size());
            model.addAttribute("sum", sum);
            model.addAttribute("total", total);
            return "products";
        }
        model.addAttribute("sum", null);
        return "products";
    }

    @GetMapping("/add")
    public String addGet(Model model){
        model.addAttribute("products", ProduktDao.getList());
        return "AddForm";
    }

    @PostMapping("/add")
    public String addPost(@RequestParam("quantity") int quantity, @RequestParam("name") String name, Model model, HttpSession session){
        List<CartItem> shopping = (List<CartItem>)session.getAttribute("shopping");
        List<Product> products = ProduktDao.getList();
        for (Product product : products) {
            if(product.getName().equals(name)){
                shopping.add(new CartItem(quantity, product));
            }
        }
        session.setAttribute("shopping", shopping);
        return "show";
    }

    @RequestMapping("/AddedCart/{action}/{name}")
    public String addedCart(@PathVariable("action") String action, @PathVariable("name") String name, HttpSession session){
        List<CartItem> shopping = (List<CartItem>)session.getAttribute("shopping");
        if(action.equals("Add")){
            for (CartItem cartItem : shopping){
                if(cartItem.getProduct().getName().equals(name)) {
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                }
            }
        } else if(action.equals("Subtract")){
            for (CartItem cartItem : shopping){
                if(cartItem.getProduct().getName().equals(name)) {
                    cartItem.setQuantity(cartItem.getQuantity() - 1);
                }
            }
        } else if(action.equals("Delete")){
            int index = -1;
            for (CartItem cartItem : shopping) {
                if(cartItem.getProduct().getName().equals(name)){
                    index = shopping.indexOf(cartItem);
                }
            }
            shopping.remove(index);
            session.setAttribute("shopping", shopping);
        }
        return "show";
    }

    @RequestMapping("/show")
    public String showProducts(Model model, HttpSession session){
        List<CartItem> shopping = (List<CartItem>)session.getAttribute("products");
        if(shopping != null) {
            model.addAttribute("shopping", shopping);
        }
        return "show";
    }
}
