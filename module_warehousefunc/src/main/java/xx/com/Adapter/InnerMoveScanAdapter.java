package xx.com.Adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import xx.com.lib_common.Common_Model.Model.Stock.StockInfo;
import xx.com.module_wharehousefunc.R;


/**
 * Created by GHOST on 2018/3/6.
 */

public class InnerMoveScanAdapter extends BaseQuickAdapter<StockInfo,BaseViewHolder>{

    public InnerMoveScanAdapter(){
        super(R.layout.item_recycle_innermovescan,null);
    }

    @Override
    protected void convert(BaseViewHolder helper, StockInfo item) {
        helper.setText(R.id.txt_MaterialNo,item.getMaterialNo());
        helper.setText(R.id.txt_MaterialDesc,item.getMaterialDesc());
        helper.setText(R.id.txt_InStock,"移入库："+item.getToAreaNo());
        helper.setText(R.id.txt_OutStock,"移出库："+item.getFromAreaNo());
        helper.setText(R.id.txt_InnerMoveNum,"移库数："+item.getQty());
    }

}
