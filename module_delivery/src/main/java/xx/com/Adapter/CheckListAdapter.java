package xx.com.Adapter;

import android.widget.Filter;
import android.widget.Filterable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

import xx.com.Model.OutStockInfo;
import xx.com.module_delivery.R;


/**
 * Created by GHOST on 2018/3/6.
 */

public class CheckListAdapter extends BaseQuickAdapter<OutStockInfo,BaseViewHolder> implements Filterable {
    private ArrayFilter mFilter;
    private ArrayList<OutStockInfo> mUnfilteredData;

    public CheckListAdapter(){
        super(R.layout.item_recycle_checklist,null);
    }

    @Override
    protected void convert(BaseViewHolder helper, OutStockInfo item) {
        helper.setText(R.id.txt_VoucherNo,item.getVoucherNo());
        helper.setText(R.id.txt_CustomContent,"客户："+item.getCustomerName());
        helper.setText(R.id.txt_StrVoucherType,item.getStrVoucherType());
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
                mUnfilteredData = new ArrayList<OutStockInfo>(mData);
            }

            if (prefix == null || prefix.length() == 0) {
                ArrayList<OutStockInfo> list = mUnfilteredData;
                results.values = list;
                results.count = list.size();
            } else {
                String prefixString = prefix.toString().toLowerCase();

                ArrayList<OutStockInfo> unfilteredValues = mUnfilteredData;
                int count = unfilteredValues.size();

                ArrayList<OutStockInfo> newValues = new ArrayList<OutStockInfo>(count);

                for (int i = 0; i < count; i++) {
                    OutStockInfo pc = unfilteredValues.get(i);
                    if (pc != null) {
                        if(pc.getErpVoucherNo()!=null && pc.getErpVoucherNo().startsWith(prefixString.toUpperCase())){
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
            mData = (ArrayList<OutStockInfo>) results.values;
            if (results.count > 0) {
                notifyDataSetChanged();
            }
        }

    }
}
