package com.duokan.reader.ui.reading;

import com.duokan.core.sys.IdleHandlerListener;
import com.duokan.reader.ui.general.ReaderUi;

class yt implements IdleHandlerListener {
    /* renamed from: a */
    final /* synthetic */ yo f11217a;

    yt(yo yoVar) {
        this.f11217a = yoVar;
    }

    public boolean idleRun() {
        ReaderUi.m10162a(this.f11217a.getContext(), this.f11217a.f11203c);
        return false;
    }
}
