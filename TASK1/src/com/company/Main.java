package com.company;

import com.company.controller.Controller;
import com.company.model.Model;
import com.company.view.View;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.process();
    }
}
