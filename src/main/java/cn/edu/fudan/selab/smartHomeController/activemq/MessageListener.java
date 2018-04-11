package cn.edu.fudan.selab.smartHomeController.activemq;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.management.timer.Timer;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject; 

public class MessageListener {
	
	private static String REST_API = "http://192.168.1.158:8123/api/states";
	private static String New_State = "";
	private static String Old_State = "";
	public static void main(String[] args) throws Exception {
		while(true) {
			JsonChange();
			Thread.sleep(500);
		}
	}
	public static void JsonChange() throws Exception {
		JSONObject message = new JSONObject();
		JSONArray json = new JSONArray();
		json = (JSONArray)getAllResource().get(0);
		System.out.println(json.toString());
		for(int i=0;i<json.size();i++) {
			JSONObject jsonobject = json.getJSONObject(i);
			//System.out.print(jsonobject.get("entity_id"));
			//System.out.print(jsonobject.get("state"));
            putMessageWhichChanged(jsonobject, message);
		}
//		if(!New_State.equals(Old_State)) {
//			Old_State = New_State;
//		    JMSProducer1 producer = new JMSProducer1();
//		    producer.send2(message);
//		}
	}

	public static void putMessageWhichChanged(JSONObject jsonobject, JSONObject message)
    {
//        if(jsonobject.get("entity_id").toString().equals(entity_id)) {
        New_State = jsonobject.get("state").toString();
//        }
        if(!New_State.equals(Old_State)) {

            message.put("entity_id", jsonobject.get("entity_id").toString());
            message.put("state", jsonobject.get("state").toString());
            message.put("last_changed", jsonobject.get("last_changed").toString());
            Old_State = New_State;
            JMSProducer1 producer = new JMSProducer1();
            producer.send2(message);
        }
    }

	public static JSONArray getAllResource() throws Exception {
		URL url = new URL(REST_API);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setRequestMethod("GET");
		httpURLConnection.setRequestProperty("Accept", "application/json");
		BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
		
		String output;
		//System.out.print("getAllResource result is :");
		JSONArray arr = new JSONArray();
		while ((output = reader.readLine()) != null) {
			arr.add(output);
		}
		//System.out.print("\n");
		return arr;
	}

}
