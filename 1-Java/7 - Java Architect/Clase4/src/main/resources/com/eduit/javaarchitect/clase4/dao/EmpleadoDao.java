package com.eduit.javaarchitect.clase4.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmpleadoDao {
    JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
}