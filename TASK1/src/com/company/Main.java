package com.company;

import com.company.controller.Controller;
import com.company.model.GameRoom;
import com.company.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        GameRoom gameRoom = new GameRoom(view);
        Controller controller = new Controller(gameRoom, view);
        controller.process();
    }
}
