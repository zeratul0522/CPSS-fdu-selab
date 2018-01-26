package cn.edu.fudan.selab.smartHomeController;

/**
 * @author Fan Zejun E-mail:fzj0522@outlook.com
 * @version 2018/1/25 下午9:21
 */
public class Test {
    public static void main(String[] args){
        try{
            Thread.sleep(5000);
            System.out.println("modified");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
