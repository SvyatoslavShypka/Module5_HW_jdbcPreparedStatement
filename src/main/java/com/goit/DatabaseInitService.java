package com.goit;

import com.goit.connection.Database;
import com.goit.reading.Reader;

import java.sql.Connection;
import java.util.List;

public class DatabaseInitService {

    public static void main(String[] args) {

        Database database = Database.getInstance();
        String sqlInitFile = "./sql/init_db.sql";
        //All queries at once
        String allLines = new Reader(sqlInitFile).read();
        database.executeUpdate(allLines);

//Queries one by one
//        String[] queries = allLines.split(";");
//        for (String query : queries) {
//            Database.getInstance().executeUpdate(query);
//        }
    }
}
