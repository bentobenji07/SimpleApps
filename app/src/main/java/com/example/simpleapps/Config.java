package com.example.simpleapps;


import android.content.Context;

import java.util.Properties;

public class Config {

    private Integer databaseVersion;
    private String databaseName;




    public Config(Context context) {
        AssetsReader assetsReader = new AssetsReader(context);
        Properties properties = assetsReader.getProperties("config.properties");

        setDatabaseName(properties.getProperty("DATABASE"));
        setDatabaseVersion(Integer.parseInt(properties.getProperty("DATABASE_VERSION")));

    }


    public Integer getDatabaseVersion() {
        return databaseVersion;
    }

    public void setDatabaseVersion(Integer databaseVersion) {
        this.databaseVersion = databaseVersion;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }


}
