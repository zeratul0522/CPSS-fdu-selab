package cn.edu.fudan.selab.smartHomeController.reasoning;

import cn.edu.fudan.selab.smartHomeController.utility.HttpRequest4DeviceStates;
import cn.edu.fudan.selab.smartHomeController.utility.Parameters;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author Fan Zejun E-mail:fzj0522@outlook.com
 * @version 2018/1/25 下午4:47
 */
public class DoorWindowStateReasoning {

    public static void execute(){
        List<String> entityList = new ArrayList<String>();
        entityList.add(Parameters.entityId4FrontDoor);

        Iterator<String> it = entityList.iterator();
        while(it.hasNext()){
            String currentEntityId = it.next();
            JSONObject obj = JSON.parseObject(HttpRequest4DeviceStates.getDeviceStateById(currentEntityId));
            System.out.println(currentEntityId + " " + obj.get("state"));
            if(obj.get("state").equals("on")){
                Parameters.labFullClosed = 0;
                break;
            }

            Parameters.labFullClosed = 1;
        }
    }

//    @RequestMapping(value = { "/labFullClosed" }, method = RequestMethod.GET)
//    @ResponseBody
//    public String get_labFullClosed() {
//        JSONObject resultObj = new JSONObject();
//        JSONArray arr = new JSONArray();
//        arr.add("labFullClosed");
//        arr.add(Parameters.labFullClosed);
//        return "labFullClosed(" + arr.toString() + ")";
//    }
}
