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

    private static String  LastContent="api/pda/";

    String  GetWCFAdress(){
        return  "http://"+IPAdress+":"+Port+"/"+LastContent;
    }

    public String UserLoginADF = GetWCFAdress()+"UserLoginADF"; //用户登录
    public String GetT_InStockListADF = GetWCFAdress()+"GetT_InStockListADF"; //收货表头


    public static String TAG_UserLoginADF="UserLoginADF";
    public static final int RESULT_GET_LOGIN_INFO = 101;

    public static String TAG_GetT_InStockList = "ReceiptBillChoice_GetT_InStockList";
    public static final int RESULT_GetT_InStockList = 102;
}
