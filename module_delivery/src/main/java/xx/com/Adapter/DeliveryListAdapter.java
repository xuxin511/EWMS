package xx.com.Adapter;

import android.widget.Filter;
import android.widget.Filterable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;


import xx.com.Model.OutStockTaskInfo;
import xx.com.module_delivery.R;


/**
 * Created by GHOST on 2018/3/6.
 */

public class DeliveryListAdapter extends BaseQuickAdapter<OutStockTaskInfo,BaseViewHolder> implements Filterable {
    private ArrayFilter mFilter;
    private ArrayList<OutStockTaskInfo> mUnfilteredData;

    public DeliveryListAdapter(){
        super(R.layout.item_recycle_deliverylist,null);
    }

    @Override
    protected void convert(BaseViewHolder helper, OutStockTaskInfo item) {
        helper.setText(R.id.txt_TaskNo,item.getTaskNo()==null?"":item.getTaskNo());
        helper.setText(R.id.txt_StrVoucherType,item.getStrVoucherType());
        helper.setText(R.id.txt_CreateTime,item.getStrCreateTime());
        helper.setText(R.id.txt_PcikName,item.getPickUserName());
        helper.setText(R.id.txt_VouUser,item.getVouUser());
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
                mUnfilteredData = new ArrayList<OutStockTaskInfo>(mData);
            }

            if (prefix == null || prefix.length() == 0) {
                ArrayList<OutStockTaskInfo> list = mUnfilteredData;
                results.values = list;
                results.count = list.size();
            } else {
                String prefixString = prefix.toString().toLowerCase();

                ArrayList<OutStockTaskInfo> unfilteredValues = mUnfilteredData;
                int count = unfilteredValues.size();

                ArrayList<OutStockTaskInfo> newValues = new ArrayList<OutStockTaskInfo>(count);

                for (int i = 0; i < count; i++) {
                    OutStockTaskInfo pc = unfilteredValues.get(i);
                    if (pc != null) {
                        if(pc.getTaskNo()!=null && pc.getTaskNo().startsWith(prefixString.toUpperCase())){
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
        protected void publishResults(CharSequence constraint,FilterResults results) {
            mData = (ArrayList<OutStockTaskInfo>) results.values;
                notifyDataSetChanged();
        }

    }
}
