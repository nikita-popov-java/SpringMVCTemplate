package com.nikitaee.springwebapp.dao;

import com.nikitaee.springwebapp.models.Otter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.*;
import java.sql.*;
import java.util.*;

@Component
public class OtterDAO {
    private final JdbcTemplate template;

    @Autowired
    public OtterDAO(JdbcTemplate template) {
        this.template = template;
    }

    public List<Otter> index() {
        return template.query("SELECT * FROM Otters", new BeanPropertyRowMapper<>(Otter.class));
    }

    public Otter show(String type) {
        return template.query(
                "SELECT * FROM Otters WHERE lower(type)=?",
                        new Object[]{type},
                        new BeanPropertyRowMapper<>(Otter.class)
                ).stream().findAny().orElse(null);
    }

    public void save(Otter otter) {
        template.update("INSERT INTO Otters VALUES(?, ?, ?, ?)",
                otter.getType(), otter.getAverageWeight(), otter.getAverageLength(), otter.getPhotoName());
    }

    public void update(String type, Otter otter) {
        template.update("UPDATE Otters SET averageweight=?, averagelength=?, photoname=? WHERE type=?",
                otter.getAverageWeight(), otter.getAverageLength(), otter.getPhotoName(), type);
    }

    public void delete(String type) {
        template.update("DELETE FROM Otters WHERE type=?", type);
    }
}
