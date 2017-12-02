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

public class mr extends fu {
    private final mo a;
    private mv b;
    private final mc c;
    private final LinkedList d = new LinkedList();

    public mr(Context context, gn gnVar, aj ajVar, Rect rect) {
        super(context, gnVar, rect, ajVar);
        setWillNotDraw(false);
        this.b = (mv) a((au) ajVar);
        this.a = new mo(context, ajVar, this.b);
        addView(this.a, new LayoutParams(-1, -1));
        this.b.setTopLayerAssistant(this.a);
        mu mhVar = new mh(context, ajVar.a(), this.b);
        mhVar.setShowInFullScreen(true);
        this.c = new mc(context);
        this.c.setMultiCallout(ajVar);
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(this.c, new LayoutParams(-1, -2));
        linearLayout.addView(mhVar, new LayoutParams(-1, -2));
        a(linearLayout, null);
        a(mhVar);
        this.b.setOnScrollListener(new ms(this));
    }

    public void a(mu muVar) {
        this.d.add(muVar);
    }

    public mn getPresenter() {
        return this.b;
    }

    public void a(Runnable runnable) {
        this.b.a(runnable);
        a(-1);
        this.c.a(-1);
    }

    public float getZoomFactor() {
        return this.b.getZoomFactor() / this.b.getMinZoomFactor();
    }

    public fy a(au auVar) {
        if (this.b == null) {
            this.b = new mt(this, getContext(), (aj) auVar);
        }
        return this.b;
    }

    public void a(int i, boolean z) {
        super.a(i, z);
        a(-1);
        this.c.a(-1);
    }

    private void a(int i) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((mu) it.next()).a(i);
        }
    }
}
