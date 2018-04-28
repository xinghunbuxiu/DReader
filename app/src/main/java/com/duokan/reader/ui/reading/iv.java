package com.duokan.reader.ui.reading;

import android.view.View;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.ui.general.gb;

public class iv extends ix {
    /* renamed from: c */
    final /* synthetic */ it f10410c;
    /* renamed from: e */
    private final View f10411e;

    public iv(it itVar, C0896a c0896a, C0896a c0896a2, View view) {
        this.f10410c = itVar;
        super(itVar, c0896a);
        this.f10411e = view;
        itVar.f10408e = itVar.f10408e + 1;
    }

    /* renamed from: b */
    public View m14455b() {
        return this.f10411e;
    }

    /* renamed from: a */
    public gb mo2324a(int i) {
        if (i > 0) {
            return this.f10410c.mo2517b(m14154b(i - 1));
        }
        return this.f10410c.mo2517b(m14154b(i));
    }
}
