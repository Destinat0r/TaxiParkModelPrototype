package com.companic.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class JsonLoader {
    static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void loadToJson(Object[] objects, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(objects, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T[] loadFromJson(String filePath, Class<T[]> clazz) {
        T[] objects = null;
        try (Reader reader = new FileReader(filePath)) {
            objects = gson.fromJson(reader, clazz);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return objects;
    }
}
