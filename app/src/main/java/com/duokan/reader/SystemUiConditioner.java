package com.duokan.reader;

import com.duokan.core.sys.af;

public interface SystemUiConditioner {
    void chooseNavigationBarColor(af<Integer> afVar);

    void chooseNavigationBarMode(af<SystemUiMode> afVar);

    void chooseStatusBarStyle(af<Boolean> afVar);
}
