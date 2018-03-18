package xx.com.module_inventory;

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
import xx.com.Adapter.InventoryScanAdapter;
import xx.com.Model.Barcode_Model;
import xx.com.Model.Check_Model;
import xx.com.lib_common.Common_Model.Action.InventoryActions;


@Route(path = InventoryActions.Action_Inventory_Scan)
public class Inventory extends BaseActivity {

    Context context = Inventory.this;
    @BindView(R2.id.edt_ScanAreaNo)
    EditText edtScanAreaNo;
    @BindView(R2.id.edt_Scanbarcode)
    EditText edtScanbarcode;
    @BindView(R2.id.edt_ScanQty)
    EditText edtScanQty;
    @BindView(R2.id.txt_VoucherNo)
    TextView txtVoucherNo;
    @BindView(R2.id.txt_ItemName)
    TextView txtItemName;
    @BindView(R2.id.rv_InventoryDetail)
    RecyclerView rvInventoryDetail;


    ArrayList<Barcode_Model> barcode_models;
    InventoryScanAdapter inventoryScanAdapter;
    @Override
    protected void initViews() {
        BaseApplication.toolBarTitle = new ToolBarTitle(getString(R.string.Inventory), getString(R.string.InventoryScan));
        setContentView(R.layout.activity_inventory);
        super.initViews();
        rvInventoryDetail.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData() {
        super.initData();
        Check_Model checkModel = getIntent().getParcelableExtra("checkModel");
        txtVoucherNo.setText(checkModel.getCHECKNO());
        initAdapter();
        txtItemName.setText("长绒棉四件套");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_inventoryscan, menu);
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
        barcode_models=new ArrayList<>();
        inventoryScanAdapter = new InventoryScanAdapter();
        inventoryScanAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);

        Barcode_Model baseModel = new Barcode_Model();
        baseModel.setMaterialNo("240-179935(65-03)");
        baseModel.setMaterialDesc("长绒棉四件套");
        baseModel.setAreano("A0101");
        baseModel.setItemQty("3");
        barcode_models.add(baseModel);
        baseModel = new Barcode_Model();
        baseModel.setMaterialNo("240-179935(65-03)");
        baseModel.setMaterialDesc("长绒棉四件套");
        baseModel.setAreano("A0102");
        baseModel.setItemQty("1");
        barcode_models.add(baseModel);
        baseModel = new Barcode_Model();
        baseModel.setMaterialNo("213-072411(12-01)");
        baseModel.setMaterialDesc("凤凰凯杰尔提花毯");
        baseModel.setAreano("A0103");
        baseModel.setItemQty("1");
        barcode_models.add(baseModel);



        inventoryScanAdapter.setNewData(barcode_models);
        rvInventoryDetail.setAdapter(inventoryScanAdapter);

    }

}