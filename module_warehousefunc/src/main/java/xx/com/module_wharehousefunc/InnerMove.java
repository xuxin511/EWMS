package xx.com.module_wharehousefunc;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xx.chinetek.chineteklib.base.BaseActivity;
import com.xx.chinetek.chineteklib.base.BaseApplication;
import com.xx.chinetek.chineteklib.base.ToolBarTitle;
import com.xx.chinetek.chineteklib.util.function.DoubleClickCheck;

import java.util.ArrayList;

import butterknife.BindView;
import xx.com.Adapter.InnerMoveScanAdapter;
import xx.com.lib_common.Common_Model.Action.MainActions;
import xx.com.lib_common.Common_Model.Model.Stock.StockInfo;


@Route(path = MainActions.Action_Main_InnerMove)
public class InnerMove extends BaseActivity {

    Context context = InnerMove.this;

    InnerMoveScanAdapter innerMoveScanAdapter;
    ArrayList<StockInfo> stockInfos;

    @BindView(R2.id.edt_ScanAreaNo)
    EditText edtScanAreaNo;
    @BindView(R2.id.edt_Scanbarcode)
    EditText edtScanbarcode;
    @BindView(R2.id.edt_ScanQty)
    EditText edtScanQty;
    @BindView(R2.id.txt_ItemName)
    TextView txtItemName;
    @BindView(R2.id.rv_InnerMoveDetail)
    RecyclerView rvInnerMoveDetail;

    @Override
    protected void initViews() {
        BaseApplication.toolBarTitle = new ToolBarTitle(getString(R.string.innermove), getString(R.string.innermoveScan));
        setContentView(R.layout.activity_inner_move);
        super.initViews();
        rvInnerMoveDetail.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData() {
        super.initData();
        txtItemName.setText("长绒棉四件套");
        initAdapter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_innermovescan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_Upload) {
            if (DoubleClickCheck.isFastDoubleClick(context)) {
                return false;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void initAdapter() {
        stockInfos=new ArrayList<>();
        innerMoveScanAdapter = new InnerMoveScanAdapter();
        innerMoveScanAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        StockInfo stockInfo=new StockInfo();
        stockInfo.setMaterialNo("240-179935(65-03)");
        stockInfo.setMaterialDesc("长绒棉四件套");
        stockInfo.setFromAreaNo("A0102");
        stockInfo.setToAreaNo("A0101");
        stockInfo.setQty(1f);
        stockInfos.add(stockInfo);
        stockInfo=new StockInfo();
        stockInfo.setMaterialNo("213-072411(12-01)");
        stockInfo.setMaterialDesc("凤凰凯杰尔提花毯");
        stockInfo.setFromAreaNo("A0103");
        stockInfo.setToAreaNo("A0101");
        stockInfo.setQty(2f);
        stockInfos.add(stockInfo);


        innerMoveScanAdapter.setNewData(stockInfos);
        rvInnerMoveDetail.setAdapter(innerMoveScanAdapter);

    }
}