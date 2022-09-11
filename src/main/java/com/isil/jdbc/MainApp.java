package com.isil.jdbc;

import java.sql.*;

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
        //Consulta
        //ResultSet rs = st.executeQuery("select * from Users");

        // Insertar
//        int filasAfectadas = st.executeUpdate("insert into Users values(1,'juan','984444459', 'Vancuver')");
//        System.out.println("Filas afectadas: "+filasAfectadas);

        //Actualizar
//        int filasAfectadas = st.executeUpdate("update Users set name='Christian' where name='Cueva'");
//        System.out.println("Filas afectadas: "+filasAfectadas);

        //Eliminar
//        int filasAfectadas = st.executeUpdate("delete from Users where idUser='4'");
//        System.out.println("Filas afectadas: "+filasAfectadas);

        //Crer prepared statement

        //Prepared statement para mantenimiento
        PreparedStatement preparedStatement = con.prepareStatement("insert into Users values(?,?,?,?)");
        preparedStatement.setInt(1, 4);
        preparedStatement.setString(2, "Martha");
        preparedStatement.setString(3, "987654321");
        preparedStatement.setString(4, "Lima");

        int filasAfectadas = preparedStatement.executeUpdate();
        System.out.println("Filas afectadas: "+filasAfectadas);

        //Prepared statement para consulta
        PreparedStatement preparedStatement2 = con.prepareStatement("SELECT * FROM Users WHERE idUser=?");
        preparedStatement2.setInt(1, 4);

        ResultSet rs = preparedStatement2.executeQuery();


        //Recorrer el resultado
        while(rs.next()) {
            System.out.println(rs.getString("idUser") +
                    " " + rs.getString("name") +
                    " " + rs.getString("phone") +
                    " " + rs.getString("city"));
        }
    }
}
