package xx.com.Adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import xx.com.Model.OutStockTaskDetailsInfo;
import xx.com.module_delivery.R;


/**
 * Created by GHOST on 2018/3/6.
 */

public class DeliveryScanAdapter extends BaseQuickAdapter<OutStockTaskDetailsInfo,BaseViewHolder>{

    public DeliveryScanAdapter(){
        super(R.layout.item_recycle_deliveryscan,null);
    }

    @Override
    protected void convert(BaseViewHolder helper, OutStockTaskDetailsInfo item) {
        helper.setText(R.id.txt_MaterialNo,item.getMaterialNo());
        helper.setText(R.id.txt_MaterialDesc,item.getMaterialDesc());
        helper.setText(R.id.txt_DeliveryNum,"发货数："+item.getRePickQty());
        helper.setText(R.id.txt_ScanNum,"扫描数："+item.getScanQty());
        helper.setText(R.id.txt_referStock,"推荐："+item.getAreaNo());
        helper.setText(R.id.txt_RowNo,"行号："+item.getRowNo());
    }

}
