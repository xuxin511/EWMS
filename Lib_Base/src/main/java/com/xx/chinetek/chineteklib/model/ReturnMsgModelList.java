package com.xx.chinetek.chineteklib.model;

import java.util.ArrayList;

/**
 * Created by GHOST on 2016/12/15.
 */

public class ReturnMsgModelList<T> {

    public String HeaderStatus;

    public String Message;

    public ArrayList<T> ModelJson;

    public String getHeaderStatus() {
        return HeaderStatus;
    }

    public void setHeaderStatus(String headerStatus) {
        HeaderStatus = headerStatus;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public ArrayList<T> getModelJson() {
        return ModelJson;
    }

    public void setModelJson(ArrayList<T> modelJson) {
        ModelJson = modelJson;
    }
}
