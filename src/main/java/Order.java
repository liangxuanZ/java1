import java.sql.Date;
import java.util.Map;

public class Order {
    /*
    该有哪些属性？依据是什么？
    依据：数据库有哪些字段，那么类就有哪些属性
     */
    private User user;
    private Product products[];
    private Map<Integer,Integer> ammount;//无法表达出买了几个哪种商品
    //商品，个数
    private Map<Integer,Float> totalAmountPerProduct;
    private float actualPay;//实付款
    private Date orderDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public Map<Integer,Integer> getAmmount() {
        return ammount;
    }

    public void setAmmount(Map<Integer,Integer> ammount) {
        this.ammount = ammount;
    }

    public Map<Integer, Float> getTotalAmountPerProduct() {
        return totalAmountPerProduct;
    }

    public void setTotalAmountPerProduct(Map<Integer, Float> totalAmountPerProduct) {
        this.totalAmountPerProduct = totalAmountPerProduct;
    }


    public float getActualPay() {
        return actualPay;
    }

    public void setActualPay(float actualPay) {
        this.actualPay = actualPay;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}