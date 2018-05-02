package com.duokan.d;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.WebSession;

import java.io.File;

class g extends WebSession {
    final /* synthetic */ MyWebSession a;

    g(MyWebSession fVar) {
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
