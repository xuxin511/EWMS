package xx.com.lib_common.Common_Model;


import static com.xx.chinetek.chineteklib.model.Paramater.IPAdress;
import static com.xx.chinetek.chineteklib.model.Paramater.Port;

/**
/**
 * Created by GHOST on 2018/2/24.
 */

public class URLModel {

    public static URLModel  GetURL() {
        return  new URLModel();
    }

    private static String  LastContent="Service.svc/";

    String  GetWCFAdress(){
        return  "http://"+IPAdress+":"+Port+"/"+LastContent;
    }

    public String UserLoginADF = GetWCFAdress()+"UserLoginADF"; //用户登录

}
