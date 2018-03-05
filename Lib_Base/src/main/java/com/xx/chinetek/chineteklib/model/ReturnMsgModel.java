package com.xx.chinetek.chineteklib.model;

/**
 * Created by GHOST on 2016/12/15.
 */

public class ReturnMsgModel<T> {

    private String HeaderStatus;

    private String Message;

    private T ModelJson;

    private String MaterialDoc;

    private String TaskNo;

    public String getTaskNo() {
        return TaskNo;
    }

    public void setTaskNo(String taskNo) {
        TaskNo = taskNo;
    }

    public String getMaterialDoc() {
        return MaterialDoc;
    }

    public void setMaterialDoc(String materialDoc) {
        MaterialDoc = materialDoc;
    }

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

    public T getModelJson() {
        return ModelJson;
    }

    public void setModelJson(T modelJson) {
        ModelJson = modelJson;
    }
}
