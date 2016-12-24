/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jacktheripper;

import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import prefobj.PrefObj;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class JackMainGUIController implements Initializable {

    @FXML
    private Button btnAdd;
    @FXML
    private TableView<ScheduleEntry> scheduleTable;

    private ObservableList<ScheduleEntry> scheduleData;
    @FXML
    private TableColumn<ScheduleEntry, DatePicker> colStartDate;
    @FXML
    private TableColumn<ScheduleEntry, String> colTime;
    @FXML
    private TableColumn<ScheduleEntry, String> colRepeating;
    @FXML
    private TableColumn<ScheduleEntry, String> colDuration;
    @FXML
    private TableColumn<ScheduleEntry, String> colFileLoc;
    @FXML
    private TableColumn<ScheduleEntry, String> colFileNamingScheme;
    @FXML
    private TableColumn<ScheduleEntry, String> colStatus;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnDelete;
    @FXML
    private TableView<?> scheduleTable1;
    @FXML
    private TableColumn<?, ?> colStartDate1;
    @FXML
    private TableColumn<?, ?> colTime1;
    @FXML
    private TableColumn<?, ?> colRepeating1;
    @FXML
    private Button btnAddStream;
    @FXML
    private Button btnEditStream;
    @FXML
    private Button btnDeleteStream;
    private Preferences prefs;

    public TableView<ScheduleEntry> getScheduleTable() {
        return scheduleTable;
    }

    public ObservableList<ScheduleEntry> getScheduleData() {
        return scheduleData;
    }
    private static JackMainGUIController instance;

    public static JackMainGUIController getInstance() {
        return instance;
    }
    
    public void saveAll(){
        try {
            PrefObj.putObject(prefs, "scheduleData", scheduleData.toArray(new ScheduleEntry[scheduleData.size()]));
            
            System.out.println(((ScheduleEntry[])PrefObj.getObject(prefs, "scheduleData")).length);
        } catch (IOException ex) {
            Logger.getLogger(JackMainGUIController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BackingStoreException ex) {
            Logger.getLogger(JackMainGUIController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JackMainGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instance = this;
        
        
        scheduleTable.setItems(scheduleData);
        colStartDate.setCellValueFactory(new PropertyValueFactory<ScheduleEntry,DatePicker>("datepicker"));
        colRepeating.setCellValueFactory(new PropertyValueFactory<ScheduleEntry,String>("repeating"));
        prefs = Preferences.userNodeForPackage(this.getClass());
        try {
            ScheduleEntry[] x = (ScheduleEntry[]) PrefObj.getObject(prefs, "scheduleData");
            System.out.println(x.length);
        } catch (IOException ex) {
            Logger.getLogger(JackMainGUIController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BackingStoreException ex) {
            Logger.getLogger(JackMainGUIController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JackMainGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        scheduleData = FXCollections.observableArrayList();
    }    

    @FXML
    private void addRow(ActionEvent event) {
        try {
            ScheduleEntry newguy = new ScheduleEntry();
            scheduleData.add(newguy);
            scheduleTable.getSelectionModel().select(newguy);
            Parent root = FXMLLoader.load(getClass().getResource("EditScheduleEntry.fxml"));
            
            
            Scene scene = new Scene(root);//, 300, 250);
            Stage stage = new Stage();
            stage.setTitle("Hello World!");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(JackMainGUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cellClicked(MouseEvent event) {
        System.out.println("HIHIHIHIHIs");
    }

    @FXML
    private void editRow(ActionEvent event) {
        System.out.println(scheduleTable.getSelectionModel().getSelectedItem());
    }
    
}
