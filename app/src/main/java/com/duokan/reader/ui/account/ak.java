package com.duokan.reader.ui.account;

import android.graphics.Bitmap;

import com.duokan.core.sys.ag;
import com.duokan.core.ui.dv;
import com.duokan.reader.common.l;

class ak implements ag {
    final /* synthetic */ String a;
    final /* synthetic */ ai b;

    ak(ai aiVar, String str) {
        this.b = aiVar;
        this.a = str;
    }

    public void a(String str) {
        try {
            Bitmap a = l.a(str, dv.b(this.b.getContext(), 55.0f));
            if (a != null) {
                this.b.i.setImageBitmap(a);
                this.b.j.setText(this.a);
                return;
            }
            this.b.i.setVisibility(8);
            this.b.j.setVisibility(8);
        } catch (Throwable th) {
            this.b.i.setVisibility(8);
            this.b.j.setVisibility(8);
        }
    }
}
