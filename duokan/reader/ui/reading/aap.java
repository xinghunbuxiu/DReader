package com.duokan.reader.ui.reading;

import com.duokan.c.j;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.is;
import com.duokan.reader.ui.general.be;

class aap implements is {
    final /* synthetic */ Runnable a;
    final /* synthetic */ aaj b;

    aap(aaj com_duokan_reader_ui_reading_aaj, Runnable runnable) {
        this.b = com_duokan_reader_ui_reading_aaj;
        this.a = runnable;
    }

    public void a(c cVar) {
        this.a.run();
    }

    public void a(String str) {
        be.a(this.b.d.getContext(), j.general__shared__network_error, 1).show();
    }
}
