package com.duokan.reader.ui.bookshelf;

import android.app.Activity;
import android.content.Context;

import com.duokan.b.i;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.app.FeatureListening;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.eh;
import com.duokan.reader.ui.general.ap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class cr implements FeatureListening {
    private Boolean a = Boolean.valueOf(e());
    private final List b = new LinkedList();
    private int c = 0;
    private Runnable d;

    public cr(MyContextWrapper mContext, Activity activity) {
    }

    public List a() {
        return ai.a().m();
    }

    public void a(List list, aa aaVar) {
        if (list != null && list.size() > 0) {
            c[] cVarArr = new c[list.size()];
            for (int i = 0; i < list.size(); i++) {
                cVarArr[i] = (c) list.get(i);
            }
            ai.a().a(cVarArr, aaVar);
            aa l = ai.a().l();
            if (l.aF() != aaVar.aF()) {
                l.a((an) aaVar);
                l.aL();
            }
            c();
        }
    }

    public List b() {
        List a = ai.a().a(10, null);
        return e() ? a(new LinkedList(a)) : a;
    }

    public List a(String str) {
        List arrayList = new ArrayList(ai.a().a(str));
        return e() ? a(arrayList) : arrayList;
    }

    public synchronized void c() {
        for (ct c : this.b) {
            c.c();
        }
    }

    public List d() {
        List arrayList = new ArrayList();
        arrayList.addAll(ai.a().l().i());
        return e() ? a(arrayList) : arrayList;
    }

    public void a(boolean z) {
        if (this.a.booleanValue() != z) {
            this.a = Boolean.valueOf(z);
            ReaderEnv.get().setPrefBoolean(PrivatePref.BOOKSHELF, "Show_local_books", z);
            ReaderEnv.get().commitPrefs();
            c();
        }
    }

    public boolean e() {
        if (this.a == null) {
            this.a = Boolean.valueOf(f());
        }
        return this.a.booleanValue();
    }

    public static boolean f() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.BOOKSHELF, "Show_local_books", false);
    }

    public void a(Context context, c cVar, eh ehVar) {
        ap csVar = new cs(this, context, cVar, ehVar);
        csVar.setTitle(i.bookshelf__general_shared__delete_recently_book);
        csVar.setPrompt(i.bookshelf__general_shared__delete_recently_book_prompt);
        csVar.setCancelLabel(i.general__shared__cancel);
        csVar.setOkLabel(i.general__shared__confirm);
        csVar.show();
    }

    public List a(aa aaVar) {
        List arrayList = new ArrayList();
        arrayList.addAll(aaVar.h() ? Arrays.asList(aaVar.d()) : aaVar.i());
        if (e()) {
            return a(arrayList);
        }
        return arrayList;
    }

    public boolean g() {
        this.c++;
        return true;
    }

    public void h() {
        this.c--;
        if (this.c <= 0 && this.d != null && this.d != null) {
            this.d.run();
            this.d = null;
        }
    }

    public void a(Runnable runnable) {
        if (this.c > 0) {
            this.d = runnable;
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public synchronized void a(ct ctVar) {
        this.b.add(ctVar);
    }

    public synchronized void b(ct ctVar) {
        if (this.b.contains(ctVar)) {
            this.b.remove(ctVar);
        }
    }

    private List a(List list) {
        if (list == null || list.size() == 0) {
            return list;
        }
        List arrayList = new ArrayList();
        for (an anVar : list) {
            if (!anVar.az()) {
                arrayList.add(anVar);
            }
        }
        return arrayList;
    }
}
