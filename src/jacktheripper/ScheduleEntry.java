/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jacktheripper;

import com.sun.corba.se.impl.orbutil.ObjectWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.DatePicker;

/**
 *
 * @author Paul
 */
class ScheduleEntry implements Serializable {

    public static enum REPEATING {
        NEVER, MONDAYS, TUESDAYS, WEDNESDAY, THURSDAYS, FRIDAYS, SATURDAYS, SUNDAYS
    }
    private final ObjectProperty<REPEATING> repeating = new SimpleObjectProperty<>();

    public REPEATING getRepeating() {
        return repeating.get();
    }

    public void setRepeating(REPEATING value) {
        repeating.set(value);
    }

    public ObjectProperty repeatingProperty() {
        return repeating;
    }
    private final ObjectProperty<LocalDateTime> starting = new SimpleObjectProperty<>();

    public LocalDateTime getStarting() {
        return starting.get();
    }

    public void setStarting(LocalDateTime value) {
        starting.set(value);
    }

    public ObjectProperty startingProperty() {
        return starting;
    }
    private final ObjectProperty<LocalDateTime> ending = new SimpleObjectProperty<>();

    public LocalDateTime getEnding() {
        return ending.get();
    }

    public void setEnding(LocalDateTime value) {
        ending.set(value);
    }

    public ObjectProperty endingProperty() {
        return ending;
    }
    private final ObjectProperty<Duration> duration = new SimpleObjectProperty<>();

    public Duration getDuration() {
        return duration.get();
    }

    public void setDuration(Duration value) {
        duration.set(value);
    }

    public ObjectProperty durationProperty() {
        return duration;
    }
    private final ObjectProperty<SavingScheme> savingScheme = new SimpleObjectProperty<>();

    public SavingScheme getSavingScheme() {
        return savingScheme.get();
    }

    public void setSavingScheme(SavingScheme value) {
        savingScheme.set(value);
    }

    public ObjectProperty savingSchemeProperty() {
        return savingScheme;
    }

//    private REPEATING repeating = REPEATING.NEVER;
//    private LocalDateTime starting;
//    private LocalDateTime ending;
//    private Duration duration;
//   
//    private SavingScheme namingScheme;
    public ScheduleEntry() {

    }

   

}
