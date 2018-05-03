package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.ge;
import com.duokan.reader.domain.document.ac;

public class jz extends gd {
    /* renamed from: b */
    private boolean f10479b = false;
    /* renamed from: c */
    private final ac f10480c;
    /* renamed from: d */
    private final kb f10481d;
    /* renamed from: e */
    private jx f10482e;

    public jz(Context context, gs gsVar, ac acVar, Rect rect) {
        super(context);
        this.f10480c = acVar;
        this.f10481d = new kb(this, context);
        for (int i = 0; i < this.f10480c.mo1389d(); i++) {
            View kyVar = new ky(getContext(), gsVar, new Rect(), this.f10480c.mo1386b(i));
            kyVar.setEnabled(false);
            this.f10481d.addView(kyVar, new LayoutParams(-1, -1));
        }
        this.f10481d.m9070b(this.f10480c.mo1381a());
        m14203a(this.f10481d, new ViewGroup.LayoutParams(-1, -1));
        this.f10481d.setOnScrollListener(new ka(this));
    }

    /* renamed from: e */
    public void mo2335e() {
        for (int i = 0; i < this.f10481d.getChildCount(); i++) {
            ((ky) this.f10481d.getChildAt(i)).m14174g();
        }
    }

    /* renamed from: g */
    public void mo2413g() {
        this.f10479b = true;
        this.f10481d.setHorizontalOverScrollMode(OverScrollMode.STRETCH);
        this.f10481d.setMaxOverScrollWidth(AnimUtils.m1959f(getContext()));
        for (int i = 0; i < this.f10481d.getChildCount(); i++) {
            ky kyVar = (ky) this.f10481d.getChildAt(i);
            kyVar.m14176i();
            kyVar.setEnabled(true);
        }
    }

    /* renamed from: f */
    public void mo2412f() {
        for (int i = 0; i < this.f10481d.getChildCount(); i++) {
            ((ky) this.f10481d.getChildAt(i)).m14175h();
        }
    }

    /* renamed from: h */
    public void mo2414h() {
        this.f10479b = false;
        this.f10481d.setHorizontalOverScrollMode(OverScrollMode.NEVER);
        this.f10481d.setMaxOverScrollWidth(0);
        for (int i = 0; i < this.f10481d.getChildCount(); i++) {
            ky kyVar = (ky) this.f10481d.getChildAt(i);
            kyVar.m14177j();
            kyVar.setEnabled(false);
        }
        mo2411a(null);
    }

    /* renamed from: a */
    public void mo2410a(int i, boolean z) {
        for (int i2 = 0; i2 < this.f10481d.getChildCount(); i2++) {
            ((ky) this.f10481d.getChildAt(i2)).mo2435a(i, z);
        }
    }

    public void setOnZoomListener(ge geVar) {
        for (int i = 0; i < this.f10481d.getChildCount(); i++) {
            ((ky) this.f10481d.getChildAt(i)).setZoomListener(geVar);
        }
    }

    public void setQuitRunnable(Runnable runnable) {
        for (int i = 0; i < this.f10481d.getChildCount(); i++) {
            ((ky) this.f10481d.getChildAt(i)).getWatchingView().setQuitRunnable(runnable);
        }
    }

    public void setToBeQuit(boolean z) {
        for (int i = 0; i < this.f10481d.getChildCount(); i++) {
            ((ky) this.f10481d.getChildAt(i)).getWatchingView().setToBeQuit(z);
        }
    }

    /* renamed from: k */
    public boolean mo2415k() {
        if (this.f10481d.getChildCount() <= this.f10480c.mo1381a()) {
            return false;
        }
        ky kyVar = (ky) this.f10481d.getChildAt(this.f10480c.mo1381a());
        if (kyVar == null) {
            return false;
        }
        gd watchingView = kyVar.getWatchingView();
        if (watchingView == null) {
            return false;
        }
        return watchingView.mo2415k();
    }

    /* renamed from: a */
    public void mo2411a(Runnable runnable) {
        int i = 0;
        while (i < this.f10481d.getChildCount()) {
            ((ky) this.f10481d.getChildAt(i)).mo2436a(i == this.f10481d.getChildCount() + -1 ? runnable : null);
            i++;
        }
    }

    public ky getShowingPic() {
        return (ky) this.f10481d.getChildAt(this.f10480c.mo1381a());
    }

    public void setGalleryShowingPicListener(jx jxVar) {
        this.f10482e = jxVar;
    }

    /* renamed from: b */
    public void m14520b(int i, int i2) {
        this.f10480c.mo1384a(i2);
        if (this.f10482e != null) {
            this.f10482e.mo2402a(i, i2);
        }
    }
}
