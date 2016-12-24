/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jacktheripper;

import com.sun.javafx.beans.event.AbstractNotifyListener;
import com.sun.javafx.css.converters.StringConverter;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;
import javafx.util.converter.FormatStringConverter;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class EditScheduleEntryController implements Initializable {

    private ScheduleEntry myScheduleEntry;
    @FXML
    private TableView<SavingScheme> tblSavingScheme;
    private SavingScheme mySavingScheme;
    @FXML
    private Label lblFile;
    @FXML
    private ChoiceBox<ScheduleEntry.REPEATING> cmbRepeating;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;
    private ObservableList<ScheduleEntry> allScheduleData;

    public EditScheduleEntryController(ScheduleEntry myScheduleEntry) {
        this.myScheduleEntry = myScheduleEntry;
    }

    public EditScheduleEntryController() {
    }

    @FXML
    private Button btnChooseFolder;
    @FXML
    private TitledPane filesavingPanel;
    @FXML
    private TableColumn<SavingScheme, String> colCustom1;
    @FXML
    private TableColumn<?, ?> colDateTime;
    @FXML
    private TableColumn<?, ?> colCustom2;

    private ObservableList<SavingScheme> savingSchemeData;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbRepeating.setItems(FXCollections.observableArrayList(ScheduleEntry.REPEATING.values()));
        cmbRepeating.setValue(ScheduleEntry.REPEATING.NEVER);
        savingSchemeData = FXCollections.observableArrayList();
        mySavingScheme = new SavingScheme();
        savingSchemeData.add(mySavingScheme);
        mySavingScheme.FileProperty().addListener(new ChangeListener<File>() {
            @Override
            public void changed(ObservableValue<? extends File> observable, File oldValue, File newValue) {
                lblFile.setText(newValue.getAbsolutePath());
            }
        });
        colCustom1.setCellValueFactory(new PropertyValueFactory<SavingScheme, String>("custom1"));
        colCustom1.setCellFactory(col -> new TextFieldTableCell<SavingScheme, String>(new javafx.util.StringConverter<String>() {
            @Override
            public String toString(String object) {
                return object;
            }

            @Override
            public String fromString(String string) {
                return string;
            }
        }));
        tblSavingScheme.setItems(savingSchemeData);
        
        allScheduleData = JackMainGUIController.getInstance().getScheduleData();
        int i = JackMainGUIController.getInstance().getScheduleTable().getSelectionModel().getSelectedIndex();
        System.out.println("i is " + i);
//        myScheduleEntry = allScheduleData.get(JackMainGUIController.getInstance().getScheduleTable().getSelectionModel().getSelectedIndex());
    }

    public void bump(){
        
    }
    @FXML
    private void chooseFolder(ActionEvent event) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("JavaFX Projects");
//        File defaultDirectory = new File("c:/dev/javafx");
//        chooser.setInitialDirectory(defaultDirectory);
        File selectedDirectory = chooser.showDialog(filesavingPanel.getScene().getWindow());
        if (null != selectedDirectory) {
            mySavingScheme.FileProperty().set(selectedDirectory);
        }
    }

    @FXML
    private void onSave(ActionEvent event) {
        System.out.println("saving!");
        JackMainGUIController.getInstance().saveAll();
        close();
//        myScheduleEntry = parseState();
//        JackMainGUIController.getInstance().getScheduleData().add(myScheduleEntry);
    }

    @FXML
    private void onCancel(ActionEvent event) {
        close();

//        Platform.exit();
    }

    private void close() {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

}
