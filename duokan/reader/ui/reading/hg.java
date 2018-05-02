package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.epub.av;

import java.util.Map;
import java.util.Map.Entry;

class hg implements ag {
    final /* synthetic */ ag a;
    final /* synthetic */ hb b;

    hg(hb hbVar, ag agVar) {
        this.b = hbVar;
        this.a = agVar;
    }

    public void a(Map map) {
        for (Entry entry : map.entrySet()) {
            av avVar = (av) entry.getKey();
            int intValue = ((Integer) entry.getValue()).intValue();
            this.b.O.remove(avVar);
            if (intValue == 0 || intValue == 1) {
                this.b.Q.add(avVar);
            } else if (!(intValue == -1 || this.b.P.containsKey(avVar))) {
                this.b.P.put(avVar, Integer.valueOf(intValue));
                this.b.a(false);
            }
        }
        this.b.c.b(new hh(this, map));
    }
}
