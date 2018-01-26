package cn.edu.fudan.selab.smartHomeController.controller;

import cn.edu.fudan.selab.smartHomeController.reasoning.PaperStateReasoning;
import cn.edu.fudan.selab.smartHomeController.utility.Parameters;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fan Zejun E-mail:fzj0522@outlook.com
 * @version Created on:2017/11/29 下午2:15
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index(){

        //PaperStateReasoning.resetTimeSinceChangedToInsuf();
        return "HelloController called." + Parameters.timeSinceChangedToInsufficient;
    }
}
