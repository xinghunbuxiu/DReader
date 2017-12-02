package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;

import java.util.List;

class al implements as {
    final /* synthetic */ List a;
    final /* synthetic */ ak b;

    al(ak akVar, List list) {
        this.b = akVar;
        this.a = list;
    }

    public void a() {
        this.b.b.a.mHotWord.clear();
        this.b.b.a.mHotWord.addAll(this.a);
        this.b.b.a.writeHotWords();
        this.b.b.a.mSearchHintView.getAdapter().a(false);
    }
}
