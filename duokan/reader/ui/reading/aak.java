package com.duokan.reader.ui.reading;

import android.text.TextUtils;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;

import java.util.LinkedList;
import java.util.List;

class aak implements ag {
    final /* synthetic */ ag a;
    final /* synthetic */ boolean b;
    final /* synthetic */ aaj c;

    aak(aaj com_duokan_reader_ui_reading_aaj, ag agVar, boolean z) {
        this.c = com_duokan_reader_ui_reading_aaj;
        this.a = agVar;
        this.b = z;
    }

    public void a(as asVar) {
        if (asVar == null) {
            this.a.a(null);
        } else if (this.c.b(asVar)) {
            this.a.a(asVar);
        } else {
            ak l = asVar.l();
            asVar.H();
            if (this.c.d.h.b() || !this.c.b(l)) {
                this.a.a(null);
                return;
            }
            long[] a = this.c.a(l);
            if (a.length < 1) {
                this.a.a(null);
            } else if (((aaq) this.c.d.c).c(a[0])) {
                this.c.d.a(a[0], new aal(this, l), new aam(this));
            } else {
                List linkedList = new LinkedList();
                for (long a2 : a) {
                    CharSequence a3 = this.c.a(a2);
                    if (!TextUtils.isEmpty(a3)) {
                        linkedList.add(a3);
                    }
                }
                this.c.d.b(linkedList, new aan(this, l));
            }
        }
    }
}
