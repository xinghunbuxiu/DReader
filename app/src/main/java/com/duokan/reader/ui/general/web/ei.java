package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class ei implements as {
    /* renamed from: a */
    final /* synthetic */ int f7772a;
    /* renamed from: b */
    final /* synthetic */ String f7773b;
    /* renamed from: c */
    final /* synthetic */ ci f7774c;

    ei(ci ciVar, int i, String str) {
        this.f7774c = ciVar;
        this.f7772a = i;
        this.f7773b = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        if (this.f7774c.f7581b.mJsPageStatusCode != this.f7772a) {
            this.f7774c.f7581b.mJsPageStatusCode = this.f7772a;
            if (this.f7774c.f7581b.mJsPageStatusCode < 0) {
                this.f7774c.f7581b.webPageError(true);
            }
        }
        if (this.f7774c.f7581b.mUpdateMirrorRunnable != null) {
            this.f7774c.f7581b.mUpdateMirrorRunnable.run();
        }
        this.f7774c.f7581b.onPageCreated(this.f7772a, this.f7773b);
    }
}
