package com.duokan.reader.ui.bookshelf;

import com.duokan.c.j;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.c;

import java.util.List;

class s implements cy {
    final /* synthetic */ g a;

    s(g gVar) {
        this.a = gVar;
    }

    public void a(List list, Object obj, Object obj2, int i) {
        c[] cVarArr = null;
        an anVar = (an) obj2;
        if (((an) obj) instanceof c) {
            Runnable runnable;
            if (anVar instanceof aa) {
                obj2 = (aa) anVar;
                c[] cVarArr2 = new c[]{(c) r8};
                runnable = null;
                cVarArr = cVarArr2;
            } else if (anVar instanceof c) {
                UmengManager.get().onEvent("V2_SHELF_CREATEGROUP", "FromGrid");
                aa a = ai.a().a(i, a());
                c[] cVarArr3 = new c[]{(c) anVar, (c) r8};
                t tVar = new t(this, a);
                aa aaVar = a;
                cVarArr = cVarArr3;
                Object obj3 = tVar;
            } else {
                obj2 = null;
                runnable = null;
            }
            ai.a().a(cVarArr, (aa) obj2, runnable);
        }
    }

    private String a() {
        String string = this.a.getContext().getString(j.bookshelf__shared__unrename_category);
        if (ai.a().g(string) == null) {
            return string;
        }
        int i = 1;
        while (ai.a().g(string + " " + i) != null) {
            i++;
        }
        return string + " " + i;
    }

    public void a(Object obj, int i) {
        ai.a().a(ai.a().l(), (an) obj, i);
    }

    public void a(aa aaVar, Object obj) {
        ai.a().a(new c[]{(c) obj}, ai.a().l());
        ai.a().n();
    }
}
