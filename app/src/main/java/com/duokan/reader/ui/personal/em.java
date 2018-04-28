package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.duokan.p024c.C0256h;

class em extends ao {
    /* renamed from: a */
    final /* synthetic */ ek f8510a;

    em(ek ekVar, Context context) {
        this.f8510a = ekVar;
        super(context);
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        if (this.f8510a.f8501a.mo506c() == 0) {
            return this.f8510a.f8501a.mo482a(view, viewGroup);
        }
        return LayoutInflater.from(this.f8510a.getContext()).inflate(C0256h.personal__search_empty_view, viewGroup, false);
    }
}
