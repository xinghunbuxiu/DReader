package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.cloud.DkUserReadBookManager.ReadBook;
import com.duokan.reader.domain.cloud.ev;

class ho implements ev {
    final /* synthetic */ int a;
    final /* synthetic */ hl b;

    ho(hl hlVar, int i) {
        this.b = hlVar;
        this.a = i;
    }

    public void a(ReadBook[] readBookArr, boolean z, boolean z2) {
        this.b.t = !z;
        this.b.a(new hp(this, readBookArr, z));
    }

    public void a(String str) {
        this.b.t = false;
        this.b.getAdapter().m();
    }
}
