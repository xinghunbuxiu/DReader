package com.duokan.reader.ui.bookshelf;

import com.duokan.p024c.C0258j;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import java.util.List;

/* renamed from: com.duokan.reader.ui.bookshelf.x */
class C1310x implements dd {
    /* renamed from: a */
    final /* synthetic */ C1290g f6747a;

    C1310x(C1290g c1290g) {
        this.f6747a = c1290g;
    }

    /* renamed from: a */
    public void mo1687a(List<an> list, Object obj, Object obj2, int i) {
        C0800c[] c0800cArr = null;
        an anVar = (an) obj2;
        if (((an) obj) instanceof C0800c) {
            aa aaVar;
            Runnable runnable;
            if (anVar instanceof aa) {
                aaVar = (aa) anVar;
                C0800c[] c0800cArr2 = new C0800c[]{(C0800c) r8};
                runnable = null;
                c0800cArr = c0800cArr2;
            } else if (anVar instanceof C0800c) {
                UmengManager.get().onEvent("V2_SHELF_CREATEGROUP", "FromGrid");
                aa a = ai.m3980a().m3861a(i, m9911a());
                C0800c[] c0800cArr3 = new C0800c[]{(C0800c) anVar, (C0800c) r8};
                C1311y c1311y = new C1311y(this, a);
                aaVar = a;
                c0800cArr = c0800cArr3;
                Object runnable2 = c1311y;
            } else {
                aaVar = null;
                runnable2 = null;
            }
            ai.m3980a().m3900a(c0800cArr, aaVar, runnable2);
        }
    }

    /* renamed from: a */
    private String m9911a() {
        String string = this.f6747a.getContext().getString(C0258j.bookshelf__shared__unrename_category);
        if (ai.m3980a().m3929g(string) == null) {
            return string;
        }
        int i = 1;
        while (ai.m3980a().m3929g(string + " " + i) != null) {
            i++;
        }
        return string + " " + i;
    }

    /* renamed from: a */
    public void mo1686a(Object obj, int i) {
        ai.m3980a().m3882a(ai.m3980a().m3937l(), (an) obj, i);
    }

    /* renamed from: a */
    public void mo1685a(aa aaVar, Object obj) {
        ai.m3980a().m3899a(new C0800c[]{(C0800c) obj}, ai.m3980a().m3937l());
        ai.m3980a().m3939n();
    }
}
