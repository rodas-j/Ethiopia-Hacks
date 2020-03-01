package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Constituencies {
    String name;

    public Constituencies(){
        this.name = "Hello";
    }

    public Constituencies(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class ElectionDatabase {
    static Connection connection;
    static Statement statement;

    ElectionDatabase() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/election", "root", "1234");
        statement = connection.createStatement();
    }


}
