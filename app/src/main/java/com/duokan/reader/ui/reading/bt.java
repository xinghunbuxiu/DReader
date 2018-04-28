package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.UmengManager;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

class bt implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ String f9889a;
    /* renamed from: b */
    final /* synthetic */ String f9890b;
    /* renamed from: c */
    final /* synthetic */ String f9891c;
    /* renamed from: d */
    final /* synthetic */ String f9892d;
    /* renamed from: e */
    final /* synthetic */ String f9893e;
    /* renamed from: f */
    final /* synthetic */ long f9894f;
    /* renamed from: g */
    final /* synthetic */ String f9895g;
    /* renamed from: h */
    final /* synthetic */ TextView f9896h;
    /* renamed from: i */
    final /* synthetic */ String f9897i;
    /* renamed from: j */
    final /* synthetic */ String f9898j;
    /* renamed from: k */
    final /* synthetic */ bn f9899k;

    bt(bn bnVar, String str, String str2, String str3, String str4, String str5, long j, String str6, TextView textView, String str7, String str8) {
        this.f9899k = bnVar;
        this.f9889a = str;
        this.f9890b = str2;
        this.f9891c = str3;
        this.f9892d = str4;
        this.f9893e = str5;
        this.f9894f = j;
        this.f9895g = str6;
        this.f9896h = textView;
        this.f9897i = str7;
        this.f9898j = str8;
    }

    public void onClick(View view) {
        if (TextUtils.equals(this.f9889a, "autopay")) {
            boolean z;
            boolean ag = this.f9899k.b.ag();
            view.setSelected(!ag);
            su suVar = this.f9899k.b;
            if (ag) {
                z = false;
            } else {
                z = true;
            }
            suVar.mo2138e(z);
            this.f9899k.m13838j();
        }
        if (!TextUtils.isEmpty(this.f9890b)) {
            C0328a.m757c().m749a(LogLevel.EVENT, "reading", "click server ui(book: %s(%s), chapter: %s(%d|%s), type: %s, click: %s)", this.f9891c, this.f9892d, this.f9893e, Long.valueOf(this.f9894f), this.f9895g, this.f9889a, this.f9890b);
            if (TextUtils.equals(this.f9889a, "button")) {
                UmengManager.get().onEvent("READING_PURCHASE_PAGE", "PURCHASE");
            } else {
                UmengManager.get().onEvent("READING_PURCHASE_PAGE", String.valueOf(this.f9896h.getText()));
            }
            if (!TextUtils.isEmpty(this.f9897i)) {
                this.f9899k.m13818a(HttpGet.METHOD_NAME, this.f9897i);
            }
            if (!TextUtils.isEmpty(this.f9898j)) {
                this.f9899k.m13818a(HttpPost.METHOD_NAME, this.f9898j);
            }
            this.f9899k.m13817a(this.f9890b);
        }
    }
}
