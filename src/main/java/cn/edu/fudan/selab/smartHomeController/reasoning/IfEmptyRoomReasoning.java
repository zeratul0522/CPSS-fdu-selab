package cn.edu.fudan.selab.smartHomeController.reasoning;

import cn.edu.fudan.selab.smartHomeController.utility.Parameters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Fan Zejun E-mail:fzj0522@outlook.com
 * @version 2018/1/25 下午9:02
 */
public class IfEmptyRoomReasoning {

    public static void execute(int delay){

        try{
            Thread.sleep(delay);//延迟数秒执行，是为了确保人把门内外的两个传感器都踩一遍
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
            Date inner = sdf.parse("2018-01-25T12:58:17.435950");// TODO: 2018/1/25 这里需要改成真实获得的传感器last_changed参数
            Date outer = sdf.parse("2018-01-25T12:49:17.435950");
            if(inner.getTime() < outer.getTime()){
                //有人出来
                Double soundValue = 100.0;// TODO: 2018/1/26 这里也是随便填的数据
                Double lightValue = 100.0;
                if(soundValue < Parameters.threshold4Sound && lightValue < Parameters.threshold4Light){
                    Parameters.somebodyAtRoom = 0;
                }
            }else{
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
