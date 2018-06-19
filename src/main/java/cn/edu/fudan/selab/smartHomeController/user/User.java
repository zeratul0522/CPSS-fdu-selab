package cn.edu.fudan.selab.smartHomeController.user;

public class User {
    private String name = "ffff";
    private String password = "dddd";


    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // TODO: 2018/5/30 等以后添加了更多用户的时候需要的方法
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
