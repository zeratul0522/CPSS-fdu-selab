package cn.edu.fudan.selab.smartHomeController.user;

import cn.edu.fudan.selab.smartHomeController.utility.Parameters;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.Console;
import java.io.UnsupportedEncodingException;

@RestController
public class login {

    @RequestMapping(value = Parameters.Login, method = RequestMethod.GET)
    @ResponseBody
    public String loginGet(HttpServletRequest httpServletRequest) throws UnsupportedEncodingException {
        String token_get = login(httpServletRequest);
        return token_get;
    }


    @RequestMapping(value = Parameters.Login, method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest httpServletRequest) throws UnsupportedEncodingException {
        User user = new User();
        String data = httpServletRequest.getParameter("param");
        System.out.println(data);
        if(data != null){
            user.setName(data.split(":")[0]);
            user.setPassword(data.split(":")[1]);
            System.out.println(user.getName() + ", " + user.getPassword());
            System.out.println(Parameters.Default_name);
        }

//        return "test";

//        if (data != null)
//        {
//            System.out.println("success");
//
//            return "success";
//        }

        if (user.getName().equals(Parameters.Default_name) && user.getPassword().equals(Parameters.Default_pwd))
        {
            String token_post = new JWTService().generateJWT(user);
            System.out.println(token_post);
            return token_post;
        }
        else if (!user.getName().equals(Parameters.Default_name) || !user.getPassword().equals(Parameters.Default_pwd))
        {
            System.out.println(user.getName());
            System.out.println("name or password is wrong");
            return " Name or password is wrong.";
        }
        else
        {
            System.out.println("Connection fail");
            return "Connection fail";
        }
    }

    @RequestMapping(value = Parameters.Auto_login, method = RequestMethod.POST)
    @ResponseBody
    public boolean auto_login(HttpServletRequest httpServletRequest) throws UnsupportedEncodingException
    {
        String data = httpServletRequest.getParameter("token");
        String name = new JWTService().parse(data).getSubject();
        if (name.equals(Parameters.Default_name))
            return true;
        else
            return false;

    }


}

