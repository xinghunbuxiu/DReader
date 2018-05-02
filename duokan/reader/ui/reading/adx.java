package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.av;

import java.util.Arrays;
import java.util.ListIterator;

class adx implements ag {
    final /* synthetic */ aej a;
    final /* synthetic */ ag b;
    final /* synthetic */ Document_a c;
    final /* synthetic */ adm d;

    adx(adm com_duokan_reader_ui_reading_adm, aej com_duokan_reader_ui_reading_aej, ag agVar, Document_a aVar) {
        this.d = com_duokan_reader_ui_reading_adm;
        this.a = com_duokan_reader_ui_reading_aej;
        this.b = agVar;
        this.c = aVar;
    }

    public void a(as asVar) {
        if (asVar == null) {
            this.a.a = null;
            this.b.a(this.a);
            return;
        }
        ak l = asVar.l();
        this.a.b.addAll(Arrays.asList(this.d.a(asVar)));
        asVar.H();
        if (!(this.c instanceof av) || this.d.a.d(l) || this.a.b.isEmpty() || !((ael) this.a.b.getFirst()).b.h().c(this.c) || this.d.a == null) {
            this.a.a = this.d.a.e(l) ? null : this.d.b.f(l);
            this.d.a(this.a);
            if (this.c instanceof av) {
                ListIterator listIterator = this.a.b.listIterator();
                while (listIterator.hasNext() && !((ael) listIterator.next()).b.h().c(this.c)) {
                    listIterator.remove();
                }
            }
            this.b.a(this.a);
            return;
        }
        this.d.a.a(this.d.b.g(l), true, new ady(this, l));
    }
}
