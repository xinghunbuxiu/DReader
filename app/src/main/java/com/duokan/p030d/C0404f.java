package com.duokan.p030d;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.WebSession;
import java.io.File;

/* renamed from: com.duokan.d.f */
class C0404f extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C0403e f1358a;

    C0404f(C0403e c0403e) {
        this.f1358a = c0403e;
    }

    protected void onSessionTry() {
        for (File delete : ReaderEnv.get().getCacheDirectory().listFiles(new C0405g(this))) {
            delete.delete();
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
