package com.example.simpleapps;


import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AssetsReader {

    private Context context;
    private Properties properties;

    public AssetsReader(Context context) {
        this.context = context;
        properties = new Properties();
    }

    public Properties getProperties(String FileName) {
        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open(FileName);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}