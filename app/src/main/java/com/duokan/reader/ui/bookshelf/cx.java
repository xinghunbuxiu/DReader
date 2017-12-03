package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.aj;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.c;

import java.util.ArrayList;
import java.util.List;

public class cx extends aj {
    static final /* synthetic */ boolean d = (!cx.class.desiredAssertionStatus());
    private final Context a;
    public cy c;
    private final cu e;
    private final ArrayList f = new ArrayList();
    private an g = null;
    private boolean h = false;
    private int i = 3;
    private final cr j;

    public cx(List list, Context context) {
        this.a = context;
        this.e = (cu) MyContextWrapper.getFeature(this.a).queryFeature(cu.class);
        b(list);
        this.j = (cr) MyContextWrapper.getFeature(context).queryFeature(cr.class);
    }

    public int b() {
        return this.f.size();
    }

    public void a(cy cyVar) {
        this.c = cyVar;
    }

    public void a(int i, boolean z) {
        this.i = i;
        this.h = z;
    }

    public boolean a(List list) {
        return ds.a(this.f, list);
    }

    public void a(an anVar) {
        for (int i = 0; i < c(); i++) {
            if (d(i) == anVar) {
                h(i, 1);
                return;
            }
        }
    }

    public void b(List list) {
        if (list != null) {
            this.f.clear();
            this.f.addAll(list);
            d();
        }
    }

    public void a(an anVar, an anVar2, int i) {
        if (this.c != null) {
            this.c.a(this.f, anVar, anVar2, i);
        }
        g(this.f.indexOf(anVar), 1);
    }

    public void a(an anVar, boolean z) {
        an anVar2 = this.g;
        this.g = anVar;
        if (anVar == null && z) {
            a(anVar2);
        }
    }

    public an e() {
        return this.g;
    }

    public void a(aa aaVar, an anVar) {
        if (this.c != null) {
            this.f.add(0, anVar);
            this.c.a(aaVar, (Object) anVar);
        }
        f(0, 1);
    }

    public void a(an anVar, int i) {
        if (anVar != null) {
            int min = Math.min(this.f.size(), i);
            int indexOf = this.f.indexOf(anVar);
            this.f.remove(indexOf);
            this.f.add(min, anVar);
            if (this.c != null) {
                this.c.a((Object) anVar, min);
            }
            b(indexOf, 1, min);
        }
    }

    public int b(an anVar) {
        return this.f.indexOf(anVar);
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        viewGroup.setClipChildren(false);
        if (this.h) {
            view = null;
        }
        return e(i, view, viewGroup);
    }

    public int c() {
        return this.f == null ? 0 : this.f.size();
    }

    public Object d(int i) {
        return this.f == null ? null : (an) this.f.get(i);
    }

    private cz e(int i, View view, ViewGroup viewGroup) {
        an anVar = (an) d(i);
        if ((anVar instanceof c) || (anVar instanceof aa)) {
            view = view instanceof cz ? (cz) view : new cz(this.a);
            if (this.e.b()) {
                view.setInSelectMode(true);
                int a = anVar instanceof c ? this.e.a((c) anVar) ? 1 : 0 : anVar instanceof aa ? this.e.a((aa) anVar) : 0;
                view.setSelectedCountInEditMode(a);
            } else {
                view.setInSelectMode(false);
            }
            if (view instanceof cz) {
                view.setItemData(anVar);
            }
            view.setLayoutParams(new LayoutParams(-2, -2, 1));
            view.setItemStatus(anVar == this.g ? DragItemStatus.Draged : DragItemStatus.Normal);
            return view;
        } else if (d) {
            return null;
        } else {
            throw new AssertionError();
        }
    }
}
