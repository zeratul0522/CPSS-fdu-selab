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
        /*
        因为判断实验室是不是全部封闭只需要看前门和前门窗户就行，
        但是这个类还兼职判断每一扇门窗的状态，
        因此定义两个list；
         */
        List<String> entityList4FullClose = new ArrayList<String>();
        List<String> entityList = new ArrayList<String>();
        entityList4FullClose.add(Parameters.entityId4FrontDoor);
        entityList4FullClose.add(Parameters.entityId4FrontWindow_1);
        entityList4FullClose.add(Parameters.entityId4FrontWindow_2);
        entityList.add(Parameters.entityId4FrontDoor);
        entityList.add(Parameters.entityId4FrontWindow_1);
        entityList.add(Parameters.entityId4FrontWindow_2);
        entityList.add(Parameters.entityId4MeetingRome);
        entityList.add(Parameters.entityId4ServerRoom);

        Iterator<String> it4FullClose = entityList4FullClose.iterator();
        Iterator<String> it = entityList.iterator();



        //实验室是否完全完全封闭
        while(it4FullClose.hasNext()){
            String currentEntityId = it4FullClose.next();
            JSONObject obj = JSON.parseObject(HttpRequest4DeviceStates.getDeviceStateById(currentEntityId));
            System.out.println(currentEntityId + " " + obj.get("state"));
            if(obj.get("state").equals("on")){
                Parameters.labFullClosed = 0;
                break;
            }
            Parameters.labFullClosed = 1;
        }

        //以光照为标准判断是不是最后一个人走了，结合labFullClosed判断实验室门窗状态，在前台进行提醒
        Double lightValue = 0.0;
        JSONObject lightTmp = JSON.parseObject((HttpRequest4DeviceStates.getDeviceStateById(Parameters.entityId4LightSensor)));
        lightValue = Double.parseDouble(String.valueOf(lightTmp.get("state")));
        System.out.println("外屋的光照强度是：" + lightValue);
        if (lightValue <= Parameters.threshold4Light && Parameters.labFullClosed == 0)
            Parameters.nightDoorWindow = 0;


        //每个门窗的状态
        while (it.hasNext())
        {
            String currentEntityId = it.next();
            JSONObject obj = JSON.parseObject(HttpRequest4DeviceStates.getDeviceStateById(currentEntityId));
            System.out.println(currentEntityId + " " + obj.get("state"));
            if (obj.get("entity_id").equals(Parameters.entityId4FrontDoor))
            {
                if (obj.get("state").equals("on"))
                    Parameters.frontDoor = 0;
                else
                    Parameters.frontDoor = 1;
            }
            if (obj.get("entity_id").equals(Parameters.entityId4FrontWindow_1))
            {
                if (obj.get("state").equals("on"))
                    Parameters.frontWindow_1 = 0;
                else
                    Parameters.frontWindow_1 = 1;
            }
            if (obj.get("entity_id").equals(Parameters.entityId4FrontWindow_2))
            {
                if (obj.get("state").equals("on"))
                    Parameters.frontWindow_2 = 0;
                else
                    Parameters.frontWindow_2 = 1;
            }
            if (obj.get("entity_id").equals(Parameters.entityId4MeetingRome))
            {
                if (obj.get("state").equals("on"))
                    Parameters.meetingRoom = 0;
                else
                    Parameters.meetingRoom = 1;
            }
            if (obj.get("entity_id").equals(Parameters.entityId4ServerRoom))
            {
                if (obj.get("state").equals("on"))
                    Parameters.serverRoom = 0;
                else
                    Parameters.serverRoom = 1;
            }
        }

        if (Parameters.frontWindow_1 == 1 && Parameters.frontWindow_2 == 1)
            Parameters.frontWindow = 1;
        else
            Parameters.frontWindow = 0;
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
