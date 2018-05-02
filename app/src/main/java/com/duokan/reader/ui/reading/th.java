package com.duokan.reader.ui.reading;

import com.duokan.core.io.FileUtil;
import com.duokan.core.sys.UThread;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ui.general.web.StorePageController;
import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

class th implements Runnable {
    /* renamed from: a */
    final /* synthetic */ File f10975a;
    /* renamed from: b */
    final /* synthetic */ InputStream f10976b;
    /* renamed from: c */
    final /* synthetic */ StorePageController f10977c;
    /* renamed from: d */
    final /* synthetic */ tf f10978d;

    th(tf tfVar, File file, InputStream inputStream, StorePageController storePageController) {
        this.f10978d = tfVar;
        this.f10975a = file;
        this.f10976b = inputStream;
        this.f10977c = storePageController;
    }

    public void run() {
        FileUtil.deleteFile(this.f10975a);
        UThread.runOnThread(new ti(this, DkPublic.unzip(new ZipInputStream(this.f10976b), this.f10975a)));
    }
}
