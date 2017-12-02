package com.duokan.reader.ui.account;

import android.graphics.Bitmap;

import com.duokan.c.j;
import com.duokan.reader.ui.general.be;

class bp implements cd {
    final /* synthetic */ String a;
    final /* synthetic */ bn b;

    bp(bn bnVar, String str) {
        this.b = bnVar;
        this.a = str;
    }

    public void a(Bitmap bitmap, boolean z) {
        this.b.a.update(this.a, bitmap, this.b.k, new bq(this, bitmap, z));
    }

    public void a() {
        be.a(this.b.getContext(), j.sina_gen_bitmap_fail, 0).show();
        this.b.b.setEnabled(true);
    }
}
