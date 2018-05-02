package com.duokan.reader.ui.account;

import android.graphics.Bitmap;
import com.duokan.core.sys.ag;
import com.duokan.core.ui.dv;
import com.duokan.reader.common.C0614l;

/* renamed from: com.duokan.reader.ui.account.x */
class C1272x implements ag<String> {
    /* renamed from: a */
    final /* synthetic */ String f5993a;
    /* renamed from: b */
    final /* synthetic */ C1270v f5994b;

    C1272x(C1270v c1270v, String str) {
        this.f5994b = c1270v;
        this.f5993a = str;
    }

    public /* synthetic */ void run(Object obj) {
        m9024a((String) obj);
    }

    /* renamed from: a */
    public void m9024a(String str) {
        try {
            Bitmap a = C0614l.m2797a(str, dv.m1932b(this.f5994b.getContext(), 55.0f));
            if (a != null) {
                this.f5994b.f5987i.setImageBitmap(a);
                this.f5994b.f5988j.setText(this.f5993a);
                return;
            }
            this.f5994b.f5987i.setVisibility(8);
            this.f5994b.f5988j.setVisibility(8);
        } catch (Throwable th) {
            this.f5994b.f5987i.setVisibility(8);
            this.f5994b.f5988j.setVisibility(8);
        }
    }
}
