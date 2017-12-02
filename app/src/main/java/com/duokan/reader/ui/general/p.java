package com.duokan.reader.ui.general;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;

import java.io.File;

class p implements Runnable {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    public void run() {
        String str;
        x c = this.a.j;
        String a = this.a.b;
        Config config = Config.RGB_565;
        if (this.a.c == null) {
            str = "";
        } else {
            str = this.a.c;
        }
        Bitmap a2 = c.a(a, config, str);
        if (a2 != null) {
            this.a.a(new File(Uri.parse(this.a.d).getPath()), a2, new q(this));
        } else {
            this.a.b();
        }
    }
}
