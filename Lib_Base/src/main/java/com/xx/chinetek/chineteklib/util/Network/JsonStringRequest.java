package com.xx.chinetek.chineteklib.util.Network;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * Created by GHOST on 2016/12/14.
 */

public class JsonStringRequest extends JsonRequest<String> {

    public JsonStringRequest(int method, String url, String requestBody, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, requestBody, listener, errorListener);
    }

    public JsonStringRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(0, url, (String) null, listener, errorListener);
    }

    public JsonStringRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, (String) null, listener, errorListener);
    }

    public JsonStringRequest(int method, String url, JSONObject jsonRequest, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, jsonRequest == null ? null : jsonRequest.toString(), listener, errorListener);
    }

    public JsonStringRequest(String url, JSONObject jsonRequest, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        this(jsonRequest == null ? 0 : 1, url, jsonRequest, listener, errorListener);
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        try {
            String je = new String(response.data, HttpHeaderParser.parseCharset(response.headers, "utf-8"));
            return Response.success(JSONTokener(je), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException var3) {
            return Response.error(new ParseError(var3));
        }
    }

//    @Override
//    public Map<String, String> getHeaders() throws AuthFailureError {
//        HashMap<String, String> headers = new HashMap<String, String>();
//        headers.put("Content-Type", "application/json");
//        return headers;
//    }

    /*
        调用WCF时，返回值包含"," 及转义字符，需要移除
         */
    public String JSONTokener(String in) {
        // consume an optional byte order mark (BOM) if it exists
        if (in != null && in.endsWith("\"")) {
            in = in.substring(0, in.length() - 1);
        }
        if (in != null && in.startsWith("\"")) {
            in = in.substring(1);
        }
        in = in.replace("\\\\n", "\n");
        in = in.replace("\\r", "");
        return in.replace("\\", "");
    }
}
