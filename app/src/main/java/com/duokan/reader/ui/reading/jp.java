package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

import com.duokan.core.ui.UTools;
import com.duokan.core.ui.ge;
import com.duokan.reader.domain.document.ac;

public class jp extends fy {
    private boolean b = false;
    private final ac c;
    private final jr d;
    private jn e;

    public jp(Context context, gn gnVar, ac acVar, Rect rect) {
        super(context);
        this.c = acVar;
        this.d = new jr(this, context);
        for (int i = 0; i < this.c.d(); i++) {
            View koVar = new ko(getContext(), gnVar, new Rect(), this.c.b(i));
            koVar.setEnabled(false);
            this.d.addView(koVar, new LayoutParams(-1, -1));
        }
        this.d.b(this.c.a());
        a(this.d, new ViewGroup.LayoutParams(-1, -1));
        this.d.setOnScrollListener(new jq(this));
    }

    public void e() {
        for (int i = 0; i < this.d.getChildCount(); i++) {
            ((ko) this.d.getChildAt(i)).g();
        }
    }

    public void g() {
        this.b = true;
        this.d.setHorizontalOverScrollMode(OverScrollMode.STRETCH);
        this.d.setMaxOverScrollWidth(UTools.defaultClose(getContext()));
        for (int i = 0; i < this.d.getChildCount(); i++) {
            ko koVar = (ko) this.d.getChildAt(i);
            koVar.i();
            koVar.setEnabled(true);
        }
    }

    public void f() {
        for (int i = 0; i < this.d.getChildCount(); i++) {
            ((ko) this.d.getChildAt(i)).h();
        }
    }

    public void h() {
        this.b = false;
        this.d.setHorizontalOverScrollMode(OverScrollMode.NEVER);
        this.d.setMaxOverScrollWidth(0);
        for (int i = 0; i < this.d.getChildCount(); i++) {
            ko koVar = (ko) this.d.getChildAt(i);
            koVar.j();
            koVar.setEnabled(false);
        }
        a(null);
    }

    public void a(int i, boolean z) {
        for (int i2 = 0; i2 < this.d.getChildCount(); i2++) {
            ((ko) this.d.getChildAt(i2)).a(i, z);
        }
    }

    public void setOnZoomListener(ge geVar) {
        for (int i = 0; i < this.d.getChildCount(); i++) {
            ((ko) this.d.getChildAt(i)).setZoomListener(geVar);
        }
    }

    public void setQuitRunnable(Runnable runnable) {
        for (int i = 0; i < this.d.getChildCount(); i++) {
            ((ko) this.d.getChildAt(i)).getWatchingView().setQuitRunnable(runnable);
        }
    }

    public void setToBeQuit(boolean z) {
        for (int i = 0; i < this.d.getChildCount(); i++) {
            ((ko) this.d.getChildAt(i)).getWatchingView().setToBeQuit(z);
        }
    }

    public boolean k() {
        if (this.d.getChildCount() <= this.c.a()) {
            return false;
        }
        ko koVar = (ko) this.d.getChildAt(this.c.a());
        if (koVar == null) {
            return false;
        }
        fy watchingView = koVar.getWatchingView();
        if (watchingView == null) {
            return false;
        }
        return watchingView.k();
    }

    public void a(Runnable runnable) {
        int i = 0;
        while (i < this.d.getChildCount()) {
            ((ko) this.d.getChildAt(i)).a(i == this.d.getChildCount() + -1 ? runnable : null);
            i++;
        }
    }

    public ko getShowingPic() {
        return (ko) this.d.getChildAt(this.c.a());
    }

    public void setGalleryShowingPicListener(jn jnVar) {
        this.e = jnVar;
    }

    public void b(int i, int i2) {
        this.c.a(i2);
        if (this.e != null) {
            this.e.a(i, i2);
        }
    }
}
