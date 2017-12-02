package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.af;
import com.duokan.core.sys.as;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.reading.sh;

class go implements as {
    final /* synthetic */ gn a;

    go(gn gnVar) {
        this.a = gnVar;
    }

    public void a() {
        sh shVar = (sh) this.a.b.b.getContext().queryFeature(sh.class);
        if (shVar != null) {
            c G = shVar.G();
            if (TextUtils.equals(G.H(), this.a.a) && G.k()) {
                a.c().a(LogLevel.EVENT, "autopay", "confirm(allowed: %s, book: %s(%s))", "" + shVar.ag(), G.aw(), this.a.a);
                G.a(new af(Boolean.valueOf(r0)));
                G.aL();
            }
        }
    }
}
