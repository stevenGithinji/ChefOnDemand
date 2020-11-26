/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chefoncall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author mburu
 */
public class Signup {
    Stage window;
    private PreparedStatement pst;
    private Connection con;
    
    public void start(Stage primaryStage) {
        window= primaryStage;
        window.setTitle("Signup Form Window");
        
        GridPane grid= new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));
        
        Text welcomeTxt=new Text ("Signup Please");
        welcomeTxt.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
       grid.add(welcomeTxt,0,0);
       
       Label lblUser= new Label("Username");
       grid.add(lblUser, 0, 1);
       
       TextField txtUser=new TextField();
       txtUser.setPromptText("Username");
       grid.add(txtUser, 1, 1);
       
       
       Label lblFname= new Label("First Name");
       grid.add(lblFname, 0, 2);
       
       TextField txtFname=new TextField();
       txtUser.setPromptText("First Name");
       grid.add(txtFname, 1, 2);
       
       
       Label lblLname= new Label("Last name");
       grid.add(lblLname, 0, 3);
       
       TextField txtLname=new TextField();
       txtUser.setPromptText("Last Name");
       grid.add(txtLname, 1, 3);
       
        Label lblEmail= new Label("Email");
       grid.add(lblEmail, 0, 4);
       
       TextField txtEmail=new TextField();
       txtEmail.setPromptText("Email");
       grid.add(txtEmail, 1, 4);
       
        Label lblPassword= new Label("Password");
       grid.add(lblPassword, 0, 5);
       
       PasswordField pwBox=new PasswordField();
       pwBox.setPromptText("Password");
       grid.add(pwBox, 1, 5);
       
       
       Button SignupBtn= new Button("Signup");
       SignupBtn.setOnAction((ActionEvent event)->{
       try{
           
           String query="INSERT INTO `user_details`(`username`, `first_name`, `last_name`, `email`, `password`) VALUES ('', '', '', '', '')";
         //  Class.forName("com.mysql.cj.jdbc.Driver.class");
         
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldhunger","root","");
           pst=con.prepareStatement(query);
           pst.setString(1, txtUser.getText());
            pst.setString(2, txtFname.getText());
            pst.setString(3, txtLname.getText());
              pst.setString(4, txtEmail.getText());
               pst.setString(5, pwBox.getText());
               
               pst.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "REGISTERED SUCCESFULLY");
               
               
               
       }catch (SQLException ex){
           JOptionPane.showMessageDialog(null, ex);
          
       }   
       });
       grid.add(SignupBtn, 1, 6);
       
       
       Scene scene= new Scene(grid,500,500);
       window.setScene(scene);
       window.show();
    
}
}
