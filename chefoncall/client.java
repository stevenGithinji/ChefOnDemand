/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chefoncall;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.ConditionalFeature.FXML;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mburu
 */
public class client extends Application{
    
    
    private final TableView<Person> table = new TableView<>();
    private final ObservableList<Person> data =
        FXCollections.observableArrayList(
            new Person("Jacob", "0732128362", "jacob.smith@example.com", "Weddings specializing in Ugali and main dishes"),
            new Person("Isabella", "0723172638", "isabella.johnson@example.com", "Burials"),
            new Person("Ethan", "0723642152", "ethan.williams@example.com", "Weddings"),
            new Person("Emma", "0723817263", "emma.jones@example.com","Burials"),
            new Person("Michael", "0718263612", "michael.brown@example.com","Birthdays")
        );
   
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Chef");
        stage.setWidth(450);
        stage.setHeight(500);
          
 Button mpesa= new Button("mpesa");
  scene = new Scene(mpesa,200,100);
 
        final Label label = new Label("Chef list");
//        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
 
        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));
 
        TableColumn PhoneCol = new TableColumn("Phone number");
        PhoneCol.setMinWidth(100);
        PhoneCol.setCellValueFactory(
                new PropertyValueFactory<>("Phone"));
 
        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<>("email"));
        
        TableColumn ocassionCol = new TableColumn("Ocassion");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<>("ocassion"));
 
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, PhoneCol, emailCol, ocassionCol);
 
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
 
    public static class Person {
 
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty Phone;
        private final SimpleStringProperty email;
        private final SimpleStringProperty ocassion;
     private final SimpleBooleanProperty selected;
 
        private Person(String fName, String Phone1, String email1, String ocassion1) {
            this.firstName = new SimpleStringProperty(fName);
            this.Phone = new SimpleStringProperty(Phone1);
            this.email = new SimpleStringProperty(email1);
            this.ocassion=new SimpleStringProperty(ocassion1);
            this.selected=new SimpleBooleanProperty(false);
        }
        
         public boolean isSelected() {
        return selected.get();
    }

    public SimpleBooleanProperty selectedProperty() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected.set(selected);
    }

       
        public String getFirstName() {
            return firstName.get();
        }
 
        public void setFirstName(String fName) {
            firstName.set(fName);
        }
 
        public String getPhoneNumber() {
            return Phone.get();
        }
 
        
        public void setPhoneNumber(String Phone1) {
            Phone.set(Phone1);
        }
        
        
 
        public String getEmail() {
            return email.get();
        }
 
        public void setEmail(String email1) {
            email.set(email1);
        }
        
        
        
         public String getOcassion() {
            return ocassion.get();
        }
 
        public void setOcassion(String ocassion1) {
            ocassion.set(ocassion1);
    }
        

    
}
}