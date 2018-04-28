package com.duokan.reader.ui.reading;

import android.content.Context;
import com.duokan.core.app.AppContext;
import com.duokan.reader.domain.bookshelf.ee;

class it extends fs {
    /* renamed from: a */
    private final su f10404a = ((su) AppContext.getAppContext(getContext()).queryFeature(su.class));
    /* renamed from: b */
    private int f10405b = 0;
    /* renamed from: c */
    private long f10406c = System.currentTimeMillis();
    /* renamed from: d */
    private long f10407d = 0;
    /* renamed from: e */
    private int f10408e = 0;

    public it(Context context) {
        super(context);
        if (this.f10404a.mo1992G() instanceof ee) {
            this.f10405b = (((ee) this.f10404a.mo1992G()).bg() + 1) / 2;
        }
        setAdapter(new iw());
    }

    /* renamed from: u */
    public int m14452u() {
        return this.f10408e;
    }
}
