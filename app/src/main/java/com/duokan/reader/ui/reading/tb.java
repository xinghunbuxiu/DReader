package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.document.C1013z;

class tb implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ sv f10964a;

    tb(sv svVar) {
        this.f10964a = svVar;
    }

    public void onClick(View view) {
        C1013z a = this.f10964a.f9661f.m15178a(this.f10964a.f9667l + 1);
        if (a != null) {
            this.f10964a.f9656a.mo2101b(this.f10964a.f9661f.m15178a(this.f10964a.f9667l).f5024a, DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT);
            this.f10964a.f9656a.mo2026a(a.f5024a, DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT);
            this.f10964a.f9656a.mo2131d(a.f5024a);
            this.f10964a.f9667l = this.f10964a.f9667l + 1;
        } else if (!this.f10964a.f9661f.m15184b()) {
            ((ReaderFeature) this.f10964a.getContext().queryFeature(ReaderFeature.class)).prompt(this.f10964a.getString(C0258j.reading__search_next_view__search_reach_last_match));
        }
    }
}
