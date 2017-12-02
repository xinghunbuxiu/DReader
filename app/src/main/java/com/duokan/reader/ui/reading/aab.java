package com.duokan.reader.ui.reading;

import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.ag;
import com.duokan.reader.domain.bookshelf.ej;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class aab implements ag {
    final /* synthetic */ List a;
    final /* synthetic */ ej b;
    final /* synthetic */ aaq c;
    final /* synthetic */ ag d;
    final /* synthetic */ zo e;

    aab(zo zoVar, List list, ej ejVar, aaq com_duokan_reader_ui_reading_aaq, ag agVar) {
        this.e = zoVar;
        this.a = list;
        this.b = ejVar;
        this.c = com_duokan_reader_ui_reading_aaq;
        this.d = agVar;
    }

    public void a(Map map) {
        a.c().b(map.size() == this.a.size());
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            int intValue = ((Integer) entry.getValue()).intValue();
            this.e.K.remove(str);
            if (intValue == 0) {
                this.e.M.add(str);
            } else if (intValue == 1) {
                if (!this.c.e((long) this.b.r(str))) {
                    this.e.M.add(str);
                }
            } else if (!(intValue == -1 || this.e.L.containsKey(str))) {
                this.e.L.put(str, Integer.valueOf(intValue));
                this.e.a(false);
            }
        }
        this.e.c.b(new aac(this, map));
    }
}
