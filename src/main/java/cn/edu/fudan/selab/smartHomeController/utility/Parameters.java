package cn.edu.fudan.selab.smartHomeController.utility;

/**
 * @author Fan Zejun E-mail:fzj0522@outlook.com
 * @version 2018/1/24 下午9:17
 *
 * Utility class for various kinds of parameters
 */
public class Parameters {

    public static final String hassApi4DeviceState = "http://192.168.1.158:8123/api/states";

    public static final String paperStateApiString = "/smartLab/paperState";
    public static final String doorWindowStateApiString = "/smartLab/doorWindowState";
    public static final String ifEmptyRoomApiString = "/smartLab/ifEmptyRoom";

    /*
    * 下面的是和纸张剩余量检测相关的参数
    */
    public static final String paramPaperDeviceState = "deviceState";
    public static int timeSinceChangedToInsufficient = 0;//纸张不足的状态已经持续的秒数
    public static int currentPaperState = 1;//当前的纸张剩余量状态，0代表不足，1代表充足
    public static final double threshold4paper = 80.0;//判断纸张足或不足的阈值
    public static final int timeToExecuteTask = 30;//如果纸张不足的状态持续了这么多秒，就判定为不够



    /*
    * 下面的是和门窗关闭状态检测相关的参数
    */
    public static int labFullClosed = 1; //1代表实验室门窗全部关闭
    public static final String entityId4FrontDoor = "binary_sensor.door_window_sensor_158d0001c0fa07";

    /*
    * 下面的是和会议室是否有人相关的参数
    */
    public static int somebodyAtRoom = 1; //
    public static final String entityId4OutsideSensor = "";
    public static final String entityId4InsideSensor = "";
    public static final String entityId4SoundSensor = "";
    public static final String entityId4LightSensor = "";
    public static final double threshold4Sound = 50.0; // TODO: 2018/1/25 这里的两个阈值都是乱填的
    public static final double threshold4Light = 50.0;
}
