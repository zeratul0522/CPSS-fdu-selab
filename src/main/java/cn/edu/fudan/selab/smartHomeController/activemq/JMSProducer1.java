package cn.edu.fudan.selab.smartHomeController.activemq;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import net.sf.json.JSONObject;
public class JMSProducer1 {
	
	private static final String USERNAME=ActiveMQConnection.DEFAULT_USER; // Ĭ�ϵ������û���
	private static final String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD; // Ĭ�ϵ���������
	private static final int SENDNUM=10; // ���͵���Ϣ����
	// ����ģʽ

	// 1�����ӹ���
	private ConnectionFactory connectionFactory;
	// 2�����Ӷ���
	private Connection connection;
	// 3��Session����
	private Session session;
	// 4��������
	private MessageProducer messageProducer;

	public JMSProducer1() {

		try {
			this.connectionFactory = new ActiveMQConnectionFactory(JMSProducer1.USERNAME,
					JMSProducer1.PASSWORD, "tcp://192.168.1.158:61616");
			this.connection = connectionFactory.createConnection();
			connection.start();
			// ��ʹ������
			// ���ÿͻ���ǩ��ģʽ
			this.session = connection.createSession(Boolean.TRUE,
					Session.AUTO_ACKNOWLEDGE);
			this.messageProducer = session.createProducer(null);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}

	}

	public Session getSession() {
		return this.session;
	}
 
	public void send1(/* String QueueName, Message message */) {
		try {

			Destination destination = this.session.createTopic("topic1");
			MapMessage msg1 = this.session.createMapMessage();
			msg1.setString("name", "Zhangsan");
			msg1.setInt("age", 22);

			MapMessage msg2 = this.session.createMapMessage();
			msg2.setString("name", "Li si");
			msg2.setInt("age", 25);

			MapMessage msg3 = this.session.createMapMessage();
			msg3.setString("name", "Wang wu");
			msg3.setInt("age", 30);

			// ������Ϣ��topic1
			this.messageProducer.send(destination, msg1,
					DeliveryMode.NON_PERSISTENT, 4, 1000 * 60 * 10);
			this.messageProducer.send(destination, msg2,
					DeliveryMode.NON_PERSISTENT, 4, 1000 * 60 * 10);
			this.messageProducer.send(destination, msg3,
					DeliveryMode.NON_PERSISTENT, 4, 1000 * 60 * 10);

		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}

	public void send3() {
		try {
			Destination destination = this.session.createTopic("topic3");
			TextMessage message = this.session.createTextMessage("LiuBo shi sb!");
			// ������Ϣ
			this.messageProducer.send(destination, message,
					DeliveryMode.NON_PERSISTENT, 4, 1000 * 60 * 10);
			session.commit();
			System.out.println("success");
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void send2(JSONObject msg) {
		try {
			Destination destination = this.session.createTopic("topic6");
			ObjectMessage message = this.session.createObjectMessage(msg.toString());
			// ������Ϣ
			this.messageProducer.send(destination, message,
					DeliveryMode.PERSISTENT, 4, 1000 * 60 * 10);
			session.commit();
			System.out.println("success");
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}

	}
	
	public static void main(String[] args) {
		JMSProducer1 publish = new JMSProducer1();
		//publish.send2();
	}
}