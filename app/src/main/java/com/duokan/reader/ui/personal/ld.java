package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.duokan.p024c.C0256h;
import com.duokan.reader.ui.bookshelf.hv;

class ld extends ne {
    /* renamed from: a */
    final /* synthetic */ lc f8871a;

    ld(lc lcVar, Context context, hv hvVar) {
        this.f8871a = lcVar;
        super(context, hvVar);
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        if (this.f8871a.getNormalAdapter().mo506c() == 0) {
            return this.f8871a.getNormalAdapter().mo482a(view, viewGroup);
        }
        return LayoutInflater.from(this.f8871a.getContext()).inflate(C0256h.personal__search_empty_view, viewGroup, false);
    }
}
