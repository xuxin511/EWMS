package xx.com.module_receipt;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xx.chinetek.chineteklib.base.BaseActivity;
import com.xx.chinetek.chineteklib.base.BaseApplication;
import com.xx.chinetek.chineteklib.base.ToolBarTitle;

import xx.com.Model.InStockInfo;
import xx.com.lib_common.Common_Model.Action.ReceiptActions;

@Route(path= ReceiptActions.Action_Receipt_Scan)
public class ReceiptScan extends BaseActivity {

    @Override
    protected void initViews() {
        BaseApplication.toolBarTitle = new ToolBarTitle(getString(R.string.receipt_title), getString(R.string.receiptscan_title_sub));
        setContentView(R.layout.activity_receipt_scan);
        super.initViews();
    }

    @Override
    protected void initData() {
        super.initData();
        InStockInfo inStockInfo=getIntent().getParcelableExtra("inStockInfo");
        String s=inStockInfo.getVoucherNo();
    }
}
