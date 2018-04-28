package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.document.C1013z;

class sz implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ sv f10960a;

    sz(sv svVar) {
        this.f10960a = svVar;
    }

    public void onClick(View view) {
        C1013z a = this.f10960a.f9661f.m15178a(this.f10960a.f9667l - 1);
        if (a == null) {
            ((ReaderFeature) this.f10960a.getContext().queryFeature(ReaderFeature.class)).prompt(this.f10960a.getString(C0258j.reading__search_next_view__search_reach_first_match));
            return;
        }
        this.f10960a.f9656a.mo2101b(this.f10960a.f9661f.m15178a(this.f10960a.f9667l).f5024a, DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT);
        this.f10960a.f9656a.mo2026a(a.f5024a, DecorDrawableStyle.SELECTION_HIGHLIGHT_RECT);
        this.f10960a.f9656a.mo2131d(a.f5024a);
        this.f10960a.f9667l = this.f10960a.f9667l - 1;
    }
}
