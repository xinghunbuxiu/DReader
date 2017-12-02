package com.duokan.reader.ui.general;

import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.core.ui.aj;
import com.duokan.core.ui.ax;
import com.duokan.reader.ui.general.DkWebListView.ListState;

class bp extends aj implements ax {
    static final /* synthetic */ boolean a = (!DkWebListView.class.desiredAssertionStatus());
    final /* synthetic */ DkWebListView c;
    private bo d;

    private bp(DkWebListView dkWebListView) {
        this.c = dkWebListView;
        this.d = null;
    }

    public final bo b() {
        return this.d;
    }

    public final void a(bo boVar) {
        if (this.d != null) {
            this.d.b(this);
        }
        this.d = boVar;
        if (this.d != null) {
            this.d.a(this);
        }
    }

    public final boolean e() {
        if (this.d == null) {
            return false;
        }
        return this.d.g();
    }

    public final boolean f() {
        return h() == ListState.MORE_TO_LOAD || h() == ListState.LOADING_MORE;
    }

    public final int g() {
        return (h() == ListState.UNKNOWN || h() == ListState.EMPTY) ? 0 : this.d.c();
    }

    public final ListState h() {
        if (this.d == null) {
            return ListState.UNKNOWN;
        }
        return this.d.l();
    }

    public final void a(boolean z) {
        if (this.d != null) {
            this.d.b(z);
        }
    }

    public final void i() {
        if (this.d != null) {
            this.d.c(Math.max(50, Math.min(this.c.a.getVisibleItemCount() * 3, 100)));
        }
    }

    public int a() {
        if (this.d == null) {
            return 0;
        }
        return this.d.a();
    }

    public int a(int i) {
        if (this.d == null) {
            return 0;
        }
        return this.d.a(i);
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        if (this.d == null) {
            return null;
        }
        return this.d.a(i, view, viewGroup);
    }

    public final int c() {
        return g();
    }

    public final Object d(int i) {
        return this.d.d(i);
    }

    public final View a(View view, ViewGroup viewGroup) {
        if (this.d == null) {
            return null;
        }
        switch (bn.a[h().ordinal()]) {
            case 1:
            case 2:
                ImageView imageView = (ImageView) LayoutInflater.from(this.c.getContext()).inflate(g.general__web_first_loading_view, viewGroup, false);
                ((Animatable) imageView.getDrawable()).start();
                return imageView;
            case 3:
                return this.d.a(null, viewGroup);
            case 4:
                View inflate = LayoutInflater.from(this.c.getContext()).inflate(g.general__web_error_view, viewGroup, false);
                inflate.findViewById(f.general__dk_web_error_view__refresh).setOnClickListener(new bq(this));
                return inflate;
            default:
                if (a) {
                    return null;
                }
                throw new AssertionError();
        }
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        if (this.d == null) {
            return null;
        }
        return this.d.b(i, view, viewGroup);
    }

    public final View c(int i, View view, ViewGroup viewGroup) {
        View childAt;
        View view2 = null;
        if (view == null || view.getId() != f.general__dk_web_loading_more_view__root) {
            view = LayoutInflater.from(this.c.getContext()).inflate(g.general__web_loading_more_view, viewGroup, false);
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(f.general__web_loading_more_view__footer_frame);
        View findViewById = view.findViewById(f.general__web_loading_more_view__loading);
        if (frameLayout.getChildCount() > 0) {
            childAt = frameLayout.getChildAt(0);
        } else {
            childAt = null;
        }
        if (!(this.d == null || f())) {
            view2 = this.d.c(i, childAt, frameLayout);
        }
        if (childAt != view2) {
            if (childAt != null) {
                frameLayout.removeView(childAt);
            }
            if (view2 != null) {
                frameLayout.addView(view2);
            }
        }
        findViewById.setVisibility(f() ? 0 : 8);
        return view;
    }

    public final View d(int i, View view, ViewGroup viewGroup) {
        if (a || this.d != null) {
            return this.d.d(i, view, viewGroup);
        }
        throw new AssertionError();
    }

    public void a_(int i, int i2) {
        a_(c());
    }

    public void b_(int i, int i2) {
        a_(c());
    }

    public final void a(int i, int i2, int i3) {
        a_(c());
    }

    public final void d(int i, int i2) {
        a_(c());
    }

    public final void a_(int i) {
        if (this.d != null) {
            d();
            this.c.c(i);
        }
    }
}
