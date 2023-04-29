package com.goit;

import com.goit.connection.Database;
import com.goit.reading.Reader;

public class DatabasePopulateService {

    public static void main(String[] args) {

    Database database = Database.getInstance();

    String sqlPopulateFile = "./sql/populate_db.sql";
    //All queries at once
    String allLines = new Reader(sqlPopulateFile).read();
    database.executeUpdate(allLines);
    }
}
