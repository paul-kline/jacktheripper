/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jacktheripper;

import java.io.File;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Paul
 */
public class SavingScheme {

    private final StringProperty custom1 = new SimpleStringProperty("customee1");

    private final ObjectProperty<File> directory = new SimpleObjectProperty<>();

    public ObjectProperty FileProperty() {
        return directory;
    }

    public String getCustom1() {
        return custom1.get();
    }

    public void setCustom1(String value) {
        custom1.set(value);
    }

    public StringProperty custom1Property() {
        return custom1;
    }
    private final StringProperty custom2 = new SimpleStringProperty();

    public String getCustom2() {
        return custom2.get();
    }

    public void setCustom2(String value) {
        custom2.set(value);
    }

    public StringProperty custom2Property() {
        return custom2;
    }
    private final StringProperty dateTime = new SimpleStringProperty("dateTime");

    public String getDateTime() {
        return dateTime.get();
    }

    public void setDateTime(String value) {
        dateTime.set(value);
    }

    public StringProperty dateTimeProperty() {
        return dateTime;
    }
   
    
    
}
