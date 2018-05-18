package com.duokan.reader.ui.reading;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.duokan.p023b.C0247i;
import com.duokan.p030d.DownloadUtil;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.ad.C0748e;
import com.duokan.reader.domain.ad.C0750g;
import com.duokan.reader.domain.ad.C0767x;

/* renamed from: com.duokan.reader.ui.reading.e */
class C1452e implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ View f10056a;
    /* renamed from: b */
    final /* synthetic */ C0748e f10057b;
    /* renamed from: c */
    final /* synthetic */ Context f10058c;
    /* renamed from: d */
    final /* synthetic */ TextView f10059d;
    /* renamed from: e */
    final /* synthetic */ C1446a f10060e;

    C1452e(C1446a c1446a, View view, C0748e c0748e, Context context, TextView textView) {
        this.f10060e = c1446a;
        this.f10056a = view;
        this.f10057b = c0748e;
        this.f10058c = context;
        this.f10059d = textView;
    }

    public void onClick(View view) {
        if (C1446a.m12752d(this.f10056a)) {
            try {
                C0750g.m3561a().m3588b(this.f10057b);
                synchronized (this.f10060e) {
                    C1446a.m12743a(this.f10060e);
                }
                if (C0767x.m3611a(this.f10058c, this.f10057b.f2533r)) {
                    if (this.f10059d != null) {
                        this.f10059d.setText(C0247i.general__shared__installed);
                    }
                } else if (!this.f10060e.f9257f.m3532a(this.f10057b.f2533r)) {
                    this.f10060e.f9257f.m3529a(this.f10057b, new C1454f(this));
                    this.f10060e.f9257f.m3528a(this.f10057b);
                    synchronized (this.f10060e) {
                        C1446a.m12749c(this.f10060e);
                    }
                    if (!(this.f10059d == null || this.f10057b.f2523h != C0748e.f2517b || C0767x.m3611a(this.f10058c, this.f10057b.f2533r))) {
                        this.f10059d.setText(C0247i.general__shared__downloading);
                    }
                    if (!ReaderEnv.get().onMiui()) {
                        DownloadUtil.init(this.f10058c).downloadAPK(this.f10057b.f2531p, this.f10058c.getResources().getString(C0247i.general__shared__ad_download) + this.f10057b.f2534s, this.f10057b.f2533r);
                    }
                } else if (!(this.f10059d == null || this.f10057b.f2523h != C0748e.f2517b || C0767x.m3611a(this.f10058c, this.f10057b.f2533r))) {
                    this.f10059d.setText(C0247i.general__shared__downloading);
                }
                if (ReaderEnv.get().onMiui()) {
                    this.f10060e.f9258g.m3609a(this.f10057b);
                }
            } catch (Throwable th) {
            }
        }
    }
}
