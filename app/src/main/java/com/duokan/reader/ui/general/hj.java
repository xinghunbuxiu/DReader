package com.duokan.reader.ui.general;

import android.view.View;

import com.duokan.core.app.e;
import com.duokan.core.app.y;

abstract class hj extends e {
    private final e a;
    final /* synthetic */ hd b;

    public hj(hd hdVar, y yVar, e eVar) {
        this.b = hdVar;
        super(yVar);
        this.a = eVar;
    }

    public final e a() {
        return this.a;
    }

    public final View b() {
        return this.a.getContentView();
    }
}
