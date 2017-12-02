package com.duokan.core.ui;

import android.view.inputmethod.InputMethodManager;

import com.duokan.core.sys.s;

class ee implements s {
    final /* synthetic */ ed a;

    ee(ed edVar) {
        this.a = edVar;
    }

    public boolean idleRun() {
        if (!(this.a.a.a.getRootView() == null || this.a.a.a.getWindowToken() == null)) {
            ((InputMethodManager) this.a.a.a.getContext().getSystemService("input_method")).showSoftInput(this.a.a.a, this.a.a.b);
        }
        return false;
    }
}
