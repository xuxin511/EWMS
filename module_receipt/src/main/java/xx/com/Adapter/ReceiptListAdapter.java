package xx.com.Adapter;

import android.widget.Filter;
import android.widget.Filterable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;

import xx.com.Model.InStockInfo;
import xx.com.module_receipt.R;

/**
 * Created by GHOST on 2018/3/6.
 */

public class ReceiptListAdapter extends BaseQuickAdapter<InStockInfo,BaseViewHolder> implements Filterable {
    private ArrayFilter mFilter;
    private ArrayList<InStockInfo> mUnfilteredData;

    public ReceiptListAdapter(){
        super(R.layout.iitem_recycle_receiptlist,null);
    }

    @Override
    protected void convert(BaseViewHolder helper, InStockInfo item) {
        helper.setText(R.id.txt_VoucherNo,item.getErpVoucherNo());
        helper.setText(R.id.txt_SupplierContent,"供："+item.getSupplierName());
        helper.setText(R.id.txt_CreateTime,item.getStrCreateTime());
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
                mUnfilteredData = new ArrayList<InStockInfo>(mData);
            }

            if (prefix == null || prefix.length() == 0) {
                ArrayList<InStockInfo> list = mUnfilteredData;
                results.values = list;
                results.count = list.size();
            } else {
                String prefixString = prefix.toString().toLowerCase();

                ArrayList<InStockInfo> unfilteredValues = mUnfilteredData;
                int count = unfilteredValues.size();

                ArrayList<InStockInfo> newValues = new ArrayList<InStockInfo>(count);

                for (int i = 0; i < count; i++) {
                    InStockInfo pc = unfilteredValues.get(i);
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
            mData = (ArrayList<InStockInfo>) results.values;
            if (results.count > 0) {
                notifyDataSetChanged();
            }
        }

    }
}
