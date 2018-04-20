package cn.edu.fudan.selab.smartHomeController.controller;

import cn.edu.fudan.selab.smartHomeController.reasoning.DoorWindowStateReasoning;
import cn.edu.fudan.selab.smartHomeController.utility.Parameters;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fan Zejun E-mail:fzj0522@outlook.com
 * @version 2018/1/25 下午9:07
 */
@RestController
public class DoorWindowStateController {

    @RequestMapping(value = Parameters.doorWindowStateApiString, method = RequestMethod.GET)
    public String index(){

        //进行逻辑演绎部分
        DoorWindowStateReasoning.execute();

        return "DoorWindowStateController called.";
    }

    @RequestMapping(value = { Parameters.doorWindowStateApiString_iffullclosed }, method = RequestMethod.GET)
    @ResponseBody
    public String get_labFullClosed() {
        DoorWindowStateReasoning.execute();
        JSONObject resultObj = new JSONObject();
        JSONArray arr = new JSONArray();
        arr.add("labFullClosed");
        arr.add(Parameters.labFullClosed);
        arr.add("FrontDoor");
        arr.add(Parameters.frontDoor);
        arr.add("FrontWindow");
        arr.add(Parameters.frontWindow);
        arr.add("MeetingRoom");
        arr.add(Parameters.meetingRoom);
        arr.add("ServerRoom");
        arr.add(Parameters.serverRoom);
        arr.add("nightDoorWindow");
        arr.add(Parameters.nightDoorWindow);
        /*
        返回的string中的格式必须是callback(json),详见前台代码里ajax部分
         */
        return "labFullClosed(" + arr.toString() + ")";
    }
}
