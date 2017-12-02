package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

class dl implements as {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ cg c;

    dl(cg cgVar, int i, String str) {
        this.c = cgVar;
        this.a = i;
        this.b = str;
    }

    public void a() {
        if (this.c.b.mJsPageStatusCode != this.a) {
            this.c.b.mJsPageStatusCode = this.a;
            if (this.c.b.mJsPageStatusCode < 0) {
                this.c.b.webPageError(true);
            }
        }
        this.c.b.onPageCreated(this.a, this.b);
    }
}
