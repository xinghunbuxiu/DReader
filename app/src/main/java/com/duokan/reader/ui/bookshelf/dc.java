package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.aj;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.an;
import java.util.ArrayList;
import java.util.List;

public class dc extends aj {
    /* renamed from: d */
    static final /* synthetic */ boolean f6320d = (!dc.class.desiredAssertionStatus());
    /* renamed from: a */
    private final Context f6321a;
    /* renamed from: c */
    public dd f6322c;
    /* renamed from: e */
    private final cz f6323e;
    /* renamed from: f */
    private final ArrayList<an> f6324f = new ArrayList();
    /* renamed from: g */
    private an f6325g = null;
    /* renamed from: h */
    private boolean f6326h = false;
    /* renamed from: i */
    private int f6327i = 3;
    /* renamed from: j */
    private final cw f6328j;

    public dc(List<an> list, Context context) {
        this.f6321a = context;
        this.f6323e = (cz) AppContext.getAppContext(this.f6321a).queryFeature(cz.class);
        m9459b((List) list);
        this.f6328j = (cw) AppContext.getAppContext(context).queryFeature(cw.class);
    }

    /* renamed from: b */
    public int m9457b() {
        return this.f6324f.size();
    }

    /* renamed from: a */
    public void m9455a(dd ddVar) {
        this.f6322c = ddVar;
    }

    /* renamed from: a */
    public void m9449a(int i, boolean z) {
        this.f6327i = i;
        this.f6326h = z;
    }

    /* renamed from: a */
    public boolean m9456a(List<an> list) {
        return ea.m9505a(this.f6324f, (List) list);
    }

    /* renamed from: a */
    public void m9451a(an anVar) {
        for (int i = 0; i < mo506c(); i++) {
            if (mo509d(i) == anVar) {
                mo2519h(i, 1);
                return;
            }
        }
    }

    /* renamed from: b */
    public void m9459b(List<an> list) {
        if (list != null) {
            this.f6324f.clear();
            this.f6324f.addAll(list);
            mo1691d();
        }
    }

    /* renamed from: a */
    public void m9453a(an anVar, an anVar2, int i) {
        if (this.f6322c != null) {
            this.f6322c.mo1687a(this.f6324f, anVar, anVar2, i);
        }
        m1398g(this.f6324f.indexOf(anVar), 1);
    }

    /* renamed from: a */
    public void m9454a(an anVar, boolean z) {
        an anVar2 = this.f6325g;
        this.f6325g = anVar;
        if (anVar == null && z) {
            m9451a(anVar2);
        }
    }

    /* renamed from: e */
    public an m9463e() {
        return this.f6325g;
    }

    /* renamed from: a */
    public void m9450a(aa aaVar, an anVar) {
        if (this.f6322c != null) {
            this.f6324f.add(0, anVar);
            this.f6322c.mo1685a(aaVar, (Object) anVar);
        }
        m1397f(0, 1);
    }

    /* renamed from: a */
    public void m9452a(an anVar, int i) {
        if (anVar != null) {
            int min = Math.min(this.f6324f.size(), i);
            int indexOf = this.f6324f.indexOf(anVar);
            this.f6324f.remove(indexOf);
            this.f6324f.add(min, anVar);
            if (this.f6322c != null) {
                this.f6322c.mo1686a((Object) anVar, min);
            }
            m1393b(indexOf, 1, min);
        }
    }

    /* renamed from: b */
    public int m9458b(an anVar) {
        return this.f6324f.indexOf(anVar);
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        viewGroup.setClipChildren(false);
        if (this.f6326h) {
            view = null;
        }
        return m9448e(i, view, viewGroup);
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f6324f == null ? 0 : this.f6324f.size();
    }

    /* renamed from: d */
    public Object mo509d(int i) {
        return this.f6324f == null ? null : (an) this.f6324f.get(i);
    }

    /* renamed from: e */
    private de m9448e(int i, View view, ViewGroup viewGroup) {
        an anVar = (an) mo509d(i);
        if ((anVar instanceof C0800c) || (anVar instanceof aa)) {
            de deVar = view instanceof de ? (de) view : new de(this.f6321a);
            if (this.f6323e.mo1657b()) {
                deVar.setInSelectMode(true);
                int a = anVar instanceof C0800c ? this.f6323e.mo1651a((C0800c) anVar) ? 1 : 0 : anVar instanceof aa ? this.f6323e.mo1642a((aa) anVar) : 0;
                deVar.setSelectedCountInEditMode(a);
            } else {
                deVar.setInSelectMode(false);
            }
            if (deVar instanceof de) {
                deVar.setItemData(anVar);
            }
            deVar.setLayoutParams(new LayoutParams(-2, -2, 1));
            deVar.setItemStatus(anVar == this.f6325g ? DragItemStatus.Draged : DragItemStatus.Normal);
            return deVar;
        } else if (f6320d) {
            return null;
        } else {
            throw new AssertionError();
        }
    }
}
