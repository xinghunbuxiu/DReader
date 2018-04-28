package com.duokan.reader.ui.personal;

import com.duokan.reader.ReaderEnv;

class fm implements Runnable {
    /* renamed from: a */
    final /* synthetic */ eu f8546a;

    fm(eu euVar) {
        this.f8546a = euVar;
    }

    public void run() {
        ReaderEnv.get().setMiLiveUser("");
        this.f8546a.m11781c();
    }
}
