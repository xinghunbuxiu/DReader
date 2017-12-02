package com.duokan.reader.ui.reading;

import com.duokan.core.io.a;
import com.duokan.core.sys.t;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ui.general.web.StorePageController;

import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

class su implements Runnable {
    final /* synthetic */ File a;
    final /* synthetic */ InputStream b;
    final /* synthetic */ StorePageController c;
    final /* synthetic */ ss d;

    su(ss ssVar, File file, InputStream inputStream, StorePageController storePageController) {
        this.d = ssVar;
        this.a = file;
        this.b = inputStream;
        this.c = storePageController;
    }

    public void run() {
        a.d(this.a);
        t.a(new sv(this, DkPublic.unzip(new ZipInputStream(this.b), this.a)));
    }
}
