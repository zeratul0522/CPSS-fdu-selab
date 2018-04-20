package cn.edu.fudan.selab.smartHomeController;

import cn.edu.fudan.selab.smartHomeController.reasoning.PaperStateReasoning;
import cn.edu.fudan.selab.smartHomeController.reasoning.ReasoningEngine;
import cn.edu.fudan.selab.smartHomeController.utility.Parameters;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.*;
import javax.servlet.http.*;

@SpringBootApplication
public class SmartHomeControllerApplication {

	public static void main(String[] args) {

        ReasoningEngine re = new ReasoningEngine();
        re.initialize();

        System.out.println("测试：实验室fullClosed状态 = " + Parameters.labFullClosed);
        System.out.println("测试：纸张状态 = " + Parameters.currentPaperState);
        System.out.println("实验室当前温度是：" + Parameters.currentTemperature);
        System.out.println("会议室当前有人吗？：" + Parameters.somebodyAtRoom);

		SpringApplication.run(SmartHomeControllerApplication.class, args);


        }


}
