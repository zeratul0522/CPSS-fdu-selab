package cn.edu.fudan.selab.smartHomeController.reasoning;

/**
 * @author Fan Zejun E-mail:fzj0522@outlook.com
 * @version 2018/1/25 下午3:48
 */
public class ReasoningEngine {

    public ReasoningEngine(){

    }


    //初始化所有的设备状态
    public void initialize(){
        DoorWindowStateReasoning.execute();
        PaperStateReasoning.execute(79.0);// TODO: 2018/1/25 这里的参数是乱填的，后面改成真实获取的数值
        IfEmptyRoomReasoning.execute(0);

    }

}
