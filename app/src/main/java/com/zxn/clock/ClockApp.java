package com.zxn.clock;

import android.app.Application;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

import com.zcommon.lib.UIUtils;

/**
 * Created by zxn on 2019/12/25.
 */
public class ClockApp extends Application {

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        UIUtils.init(this);
    }
}
