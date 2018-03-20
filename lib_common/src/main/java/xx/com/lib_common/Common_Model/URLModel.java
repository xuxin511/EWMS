package xx.com.lib_common.Common_Model;


import static com.xx.chinetek.chineteklib.model.Paramater.IPAdress;
import static com.xx.chinetek.chineteklib.model.Paramater.Port;

/**
/**
 * Created by GHOST on 2018/2/24.
 */

public class URLModel {

    public static URLModel GetURL() {
        return new URLModel();
    }

    private static String LastContent = "api/pda/";

    String GetWCFAdress() {
        return "http://" + IPAdress + ":" + Port + "/" + LastContent;
    }

    public String UserLoginADF = GetWCFAdress() + "UserLoginADF"; //用户登录
    public String GetT_InStockListADF = GetWCFAdress() + "GetT_InStockListADF"; //收货表头
    public String GetT_InStockDetailListByHeaderIDADF = GetWCFAdress() + "GetT_InStockDetailListByHeaderIDADF"; //收货表体
    public String GetT_PalletDetailByBarCodeADF = GetWCFAdress() + "GetT_PalletDetailByBarCodeADF"; //扫描条码
    public String GetAreaModelADF = GetWCFAdress() + "GetAreaModelADF"; //扫描库位
    public String SaveT_InStockDetailADF = GetWCFAdress() + "SaveT_InStockDetailADF"; //保存收货信息


    public String GetT_OutTaskListADF = GetWCFAdress() + "GetT_OutTaskListADF"; //下架单据
    public String GetT_OutTaskDetailListByHeaderIDADF = GetWCFAdress() + "GetT_OutTaskDetailListByHeaderIDADF"; //下架单据明细
    public String GetStockModelADF = GetWCFAdress() + "GetStockModelADF"; //下架扫描条码
    public String SaveT_OutStockTaskDetailADF = GetWCFAdress() + "SaveT_OutStockTaskDetailADF"; //保存下架信息


    public String GetT_OutStockReviewListADF = GetWCFAdress() + "GetT_OutStockReviewListADF"; //复核单据
    public String GetT_OutStockReviewDetailListByHeaderIDADF = GetWCFAdress() + "GetT_OutStockReviewDetailListByHeaderIDADF"; //复核单据明细
    public String ScanOutStockReviewByBarCodeADF=GetWCFAdress()+"ScanOutStockReviewByBarCodeADF";//复核条码扫描
    public String SaveT_OutStockReviewDetailADF=GetWCFAdress()+"SaveT_OutStockReviewDetailADF";//复核条码扫描

    public String SaveMoveStockToOutADF = GetWCFAdress() + "SaveMoveStockToOutADF"; //移库提交


    public static String TAG_UserLoginADF = "UserLoginADF";
    public static final int RESULT_GET_LOGIN_INFO = 101;

    public static String TAG_GetT_InStockList = "ReceiptBillChoice_GetT_InStockList";
    public static final int RESULT_GetT_InStockList = 102;

    public static String TAG_GetT_InStockDetailListByHeaderIDADF = "ReceiptionScan_GetT_InStockDetailListByHeaderIDADF";
    public static final int RESULT_GetT_InStockDetailListByHeaderIDADF = 103;
    public static String TAG_GetT_PalletDetailByBarCodeADF = "ReceiptionScan_GetT_PalletDetailByBarCodeADF";
    public static final int RESULT_GetT_PalletDetailByBarCode = 104;
    public static String TAG_SaveT_InStockDetailADF = "ReceiptionScan_SaveT_InStockDetailADF";
    public static final int RESULT_SaveT_InStockDetailADF = 105;
    public static String TAG_GetAreaModelADF = "ReceiptionScan_GetAreaModelADF";
    public static final int RESULT_GetAreaModelADF = 106;


    public static String TAG_GetT_OutTaskListADF = "DeleveryBillChoice_GetT_OutTaskListADF";
    public static final int RESULT_GetT_OutTaskListADF = 107;
    public static String TAG_GetT_OutTaskDetailListByHeaderIDADF = "DeleveryScan_GetT_OutTaskDetailListByHeaderIDADF";
    public static final int RESULT_GetT_OutTaskDetailListByHeaderIDADF = 108;
    public static String TAG_GetStockModelADF = "DeleveryScan_GetStockModelADF";
    public static final int RESULT_GetStockModelADF = 109;
    public static String TAG_SaveT_OutStockTaskDetailADF = "DeleveryScan_SaveT_OutStockTaskDetailADF";
    public static final int RESULT_SaveT_OutStockTaskDetailADF = 110;

    public static String TAG_GetT_OutStockReviewListADF = "CheckBillChoice_GetT_OutStockReviewListADF";
    public static final int RESULT_GetT_OutStockReviewListADF = 111;
    public static String TAG_GetT_OutStockReviewDetailListByHeaderIDADF = "CheckScan_GetT_OutStockReviewDetailListByHeaderIDADF";
    public static final int RESULT_GetT_OutStockReviewDetailListByHeaderIDADF = 112;
    public static String TAG_ScanOutStockReviewByBarCodeADF = "CheckScan_ScanOutStockReviewByBarCodeADF";
    public static final int RESULT_ScanOutStockReviewByBarCodeADF = 113;
    public static String TAG_SaveT_OutStockReviewDetailADF = "CheckScan_SaveT_OutStockReviewDetailADF";
    public static final int RESULT_SaveT_OutStockReviewDetailADF = 114;

    public static String TAG_SaveMoveStockToOutADF = "InnerMove_SaveMoveStockToOutADF";
    public static final int RESULT_SaveMoveStockToOutADF = 114;
}
