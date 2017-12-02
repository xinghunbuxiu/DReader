package com.duokan.reader.ui.reading;

import android.content.Context;

import com.duokan.core.app.x;
import com.duokan.reader.domain.bookshelf.ej;

class ij extends fo {
    private final sh a = ((sh) x.a(getContext()).queryFeature(sh.class));
    private int b = 0;
    private long c = System.currentTimeMillis();
    private long d = 0;
    private int e = 0;

    public ij(Context context) {
        super(context);
        if (this.a.G() instanceof ej) {
            this.b = (((ej) this.a.G()).be() + 1) / 2;
        }
        setAdapter(new im());
    }

    public int u() {
        return this.e;
    }
}
