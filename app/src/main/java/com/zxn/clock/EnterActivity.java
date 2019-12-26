package com.zxn.clock;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zxn.divider.LinearDecoration;
import com.zxn.divider.RvItemDecoration;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EnterActivity extends AppCompatActivity {

    @BindView(R.id.rv_common)
    RecyclerView rvCommon;
    private NetPrinterAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        ButterKnife.bind(this);

        rvCommon.setHasFixedSize(true);
        rvCommon.setLayoutManager(new LinearLayoutManager(this));
        rvCommon.addItemDecoration(new RvItemDecoration.Builder(this)
                .bgColor(R.color.divline_color)
                .widthDp(1f)
                .setOrientation(LinearDecoration.VERTICAL)
                .createLinear());
        mAdapter = new NetPrinterAdapter();
        rvCommon.setAdapter(mAdapter);
        mAdapter.setOnDeleteItemListener(new NetPrinterAdapter.OnDeleteItemListener() {
            @Override
            public void onItemDeleteClick(int position) {
                //long id = mAdapter.getData().get(position).getId();
                //GreenDB.getInstance(mContext).deletePrinterByKey(id);
                //mAdapter.getData().remove(position);
                //mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onItemClick(int position) {
                //NetPrinterDetailsActivity.jumpTo(NetPrinterActivity.this, mAdapter.getItem(position));
            }
        });
        mAdapter.setEmptyView(LayoutInflater.from(this).inflate(R.layout.layout_net_printer_empty, null));
//        OperatorInfo operator = XjlApp.app.mGreenDB.queryLatestOperator();
//        List<LocalPrinter> printers = GreenDB.getInstance(this).loadAllPrinter(operator.getOperatorId());
//        mAdapter.setNewData(printers);

    }

    @OnClick(R.id.tv_add_clock)
    public void onViewClicked() {
        MainActivity.jumpTo(this);
    }
}
