package com.example.sdp;

import java.sql.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Query {

    public static void query(String query) throws SQLException{
        Instant start = Instant.now();
        Connection c = establishConnection();
        Statement s = c.createStatement();
        s.execute(query);
        Instant end = Instant.now();
        String queryType = query.substring(0, query.indexOf(' '));
        System.out.println("Execution time for " + queryType + ": " +
                (Duration.between(start, end)).toMillis() + "ms");
    }

    public static ResultSet select(String selectQuery) throws SQLException {
        Connection c = establishConnection();
        Statement s = c.createStatement();
        return s.executeQuery(selectQuery);
    }

    public static void insert(int n) throws SQLException{
        String[] names = new String[] { "Liam", "Noah", "Oliver", "William", "Elijah", "James", "Benjamin", "Lucas",
                "Mason", "Ethan", "Alexander", "Henry", "Jacob", "Michael", "Daniel", "Logan", "Jackson",
                "Sebastian","Jack", "Aiden", "Owen", "Samuel", "Matthew", "Joseph", "Levi",
                "Mateo", "David", "John", "Wyatt", "Carter", "Julian", "Luke", "Grayson", "Isaac",
                "Jayden", "Theodore", "Gabriel", "Anthony", "Dylan", "Leo", "Lincoln"};
        Random rand = new Random();
        StringBuilder sb = new StringBuilder("INSERT INTO PUBLIC.NAMES(\"id_name\", \"name\") VALUES ");

        for(int i=0; i<n; i++){
            sb.append("(" + (i+1) + ", '" + names[rand.nextInt(names.length)] + "')");
            if(i != n-1){
                sb.append(", ");
            }
        }

        String query = sb.toString();
        Instant start = Instant.now();

        Connection c = establishConnection();
        Statement s = c.createStatement();
        s.execute(query);

        Instant end = Instant.now();
        System.out.println("Execution time for INSERTs in number of " + n + ": " +
                (Duration.between(start, end)).toMillis() + "ms");
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
