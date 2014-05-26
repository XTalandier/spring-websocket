package com.sopra.websocket;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;

public interface IWebsocketHandler {
	
	public void setServer(SocketIOServer _server);

	@OnConnect
    public void onConnectHandler(SocketIOClient client);
	
	@OnDisconnect
    public void onDisconnectHandler(SocketIOClient client);
    
	@OnEvent("hello")
    public void onHelloEventHandler(SocketIOClient client, AckRequest ackRequest);
}
