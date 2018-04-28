package com.duokan.reader.ui.bookshelf;

import android.app.Activity;
import android.content.Context;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.FeatureListening;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.ec;
import com.duokan.reader.ui.general.ap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class cw implements FeatureListening {
    /* renamed from: a */
    private Boolean f6312a = Boolean.valueOf(m9445e());
    /* renamed from: b */
    private final List<cy> f6313b = new LinkedList();
    /* renamed from: c */
    private int f6314c = 0;
    /* renamed from: d */
    private Runnable f6315d;

    public cw(AppContext appContext, Activity activity) {
    }

    /* renamed from: a */
    public List<aa> m9433a() {
        return ai.m3980a().m3938m();
    }

    /* renamed from: a */
    public void m9439a(List<an> list, aa aaVar) {
        if (list != null && list.size() > 0) {
            C0800c[] c0800cArr = new C0800c[list.size()];
            for (int i = 0; i < list.size(); i++) {
                c0800cArr[i] = (C0800c) list.get(i);
            }
            ai.m3980a().m3899a(c0800cArr, aaVar);
            aa l = ai.m3980a().m3937l();
            if (l.aH() != aaVar.aH()) {
                l.m3756a((an) aaVar);
                l.aN();
            }
            m9443c();
        }
    }

    /* renamed from: b */
    public List<C0800c> m9441b() {
        List<C0800c> a = ai.m3980a().m3878a(10, null);
        return m9445e() ? m9431a(new LinkedList(a)) : a;
    }

    /* renamed from: a */
    public List<an> m9435a(String str) {
        List arrayList = new ArrayList(ai.m3980a().m3879a(str));
        return m9445e() ? m9431a(arrayList) : arrayList;
    }

    /* renamed from: c */
    public synchronized void m9443c() {
        for (cy c : this.f6313b) {
            c.mo1672c();
        }
    }

    /* renamed from: d */
    public List<an> m9444d() {
        List arrayList = new ArrayList();
        arrayList.addAll(ai.m3980a().m3937l().m3768i());
        return m9445e() ? m9431a(arrayList) : arrayList;
    }

    /* renamed from: a */
    public void m9440a(boolean z) {
        if (this.f6312a.booleanValue() != z) {
            this.f6312a = Boolean.valueOf(z);
            ReaderEnv.get().setPrefBoolean(PrivatePref.BOOKSHELF, "Show_local_books", z);
            ReaderEnv.get().commitPrefs();
            m9443c();
        }
    }

    /* renamed from: e */
    public boolean m9445e() {
        if (this.f6312a == null) {
            this.f6312a = Boolean.valueOf(m9432f());
        }
        return this.f6312a.booleanValue();
    }

    /* renamed from: f */
    public static boolean m9432f() {
        return ReaderEnv.get().getPrefBoolean(PrivatePref.BOOKSHELF, "Show_local_books", false);
    }

    /* renamed from: a */
    public void m9436a(Context context, C0800c c0800c, ec ecVar) {
        ap cxVar = new cx(this, context, c0800c, ecVar);
        cxVar.setTitle(C0247i.bookshelf__general_shared__delete_recently_book);
        cxVar.setPrompt(C0247i.bookshelf__general_shared__delete_recently_book_prompt);
        cxVar.setCancelLabel(C0247i.general__shared__cancel);
        cxVar.setOkLabelResid(C0247i.general__shared__confirm);
        cxVar.show();
    }

    /* renamed from: a */
    public List<an> m9434a(aa aaVar) {
        List<an> arrayList = new ArrayList();
        arrayList.addAll(aaVar.m3767h() ? Arrays.asList(aaVar.m3763d()) : aaVar.m3768i());
        if (m9445e()) {
            return m9431a((List) arrayList);
        }
        return arrayList;
    }

    /* renamed from: g */
    public boolean m9446g() {
        this.f6314c++;
        return true;
    }

    /* renamed from: h */
    public void m9447h() {
        this.f6314c--;
        if (this.f6314c <= 0 && this.f6315d != null && this.f6315d != null) {
            this.f6315d.run();
            this.f6315d = null;
        }
    }

    /* renamed from: a */
    public void m9438a(Runnable runnable) {
        if (this.f6314c > 0) {
            this.f6315d = runnable;
        } else if (runnable != null) {
            runnable.run();
        }
    }

    /* renamed from: a */
    public synchronized void m9437a(cy cyVar) {
        this.f6313b.add(cyVar);
    }

    /* renamed from: b */
    public synchronized void m9442b(cy cyVar) {
        if (this.f6313b.contains(cyVar)) {
            this.f6313b.remove(cyVar);
        }
    }

    /* renamed from: a */
    private List<an> m9431a(List<an> list) {
        if (list == null || list.size() == 0) {
            return list;
        }
        List<an> arrayList = new ArrayList();
        for (an anVar : list) {
            if (!anVar.aB()) {
                arrayList.add(anVar);
            }
        }
        return arrayList;
    }
}
