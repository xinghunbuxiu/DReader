package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.OnScrollListener;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;

public class DotScrollerView extends LinearLayout {
    /* renamed from: a */
    private final LinearScrollView f6817a;
    /* renamed from: b */
    private final DotProgressBar f6818b;
    /* renamed from: c */
    private OnScrollListener f6819c;
    /* renamed from: d */
    private boolean f6820d;

    public DotScrollerView(Context context) {
        this(context, null);
    }

    public DotScrollerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6819c = null;
        this.f6820d = false;
        LayoutInflater.from(getContext()).inflate(C0245g.general__dot_scroller_view, this);
        this.f6817a = (LinearScrollView) findViewById(C0244f.general__dot_scroller_view__scroller);
        this.f6818b = (DotProgressBar) findViewById(C0244f.general__dot_scroller_view__dot);
        this.f6817a.setThumbEnabled(false);
        this.f6818b.setNums(5);
        this.f6818b.setCurrentIndex(0);
        this.f6817a.setOnScrollListener(new bv(this));
        this.f6817a.setOnHierarchyChangeListener(new bw(this));
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f6819c = onScrollListener;
    }

    protected LinearScrollView getScrollView() {
        return this.f6817a;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z || this.f6820d) {
            this.f6820d = false;
            if (this.f6817a.m1280b()) {
                this.f6818b.setVisibility(0);
                m9974a();
                return;
            }
            this.f6818b.setVisibility(4);
        }
    }

    /* renamed from: a */
    private void m9974a() {
        if (this.f6817a.m1282c()) {
            this.f6818b.setCurrentIndex(0);
        } else if (this.f6817a.m1283d()) {
            this.f6818b.setCurrentIndex(5);
        } else {
            this.f6818b.setCurrentIndex(Math.round((((float) this.f6817a.getViewportBounds().centerX()) * 1.0f) / ((float) (this.f6817a.getContentWidth() / 5))));
        }
    }
}
