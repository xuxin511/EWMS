package com.xx.chinetek.chineteklib.util.function;

import android.text.TextUtils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by GHOST on 2017/6/22.
 */

public class NetDateTimeAdapter extends TypeAdapter<Date> {
    @Override
    public Date read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }
        Date result = null;
        String str = reader.nextString();
      //  str = str.replaceAll("[^0-9]", "");
        if (!TextUtils.isEmpty(str)) {
            try {
                str=str.replace("/Date(","").replace(")/","");
                String time = str.substring(0,str.length());
                result= new Date(Long.parseLong(time));
            } catch (NumberFormatException e) {
            }
        }
        return result;
    }
    @Override
    public void write(JsonWriter writer, Date value) throws IOException {
        // Nah..
    }
}
