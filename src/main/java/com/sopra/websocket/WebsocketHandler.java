package com.sopra.websocket;

import java.util.HashMap;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.*;

public class WebsocketHandler implements IWebsocketHandler {

	SocketIOServer server;

	/**
	 * Set the server.
	 * @param _server The server to set.
	 */
	public void setServer(SocketIOServer _server) {
		server = _server;
		server.addListeners(this);
	}

	
	@OnConnect
    public void onConnectHandler(SocketIOClient client) {

    }

    @OnDisconnect
    public void onDisconnectHandler(SocketIOClient client) {

    }
    
    @OnEvent("hello")
    public void onHelloEventHandler(SocketIOClient client, AckRequest ackRequest) {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("v1", "Valeur 1");
        data.put("v2", "Valeur 2");
        data.put("v3", "Valeur 3");
        data.put("v4", "Valeur 4");

        
        server.getBroadcastOperations().sendEvent("evt1", data);
        server.getBroadcastOperations().sendJsonObject("Hello world !!");
    }

}
