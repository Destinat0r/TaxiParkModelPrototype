package com.companic.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

/**
 * Reads and writes array of objects from/to <b>JSON</b>
 */
public class JsonLoader {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     *Writes array of objects to Json
     * @param objects
     * @param filePath
     */
    public static void writeToJson(Object[] objects, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            GSON.toJson(objects, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read objects from Json to array
     * @param filePath
     * @param clazz class of object to read. Has to be in form YourObject[].class
     * @return array of objects of pointed type
     */
    public static <T> T[] readFromJson(String filePath, Class<T[]> clazz) {
        T[] objects = null;
        try (Reader reader = new FileReader(filePath)) {
            objects = GSON.fromJson(reader, clazz);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return objects;
    }
}
