package com.duokan.reader.ui.general;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import java.io.File;

/* renamed from: com.duokan.reader.ui.general.p */
class C1344p implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1343o f7547a;

    C1344p(C1343o c1343o) {
        this.f7547a = c1343o;
    }

    public void run() {
        String str;
        C1381x c = this.f7547a.f7546j;
        String a = this.f7547a.f7538b;
        Config config = Config.RGB_565;
        if (this.f7547a.f7539c == null) {
            str = "";
        } else {
            str = this.f7547a.f7539c;
        }
        Bitmap a2 = c.m11310a(a, config, str);
        if (a2 != null) {
            this.f7547a.m10944a(new File(Uri.parse(this.f7547a.f7540d).getPath()), a2, new C1346q(this));
        } else {
            this.f7547a.m10948b();
        }
    }
}
