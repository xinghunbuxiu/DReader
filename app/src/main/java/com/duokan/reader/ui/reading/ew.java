package com.duokan.reader.ui.reading;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.p044b.C0794o;

class ew implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C0794o f10114a;
    /* renamed from: b */
    final /* synthetic */ er f10115b;

    ew(er erVar, C0794o c0794o) {
        this.f10115b = erVar;
        this.f10114a = c0794o;
    }

    public void onClick(View view) {
        if (this.f10114a.m3704e()) {
            if (this.f10115b.f10098a) {
                this.f10115b.m14016a("FONT_URI_SYSTEM");
            } else {
                this.f10115b.m14021b("FONT_URI_SYSTEM");
            }
        } else if (this.f10115b.f10098a) {
            this.f10115b.m14016a(Uri.fromFile(this.f10114a.m3703d()).toString());
        } else {
            this.f10115b.m14021b(Uri.fromFile(this.f10114a.m3703d()).toString());
        }
        this.f10115b.mo2312b();
    }
}
