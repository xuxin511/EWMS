package xx.com.module_delivery;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xx.chinetek.chineteklib.base.BaseActivity;
import com.xx.chinetek.chineteklib.base.BaseApplication;
import com.xx.chinetek.chineteklib.base.ToolBarTitle;
import com.xx.chinetek.chineteklib.util.function.DoubleClickCheck;

import java.util.ArrayList;

import butterknife.BindView;
import xx.com.Adapter.CheckScanAdapter;
import xx.com.Model.OutStockDetailInfo;
import xx.com.Model.OutStockInfo;
import xx.com.lib_common.Common_Model.Action.DeliveryActions;

@Route(path = DeliveryActions.Action_Check_Scan)
public class CheckScan extends BaseActivity {

    Context context=CheckScan.this;

    @BindView(R2.id.edt_Scanbarcode)
    EditText edtScanbarcode;
    @BindView(R2.id.edt_ScanQty)
    EditText edtScanQty;
    @BindView(R2.id.txt_CustomName)
    TextView txtCustomName;
    @BindView(R2.id.txt_VoucherNo)
    TextView txtVoucherNo;
    @BindView(R2.id.txt_ItemName)
    TextView txtItemName;
    @BindView(R2.id.rv_CheckDetail)
    RecyclerView rvCheckDetail;

    CheckScanAdapter checkScanAdapter;
    ArrayList<OutStockDetailInfo> outStockDetailInfos;

    @Override
    protected void initViews() {
        BaseApplication.toolBarTitle = new ToolBarTitle(getString(R.string.check), getString(R.string.checkScan));
        setContentView(R.layout.activity_check_scan);
        super.initViews();
        rvCheckDetail.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData() {
        super.initData();
        OutStockInfo outStockInfo = getIntent().getParcelableExtra("outStockInfo");
        txtVoucherNo.setText(outStockInfo.getVoucherNo());
        txtCustomName.setText(outStockInfo.getCustomerName());
        txtItemName.setText("长绒棉四件套");
        initAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_checkscan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_Weigh) {
            if (DoubleClickCheck.isFastDoubleClick(context)) {
                return false;
            }
            ARouter.getInstance().build(DeliveryActions.Action_Check_Weigh)
                    .navigation();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initAdapter() {
        outStockDetailInfos=new ArrayList<>();
        checkScanAdapter = new CheckScanAdapter();
        checkScanAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);

        OutStockDetailInfo outStockTaskDetailsInfo = new OutStockDetailInfo();
        outStockTaskDetailsInfo.setMaterialNo("240-179935(65-03)");
        outStockTaskDetailsInfo.setMaterialDesc("长绒棉四件套");
        outStockTaskDetailsInfo.setRemainQty(3f);
        outStockTaskDetailsInfo.setScanQty(0f);
        outStockTaskDetailsInfo.setRowNo("1");
        outStockDetailInfos.add(outStockTaskDetailsInfo);

        checkScanAdapter.setNewData(outStockDetailInfos);
        rvCheckDetail.setAdapter(checkScanAdapter);

    }
}
