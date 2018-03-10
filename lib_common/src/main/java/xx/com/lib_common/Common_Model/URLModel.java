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
    public String GetT_InStockDetailListByHeaderIDADF = GetWCFAdress()+"GetT_InStockDetailListByHeaderIDADF"; //收货表体



    public static String TAG_UserLoginADF="UserLoginADF";
    public static final int RESULT_GET_LOGIN_INFO = 101;

    public static String TAG_GetT_InStockList = "ReceiptBillChoice_GetT_InStockList";
    public static final int RESULT_GetT_InStockList = 102;

    public static String TAG_GetT_InStockDetailListByHeaderIDADF="ReceiptionScan_GetT_InStockDetailListByHeaderIDADF";
    public static final int RESULT_Msg_GetT_InStockDetailListByHeaderIDADF=103;
    public static String TAG_GetT_PalletDetailByBarCodeADF="ReceiptionScan_GetT_PalletDetailByBarCodeADF";
    public static final int RESULT_Msg_GetT_PalletDetailByBarCode=104;
    public static String TAG_SaveT_InStockDetailADF="ReceiptionScan_SaveT_InStockDetailADF";
    public static final int RESULT_Msg_SaveT_InStockDetailADF=105;
}
