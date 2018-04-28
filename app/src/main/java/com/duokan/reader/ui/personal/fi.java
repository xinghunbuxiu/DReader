package com.duokan.reader.ui.personal;

import android.content.Context;
import com.duokan.core.app.ag;
import com.duokan.core.app.ah;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkPublic;
import com.duokan.reader.ui.general.FileTransferPrompter;

class fi implements ah {
    /* renamed from: a */
    final /* synthetic */ eu f8541a;

    fi(eu euVar) {
        this.f8541a = euVar;
    }

    /* renamed from: a */
    public void mo1562a(ag agVar) {
        Context a = this.f8541a.f8523a;
        String string = this.f8541a.f8523a.getString(C0258j.store__mi_live__need_data);
        String string2 = this.f8541a.f8523a.getString(C0258j.store__mi_live__data_usage);
        Object[] objArr = new Object[1];
        objArr[0] = 23607064 <= 0 ? "" : DkPublic.formatBytes(23607064);
        FileTransferPrompter.m9977a(a, 23607064, string, String.format(string2, objArr), new fj(this));
    }

    /* renamed from: b */
    public void mo1567b(ag agVar) {
    }

    /* renamed from: c */
    public void mo1565c(ag agVar) {
    }
}
