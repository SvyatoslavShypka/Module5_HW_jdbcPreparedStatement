package com.goit.queries;

import com.goit.connection.Database;
import com.goit.reading.Reader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public static Connection conn = Database.getInstance().getConnection();

    public static void main(String[] args) {

        List<PrintProjectPrices> resultProjectPrices = DatabaseQueryService.printProjectPrices();
        for (PrintProjectPrices x: resultProjectPrices
             ) {
            System.out.println(x);
        }
        System.out.println();

        List<LongestProject> resultLongestProject = DatabaseQueryService.findLongestProject();
        for (LongestProject x: resultLongestProject
             ) {
            System.out.println(x);
        }
        System.out.println();

        List<MaxProjectCountClient> resultMaxProjectCountClient = DatabaseQueryService.findMaxProjectsClient();
        for (MaxProjectCountClient x: resultMaxProjectCountClient
             ) {
            System.out.println(x);
        }
        System.out.println();

        List<MaxSalaryWorker> resultMaxSalaryWorker = DatabaseQueryService.findMaxSalaryWorker();
        for (MaxSalaryWorker x: resultMaxSalaryWorker
             ) {
            System.out.println(x);
        }
        System.out.println();

        List<YoungestEldestWorkers> resultYoungestEldestWorkers = DatabaseQueryService.findYoungestEldestWorkers();
        for (YoungestEldestWorkers x: resultYoungestEldestWorkers
             ) {
            System.out.println(x);
        }

        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<LongestProject> findLongestProject() {
        List<LongestProject> result = new ArrayList<>();
        String sqlInitFile = "./sql/find_longest_project.sql";
        String allLines = new Reader(sqlInitFile).read();
        try {
            PreparedStatement queryStatement = conn.prepareStatement(allLines);
            ResultSet resultSet = queryStatement.executeQuery();
            while (resultSet.next()) {
                result.add(new LongestProject(resultSet.getString("name"), resultSet.getInt("MONTH_COUNT")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();
        String sqlInitFile = "./sql/find_max_projects_client.sql";
        String allLines = new Reader(sqlInitFile).read();
        try {
            PreparedStatement queryStatement = conn.prepareStatement(allLines);
            ResultSet resultSet = queryStatement.executeQuery();
            while (resultSet.next()) {
                result.add(new MaxProjectCountClient(resultSet.getString("client.NAME"), resultSet.getInt("PROJECT_COUNT")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> result = new ArrayList<>();
        String sqlInitFile = "./sql/find_max_salary_worker.sql";
        String allLines = new Reader(sqlInitFile).read();
        try {
            PreparedStatement queryStatement = conn.prepareStatement(allLines);
            ResultSet resultSet = queryStatement.executeQuery();
            while (resultSet.next()) {
                result.add(new MaxSalaryWorker(resultSet.getString("name"), resultSet.getInt("salary")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        List<YoungestEldestWorkers> result = new ArrayList<>();
        String sqlInitFile = "./sql/find_youngest_eldest_workers.sql";
        String allLines = new Reader(sqlInitFile).read();
        try {
            PreparedStatement queryStatement = conn.prepareStatement(allLines);
            ResultSet resultSet = queryStatement.executeQuery();
            while (resultSet.next()) {
                result.add(new YoungestEldestWorkers(resultSet.getString("type"),
                        resultSet.getString("name"),
                        LocalDate.parse(resultSet.getString("birthday"))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static List<PrintProjectPrices> printProjectPrices() {
        List<PrintProjectPrices> result = new ArrayList<>();
        String sqlInitFile = "./sql/print_project_prices.sql";
        String allLines = new Reader(sqlInitFile).read();
        try {
            PreparedStatement queryStatement = conn.prepareStatement(allLines);
            ResultSet resultSet = queryStatement.executeQuery();
            while (resultSet.next()) {
                result.add(new PrintProjectPrices(
                        resultSet.getString("name"),
                        resultSet.getInt("price")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
