package com.duokan.reader.ui.reading;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.duokan.b.i;
import com.duokan.d.a;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.ad.g;
import com.duokan.reader.domain.ad.x;

class e implements OnClickListener {
    final /* synthetic */ View a;
    final /* synthetic */ com.duokan.reader.domain.ad.e b;
    final /* synthetic */ Context c;
    final /* synthetic */ TextView d;
    final /* synthetic */ a e;

    e(a aVar, View view, com.duokan.reader.domain.ad.e eVar, Context context, TextView textView) {
        this.e = aVar;
        this.a = view;
        this.b = eVar;
        this.c = context;
        this.d = textView;
    }

    public void onClick(View view) {
        if (a.d(this.a)) {
            try {
                g.a().b(this.b);
                synchronized (this.e) {
                    a.a(this.e);
                }
                if (x.a(this.c, this.b.r)) {
                    if (this.d != null) {
                        this.d.setText(i.general__shared__installed);
                    }
                } else if (!this.e.f.a(this.b.r)) {
                    this.e.f.a(this.b, new f(this));
                    this.e.f.a(this.b);
                    synchronized (this.e) {
                        a.c(this.e);
                    }
                    if (!(this.d == null || this.b.h != com.duokan.reader.domain.ad.e.b || x.a(this.c, this.b.r))) {
                        this.d.setText(i.general__shared__downloading);
                    }
                    if (!ReaderEnv.get().onMiui()) {
                        a.a(this.c).a(this.b.p, this.c.getResources().getString(i.general__shared__ad_download) + this.b.s, this.b.r);
                    }
                } else if (!(this.d == null || this.b.h != com.duokan.reader.domain.ad.e.b || x.a(this.c, this.b.r))) {
                    this.d.setText(i.general__shared__downloading);
                }
                if (ReaderEnv.get().onMiui()) {
                    this.e.g.a(this.b);
                }
            } catch (Throwable th) {
            }
        }
    }
}
