import javafx.scene.control.Tab;

import java.io.InputStream;
import java.util.Scanner;

public class Test {
    static Product carts[] = new Product[3];//创建购物车（用数组模拟）
    static int count = 0;

    public static void main(String[] args) throws ClassNotFoundException {
        boolean bool = true;
        while (bool) {
            System.out.println("请输入用户名：");
            Scanner sc = new Scanner(System.in);
            String username = sc.next();//阻塞方法

            System.out.println("请输入密码：");
            String password = sc.next();

            //File file=new File("C:\\Users\\Administrator\\IdeaProjects\\ConsoleShop\\src\\users.xlsx");
            InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");//  /表示的就是classpath
            ReadUserExcel readExcel = new ReadUserExcel();//创建对象
            User users[] = readExcel.getAllUser(in);
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    bool = false;
                    while (true) {
                        System.out.println("查看购物车请按1");
                        System.out.println("购物请按2");
                        System.out.println("结账请按3");
                        System.out.println("退出请按4");
                        int choose = sc.nextInt();
                        if (choose == 1) {
                            viewCarts();
                        } else if (choose == 2) {
                            shopping(sc);
                        } else if (choose == 3) {
                            /*
                            1、产生订单（必须有订单类）
                            2、用POI创建Order.xlsx文件
                            3、把购物车里的商品写入Order.xlsx文件
                             */
                            Order order = new Order();
                            order.setUser(users[i]);
                            //order.setProduct();
                            //如何关联订单和商品
                        } else if (choose == 4) {
                            break;//最终导致循环结束，循环结束后，main方法结束（main线程），JavaVM也会结束
                        }
                    }
                    break;
                } else {
                    System.out.println("登录失败");
                }
            }
        }
    }

    public static void viewCarts() {
        for (Product product : carts) {
            if (product != null) {
                System.out.print(product.getId());
                System.out.print("\t" + product.getName());
                System.out.print("\t\t" + product.getPrice());
                System.out.println("\t\t" + product.getDesc());
            }
        }
    }

    public static void shopping(Scanner sc) throws ClassNotFoundException {
        InputStream inPro = Class.forName("Test").getResourceAsStream("/product.xlsx");//  /表示的就是classpath
        ReadProductExcel readProductExcel = new ReadProductExcel();
        Product products[] = readProductExcel.getAllProduct(inPro);
        for (Product product : products) {
            System.out.print(product.getId());
            System.out.print("\t" + product.getName());
            System.out.print("\t\t" + product.getPrice());
            System.out.println("\t\t" + product.getDesc());
        }
        /*
        遍历数组
         */
        System.out.println("请输入商品ID，把该商品加入购物车：");
        String pId = sc.next();
        ReadProductExcel readProductExcel1 = new ReadProductExcel();
        inPro = null;
        inPro = Class.forName("Test").getResourceAsStream("/product.xlsx");//  /表示的就是classpath
        Product product = readProductExcel1.getProductById(pId, inPro);
        if (product != null) {
            /*
            把商品加入购物车
             */
            carts[count++] = product;
        }
    }
}