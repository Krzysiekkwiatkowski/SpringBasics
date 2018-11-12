package pl.coderslab.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("products")
public class CartController {
    private Cart cart;

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @RequestMapping("/addtocart/{id}/{quantity}")
    public String addtocart(HttpSession ses, @PathVariable("id") int id, @PathVariable("quantity") int quantity) {
        List<CartItem> products = (List<CartItem>)ses.getAttribute("products");
        Product product = ProduktDao.getList().get(id);
        int counter = 0;
        if(products == null){
            products = new ArrayList<>();
            CartItem cartItem = new CartItem(quantity, product);
            products.add(cartItem);
        } else {
            for (CartItem cartItem : products) {
                if(cartItem.getProduct().getId() == id){
                    cartItem.setQuantity(cartItem.getQuantity() + quantity);
                } else {
                    counter++;
                }
            }
        }
        if(counter == products.size()){
            CartItem cartitem = new CartItem(quantity, product);
            products.add(cartitem);
        }
        ses.setAttribute("products", products);
        return "AddToCart";
    }

    @RequestMapping("/cart")
    public String showAll(Model model, HttpSession session){
        List<CartItem> products = (List<CartItem>)session.getAttribute("products");
        if(products != null) {
            int sum = 0;
            double total = 0.0;
            for (CartItem cartItem : products) {
                sum += cartItem.getQuantity();
                total += cartItem.getProduct().getPrice() * cartItem.getQuantity();
            }
            model.addAttribute("size", products.size());
            model.addAttribute("sum", sum);
            model.addAttribute("total", total);
            return "products";
        }
        model.addAttribute("sum", null);
        return "products";
    }
}
