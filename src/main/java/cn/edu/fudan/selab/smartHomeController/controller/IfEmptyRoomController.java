package cn.edu.fudan.selab.smartHomeController.controller;

import cn.edu.fudan.selab.smartHomeController.reasoning.IfEmptyRoomReasoning;
import cn.edu.fudan.selab.smartHomeController.utility.Parameters;
import com.alibaba.fastjson.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fan Zejun E-mail:fzj0522@outlook.com
 * @version 2018/1/25 下午9:02
 */
@RestController
public class IfEmptyRoomController {

    @RequestMapping(value = Parameters.ifEmptyRoomApiString, method = RequestMethod.GET)
    @ResponseBody
    public String somebodyAtRoom(){

        IfEmptyRoomReasoning.execute(2000);
        JSONArray arr = new JSONArray();
        arr.add("somebodyAtRoom");
        arr.add(Parameters.somebodyAtRoom);
        System.out.println("is there  anybody in meeting room?" + Parameters.somebodyAtRoom);
        /*
        返回的string中的格式必须是callback(json),详见前台代码里ajax部分
         */
        return "somebodyAtRoom(" + arr.toString() + ")";
    }
}
