package cn.edu.fudan.selab.smartHomeController.utility;

import net.sf.json.JSONArray;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    public static final String doorWindowStateApiString_iffullclosed = "/smartLab/iffullclosed";
    public static final String ifEmptyRoomApiString = "/smartLab/ifEmptyRoom";
    public static final String TemperatureApiDouble = "/smartLab/temperature";
    public static final String heart = "/heartbeat";
    public static final String is_boiled = "/boiled";
    public static final String book_water = "/bookwater";
    public static final String drink_water = "/drink";
    public static final String who_first = "/first";
    public static final String get_list = "/list";

    public static Date heartbeat_date = new Date();

    public static ArrayList<String> WaterList = new ArrayList<String>();


    public static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
    public static final String Login = "/login";
    public static final String Auto_login = "/autologin";
    public static final String Default_name = "fdse";
    public static final String Default_pwd = "fdse";
    public static String Token = "";



    /*
    * 下面的是和纸张剩余量检测相关的参数
    */
    public static final String paramPaperDeviceState = "deviceState";
    public static int timeSinceChangedToInsufficient = 0;//纸张不足的状态已经持续的秒数
    public static int currentPaperState = 1;//当前的纸张剩余量状态，0代表不足，1代表充足
    public static final double threshold4paper = 80.0;//判断纸张足或不足的阈值
    public static final int timeToExecuteTask = 30;//如果纸张不足的状态持续了这么多秒，就判定为不够


    /**
     * 两个人体传感器
     */
    public static final String entityId4FrontMeetingRoom = "binary_sensor.motion_sensor_158d0001abdfb4";
    public static final String entityId4BehindMeetingRoom = "binary_sensor.motion_sensor_158d000e16557";



    /*
    * 下面的是和门窗关闭状态检测相关的参数
    */
    public static int labFullClosed = 10; //1代表实验室门窗全部关闭
    public static final String entityId4FrontWindow_1 = "binary_sensor.door_window_sensor_158d0001c0fa07";
    public static int frontWindow_1 = 10;
    public static final String entityId4FrontWindow_2 = "binary_sensor.door_window_sensor_158d0001f49bc1";
    public static int frontWindow_2 = 10;
    public static int frontWindow = 10;
    public static final String entityId4FrontDoor = "binary_sensor.door_window_sensor_158d0002026341";
    public static int frontDoor = 10;
    public static final String entityId4MeetingRome = "binary_sensor.door_window_sensor_158d0001f3976b";
    public static int meetingRoom = 10;
    public static final String entityId4ServerRoom = "binary_sensor.door_window_sensor_158d000202607d";
    public static int serverRoom = 10;
    public static int OutsideSensor = 10;
    public static int InsideSensor = 10;

    /*
    * 温度相关的传感器参数----测试用
    * */
    public static final String entityId4Temperature = "sensor.temperature_158d0001c1c050";
    public static final String entityId4Humidity = "sensor.humidity_158d0001c1c050";
    public static String currentTemperature = "0.0";
    public static String currentHumidity = "0.0";

    /*
    * 下面的是和会议室是否有人相关的参数
    */
    public static int somebodyAtRoom = 10; //
    public static final String entityId4OutsideSensor = "binary_sensor.motion_sensor_158d0001abdfb4";
    public static final String entityId4InsideSensor = "binary_sensor.motion_sensor_158d0001e16557";
    public static final String entityId4SoundSensor = "";
    public static final String entityId4MeetingRoomLightSensor = "sensor.illumination_158d0001e16557";
    public static final double threshold4Sound = 50.0; // TODO: 2018/1/25 这里的两个阈值都是乱填的
    public static final double threshold4Light = 120; // TODO: 2018/4/4 声音还是乱填的，但是光照已经可用了

    /*
    实验室晚上最后一个走的时候关门关窗
     */
    //外屋的光照传感器，以光照为标准判断是不是最后一个人走了
    public static final String entityId4LightSensor = "sensor.illumination_7811dcaf1e8a";
    public static int nightDoorWindow = 10;

    public static Date inner = null;
    public static Date outer = null;

    public static double lightValue = 0.0;

}
