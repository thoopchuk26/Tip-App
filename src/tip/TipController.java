package tip;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class TipController {

    @FXML
    private TextField bill;

    @FXML
    public ChoiceBox<Service> tips;

    @FXML
    private TextField total;

    @FXML
    public void initialize() {
        bill.setEditable(true);
        total.setEditable(false);
        for (Service s: Service.values()) {
            tips.getItems().add(s);
        }
        tips.getSelectionModel().select(Service.GOOD);
    }

    @FXML
    public void calculate() {
        double billEntered = Double.parseDouble(bill.getText());
        Service level = tips.getSelectionModel().getSelectedItem();
        double totalAmount = level.computeTotal(billEntered);
        total.setText(String.format("%7.2f", totalAmount));
    }
}