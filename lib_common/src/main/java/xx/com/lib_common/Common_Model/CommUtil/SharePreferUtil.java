package xx.com.lib_common.Common_Model.CommUtil;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xx.chinetek.chineteklib.model.Paramater;

import java.lang.reflect.Type;

import xx.com.lib_common.Common_Model.CommonModel;
import xx.com.lib_common.Common_Model.Model.User.UserModel;

/**
 * Created by GHOST on 2018/3/5.
 */

public class SharePreferUtil {

    public static void ReadUserShare(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("User", Context.MODE_PRIVATE);
        if(sharedPreferences!=null) {
            Gson gson = new Gson();
            Type type = new TypeToken<UserModel>(){}.getType();
            CommonModel.userInfo= gson.fromJson(sharedPreferences.getString("User", ""), type);
        }
    }

    public static void SetUserShare(Context context, UserModel user){
        SharedPreferences sharedPreferences=context.getSharedPreferences("User", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=sharedPreferences.edit();
        Gson gson=new Gson();
        Type type = new TypeToken<UserModel>() {}.getType();
        edit.putString("User",gson.toJson(user,type));
        edit.commit();
        CommonModel.userInfo=user;
    }

    /**
     * 配置文件
     * @param context
     */
    public static void ReadShare(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("Setting", Context.MODE_PRIVATE);
        if(sharedPreferences!=null) {
            Paramater.IPAdress=sharedPreferences.getString("IPAdress", "192.168.1.1");
            Paramater.Port=sharedPreferences.getInt("Port", 80);
            Paramater.SOCKET_TIMEOUT=sharedPreferences.getInt("TimeOut", 30000);
            CommonModel.IsInputQty=sharedPreferences.getBoolean("IsInputQty",true);
        }
    }

    public static void SetShare(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("Setting", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=sharedPreferences.edit();
        edit.putString("IPAdress",Paramater.IPAdress);
        edit.putInt("Port",Paramater.Port);
        edit.putInt("TimeOut",Paramater.SOCKET_TIMEOUT);
        edit.putBoolean("IsInputQty", CommonModel.IsInputQty);
        edit.apply();
    }

}
