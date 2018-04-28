package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.general.ak;
import com.duokan.reader.ui.general.an;

class er implements an {
    /* renamed from: a */
    final /* synthetic */ ak f6401a;
    /* renamed from: b */
    final /* synthetic */ C0800c f6402b;
    /* renamed from: c */
    final /* synthetic */ eq f6403c;

    er(eq eqVar, ak akVar, C0800c c0800c) {
        this.f6403c = eqVar;
        this.f6401a = akVar;
        this.f6402b = c0800c;
    }

    /* renamed from: a */
    public void mo1689a(int i) {
        this.f6401a.close();
        if (i == 0) {
            ai.m3980a().m3886a(this.f6402b, true);
            if (this.f6403c.f6399a != null) {
                this.f6403c.f6399a.m9573a();
            }
            if (this.f6401a.isChecked(0)) {
                this.f6403c.m9560a();
            }
        }
    }
}
