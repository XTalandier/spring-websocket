	package com.sopra.websocket;
	
	import org.springframework.beans.factory.annotation.Autowired;
	
	import com.corundumstudio.socketio.Configuration;
	import com.corundumstudio.socketio.SocketIOServer;
	
	public class Websocket implements AutoCloseable  {
		
		/**
		 * Correspond aux ev�nements qui seront
		 * g�r� par le serveur websocket
		 */
		@Autowired
		private IWebsocketHandler wsHandler;
		
		/**
		 * Configuration du serveur Websocket
		 */
		@Autowired
		private Configuration confWebsocket;
		
		/**
		 * Serveur
		 */
		private SocketIOServer server;
		
		/**
		 * D�marrage du serveur
		 * 
		 * @return void
		 */
		public void start(){
			server = new SocketIOServer(confWebsocket);
			wsHandler.setServer(server);
			server.addListeners(wsHandler);
			server.start();
		}
	
		/**
		 * Ferme la connexion
		 */
		@Override
		public void close() throws Exception {
			server.stop();
		}
		
		
	}
