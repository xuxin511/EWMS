package xx.com.Adapter;

import android.widget.Filter;
import android.widget.Filterable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

import xx.com.Model.Check_Model;
import xx.com.module_inventory.R;


/**
 * Created by GHOST on 2018/3/6.
 */

public class InventoryListAdapter extends BaseQuickAdapter<Check_Model,BaseViewHolder> implements Filterable {
    private ArrayFilter mFilter;
    private ArrayList<Check_Model> mUnfilteredData;

    public InventoryListAdapter(){
        super(R.layout.item_recycle_inventorylist,null);
    }

    @Override
    protected void convert(BaseViewHolder helper, Check_Model item) {
        helper.setText(R.id.txt_VoucherNo,item.getCHECKNO());
        helper.setText(R.id.txt_Remark,item.getREMARKS());
        helper.setText(R.id.txt_Status,item.getCHECKSTATUS());
    }

    public Filter getFilter() {
        if (mFilter == null) {
            mFilter = new ArrayFilter();
        }
        return mFilter;
    }

    private class ArrayFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence prefix) {
            FilterResults results = new FilterResults();

            if (mUnfilteredData == null) {
                mUnfilteredData = new ArrayList<Check_Model>(mData);
            }

            if (prefix == null || prefix.length() == 0) {
                ArrayList<Check_Model> list = mUnfilteredData;
                results.values = list;
                results.count = list.size();
            } else {
                String prefixString = prefix.toString().toLowerCase();

                ArrayList<Check_Model> unfilteredValues = mUnfilteredData;
                int count = unfilteredValues.size();

                ArrayList<Check_Model> newValues = new ArrayList<Check_Model>(count);

                for (int i = 0; i < count; i++) {
                    Check_Model pc = unfilteredValues.get(i);
                    if (pc != null) {
                        if(pc.getCHECKNO()!=null && pc.getCHECKNO().startsWith(prefixString.toUpperCase())){
                            newValues.add(pc);
                        }
                    }
                }
                results.values = newValues;
                results.count = newValues.size();
            }

            return results;//过滤结果
        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            mData = (ArrayList<Check_Model>) results.values;
            if (results.count > 0) {
                notifyDataSetChanged();
            }
        }

    }
}
