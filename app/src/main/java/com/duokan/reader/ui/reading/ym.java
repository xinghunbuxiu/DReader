package com.duokan.reader.ui.reading;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0255g;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.document.C0923m;

class ym extends yo {
    public ym(IFeature mFeature, yu yuVar) {
        super(mFeature, yuVar);
        findViewById(C0255g.reading__search_text_view__cancel).setOnClickListener(new yn(this));
        findViewById(C0255g.reading__search_text_view__bar).setPadding(dv.m1932b(getContext(), 15.0f), ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).getTheme().getHeaderPaddingTop() + dv.m1932b(getContext(), 10.0f), dv.m1932b(getContext(), 15.0f), dv.m1932b(getContext(), 10.0f));
    }

    protected void onAttachToStub() {
        C0923m l = this.a.mo1246l();
        if (l.f4355c == 0) {
            int argb = (l.f4361i || l.f4362j) ? Color.argb(Math.round(153.0f), 255, 255, 255) : -16777216;
            this.f = argb;
        } else {
            this.f = l.f4355c;
        }
        getContentView().setBackgroundDrawable(((su) getContext().queryFeature(su.class)).mo2145g() ? new ColorDrawable(-1) : l.f4353a.mutate());
        this.g = Color.argb(Math.round(51.0f), Color.red(this.f), Color.green(this.f), Color.blue(this.f));
        super.onAttachToStub();
    }
}
