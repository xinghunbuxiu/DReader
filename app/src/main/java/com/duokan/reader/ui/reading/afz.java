package com.duokan.reader.ui.reading;

import android.view.View;
import com.duokan.core.app.IFeature;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;

class afz extends py {
    public afz(IFeature mFeature) {
        super(mFeature);
        findViewById(C0255g.reading__reading_menu_bottom_view__read_mode).setOnClickListener(new aga(this));
    }

    /* renamed from: a */
    protected View mo2256a() {
        return inflate(C0256h.reading__reading_menu_view_txt, null);
    }
}
