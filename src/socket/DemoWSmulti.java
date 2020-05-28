package socket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/DemoWSmulti")
public class DemoWSmulti {
	private static final Set<Session> connectedSessions = Collections.synchronizedSet(new HashSet<>());

	@OnOpen
	public void onOpen(Session userSession) throws IOException {
		connectedSessions.add(userSession); // client連線時將連線session放入set內儲存
		String text = String.format("Session ID = %s, connected;", userSession.getId());

		System.out.println(text);
	}

	@OnMessage
	public void onMessage(Session userSession, String message) {
		// 收到訊息時 message
		// 在此可以做分流比如說room number
		String msg = null;
		for (Session session1 : connectedSessions) {
			if (session1.isOpen()) {
				session1.getAsyncRemote().sendText(message);
				if (session1.equals(userSession)) {

				}

			}
			// 送訊息回client
		}

		System.out.println("Session ID =" + userSession.getId() + " ,Message received:" + message);
	}

	@OnClose
	public void onClose(Session userSession, CloseReason reason) {
		connectedSessions.remove(userSession);
		String text = String.format("session ID = %s, disconnected; close code = %d; reason phrase = %s",
				userSession.getId(), reason.getCloseCode().getCode(), reason.getReasonPhrase());
		System.out.println(text);
	}

	@OnError
	public void onError(Session userSession, Throwable e) {
		System.out.println("Error: " + e.toString());
	}

}
