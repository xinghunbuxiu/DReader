package com.duokan.reader.domain.p044b;

import android.os.FileObserver;
import com.iflytek.cloud.SpeechError;
import com.umeng.analytics.pro.C2295j;

/* renamed from: com.duokan.reader.domain.b.c */
class C0782c extends FileObserver {
    /* renamed from: a */
    final /* synthetic */ C0781b f2631a;

    C0782c(C0781b c0781b, String str) {
        this.f2631a = c0781b;
        super(str);
    }

    public void onEvent(int i, String str) {
        synchronized (this.f2631a) {
            switch (i & 4095) {
                case SpeechError.TIP_ERROR_MODEL_NOT_FOUND /*64*/:
                case 128:
                case C2295j.f14327g /*512*/:
                    this.f2631a.m3676h();
                    break;
            }
        }
    }
}
