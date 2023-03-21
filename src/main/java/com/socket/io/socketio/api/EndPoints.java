package com.socket.io.socketio.api;

import com.socket.io.socketio.socket.SocketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/")
public class EndPoints {

    @Autowired
    private final SocketService socketService;

    public EndPoints(SocketService socketService) {
        this.socketService = socketService;
    }

    @GetMapping
    public String get() {
        return "This is the local server";
    }

    @PostMapping("/{event}")
    public void getData(@RequestBody Object data,  @PathVariable String event) {
        System.out.println(data);
        socketService.emit(event, data);
    }
}
