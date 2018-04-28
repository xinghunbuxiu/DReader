package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.duokan.reader.domain.document.aj;
import com.duokan.reader.domain.document.au;
import java.util.Iterator;
import java.util.LinkedList;

public class nb extends fz {
    /* renamed from: a */
    private final my f10655a;
    /* renamed from: b */
    private nf f10656b;
    /* renamed from: c */
    private final mm f10657c;
    /* renamed from: d */
    private final LinkedList<ne> f10658d = new LinkedList();

    public nb(Context context, gs gsVar, aj ajVar, Rect rect) {
        super(context, gsVar, rect, ajVar);
        setWillNotDraw(false);
        this.f10656b = (nf) mo2403a((au) ajVar);
        this.f10655a = new my(context, ajVar, this.f10656b);
        addView(this.f10655a, new LayoutParams(-1, -1));
        this.f10656b.setTopLayerAssistant(this.f10655a);
        ne mrVar = new mr(context, ajVar.mo1415a(), this.f10656b);
        mrVar.setShowInFullScreen(true);
        this.f10657c = new mm(context);
        this.f10657c.setMultiCallout(ajVar);
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(this.f10657c, new LayoutParams(-1, -2));
        linearLayout.addView(mrVar, new LayoutParams(-1, -2));
        m14166a(linearLayout, null);
        m14704a(mrVar);
        this.f10656b.setOnScrollListener(new nc(this));
    }

    /* renamed from: a */
    public void m14704a(ne neVar) {
        this.f10658d.add(neVar);
    }

    public mx getPresenter() {
        return this.f10656b;
    }

    /* renamed from: a */
    public void mo2436a(Runnable runnable) {
        this.f10656b.mo2411a(runnable);
        m14699a(-1);
        this.f10657c.m14661a(-1);
    }

    public float getZoomFactor() {
        return this.f10656b.getZoomFactor() / this.f10656b.getMinZoomFactor();
    }

    /* renamed from: a */
    public gd mo2403a(au auVar) {
        if (this.f10656b == null) {
            this.f10656b = new nd(this, getContext(), (aj) auVar);
        }
        return this.f10656b;
    }

    /* renamed from: a */
    public void mo2435a(int i, boolean z) {
        super.mo2435a(i, z);
        m14699a(-1);
        this.f10657c.m14661a(-1);
    }

    /* renamed from: a */
    private void m14699a(int i) {
        Iterator it = this.f10658d.iterator();
        while (it.hasNext()) {
            ((ne) it.next()).mo2430a(i);
        }
    }
}
