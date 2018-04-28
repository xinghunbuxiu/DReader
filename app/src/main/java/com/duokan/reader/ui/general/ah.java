package com.duokan.reader.ui.general;

import android.content.Context;
import com.duokan.core.app.aa;
import com.duokan.reader.ui.C0457r;

class ah extends aa {
    /* renamed from: a */
    private final Context f6930a;
    /* renamed from: b */
    private final C0457r f6931b = new ai(this);

    public ah(Context context) {
        super(context);
        this.f6930a = context;
        addFeatureListener(new aj(this));
    }
}
