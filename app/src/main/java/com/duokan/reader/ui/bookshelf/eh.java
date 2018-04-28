package com.duokan.reader.ui.bookshelf;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.duokan.reader.ui.general.p052a.C1317a;

class eh implements OnFocusChangeListener {
    /* renamed from: a */
    final /* synthetic */ ec f6382a;

    eh(ec ecVar) {
        this.f6382a = ecVar;
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f6382a.f6377i = true;
            this.f6382a.f6376h.setVisibility(0);
            C1317a.m10196a(this.f6382a.f6375g, 300, null);
            C1317a.m10193a(this.f6382a.f6376h, 0.0f, 1.0f, 300, Boolean.valueOf(false), null);
            return;
        }
        this.f6382a.f6377i = false;
        this.f6382a.m9544e();
    }
}
