package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.ReaderEnv.PrivatePref;

class hl implements Runnable {
    /* renamed from: a */
    final /* synthetic */ hc f3309a;

    hl(hc hcVar) {
        this.f3309a = hcVar;
    }

    public void run() {
        this.f3309a.f2742f.setPrefLong(PrivatePref.BOOKSHELF, "last_serial_update_date", System.currentTimeMillis());
        this.f3309a.f2760y = null;
    }
}
