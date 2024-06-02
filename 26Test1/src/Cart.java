public class Cart {
    private String cartname;
    private String cartbrand;
    private String cartprice;
    private String cartcolor;

    public Cart() {
    }

    public Cart(String cartname, String cartbrand, String cartprice, String cartcolor) {
        this.cartname = cartname;
        this.cartbrand = cartbrand;
        this.cartprice = cartprice;
        this.cartcolor = cartcolor;
    }

    public void setCartname(String cartname) {
        this.cartname = cartname;
    }

    public void setCartbrand(String cartbrand) {
        this.cartbrand = cartbrand;
    }

    public void setCartprice(String cartprice) {
        this.cartprice = cartprice;
    }

    public void setCartcolor(String cartcolor) {
        this.cartcolor = cartcolor;
    }

    public String getCartname() {
        return cartname;
    }

    public String getCartbrand() {
        return cartbrand;
    }

    public String getCartprice() {
        return cartprice;
    }

    public String getCartcolor() {
        return cartcolor;
    }
}
