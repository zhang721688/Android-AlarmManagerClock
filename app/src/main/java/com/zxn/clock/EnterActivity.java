package com.zxn.clock;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EnterActivity extends AppCompatActivity {

    @BindView(R.id.rv_common)
    RecyclerView rvCommon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_add_clock)
    public void onViewClicked() {
        MainActivity.jumpTo(this);
    }
}
