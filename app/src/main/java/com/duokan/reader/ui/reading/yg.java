package com.duokan.reader.ui.reading;

import com.duokan.core.sys.s;
import com.duokan.reader.ui.general.ReaderUi;

class yg implements s {
    final /* synthetic */ yb a;

    yg(yb ybVar) {
        this.a = ybVar;
    }

    public boolean idleRun() {
        ReaderUi.a(this.a.getContext(), this.a.c);
        return false;
    }
}
