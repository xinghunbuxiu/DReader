package com.duokan.reader.ui.account;

import android.graphics.Bitmap;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.be;

class bf implements bt {
    /* renamed from: a */
    final /* synthetic */ String f5864a;
    /* renamed from: b */
    final /* synthetic */ bd f5865b;

    bf(bd bdVar, String str) {
        this.f5865b = bdVar;
        this.f5864a = str;
    }

    /* renamed from: a */
    public void mo1573a(Bitmap bitmap, boolean z) {
        this.f5865b.f5822c.update(this.f5864a, bitmap, this.f5865b.f5827h, new bg(this, bitmap, z));
    }

    /* renamed from: a */
    public void mo1572a() {
        be.m10286a(this.f5865b.getContext(), C0258j.sina_gen_bitmap_fail, 0).show();
        this.f5865b.f5823d.setEnabled(true);
    }
}
