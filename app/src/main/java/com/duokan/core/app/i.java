package com.duokan.core.app;

import android.content.res.Configuration;
import android.view.KeyEvent;

interface i extends IController {
    boolean onActivityBackPressed(BaseActivity baseActivityVar);

    void onActivityConfigurationChanged(BaseActivity baseActivityVar, Configuration configuration);

    boolean onActivityKeyDown(BaseActivity baseActivityVar, int i, KeyEvent keyEvent);

    boolean onActivityKeyUp(BaseActivity baseActivityVar, int i, KeyEvent keyEvent);

    void onActivityWindowFocusChanged(BaseActivity baseActivityVar, boolean z);
}
