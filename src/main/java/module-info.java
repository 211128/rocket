module com.navigate.zenteno125 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.navigate.zenteno125 to javafx.fxml;
    exports com.navigate.zenteno125;
}