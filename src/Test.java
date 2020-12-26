import java.io.File;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("请输入用户名：");
        Scanner sc=new Scanner (System.in);
        String username=sc.next();
        System.out.println("你输入的用户名：" + username);
        System.out.println("请输入密码：");
        String password=sc.next();
        System.out.println("你输入的密码是：" + password);
        File file=new File ("C:\\Users\\Admin\\Desktop\\zlx.xlsx");
        ReadExcel readExcel=new ReadExcel();
        User users[]=readExcel.readExcel(file);
        for (int i=0;i<users.length;i++){
            if (username.equals(users[i].getUsername())&&password.equals(users[i].getPassword())){
                System.out.println("登录成功！");
                break;

            }else {
                System.out.println("登录失败！");
            }
        }


    }
}