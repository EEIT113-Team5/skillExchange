package socket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import net.sf.json.JSONObject;

@ServerEndpoint("/DemoWS/{sendUser}")
public class DemoWS {
	private static final Set<Session> connectedSessions = Collections.synchronizedSet(new HashSet<>());
	// 用户在線數
	private static int onLineCount = 0;
	// 當前的websocket对象
	private static ConcurrentHashMap<String, DemoWS> webSocketMap = new ConcurrentHashMap<>();
	// 当前会话,属于websocket的session
	private Session session;
	// 聊天信息

	// 從client送來
	private String sendUser;// 當前用戶訊息
	private String toUser;// 接收人
	private String message;// 聊天信息

	@OnOpen
	public void onOpen(@PathParam("sendUser") String sendUser, Session userSession) throws IOException {
		connectedSessions.add(userSession); // client連線時將連線session放入set內儲存
		String text = String.format("Session ID = %s, 當前session = %s, 使用者User= %s, connected;", userSession.getId(),userSession.hashCode(), sendUser );
		this.sendUser = sendUser;
		this.session = userSession;
		addOnlineCount();
		System.out.println("有新連接加入！當前在線人數為" + getOnlineCount());
		System.out.println(text);
		webSocketMap.put(sendUser, this);// 當前用户的websocket
		// 刷新在線人數
		for (DemoWS Demows : webSocketMap.values()) {
			// 使用if判断是要统计人数还是发送消息
			//如何隔離不同房間
			if (Demows.session.isOpen()) {
			    
				Demows.sendMessage("null", "count", getOnlineCount() + "");
			}
		}

		
	}

	@OnMessage
	public void onMessage(Session userSession, String jsonMsg) {
		// 收到訊息時 message
		// 在此可以做分流比如說room number
		JSONObject jsonOject = JSONObject.fromObject(jsonMsg);
		sendUser = jsonOject.getString("sendUser");
		toUser = jsonOject.getString("toUser");
		message = jsonOject.getString("message");
		DemoWS user = webSocketMap.get(toUser);

		try {
			String img = null;
			if (sendUser.equals("菅田將輝")) {
				img = "'images/suda.jpeg'";
			} else {
				img = "'images/nemotsukensi.jpg'";
			}
			String msg = "<div class='d-flex justify-content-end mb-4'><div class='msg_cotainer_send'>" + message
					+ "<span class='msg_time_send'><!-- 時間 --></span></div><div class='img_cont_msg'><img src=" + img
					+ " class='rounded-circle user_img_msg'></div></div>";
//		    System.out.println(msg);

			if (user != null) {
				if (user.session.isOpen()) {
					user.sendMessage(img, "send", message);
				} 
			} else {
				System.out.println("信息存到數據庫");
			}
			;
			userSession.getAsyncRemote().sendText(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Session ID =" + userSession.getId() + " , Message received:" + message);
	}

	@OnClose
	public void onClose(Session userSession, CloseReason reason) {
		connectedSessions.remove(userSession);
		String text = String.format("session ID = %s, disconnected; close code = %d; reason phrase = %s",
				userSession.getId(), reason.getCloseCode().getCode(), reason.getReasonPhrase());
		subOnlineCount();
		for (DemoWS Demows : webSocketMap.values()) {
			// 使用if判断是要统计人数还是发送消息
			try {
				if (Demows.session.isOpen()) {
					Demows.sendMessage("null", "count", getOnlineCount() + "");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(text);
	}

	@OnError
	public void onError(Session userSession, Throwable e) {
		System.out.println("Error: " + e.toString());
	}

	public void sendMessage(String img, String type, String message) throws IOException {
		if (type.equals("count")) {

			this.session.getAsyncRemote().sendText("count:" + message);// 在jsp判断是否包含count

		} else {

			String msg1 = "<div class='d-flex justify-content-start mb-4'><div class='img_cont_msg'><img src=" + img
					+ " class='rounded-circle user_img_msg'></div><div class='msg_cotainer'>" + message
					+ "<span class='msg_time'><!-- 時間 --></span></div></div>";
			this.session.getAsyncRemote().sendText(msg1);// 提供阻塞式的消息发送方式

			// this.session.getAsyncRemote().sendText(message);//提供非阻塞式的消息传输方式。
		}

	}

	// 获得当前在线人数
	public static synchronized int getOnlineCount() {
		return onLineCount;
	}

	// 新用户
	public static synchronized void addOnlineCount() {
		DemoWS.onLineCount++;
	}

	// 移除退出用户
	public static synchronized void subOnlineCount() {
		DemoWS.onLineCount--;
	}

}
