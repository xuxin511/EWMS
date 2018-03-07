package xx.com.Adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import xx.com.ewms.R;
import xx.com.Model.FuncModel;

/**
 * Created by GHOST on 2018/2/19.
 */

public class FuncRecyclerAdapter extends BaseQuickAdapter<FuncModel,BaseViewHolder> {

    public FuncRecyclerAdapter(List data ){
        super(R.layout.item_recycler_func, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FuncModel item) {
        helper.setText(R.id.tv_Title, item.getTitleName());
        helper.setImageResource(R.id.iv_Pic, item.getImgResID());
    }
}

