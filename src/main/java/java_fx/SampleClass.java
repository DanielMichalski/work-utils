package java_fx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Author: Daniel
 */
public class SampleClass extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        LimitedTextField limitedTextField = new LimitedTextField();
        limitedTextField.setMaxLength(20);

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(limitedTextField);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
