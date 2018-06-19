package cn.edu.fudan.selab.smartHomeController.user;


import cn.edu.fudan.selab.smartHomeController.utility.Parameters;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@RestController
public class HeartBeat {
    @RequestMapping(value = Parameters.heart, method = RequestMethod.GET)
    @ResponseBody
    public void heartbeat()
    {
        Date date = new Date();
        Parameters.heartbeat_date = date;
    }


    public boolean is_live(Date date)
    {
        Date current = new Date();
        if ((current.getTime() - date.getTime()) > 60000)
            return false;
        else
            return true;

    }

}
