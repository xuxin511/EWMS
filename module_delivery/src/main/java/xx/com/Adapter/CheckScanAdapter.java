package xx.com.Adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import xx.com.Model.OutStockDetailInfo;
import xx.com.module_delivery.R;


/**
 * Created by GHOST on 2018/3/6.
 */

public class CheckScanAdapter extends BaseQuickAdapter<OutStockDetailInfo,BaseViewHolder>{

    public CheckScanAdapter(){
        super(R.layout.item_recycle_checkscan,null);
    }

    @Override
    protected void convert(BaseViewHolder helper, OutStockDetailInfo item) {
        helper.setText(R.id.txt_MaterialNo,item.getMaterialNo());
        helper.setText(R.id.txt_MaterialDesc,item.getMaterialDesc());
        helper.setText(R.id.txt_CheckNum,"复核数："+item.getRemainQty());
        helper.setText(R.id.txt_ScanNum,"扫描数："+item.getScanQty());
        helper.setText(R.id.txt_RowNo,"行号："+item.getRowNo());
    }

}
