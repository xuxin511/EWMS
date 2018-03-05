package com.xx.chinetek.chineteklib.util.function;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

/**
 * Created by GHOST on 2016/12/15.
 */

public class GsonUtil {

    private static Gson instance;

    public static Gson getGsonUtil() {
        if (instance == null) {
            instance =new GsonBuilder().registerTypeAdapter(Date.class, new NetDateTimeAdapter()).create();//.setDateFormat("yyyy-MM-dd HH:mm:ss")
        }
        return instance;
    }

    public static <T> T parseJsonToModel(String jsonData) {
        Gson gson =new GsonBuilder().registerTypeAdapter(Date.class, new NetDateTimeAdapter()).setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        T result = gson.fromJson(jsonData, new TypeToken<T>() {
        }.getType());
        return result;
    }

    public static <T> T parseJsonToModel(String jsonData,Type type) {
        Gson gson =new GsonBuilder().registerTypeAdapter(Date.class, new NetDateTimeAdapter()).setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        T result = gson.fromJson(jsonData, type);
        return result;
    }

    public static <T> String parseModelToJson(T TModel) {
        Gson gson = new Gson(); //new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
        String result = gson.toJson(TModel, new TypeToken<T>() {
        }.getType());
        return result;
    }

    public static <T> List<T> parseJsonArrayToModelList(String jsonData) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new NetDateTimeAdapter()).setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        List<T> result = gson.fromJson(jsonData, new TypeToken<List<T>>() {
        }.getType());
        return result;
    }

    public static <T> String parseModelListToJsonArray(List<T> TModelList) {
        Gson gson =new Gson();//  new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
        String result = gson.toJson(TModelList, new TypeToken<List<T>>() {
        }.getType());
        return result;
    }
}
