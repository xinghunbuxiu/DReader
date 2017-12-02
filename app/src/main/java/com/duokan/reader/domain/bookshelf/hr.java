package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.ReaderEnv.PrivatePref;

class hr implements Runnable {
    final /* synthetic */ hi a;

    hr(hi hiVar) {
        this.a = hiVar;
    }

    public void run() {
        this.a.f.setPrefLong(PrivatePref.BOOKSHELF, "last_serial_update_date", System.currentTimeMillis());
        this.a.y = null;
    }
}
