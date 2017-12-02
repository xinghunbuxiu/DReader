package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;

class bt implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ long f;
    final /* synthetic */ String g;
    final /* synthetic */ bn h;

    bt(bn bnVar, String str, String str2, String str3, String str4, String str5, long j, String str6) {
        this.h = bnVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = j;
        this.g = str6;
    }

    public void onClick(View view) {
        if (TextUtils.equals(this.a, "autopay")) {
            boolean z;
            boolean ag = this.h.b.ag();
            view.setSelected(!ag);
            sh shVar = this.h.b;
            if (ag) {
                z = false;
            } else {
                z = true;
            }
            shVar.e(z);
            this.h.j();
        }
        if (!TextUtils.isEmpty(this.b)) {
            a.c().a(LogLevel.EVENT, "reading", "click server ui(book: %s(%s), chapter: %s(%d|%s), type: %s, click: %s)", this.c, this.d, this.e, Long.valueOf(this.f), this.g, this.a, this.b);
            this.h.a(this.b);
        }
    }
}
