package com.duokan.reader.ui.reading;

import android.net.Uri;
import java.io.File;

class ti implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f10979a;
    /* renamed from: b */
    final /* synthetic */ th f10980b;

    ti(th thVar, boolean z) {
        this.f10980b = thVar;
        this.f10979a = z;
    }

    public void run() {
        if (this.f10979a) {
            this.f10980b.f10977c.loadUrl(Uri.fromFile(new File(this.f10980b.f10975a, "index.html")).toString());
        } else {
            this.f10980b.f10977c.requestDetach();
        }
    }
}
