package cn.edu.fudan.selab.smartHomeController.activemq;


import com.alibaba.fastjson.JSONObject;

import javax.jms.*;
import javax.jms.MessageListener;

/**
 * 消息监听-订阅者二
 * @author fendo
 *
 */
public class Listener2 implements MessageListener{

	public ObjectMessage Message;

	public void setMessage(ObjectMessage message) {
		Message = message;
	}

	public ObjectMessage getMessage() {
		return Message;
	}

	@Override
	public void onMessage(Message message) {

		System.out.println("hh");
		try {
			setMessage(((ObjectMessage)message));
			System.out.println("订阅者二收到的消息："+((ObjectMessage)message).getObject().toString());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
