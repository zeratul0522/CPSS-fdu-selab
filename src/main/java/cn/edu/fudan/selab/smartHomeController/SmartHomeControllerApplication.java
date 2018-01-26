package cn.edu.fudan.selab.smartHomeController;

import cn.edu.fudan.selab.smartHomeController.reasoning.PaperStateReasoning;
import cn.edu.fudan.selab.smartHomeController.reasoning.ReasoningEngine;
import cn.edu.fudan.selab.smartHomeController.utility.Parameters;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartHomeControllerApplication {

	public static void main(String[] args) {

        ReasoningEngine re = new ReasoningEngine();
        re.initialize();

        System.out.println("测试：实验室fullClosed状态 = " + Parameters.labFullClosed);
        System.out.println("测试：纸张状态 = " + Parameters.currentPaperState);

		SpringApplication.run(SmartHomeControllerApplication.class, args);

	}
}
