package com.goit;

import com.goit.connection.Database;
import com.goit.reading.Reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {

    private static Connection conn = Database.getInstance().getConnection();

    public static void main(String[] args) {

    populateWorker();
    populateClient();
    populateProject();
    populateProject_Worker();

        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void populateProject_Worker() {
        String sqlTemplate = "INSERT INTO PROJECT_WORKER (PROJECT_ID, WORKER_ID) VALUES(?, ?)";
        Integer[] projectId = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 1, 1, 7, 7, 7, 7, 4, 5, 6};
        Integer[] workerId = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 4, 7, 8, 3, 5, 9, 10, 5, 6, 9};
        try {
            PreparedStatement queryStatement = conn.prepareStatement(sqlTemplate);
            for (int i = 0; i < projectId.length; i++) {
                queryStatement.setInt(1, projectId[i]);
                queryStatement.setInt(2, workerId[i]);
                queryStatement.addBatch();
            }
            queryStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void populateProject() {
        String sqlTemplate = "INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES (?, ?, ?)";
        Integer[] clientId = new Integer[]{1, 2, 1, 4, 3, 1, 4, 5, 4, 3};
        String[] startDate = new String[]{"2022-01-01", "2012-01-01", "2013-01-01", "2017-01-01", "2019-01-01",
                "2021-01-01", "2011-01-01", "2020-01-01", "2022-01-01", "2020-01-01"
        };
        String[] finishDate = new String[]{"2023-01-01", "2019-12-13", "2020-12-01", "2023-01-01", "2023-01-01",
                "2023-01-01", "2014-01-01", "2021-01-01", "2023-01-01", "2022-01-15"
        };
        try {
            PreparedStatement queryStatement = conn.prepareStatement(sqlTemplate);
            for (int i = 0; i < clientId.length; i++) {
                queryStatement.setInt(1, clientId[i]);
                queryStatement.setString(2, startDate[i]);
                queryStatement.setString(3, finishDate[i]);
                queryStatement.addBatch();
            }
            queryStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void populateClient() {
        String sqlTemplate = "INSERT INTO client(NAME) VALUES (?)";
        String[] name = new String[]{"Katarzyna Wasilewicz", "Agnieszka Klimowicz", "Andrzej Kowalczyk",
                "Monika Stas", "Joanna Wawryszkiewicz"
        };
        try {
            PreparedStatement queryStatement = conn.prepareStatement(sqlTemplate);
            for (int i = 0; i < name.length; i++) {
                queryStatement.setString(1, name[i]);
                queryStatement.addBatch();
            }
            queryStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void populateWorker() {
        String sqlTemplate = "INSERT INTO worker(NAME, BIRTHDAY, LEVEL, SALARY) VALUES (?, ?, ?, ?)";

        String[] name = new String[]{"Jurko Jurchenko", "Ivan Ivanenko", "Petro Petrenko", "Stepan Stepanenko", "Andriy Andrijenko",
                "Anna Radchenko", "Vasylyna Vasylenko", "Iryna Irynenko", "Vasyl Vasylenko", "Marija Marynenko"
        };
        String[] birthday = new String[]{"1980-01-02", "1985-12-25", "1990-01-02", "1971-03-03", "1980-01-02",
                "1983-01-02", "1977-01-02", "1971-03-03", "2001-01-02", "2001-01-02"
        };
        String[] level = new String[]{"Trainee", "Senior", "Junior", "Senior", "Trainee",
                "Middle", "Senior", "Trainee", "Middle", "Junior"
        };
        Integer[] salary = new Integer[]{900, 8000, 1500, 8000, 500, 2000, 6000, 700, 5500, 1680};
        try {
            PreparedStatement queryStatement = conn.prepareStatement(sqlTemplate);
            for (int i = 0; i < name.length; i++) {
                queryStatement.setString(1, name[i]);
                queryStatement.setString(2, birthday[i]);
                queryStatement.setString(3, level[i]);
                queryStatement.setInt(4, salary[i]);
                queryStatement.addBatch();
            }
            queryStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
