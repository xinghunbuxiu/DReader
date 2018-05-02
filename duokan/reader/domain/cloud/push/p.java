package com.duokan.reader.domain.cloud.push;

import com.duokan.core.ui.j;

class p implements s {
    final /* synthetic */ j a;
    final /* synthetic */ s b;
    final /* synthetic */ b c;

    p(b bVar, j jVar, s sVar) {
        this.c = bVar;
        this.a = jVar;
        this.b = sVar;
    }

    public void a(boolean z) {
        if (this.a != null) {
            this.a.dismiss();
        }
        if (this.b != null) {
            this.b.a(z);
        }
        if (z) {
            this.c.d("black_list");
        } else {
            this.c.c("black_list");
        }
    }

    public void a(String str) {
        if (this.a != null) {
            this.a.dismiss();
        }
        if (this.b != null) {
            this.b.a(str);
        }
    }
}
