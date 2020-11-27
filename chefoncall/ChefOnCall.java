/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chefoncall;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author mburu
 */
public class ChefOnCall extends Application {
    Stage window;
    

  private Authentication authentication;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
//        window.setTitle("Login Form Window");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(20);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));

        Text welcomeTxt = new Text("Chef On Demand");
        welcomeTxt.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));
        grid.add(welcomeTxt, 0, 0);

        Label lblUser = new Label("Username");
        grid.add(lblUser, 0, 1);

        TextField txtUser = new TextField();
        txtUser.setPromptText("Username");
        grid.add(txtUser, 1, 1);

        Label lblPassword = new Label("Password");
        grid.add(lblPassword, 0, 2);

        PasswordField pwBox = new PasswordField();
        pwBox.setPromptText("Password");
        grid.add(pwBox, 1, 2);

        Button loginBtn = new Button("Login");

        loginBtn.setOnAction(e -> {

            PreparedStatement ps;
            String uname = lblUser.getText();
            String pass = pwBox.getText();
            String Try="t";

            String query = "SELECT * FROM user_details WHERE username ='" + uname + "' AND password ='" + pass + "'";


                try {
                ps = DataConnection.getConnection().prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    rs.next();
                } catch (SQLException ex) {
                    Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);

                }
            if ( !lblUser.getText().trim().isEmpty()&&!pwBox.getText().trim().isEmpty()) {
                this.authentication = new Authentication();
                try {
                    window.setScene(authentication.setLayout());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

        grid.add(loginBtn, 1, 3);

        //hyperlink to go to sign up
        Hyperlink signup = new Hyperlink("Don't have an account?");
        signup.setOnAction(e -> {

            Signup x = new Signup();
            x.start(primaryStage);

        });
        grid.add(signup, 0, 3);

        Scene scene = new Scene(grid, 500, 500);
        window.setScene(scene);
        window.show();
    }

   /* private void showView(AppViews view, String extra) {
        switch (view) {
            case Authentication:
                new Authentication();
                break;


       }

    }*/ 

    public  class Signup extends Application {
        Stage window;
        private PreparedStatement pst;
        private Connection con;
        private Scene Scene;

        @Override
        public void start(Stage primaryStage) {
            window = primaryStage;
            window.setTitle("Signup Form Window");

            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setVgap(10);
            grid.setHgap(10);
            grid.setPadding(new Insets(10));

            Text welcomeTxt = new Text("Signup Please");
            welcomeTxt.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
            grid.add(welcomeTxt, 0, 0);
            Label lblid = new Label("Client id");
            grid.add(lblid, 0, 1);

            TextField txtid = new TextField();
            txtid.setPromptText("Client id");
            grid.add(txtid, 1, 1);


            Label lblname = new Label("Client Name");
            grid.add(lblname, 0, 2);

            TextField txtname = new TextField();
            txtid.setPromptText("Client Name");
            grid.add(txtname, 1, 2);


            Label lblEmail = new Label("Client Email");
            grid.add(lblEmail, 0, 3);

            TextField txtEmail = new TextField();
            txtid.setPromptText("Client Email");
            grid.add(txtEmail, 1, 3);

            Label lblPassword = new Label("Client Password");
            grid.add(lblPassword, 0, 4);

            PasswordField pwBox = new PasswordField();
            pwBox.setPromptText("Client Password");
            grid.add(pwBox, 1, 4);
            
            Label lblphone= new Label("Client Number");
            txtid.setPromptText("Client Number");
            grid.add(lblphone, 0, 5);
            
             TextField txtphone = new TextField();
            txtid.setPromptText("Client Number");
            grid.add(txtEmail, 1, 5);


            Button SignupBtn = new Button("Signup");
            SignupBtn.setOnAction((ActionEvent event) -> {
                
                String id=txtid.getText();
                String name=txtname.getText();
                String Email=txtEmail.getText();
                String pass=pwBox.getText();
                String phone=txtphone.getText();

                PreparedStatement ps;
                String query="INSERT INTO 'client'('client_id','client_name','client_email','password',client_phone) VALUES(?,?,?,?,?)";

                try {


                        ps = DataConnection.getConnection().prepareStatement(query);

                        ps.setString(1, id);
                        ps.setString(2, name);
                        ps.setString(3, Email);
                        ps.setString(4, pass);
                        ps.setString(5, phone);


                    } catch (SQLException ex) {
                        Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        if(!txtid.getText().trim().isEmpty()&&!txtname.getText().trim().isEmpty()&&!txtEmail.getText().trim().isEmpty()&&!txtphone.getText().trim().isEmpty()&&!pwBox.getText().trim().isEmpty()) {


            
                            SignupBtn.setOnAction(e -> {
                                authentication = new Authentication();
                                try {
                                    window.setScene(authentication.setLayout());
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            });
                        }
            });


            grid.add(SignupBtn, 1, 6);

            Hyperlink Main = new Hyperlink("Go back to login");
            Main.setOnAction(e -> {

                        ChefOnCall x = new ChefOnCall();
                        x.start(primaryStage);

                    });
            grid.add(Main,0,6);

            Scene scene = new Scene(grid, 500, 500);
            window.setScene(scene);
            window.show();
        }


        }
   
}
