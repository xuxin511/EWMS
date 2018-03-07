package xx.com.lib_common.Common_Model.CommUtil;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
}
