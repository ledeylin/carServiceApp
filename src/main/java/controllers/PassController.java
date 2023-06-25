package controllers;

import graphics.Shake;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.SQLException;
import java.util.Objects;

public class PassController {
    @FXML
    private Button button_save;
    @FXML
    private TextField passwordField;
    @FXML
    private Text text_mistake;

    private static String password;

    private static int id; // admin:
                           // 0 - edit employees    1 - edit service     8 - edit clients
                           // 2 - add employees     3 - add services     9 - add clients
                           // 4 - delete employees  5 - delete services  10 - delete clients
                           // 6 - edit
                           // employee:
                           // 7 - edit
                           // client:
                           // 11 - edit
                           // 12 - edit car
                           // 13 - add car
                           // 14 - delete car
    @FXML
    void initialize() {

        // окно подтверждения пароля перед сохранением редактирования
        button_save.setOnAction(actionEvent -> {

            if (Objects.equals(passwordField.getText(), password)) {
                button_save.getScene().getWindow().hide();

                try {
//                    if (id == 0) EditAdminEmployees.save();
//                    if (id == 1) EditAdminServices.save();
//                    if (id == 2) AddAdminEmployee.add();
//                    if (id == 3) AddAdminService.add();
//                    if (id == 4) AdminEmployees.delete();
//                    if (id == 5) AdminServices.delete();
                    if (id == 6) AdminEditController.save();
//                    if (id == 7) EmployeeEdit.save();
//                    if (id == 8) EditAdminClients.save();
//                    if (id == 9) AddAdminClients.add();
//                    if (id == 10) AdminClients.delete();
//                    if (id == 11) ClientEdit.save();
//                    if (id == 12) EditClientCar.save();
//                    if (id == 13) AddClientCar.add();
//                    if (id == 14) ClientGarage.delete();

                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                System.out.println("Error: password entered incorrectly.");
                text_mistake.setText("Пароль введён неправильно!");
                Shake passwordAnim = new Shake(passwordField);
                passwordAnim.playAnim();
            }

        });
    }

    public static void setId(int id) {
        PassController.id = id;
    }

    public static void setPassword(String password) {
        PassController.password = password;
    }
}
