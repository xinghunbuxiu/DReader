package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.af;
import com.duokan.core.sys.as;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.reading.su;

class gy implements as {
    /* renamed from: a */
    final /* synthetic */ gx f7913a;

    gy(gx gxVar) {
        this.f7913a = gxVar;
    }

    /* renamed from: a */
    public void mo1831a() {
        su suVar = (su) this.f7913a.f7912b.f7581b.getContext().queryFeature(su.class);
        if (suVar != null) {
            C0800c G = suVar.mo1992G();
            if (TextUtils.equals(G.getId(), this.f7913a.f7911a) && G.mo1038k()) {
                WebLog.init().a(LogLevel.EVENT, "autopay", "confirm(allowed: %s, book: %s(%s))", "" + suVar.ag(), G.ay(), this.f7913a.f7911a);
                G.mo1009a(new af(Boolean.valueOf(r0)));
                G.aN();
            }
        }
    }
}
