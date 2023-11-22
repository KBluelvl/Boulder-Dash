module g.atlg.boulder.boulderdashg {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens g58137.atlg3.boulder to javafx.fxml;
    exports g58137.atlg3.boulder.view;
}