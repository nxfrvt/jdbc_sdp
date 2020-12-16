package com.example.sdp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class run {
    public static void main(String[] args) throws SQLException {

        Query.query("INSERT INTO PUBLIC.ITEMS(\"id_item\", \"name_item\") values (4, 'Zatruty miecz')");

        ResultSet rs = Query.select("SELECT * FROM PUBLIC.ITEMS");
        while(rs.next()) {
            int id = rs.getInt("id_item");
            String name = rs.getString("name_item");
            System.out.println(id + ". " + name);
        }

        Query.query("DELETE FROM PUBLIC.ITEMS WHERE \"id_item\" = 4");

    }

}
