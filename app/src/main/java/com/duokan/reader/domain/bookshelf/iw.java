package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.async.work.C0523c;
import java.io.File;

class iw implements Runnable {
    /* renamed from: a */
    final /* synthetic */ File f3369a;
    /* renamed from: b */
    final /* synthetic */ it f3370b;

    iw(it itVar, File file) {
        this.f3370b = itVar;
        this.f3369a = file;
    }

    public void run() {
        jp b = this.f3370b.f3365i;
        if (b != null) {
            C0523c b2 = b.f3405b.m8112a().m8235b(this.f3369a.getAbsolutePath());
            if (b2 != null) {
                b.f3405b.m8112a().m2370d(b2);
            }
        }
    }
}
