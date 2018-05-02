package com.duokan.reader.ui.reading;

import android.net.Uri;

import java.io.File;

class sv implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ su b;

    sv(su suVar, boolean z) {
        this.b = suVar;
        this.a = z;
    }

    public void run() {
        if (this.a) {
            this.b.c.loadUrl(Uri.fromFile(new File(this.b.a, "index.html")).toString());
        } else {
            this.b.c.requestDetach();
        }
    }
}
