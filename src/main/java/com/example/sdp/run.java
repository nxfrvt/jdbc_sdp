package com.example.sdp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;

public class run {
    public static void main(String[] args) throws SQLException {

//        Query.query("INSERT INTO PUBLIC.ITEMS(\"id_item\", \"name_item\") values (4, 'Zatruty miecz')")
        Query.query("DELETE FROM PUBLIC.NAMES");

        Query.insert(10000);
        Instant start = Instant.now();
        ResultSet rs = Query.select("SELECT * FROM PUBLIC.NAMES");
        while(rs.next()) {
            int id = rs.getInt("id_name");
            String name = rs.getString("name");
            System.out.println(id + ". " + name);
        }
        Instant end = Instant.now();
        System.out.println("Execution time for SELECT: " +
                (Duration.between(start, end)).toMillis() + "ms");


    }

}
