package com.isil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainApp {

    public static void main(String[] args) throws Exception {

        String jdbcUrl = "jdbc:mysql://localhost:3306/DESA1";
        //cargar el driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //crar la conexion
        Connection con = DriverManager.getConnection(jdbcUrl, "root", "5151");

        //crear el statement
        Statement st = con.createStatement();

        //ejecutar la sentencia SQL
        ResultSet rs = st.executeQuery("select * from Users");

        //procesar el resultado
        while(rs.next()) {
            System.out.println(rs.getString("idUser") +
                    " " + rs.getString("name") +
                    " " + rs.getString("phone") +
                    " " + rs.getString("city"));
        }
    }
}
