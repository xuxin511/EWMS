package xx.com.Adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import xx.com.Model.Barcode_Model;
import xx.com.module_inventory.R;


/**
 * Created by GHOST on 2018/3/6.
 */

public class InventoryScanAdapter extends BaseQuickAdapter<Barcode_Model,BaseViewHolder>{

    public InventoryScanAdapter(){
        super(R.layout.item_recycle_inventoryscan,null);
    }

    @Override
    protected void convert(BaseViewHolder helper, Barcode_Model item) {
        helper.setText(R.id.txt_MaterialNo,item.getMaterialNo());
        helper.setText(R.id.txt_MaterialDesc,item.getMaterialDesc());
        helper.setText(R.id.txt_invnetoryNum,"盘点数："+item.getItemQty());
        helper.setText(R.id.txt_InventoryAreaNo,"库位："+item.getAreano());

    }

}
