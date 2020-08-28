package com.app.jadeimplement;

import jade.core.Agent;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    static AgentController central = null;
    static ContainerController mc = null;
    public static void main(String[] args) {
        try {
            Runtime rt = Runtime.instance();
            ProfileImpl p= new ProfileImpl("localhost", 1099, "RSHP");
            mc = rt.createMainContainer(p);
            AgentController PC = mc.createNewAgent("pc", AgentPCAssmebler.class.getName() ,null);
            AgentController phone = mc.createNewAgent("phone", AgentPhone.class.getName() ,null);

            phone.start();
            PC.start();
            Object[] arg = new Object[2];
            arg[0] = PC.getName(); arg[1] = phone.getName();
            central = mc.createNewAgent("central", AgentCentral.class.getName(), arg);
            central.start();

        } catch (Exception e) { 	e.printStackTrace();   }
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Commercial App");
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }
}
