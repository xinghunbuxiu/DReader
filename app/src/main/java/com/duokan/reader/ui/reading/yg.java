package com.duokan.reader.ui.reading;

import com.duokan.core.sys.IdleStatus;
import com.duokan.reader.ui.general.ReaderUi;

class yg implements IdleStatus {
    final /* synthetic */ yb a;

    yg(yb ybVar) {
        this.a = ybVar;
    }

    public boolean idleRun() {
        ReaderUi.a(this.a.getContext(), this.a.c);
        return false;
    }
}
