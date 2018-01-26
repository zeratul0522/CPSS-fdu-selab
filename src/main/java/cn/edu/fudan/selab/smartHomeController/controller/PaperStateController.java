package cn.edu.fudan.selab.smartHomeController.controller;

import cn.edu.fudan.selab.smartHomeController.reasoning.PaperStateReasoning;
import cn.edu.fudan.selab.smartHomeController.utility.Parameters;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Fan Zejun E-mail:fzj0522@outlook.com
 * @version Created on 2018/1/24 下午8:38
 */

@RestController
public class PaperStateController {

    @RequestMapping(value = Parameters.paperStateApiString, method = RequestMethod.POST)
    public String getPaperState(HttpServletRequest request){
        double deviceState = Double.parseDouble(request.getParameter(Parameters.paramPaperDeviceState));
        PaperStateReasoning.execute(deviceState);
        return "Paper API called, device state = "+deviceState;
    }

}
