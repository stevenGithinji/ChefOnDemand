/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chefoncall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author mburu
 */
public class DataConnection {
    private static boolean successfullConnection=false;

    public static Connection getConnection(){

        Connection con=null;
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/worldhunger?serverTimezone=UTC";
            Properties info = new Properties();
            info.put("user","root");
            info.put("password", "120352");
            con = DriverManager.getConnection(url, info);

            if(con != null) {
                successfullConnection=true;
                System.out.println("DB connected");
            }

        }catch (Exception ex){
            System.out.println("DB Error: " + ex.getMessage());
        }
        return con;
    }

    public static boolean isSuccessfullConnection() {
        return successfullConnection;
    }
}

    

