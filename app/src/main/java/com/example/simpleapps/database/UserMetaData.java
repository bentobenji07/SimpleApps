package com.example.simpleapps.database;



public class UserMetaData {

    private Integer sqliteId;
    private String email;
    private String name;


    public Integer getSqliteId() {
        return sqliteId;
    }

    public void setSqliteId(Integer sqliteId) {
        this.sqliteId = sqliteId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
