package com.socket.io.socketio.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SocketService {

    @Autowired
    private final SocketIOServer server;

    public SocketService(SocketIOServer server) {
        this.server = server;
    }

    public void emit(String eventName, Object message) {
        for (SocketIOClient client : server.getAllClients()) {
            client.sendEvent(eventName, message);
        }
    }

}
