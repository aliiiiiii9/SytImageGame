package com.example.sytimagegame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView imageView;
    private ImageDiscoverer discoverer;


    @FXML
    protected void onStart() {
        discoverer.startDiscover();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Image image = new Image("image.jpg");

        discoverer = new ImageDiscoverer(image);

        imageView.setImage(discoverer.getCurrentImage());
    }

}