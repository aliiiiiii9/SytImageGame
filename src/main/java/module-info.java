module com.example.sytimagegame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.sytimagegame to javafx.fxml;
    exports com.example.sytimagegame;
}