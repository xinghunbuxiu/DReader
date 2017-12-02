package com.duokan.reader.ui.general;

import android.graphics.Bitmap;

import java.io.File;

class r implements Runnable {
    final /* synthetic */ File a;
    final /* synthetic */ Bitmap b;
    final /* synthetic */ o c;

    r(o oVar, File file, Bitmap bitmap) {
        this.c = oVar;
        this.a = file;
        this.b = bitmap;
    }

    public void run() {
        this.c.a(this.a, this.b, null);
    }
}
