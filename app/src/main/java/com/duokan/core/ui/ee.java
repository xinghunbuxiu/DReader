package com.duokan.core.ui;

import android.view.inputmethod.InputMethodManager;
import com.duokan.core.sys.IdleHandlerListener;

class ee implements IdleHandlerListener {
    /* renamed from: a */
    final /* synthetic */ ed f1215a;

    ee(ed edVar) {
        this.f1215a = edVar;
    }

    public boolean idleRun() {
        if (!(this.f1215a.f1214a.f1212a.getRootView() == null || this.f1215a.f1214a.f1212a.getWindowToken() == null)) {
            ((InputMethodManager) this.f1215a.f1214a.f1212a.getContext().getSystemService("input_method")).showSoftInput(this.f1215a.f1214a.f1212a, this.f1215a.f1214a.f1213b);
        }
        return false;
    }
}
