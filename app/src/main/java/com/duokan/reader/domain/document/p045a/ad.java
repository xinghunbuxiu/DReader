package com.duokan.reader.domain.document.p045a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.duokan.reader.domain.document.ap;
import com.duokan.reader.domain.document.ar;

/* renamed from: com.duokan.reader.domain.document.a.ad */
class ad implements ar {
    /* renamed from: a */
    final /* synthetic */ Rect f4226a;
    /* renamed from: b */
    final /* synthetic */ float f4227b;
    /* renamed from: c */
    final /* synthetic */ C0926w f4228c;

    ad(C0926w c0926w, Rect rect, float f) {
        this.f4228c = c0926w;
        this.f4226a = rect;
        this.f4227b = f;
    }

    /* renamed from: a */
    public void mo1195a(ap apVar, Bitmap bitmap, Object obj) {
        this.f4228c.m6212a(bitmap, (Bitmap) obj, this.f4226a, this.f4227b);
        if (this.f4228c.m6203T()) {
            this.f4228c.m6200Q();
        } else {
            this.f4228c.m6202S();
        }
    }

    /* renamed from: a */
    public void mo1194a(ap apVar) {
        if (this.f4228c.m6203T()) {
            this.f4228c.m6200Q();
        } else {
            this.f4228c.m6202S();
        }
    }
}
