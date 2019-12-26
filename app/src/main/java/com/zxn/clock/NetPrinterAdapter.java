package com.zxn.clock;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mcxtzhang.swipemenulib.SwipeMenuLayout;
import com.zcommon.lib.UIUtils;
import com.zxn.iconitemview.IconItemView;

/**
 * Created by zxn on 2019/6/22.
 */
public class NetPrinterAdapter extends BaseQuickAdapter<LocalPrinter, BaseViewHolder> implements BaseQuickAdapter.OnItemChildClickListener {
    public NetPrinterAdapter() {
        super(R.layout.item_net_printer);
        setOnItemChildClickListener(this);
    }

    @Override
    protected void convert(BaseViewHolder helper, LocalPrinter item) {
        IconItemView iiv_printer = helper.getView(R.id.iiv_printer);
        //SwipeMenuLayout sml_common = helper.getView(R.id.sml_common);
        helper.addOnClickListener(R.id.btn_delete);
        helper.addOnClickListener(R.id.iiv_printer);

        iiv_printer.getTitleView().setText(item.printerName);
        iiv_printer.setRightText(item.status+"");
        int statusTextColor = item.status == 0 ? UIUtils.getColor(R.color.red) : UIUtils.getColor(R.color.c_00bb9c);
        iiv_printer.getRightTextView().setTextColor(statusTextColor);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (view.getId() == R.id.btn_delete) {
            if (view.getParent() instanceof SwipeMenuLayout) {
                SwipeMenuLayout mSwipeMenuLayout = (SwipeMenuLayout) view.getParent();
                mSwipeMenuLayout.smoothClose();
            }
            if (null != mOnDeleteItemListener) {
                mOnDeleteItemListener.onItemDeleteClick(position);
            }
        }else  if (view.getId() == R.id.iiv_printer) {
            mOnDeleteItemListener.onItemClick(position);
        }
    }

    private OnDeleteItemListener mOnDeleteItemListener;

    public interface OnDeleteItemListener {
        void onItemDeleteClick(int position);

        void onItemClick(int position);
    }

    public void setOnDeleteItemListener(OnDeleteItemListener listener) {
        this.mOnDeleteItemListener = listener;
    }
}
