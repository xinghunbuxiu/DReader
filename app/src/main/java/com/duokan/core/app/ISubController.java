package com.duokan.core.app;

import android.content.res.Configuration;
import android.view.KeyEvent;

interface ISubController extends ISubControllerParent {
    boolean onActivityBackPressed(BaseActivity mActivity);

    void onActivityConfigurationChanged(BaseActivity mActivity, Configuration configuration);

    boolean onActivityKeyDown(BaseActivity mActivity, int keyCode, KeyEvent keyEvent);

    boolean onActivityKeyUp(BaseActivity mActivity, int keyCode, KeyEvent keyEvent);

    void onActivityWindowFocusChanged(BaseActivity mActivity, boolean z);
}
