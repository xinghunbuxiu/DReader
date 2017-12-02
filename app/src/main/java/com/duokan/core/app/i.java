package com.duokan.core.app;

import android.content.res.Configuration;
import android.view.KeyEvent;

interface i extends h {
    boolean onActivityBackPressed(m mVar);

    void onActivityConfigurationChanged(m mVar, Configuration configuration);

    boolean onActivityKeyDown(m mVar, int i, KeyEvent keyEvent);

    boolean onActivityKeyUp(m mVar, int i, KeyEvent keyEvent);

    void onActivityWindowFocusChanged(m mVar, boolean z);
}
