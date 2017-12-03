package com.duokan.reader.domain.b;

import android.os.FileObserver;

class c extends FileObserver {
    final /* synthetic */ b a;

    c(b bVar, String str) {
        this.a = bVar;
        super(str);
    }

    public void onEvent(int i, String str) {
        synchronized (this.a) {
            switch (i & 4095) {
                case 64:
                case 128:
                case j.g /*512*/:
                    this.a.h();
                    break;
            }
        }
    }
}
