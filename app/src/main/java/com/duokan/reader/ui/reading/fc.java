package com.duokan.reader.ui.reading;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.duokan.reader.domain.p044b.C0794o;

class fc implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C0794o f10133a;
    /* renamed from: b */
    final /* synthetic */ ex f10134b;

    fc(ex exVar, C0794o c0794o) {
        this.f10134b = exVar;
        this.f10133a = c0794o;
    }

    public void onClick(View view) {
        if (this.f10133a.m3704e()) {
            if (this.f10134b.f10116a) {
                this.f10134b.m14031a("FONT_URI_SYSTEM");
            } else {
                this.f10134b.m14036b("FONT_URI_SYSTEM");
            }
        } else if (this.f10134b.f10116a) {
            this.f10134b.m14031a(Uri.fromFile(this.f10133a.m3703d()).toString());
        } else {
            this.f10134b.m14036b(Uri.fromFile(this.f10133a.m3703d()).toString());
        }
        this.f10134b.mo2312b();
    }
}
