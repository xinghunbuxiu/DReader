package com.duokan.reader.ui.general;

import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.duokan.core.ui.aj;
import com.duokan.core.ui.ax;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.reader.ui.general.DkWebListView.ListState;

class bp extends aj implements ax {
    /* renamed from: a */
    static final /* synthetic */ boolean f7004a = (!DkWebListView.class.desiredAssertionStatus());
    /* renamed from: c */
    final /* synthetic */ DkWebListView f7005c;
    /* renamed from: d */
    private bo f7006d;

    private bp(DkWebListView dkWebListView) {
        this.f7005c = dkWebListView;
        this.f7006d = null;
    }

    /* renamed from: b */
    public final bo m10302b() {
        return this.f7006d;
    }

    /* renamed from: a */
    public final void m10299a(bo boVar) {
        if (this.f7006d != null) {
            this.f7006d.mo484b(this);
        }
        this.f7006d = boVar;
        if (this.f7006d != null) {
            this.f7006d.mo483a(this);
        }
    }

    /* renamed from: e */
    public final boolean m10308e() {
        if (this.f7006d == null) {
            return false;
        }
        return this.f7006d.mo1715g();
    }

    /* renamed from: f */
    public final boolean m10309f() {
        return m10311h() == ListState.MORE_TO_LOAD || m10311h() == ListState.LOADING_MORE;
    }

    /* renamed from: g */
    public final int m10310g() {
        return (m10311h() == ListState.UNKNOWN || m10311h() == ListState.EMPTY) ? 0 : this.f7006d.mo506c();
    }

    /* renamed from: h */
    public final ListState m10311h() {
        if (this.f7006d == null) {
            return ListState.UNKNOWN;
        }
        return this.f7006d.m8789l();
    }

    /* renamed from: a */
    public final void m10300a(boolean z) {
        if (this.f7006d != null) {
            this.f7006d.mo1755b(z);
        }
    }

    /* renamed from: i */
    public final void m10312i() {
        if (this.f7006d != null) {
            this.f7006d.mo1556c(Math.max(50, Math.min(this.f7005c.f6792a.getVisibleItemCount() * 3, 100)));
        }
    }

    /* renamed from: a */
    public int mo486a() {
        if (this.f7006d == null) {
            return 0;
        }
        return this.f7006d.mo486a();
    }

    /* renamed from: a */
    public int mo487a(int i) {
        if (this.f7006d == null) {
            return 0;
        }
        return this.f7006d.mo487a(i);
    }

    /* renamed from: a */
    public View mo488a(int i, View view, ViewGroup viewGroup) {
        if (this.f7006d == null) {
            return null;
        }
        return this.f7006d.mo488a(i, view, viewGroup);
    }

    /* renamed from: c */
    public final int mo506c() {
        return m10310g();
    }

    /* renamed from: d */
    public final Object mo509d(int i) {
        return this.f7006d.mo509d(i);
    }

    /* renamed from: a */
    public final View mo482a(View view, ViewGroup viewGroup) {
        if (this.f7006d == null) {
            return null;
        }
        switch (bn.f7003a[m10311h().ordinal()]) {
            case 1:
            case 2:
                ImageView imageView = (ImageView) LayoutInflater.from(this.f7005c.getContext()).inflate(C0245g.general__web_first_loading_view, viewGroup, false);
                ((Animatable) imageView.getDrawable()).start();
                return imageView;
            case 3:
                return this.f7006d.mo482a(null, viewGroup);
            case 4:
                View inflate = LayoutInflater.from(this.f7005c.getContext()).inflate(C0245g.general__web_error_view, viewGroup, false);
                inflate.findViewById(C0244f.general__dk_web_error_view__refresh).setOnClickListener(new bq(this));
                return inflate;
            default:
                if (f7004a) {
                    return null;
                }
                throw new AssertionError();
        }
    }

    /* renamed from: b */
    public final View mo505b(int i, View view, ViewGroup viewGroup) {
        if (this.f7006d == null) {
            return null;
        }
        return this.f7006d.mo505b(i, view, viewGroup);
    }

    /* renamed from: c */
    public final View mo507c(int i, View view, ViewGroup viewGroup) {
        View childAt;
        View view2 = null;
        if (view == null || view.getId() != C0244f.general__dk_web_loading_more_view__root) {
            view = LayoutInflater.from(this.f7005c.getContext()).inflate(C0245g.general__web_loading_more_view, viewGroup, false);
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(C0244f.general__web_loading_more_view__footer_frame);
        View findViewById = view.findViewById(C0244f.general__web_loading_more_view__loading);
        if (frameLayout.getChildCount() > 0) {
            childAt = frameLayout.getChildAt(0);
        } else {
            childAt = null;
        }
        if (!(this.f7006d == null || m10309f())) {
            view2 = this.f7006d.mo507c(i, childAt, frameLayout);
        }
        if (childAt != view2) {
            if (childAt != null) {
                frameLayout.removeView(childAt);
            }
            if (view2 != null) {
                frameLayout.addView(view2);
            }
        }
        findViewById.setVisibility(m10309f() ? 0 : 8);
        return view;
    }

    /* renamed from: d */
    public final View mo508d(int i, View view, ViewGroup viewGroup) {
        if (f7004a || this.f7006d != null) {
            return this.f7006d.mo508d(i, view, viewGroup);
        }
        throw new AssertionError();
    }

    public void a_(int i, int i2) {
        a_(mo506c());
    }

    public void b_(int i, int i2) {
        a_(mo506c());
    }

    /* renamed from: a */
    public final void mo440a(int i, int i2, int i3) {
        a_(mo506c());
    }

    /* renamed from: d */
    public final void mo444d(int i, int i2) {
        a_(mo506c());
    }

    public final void a_(int i) {
        if (this.f7006d != null) {
            mo1691d();
            this.f7005c.m9944c(i);
        }
    }
}
