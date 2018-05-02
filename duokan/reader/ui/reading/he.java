package com.duokan.reader.ui.reading;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.document.epub.av;

import java.util.Arrays;
import java.util.Map;

class he implements ag {
    final /* synthetic */ hb a;

    he(hb hbVar) {
        this.a = hbVar;
    }

    public void a(Map map) {
        if (this.a.a == this) {
            if (this.a.q || this.a.S.isEmpty()) {
                this.a.a = null;
                return;
            }
            av avVar = (av) this.a.S.poll();
            this.a.b(Arrays.asList(new av[]{avVar}), this);
        }
    }
}
