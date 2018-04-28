package com.duokan.reader.ui.bookshelf;

import android.graphics.Rect;
import com.duokan.core.app.AppContext;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.an;

public class eb extends dn {
    /* renamed from: a */
    private final aa f6367a;
    /* renamed from: b */
    private final ec f6368b;

    public eb(AppContext appContext, aa aaVar) {
        super(appContext);
        this.f6367a = aaVar;
        this.f6368b = new ec(getContext(), aaVar);
        setContentView(this.f6368b);
    }

    /* renamed from: c */
    public aa m9517c() {
        return this.f6367a;
    }

    /* renamed from: d */
    public void m9519d() {
        this.f6368b.m9545f();
    }

    protected boolean onBack() {
        if (!this.f6368b.m9543d()) {
            return super.onBack();
        }
        this.f6368b.requestFocus();
        return true;
    }

    public int[] getVisibleItemIndices() {
        return this.f6368b.getVisibleItemIndices();
    }

    /* renamed from: a */
    public Rect mo1661a(int i) {
        return this.f6368b.mo1661a(i);
    }

    public int getItemCount() {
        return this.f6368b.getItemCount();
    }

    /* renamed from: b */
    public de mo1670b(int i) {
        return this.f6368b.mo1670b(i);
    }

    public de getDraggingItemView() {
        return this.f6368b.getDraggingItemView();
    }

    /* renamed from: c */
    public an mo1671c(int i) {
        return this.f6368b.mo1671c(i);
    }

    /* renamed from: a */
    public void mo1664a(Rect rect) {
        this.f6368b.mo1664a(rect);
    }

    /* renamed from: a */
    public void mo1668a(an anVar, boolean z) {
        this.f6368b.mo1668a(anVar, z);
    }

    /* renamed from: a */
    public void mo1666a(an anVar, int i) {
        this.f6368b.mo1666a(anVar, i);
    }

    /* renamed from: a */
    public void mo1665a(aa aaVar, an anVar) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public void mo1667a(an anVar, an anVar2, int i) {
        this.f6368b.mo1667a(anVar, anVar2, i);
    }

    public boolean d_() {
        return this.f6368b.d_();
    }

    public boolean e_() {
        return this.f6368b.e_();
    }

    /* renamed from: a */
    public boolean mo1669a(int i, de deVar) {
        return this.f6368b.mo1669a(i, deVar);
    }

    /* renamed from: a */
    public void mo1662a(int i, int i2) {
        this.f6368b.mo1662a(i, i2);
    }

    /* renamed from: a */
    public void mo1663a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.f6368b.mo1663a(i, i2, i3, runnable, runnable2);
    }

    public int getContentScrollY() {
        return this.f6368b.getContentScrollY();
    }

    /* renamed from: a */
    public void m9511a(an anVar) {
        this.f6368b.m9539b(anVar);
    }
}
