package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import java.util.List;

class an implements as {
    /* renamed from: a */
    final /* synthetic */ List f7585a;
    /* renamed from: b */
    final /* synthetic */ am f7586b;

    an(am amVar, List list) {
        this.f7586b = amVar;
        this.f7585a = list;
    }

    /* renamed from: a */
    public void mo1831a() {
        this.f7586b.f7584b.f7582a.mHotWord.clear();
        this.f7586b.f7584b.f7582a.mHotWord.addAll(this.f7585a);
        this.f7586b.f7584b.f7582a.writeHotWords();
        this.f7586b.f7584b.f7582a.mSearchHintView.getAdapter().m8785a(false);
    }
}
