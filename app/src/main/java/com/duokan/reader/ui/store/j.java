package com.duokan.reader.ui.store;

import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.store.a;

import java.util.LinkedList;

public class j extends e {
    private final String a;
    private final LinkedList b = new LinkedList();
    private final l c;

    public j(y yVar, String str) {
        super(yVar);
        this.a = str;
        this.c = new l(this, getContext());
        setContentView(this.c);
        UmengManager.get().onEvent("V2_STORE_BOOK_DETAILPAGE_ACTION", "RevisionHistory");
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            a(0);
        }
    }

    private void a(int i) {
        a.a().a(this.a, i, 10, new k(this));
    }
}
