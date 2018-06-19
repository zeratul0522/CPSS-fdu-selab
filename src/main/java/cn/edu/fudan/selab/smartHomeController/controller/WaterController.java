package cn.edu.fudan.selab.smartHomeController.controller;

import cn.edu.fudan.selab.smartHomeController.service.WaterService;
import cn.edu.fudan.selab.smartHomeController.utility.Parameters;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Parameter;

@RestController
public class WaterController {

    WaterService waterService = null;
    @RequestMapping(value = Parameters.is_boiled, method = RequestMethod.GET)
    @ResponseBody
    public boolean is_boiled()
    {
        return waterService.is_boiled();
    }

    @RequestMapping(value = Parameters.book_water, method = RequestMethod.GET)
    @ResponseBody
    public boolean BookWater(HttpServletRequest httpServletRequest)
    {
        String name = httpServletRequest.getParameter("name");
        return waterService.book_water(name);
    }

    @RequestMapping(value = Parameters.who_first, method = RequestMethod.GET)
    @ResponseBody
    public String WhoFirst()
    {
        return waterService.now_first(Parameters.WaterList);
    }

    @RequestMapping(value = Parameters.drink_water, method = RequestMethod.GET)
    @ResponseBody
    public boolean DrinkWater()
    {
        return waterService.drink_water(Parameters.WaterList);
    }

    @RequestMapping(value = Parameters.get_list, method = RequestMethod.GET)
    @ResponseBody
    public String GetList()
    {
        return waterService.get_list(Parameters.WaterList);
    }
}
