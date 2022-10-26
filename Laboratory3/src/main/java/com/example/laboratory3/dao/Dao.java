package com.example.laboratory3.dao;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Dao {
    private final DataSource tournamentDatabase;

    public Dao() throws NamingException {
        InitialContext initialContext = new InitialContext();
        this.tournamentDatabase = (DataSource) initialContext.lookup("jdbc/Tournament");
    }

    protected Connection getConnection() throws SQLException {
        return tournamentDatabase.getConnection();
    }

}
