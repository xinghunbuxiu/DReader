package com.duokan.core.ui;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

import com.duokan.core.sys.s;

class ee implements s {
    final  ed a;

    ee(ed edVar) {
        this.a = edVar;
    }

    public boolean idleRun() {
        if (!(this.a.a.view.getRootView() == null || this.a.a.view.getWindowToken() == null)) {
            ((InputMethodManager) this.a.a.view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(this.a.a.view, this.a.a.flag);
        }
        return false;
    }
}
