package cn.edu.fudan.selab.smartHomeController.controller;

import cn.edu.fudan.selab.smartHomeController.reasoning.IfEmptyRoomReasoning;
import cn.edu.fudan.selab.smartHomeController.utility.Parameters;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fan Zejun E-mail:fzj0522@outlook.com
 * @version 2018/1/25 下午9:02
 */
@RestController
public class IfEmptyRoomController {

    @RequestMapping(value = Parameters.ifEmptyRoomApiString, method = RequestMethod.GET)
    public String index(){

        IfEmptyRoomReasoning.execute(2000);
        return "IfEmptyRoomController called.";
    }
}
