package com.duokan.d;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.WebSession;

import java.io.File;

class g extends WebSession {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    protected void onSessionTry() {
        for (File delete : ReaderEnv.get().getCacheDirectory().listFiles(new h(this))) {
            delete.delete();
        }
    }

    protected void onSessionSucceeded() {
    }

    protected void onSessionFailed() {
    }
}
