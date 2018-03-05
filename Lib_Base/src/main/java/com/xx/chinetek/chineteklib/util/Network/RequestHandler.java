package com.xx.chinetek.chineteklib.util.Network;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.xx.chinetek.chineteklib.model.Paramater;
import com.xx.chinetek.chineteklib.util.dialog.LoadingDialog;

import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;

import static com.android.volley.DefaultRetryPolicy.DEFAULT_MAX_RETRIES;
import static com.xx.chinetek.chineteklib.base.BaseApplication.context;
import static com.xx.chinetek.chineteklib.base.BaseApplication.getRequestQueue;


/**
 * Created by GHOST on 2017/3/13.
 */

public class RequestHandler {


    private static void addRequest(
            int method, String tag,
            final Handler handler, final int what,
            final Bundle bundle, String url, final Map<String, String> params, final Map<String, String> header,
            final NetWorkRequestListener listener) {
        if (method == Request.Method.GET) {
            url = NetworkHelper.getUrlWithParams(url, params);
        }
        listener.onPreRequest();
        String para = (new org.json.JSONObject(params)).toString();
        JsonStringRequest JsonRequest = new JsonStringRequest(method, url, para, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                onVolleyResponse(response, handler, what, bundle);
                listener.onResponse();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                onVolleyErrorResponse(volleyError, listener, handler, bundle);
            }
        });
        //清除缓存
        getRequestQueue().getCache().get(url);
        getRequestQueue().getCache().remove(url);
        getRequestQueue().getCache().clear();
        // 清除请求队列中的tag标记请求
        getRequestQueue().cancelAll(tag);
        // 为当前请求添加标记
        JsonRequest.setTag(tag);
        //设置超时时间
        JsonRequest.setRetryPolicy(getRetryPolicy());
        getRequestQueue().add(JsonRequest);
    }

    private static void onVolleyErrorResponse(VolleyError volleyError, NetWorkRequestListener listener, Handler handler, Bundle bundle) {
//        if (listener.retry()) {
//            listener.onFailed();
//        }
        Message msg = handler.obtainMessage(NetworkError.NET_ERROR_CUSTOM,VolleyErrorHelper.getMessage(volleyError,context));
        msg.setData(bundle);
        handler.sendMessage(msg);
        listener.onFailed();
    }

    private static void onVolleyResponse(String response, Handler handler, int what, Bundle bundle) {
       if(!response.contains("HeaderStatus")) {
           response=response.replace("\"","");
           response = "{\"HeaderStatus\":\"E\",\"Message\":\"" + response + "\",\"MaterialDoc\":null,\"TaskNo\":null}";
       }
        Message msg = handler.obtainMessage(what, response);
        msg.setData(bundle);
        handler.sendMessage(msg);
    }

    /**
     * @param method  Request.Method.GET 或 Request.Method.POST
     * @param handler 请求结束后将结果作为Message.obj发送到该Handler
     * @param what    请求结束后发送的Message.what
     * @param bundle  不参与网络请求，仅携带参数
     *                （请求结束后，通过Message.setData设置到Message对象，数据原样返回）
     * @param url     请求地址
     * @param params  请求参数
     * @param header  请求头
     */
    public static void addRequest(
            final int method, final String tag, final Handler handler, final int what, final Bundle bundle,
            final String url, final Map<String, String> params, final Map<String, String> header) {
        addRequest(method, tag, handler, what, bundle, url, params, header, new DefaultRequestListener() {
//            @Override
//            public boolean retry() {
//                addRequest(method, tag, handler, what, bundle, url, params, header,
//                        retryTimer++ >= MAX_RETRY_TIME ? new DefaultRequestListener() : this);
//                return true;
//            }
        });
    }

    public static void addRequestWithDialog(
            final int method, final String tag, final String LoadText, Context context, final Handler handler, final int what, final Bundle bundle,
            final String url, final Map<String, String> params, final Map<String, String> header) {
        addRequest(method, tag, handler, what, bundle, url, params, header, new DefaultDialogRequestListener(context, LoadText,tag) {
//            @Override
//            public boolean retry() {
////                addRequest(method, tag, handler, what, bundle, url, params, header,
////                        retryTimer++ >= MAX_RETRY_TIME ? new DefaultDialogRequestListener(context, LoadText) : this);
////                return true;
//                return false;
//            }
        });
    }

    static RetryPolicy getRetryPolicy() {
       // RetryPolicy retryPolicy = new DefaultRetryPolicy(SOCKET_TIMEOUT, DefaultDialogRequestListener.MAX_RETRY_TIME, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        RetryPolicy retryPolicy = new DefaultRetryPolicy(Paramater.SOCKET_TIMEOUT, DEFAULT_MAX_RETRIES, 0f);
        return retryPolicy;
    }

    /**
     * 请求过程中显示加载对话框，且自动处理其生命周期
     */
    private static class DefaultDialogRequestListener extends DefaultRequestListener {

        Context context;
        SweetAlertDialog dialog;

        public DefaultDialogRequestListener(Context context, String LoadText, final String tag) {
            this.context = context;
            dialog =new LoadingDialog().getDialog(context,LoadText);
                    //new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE).setTitleText(LoadText);
            dialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sDialog) {
                    // 清除请求队列中的tag标记请求
                    getRequestQueue().cancelAll(tag);
                    dialog.dismissWithAnimation();
                }
            });
        }

        @Override
        public void onPreRequest() {
            dialog.show();
        }

        @Override
        public void onResponse() {
            dialog.dismissWithAnimation();
        }

        @Override
        public void onFailed() {
            dialog.dismissWithAnimation();
        }
    }

    private static class DefaultRequestListener implements NetWorkRequestListener {

        int retryTimer;

        static final int MAX_RETRY_TIME = -1;

        @Override
        public void onPreRequest() {

        }

        @Override
        public void onResponse() {

        }

        @Override
        public void onFailed() {

        }

//        @Override
//         public boolean retry() {
//            return false;
//        }
    }

    /**
     * 用于所有网络请求，在不同时机回调的接口
     */
    private static interface NetWorkRequestListener {
        void onPreRequest();

        void onResponse();

        void onFailed();

       // boolean retry();
    }

    // StringRequest request = new StringRequest(method, url, new Response.Listener<String>() {
//
//            @Override
//            public void onResponse(String response) {
//                onVolleyResponse(response, handler, what, bundle);
//                listener.onResponse();
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                onVolleyErrorResponse(volleyError, listener, handler, bundle);
//            }
//        })
//            {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> map = header;
//                if (map == null) {
//                    map = new HashMap<>();
//                }
//                // 在此统一添加header
//               // map.put("versionName", BuildConfig.VERSION_NAME);
//                return map;
//            }
//
////            /**
////             * Volley仅在post的情况下会回调该方法，获取form表单参数
////             * @return
////             * @throws AuthFailureError
////             */
////            @Override
////            protected Map<String, String> getParams() throws AuthFailureError {
////                return params;
////            }
    //   };

}
