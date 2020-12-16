package com.example.sdp;

import java.sql.*;

public class Query {

    public static void query(String query) throws SQLException{
        Connection c = establishConnection();
        Statement s = c.createStatement();
        s.execute(query);
    }

    public static ResultSet select(String selectQuery) throws SQLException {
        Connection c = establishConnection();
        Statement s = c.createStatement();
        return s.executeQuery(selectQuery);
    }

    private static Connection establishConnection() {
        String URL = "jdbc:postgresql://localhost/sdp";
        String user = "postgres";
        String pwd = "haha12";

        Connection c = null;
        try {
            c = DriverManager.getConnection(URL, user, pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return c;
    }


}
