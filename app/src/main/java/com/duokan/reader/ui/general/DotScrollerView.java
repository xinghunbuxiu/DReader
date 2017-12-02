package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.cg;

public class DotScrollerView extends LinearLayout {
    private final LinearScrollView a;
    private final DotProgressBar b;
    private cg c;
    private boolean d;

    public DotScrollerView(Context context) {
        this(context, null);
    }

    public DotScrollerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = null;
        this.d = false;
        LayoutInflater.from(getContext()).inflate(g.general__dot_scroller_view, this);
        this.a = (LinearScrollView) findViewById(f.general__dot_scroller_view__scroller);
        this.b = (DotProgressBar) findViewById(f.general__dot_scroller_view__dot);
        this.a.setThumbEnabled(false);
        this.b.setNums(5);
        this.b.setCurrentIndex(0);
        this.a.setOnScrollListener(new bv(this));
        this.a.setOnHierarchyChangeListener(new bw(this));
    }

    public void setOnScrollListener(cg cgVar) {
        this.c = cgVar;
    }

    protected LinearScrollView getScrollView() {
        return this.a;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z || this.d) {
            this.d = false;
            if (this.a.b()) {
                this.b.setVisibility(0);
                a();
                return;
            }
            this.b.setVisibility(4);
        }
    }

    private void a() {
        if (this.a.c()) {
            this.b.setCurrentIndex(0);
        } else if (this.a.d()) {
            this.b.setCurrentIndex(5);
        } else {
            this.b.setCurrentIndex(Math.round((((float) this.a.getViewportBounds().centerX()) * 1.0f) / ((float) (this.a.getContentWidth() / 5))));
        }
    }
}
