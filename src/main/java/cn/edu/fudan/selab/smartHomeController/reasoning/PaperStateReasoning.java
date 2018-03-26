package cn.edu.fudan.selab.smartHomeController.reasoning;

import cn.edu.fudan.selab.smartHomeController.utility.Parameters;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Fan Zejun E-mail:fzj0522@outlook.com
 * @version 2018/1/24 下午8:55
 */
public class PaperStateReasoning {


    public static void execute(double value){
        if(value >= Parameters.threshold4paper){
            Parameters.currentPaperState = 1;
        }else{
            Parameters.currentPaperState = 0;
        }

        // TODO: 2018/1/25 知道了现在的纸张状况，更新dashboard状态
        System.out.println("Current paper state = " + Parameters.currentPaperState);
    }


//
//    private static Integer cacheTime = 2000; //执行间隔
//    private static Integer delay = 1000; //多少时间后开始执行

//   public static void execute(){
//
//
//       Timer timer = new Timer();
//       timer.schedule(new TimerTask() {
//           @Override
//           public void run() {
//               if(Parameters.currentPaperState == 0) {
//                   Parameters.timeSinceChangedToInsufficient += 2;
//               }else {
//                   Parameters.timeSinceChangedToInsufficient = 0;
//               }
//
//
//
//               System.out.println("timeSincePaperChangedToInsufficient = "+Parameters.timeSinceChangedToInsufficient);
//               if(Parameters.timeSinceChangedToInsufficient >= Parameters.timeToExecuteTask){
//                   // TODO: 2018/1/25 判定为纸张不够了
//                   System.out.println("notify executed");
//               }
//           }
//       }, delay, cacheTime);
//   }
//
//   public static void resetTimeSinceChangedToInsuf(){
//       Parameters.timeSinceChangedToInsufficient = 0;
//   }


}


