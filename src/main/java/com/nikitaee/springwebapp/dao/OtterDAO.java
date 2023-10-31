package com.nikitaee.springwebapp.dao;

import com.nikitaee.springwebapp.models.Otter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.*;
import java.sql.*;
import java.util.*;

@Component
@PropertySource("classpath:/application.properties")
public class OtterDAO {
    private static Connection connection;
    private static Environment environment;
    //todo разобраться с .properties
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mvctemplate_db", USERNAME, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Autowired
    public OtterDAO(Environment environment) {
        if (OtterDAO.environment == null)
            OtterDAO.environment = environment;
    }

    public List<Otter> index() {
        List<Otter> otters = new ArrayList<>();

        try {

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM otters";
            statement.executeQuery(query);

            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                Otter otter = new Otter(
                        resultSet.getString("type"),
                        resultSet.getInt("averageWeight"),
                        resultSet.getInt("averageLength"),
                        resultSet.getString("photoName")
                );

                otters.add(otter);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return otters;
    }

    public Otter show(String type) {
//        return otters.stream()
//                .filter(o -> o.getType().equalsIgnoreCase(type))
//                .findAny()
//                .orElse(null);
        return null;
    }

    public void save(Otter otter) {
        try {
            Statement statement = connection.createStatement();
            String query = String.format("INSERT INTO otters VALUES('%s', %d, %d, '%s')",
                    otter.getType(), otter.getAverageWeight(), otter.getAverageLength(), otter.getPhotoName());
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(String type, Otter otter) {
//        Otter otterToUpdate = show(type);
//
//        if (otterToUpdate == null) {
//            throw new IllegalArgumentException(String.format("Otter with type '%s' does not exist!", type));
//        }
//
//        otterToUpdate.setType(otter.getType());
//        otterToUpdate.setAverageLength(otter.getAverageLength());
//        otterToUpdate.setAverageWeight(otter.getAverageWeight());
//        otterToUpdate.setPhotoName(otter.getPhotoName());
    }

    public void delete(String type) {
//        otters.removeIf(otter -> otter.getType().equalsIgnoreCase(type));
    }
}
