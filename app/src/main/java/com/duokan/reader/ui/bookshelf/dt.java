package com.duokan.reader.ui.bookshelf;

import android.graphics.Rect;

import com.duokan.core.app.x;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.an;

public class dt extends dg {
    private final aa a;
    private final du b;

    public dt(x xVar, aa aaVar) {
        super(xVar);
        this.a = aaVar;
        this.b = new du(getContext(), aaVar);
        setContentView(this.b);
    }

    public aa c() {
        return this.a;
    }

    public void d() {
        this.b.f();
    }

    protected boolean onBack() {
        if (!this.b.d()) {
            return super.onBack();
        }
        this.b.requestFocus();
        return true;
    }

    public int[] getVisibleItemIndices() {
        return this.b.getVisibleItemIndices();
    }

    public Rect a(int i) {
        return this.b.a(i);
    }

    public int getItemCount() {
        return this.b.getItemCount();
    }

    public cz b(int i) {
        return this.b.b(i);
    }

    public cz getDraggingItemView() {
        return this.b.getDraggingItemView();
    }

    public an c(int i) {
        return this.b.c(i);
    }

    public void a(Rect rect) {
        this.b.a(rect);
    }

    public void a(an anVar, boolean z) {
        this.b.a(anVar, z);
    }

    public void a(an anVar, int i) {
        this.b.a(anVar, i);
    }

    public void a(aa aaVar, an anVar) {
        throw new UnsupportedOperationException();
    }

    public void a(an anVar, an anVar2, int i) {
        this.b.a(anVar, anVar2, i);
    }

    public boolean c_() {
        return this.b.c_();
    }

    public boolean d_() {
        return this.b.d_();
    }

    public boolean a(int i, cz czVar) {
        return this.b.a(i, czVar);
    }

    public void a(int i, int i2) {
        this.b.a(i, i2);
    }

    public void a(int i, int i2, int i3, Runnable runnable, Runnable runnable2) {
        this.b.a(i, i2, i3, runnable, runnable2);
    }

    public int getContentScrollY() {
        return this.b.getContentScrollY();
    }

    public void a(an anVar) {
        this.b.b(anVar);
    }
}
