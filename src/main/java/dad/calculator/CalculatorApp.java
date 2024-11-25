package dad.calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    private final CalculatorController calculatorController= new CalculatorController();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Calculadora");
        primaryStage.setScene(new Scene(calculatorController.getRoot()));
        primaryStage.show();

    }

}
