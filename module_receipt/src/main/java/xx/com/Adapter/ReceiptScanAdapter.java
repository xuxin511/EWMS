package xx.com.Adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import xx.com.Model.InStockDetailInfo;
import xx.com.module_receipt.R;

/**
 * Created by GHOST on 2018/3/6.
 */

public class ReceiptScanAdapter extends BaseQuickAdapter<InStockDetailInfo,BaseViewHolder>{

    public ReceiptScanAdapter(){
        super(R.layout.iitem_recycle_receiptscan,null);
    }

    @Override
    protected void convert(BaseViewHolder helper, InStockDetailInfo item) {
        helper.setText(R.id.txt_MaterialNo,item.getMaterialNo());
        helper.setText(R.id.txt_MaterialDesc,item.getMaterialDesc());
        helper.setText(R.id.txt_ReceiptNum,"收货数："+item.getRemainQty());
        helper.setText(R.id.txt_ScanNum,"扫描数："+item.getScanQty());
        helper.setText(R.id.txt_RowNo,"行号："+item.getRowNo());
    }

}
