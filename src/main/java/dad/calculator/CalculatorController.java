
package dad.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

    // View
    @FXML
    private Button cButton;

    @FXML
    private Button ceButton;

    @FXML
    private Button divideButton;

    @FXML
    private Button dotButton;

    @FXML
    private Button eightButton;

    @FXML
    private Button equalsButton;

    @FXML
    private Button fiveButton;

    @FXML
    private Button fourButton;

    @FXML
    private Button minusButton;

    @FXML
    private Button multiplyButton;

    @FXML
    private Button nineButton;

    @FXML
    private Button oneButton;

    @FXML
    private Button plusButton;

    @FXML
    private Button sevenButton;

    @FXML
    private Button sixButton;

    @FXML
    private Button threeButton;

    @FXML
    private Button twoButton;

    @FXML
    private Button zeroButton;

    @FXML
    private BorderPane root;

    @FXML
    private TextField operacionText;

    private double operadorUno = 0;
    private double operadorDos = 0;
    private String operador = "";
    private boolean start = true;

    public CalculatorController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CalculatorView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public BorderPane getRoot() {
        return root;
    }

    @FXML
    void onEqualsAction(ActionEvent event) {
        if (operador.isEmpty()) {
            return;
        }
        operadorDos = Double.parseDouble(operacionText.getText());
        double result = calcularResultado(operadorUno, operadorDos, operador);
        operacionText.setText(String.valueOf(result));
        operador = "";
        start = true;
    }

    @FXML
    void onCAction(ActionEvent event) {
        operacionText.setText("");
        operadorUno = 0;
        operadorDos = 0;
        operador = "";
        start = true;
    }

    @FXML
    void onCEAction(ActionEvent event) {
        operacionText.setText("");
    }

    @FXML
    void onDivideAction(ActionEvent event) {
        operar("/");
    }

    @FXML
    void onDotAction(ActionEvent event) {
        operacionText.appendText(".");
    }

    @FXML
    void onEightAction(ActionEvent event) {
        appendNumber("8");
    }

    @FXML
    void onFiveAction(ActionEvent event) {
        appendNumber("5");
    }

    @FXML
    void onFourAction(ActionEvent event) {
        appendNumber("4");
    }

    @FXML
    void onMinusAction(ActionEvent event) {
        operar("-");
    }

    @FXML
    void onMultiplyAction(ActionEvent event) {
        operar("*");
    }

    @FXML
    void onNineAction(ActionEvent event) {
        appendNumber("9");
    }

    @FXML
    void onOneAction(ActionEvent event) {
        appendNumber("1");
    }

    @FXML
    void onPlusAction(ActionEvent event) {
        operar("+");
    }

    @FXML
    void onSevenAction(ActionEvent event) {
        appendNumber("7");
    }

    @FXML
    void onSixAction(ActionEvent event) {
        appendNumber("6");
    }

    @FXML
    void onThreeAction(ActionEvent event) {
        appendNumber("3");
    }

    @FXML
    void onTwoAction(ActionEvent event) {
        appendNumber("2");
    }

    @FXML
    void onZeroAction(ActionEvent event) {
        appendNumber("0");
    }

    private void appendNumber(String numero) {
        if (start) {
            operacionText.setText(numero);
            start = false;
        } else {
            operacionText.appendText(numero);
        }
    }

    private void operar(String operador) {
        operadorUno = Double.parseDouble(operacionText.getText());
        this.operador = operador;
        operacionText.setText("");
    }

    private double calcularResultado(double operadorUno, double operadorDos, String operador) {
        switch (operador) {
            case "+":
                return operadorUno + operadorDos;
            case "-":
                return operadorUno - operadorDos;
            case "*":
                return operadorUno * operadorDos;
            case "/":
                if (operadorDos == 0) {
                    return 0; // Division by zero handling
                }
                return operadorUno / operadorDos;
            default:
                return 0;
        }
    }
}
