package cn.edu.fudan.selab.smartHomeController.reasoning;

import cn.edu.fudan.selab.smartHomeController.utility.HttpRequest4DeviceStates;
import cn.edu.fudan.selab.smartHomeController.utility.Parameters;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

/**
 * @author Fan Zejun E-mail:fzj0522@outlook.com
 * @version 2018/1/25 下午9:02
 */
public class IfEmptyRoomReasoning {

    public static void execute(int delay){

        try{
            List<String> entityList = new ArrayList<String>();
            entityList.add(Parameters.entityId4OutsideSensor);
            entityList.add(Parameters.entityId4InsideSensor);
            entityList.add(Parameters.entityId4LightSensor);
            Iterator<String> it = entityList.iterator();

            JSONObject obj = null;
            Date outer = null;
            Date inner = null;
            Double lightValue = 0.0;
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");

            Thread.sleep(delay);//延迟数秒执行，是为了确保人把门内外的两个传感器都踩一遍

            while(it.hasNext()){
                String currentEntityId = it.next();
                obj = JSON.parseObject(HttpRequest4DeviceStates.getDeviceStateById(currentEntityId));
                System.out.println(currentEntityId + " " + obj.get("state"));
                if (obj.get("entity_id").equals(Parameters.entityId4OutsideSensor))
                {
                    outer = sdf.parse(String.valueOf(obj.get("last_changed")));
                    System.out.println("外面的变化时间是：" + outer);
                }
                if (obj.get("entity_id").equals(Parameters.entityId4InsideSensor))
                {
                    inner = sdf.parse(String.valueOf(obj.get("last_changed")));// TODO: 2018/1/25 这里需要改成真实获得的传感器last_changed参数
                    System.out.println("里面的变化时间是：" + inner);
                }
                if (obj.get("entity_id").equals(Parameters.entityId4LightSensor))
                {
                    lightValue = Double.parseDouble(String.valueOf(obj.get("state")));
                    System.out.println("光照是：" + lightValue);
                }
            }

            if((inner != null ? inner.getTime() : 0) < (outer != null ? outer.getTime() : 0)){
                //有人出来
                Double soundValue = 100.0;// TODO: 2018/1/26 这里也是随便填的数据
                if(/*soundValue < Parameters.threshold4Sound && */lightValue < Parameters.threshold4Light){
                    Parameters.somebodyAtRoom = 0;
                }
            }else if ((inner != null ? inner.getTime() : 0) > (outer != null ? outer.getTime() : 0)){
                //有人进去
                Parameters.somebodyAtRoom = 1;
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ParseException pe){
            pe.printStackTrace();
        }



    }
}
