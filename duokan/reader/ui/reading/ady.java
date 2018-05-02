package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.as;

import java.util.Arrays;

class ady implements ag {
    final /* synthetic */ ak a;
    final /* synthetic */ adx b;

    ady(adx com_duokan_reader_ui_reading_adx, ak akVar) {
        this.b = com_duokan_reader_ui_reading_adx;
        this.a = akVar;
    }

    public void a(as asVar) {
        aej com_duokan_reader_ui_reading_aej;
        Document_a aVar = null;
        if (asVar != null) {
            com_duokan_reader_ui_reading_aej = new aej();
            com_duokan_reader_ui_reading_aej.a = this.a;
            com_duokan_reader_ui_reading_aej.b.addAll(Arrays.asList(this.b.d.a(asVar)));
            asVar.H();
            this.b.d.a(com_duokan_reader_ui_reading_aej);
            this.b.a.c = com_duokan_reader_ui_reading_aej.c;
        }
        com_duokan_reader_ui_reading_aej = this.b.a;
        if (!this.b.d.a.e(this.a)) {
            aVar = this.b.d.b.f(this.a);
        }
        com_duokan_reader_ui_reading_aej.a = aVar;
        this.b.d.a(this.b.a);
        this.b.b.a(this.b.a);
    }
}
