package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

import com.duokan.core.ui.Scrollable.OverScrollMode;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.fr;
import com.duokan.core.ui.ft;
import com.duokan.core.ui.fx;

public class WebView extends fr {
    private final jx b;
    private OverScrollMode c;
    private int d;

    public enum PullDownHeaderState {
        NONE,
        UNDOCKED,
        UNDOCKING,
        DOCKING,
        DOCKED
    }

    protected /* synthetic */ ft a(fx fxVar) {
        return b(fxVar);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new jx();
        this.c = OverScrollMode.ALWAYS;
        this.d = 0;
        this.c = super.getVerticalOverScrollMode();
    }

    public View getPullDownHeaderView() {
        return this.b.a;
    }

    public void setPullDownHeaderView(View view) {
        if (this.b.a != view) {
            if (this.b.a != null) {
                removeView(this.b.a);
                this.b.a = null;
            }
            this.b.a = view;
            if (this.b.a != null) {
                addView(this.b.a);
            }
        }
    }

    public boolean getPullDownHeaderDockable() {
        return this.b.c;
    }

    public void setPullDownHeaderDockable(boolean z) {
        if (this.b.c != z) {
            this.b.c = z;
            if (!this.b.c) {
                a(PullDownHeaderState.UNDOCKING);
                if (getScrollState() != ScrollState.DRAG) {
                    a();
                }
            }
        }
    }

    public void setPullDownHeaderDockableHeight(int i) {
        this.b.d = i;
    }

    public void i() {
        a(PullDownHeaderState.UNDOCKING);
        if (getScrollState() != ScrollState.DRAG) {
            a();
        }
    }

    public PullDownHeaderState getPullDownHeaderState() {
        return l();
    }

    public boolean j() {
        return k();
    }

    public void setOnPullDownHeaderStateChangedListener(jv jvVar) {
        this.b.e = jvVar;
    }

    private final boolean k() {
        if (this.b.a != null && (-getScrollY()) >= this.b.a.getHeight()) {
            return true;
        }
        return false;
    }

    private PullDownHeaderState l() {
        return this.b.a == null ? PullDownHeaderState.NONE : this.b.b;
    }

    private void a(PullDownHeaderState pullDownHeaderState) {
        if (this.b.b != pullDownHeaderState) {
            PullDownHeaderState pullDownHeaderState2 = this.b.b;
            if (pullDownHeaderState2 != PullDownHeaderState.DOCKING || pullDownHeaderState != PullDownHeaderState.UNDOCKED) {
                if (pullDownHeaderState2 != PullDownHeaderState.DOCKED || pullDownHeaderState != PullDownHeaderState.UNDOCKED) {
                    if (pullDownHeaderState2 != PullDownHeaderState.UNDOCKING || pullDownHeaderState != PullDownHeaderState.DOCKED) {
                        if (pullDownHeaderState2 != PullDownHeaderState.UNDOCKED || pullDownHeaderState != PullDownHeaderState.DOCKED) {
                            this.b.b = pullDownHeaderState;
                            if (this.b.e != null) {
                                this.b.e.a(this, pullDownHeaderState2, this.b.b);
                            }
                        }
                    }
                }
            }
        }
    }

    private int m() {
        if (getVerticalOverScrollMode() == OverScrollMode.NEVER) {
            return 0;
        }
        return this.b.d >= 0 ? Math.max(this.b.d, n()) : n();
    }

    private int n() {
        if (getVerticalOverScrollMode() == OverScrollMode.NEVER || this.b.a == null) {
            return 0;
        }
        return this.b.a.getHeight();
    }

    public OverScrollMode getVerticalOverScrollMode() {
        return this.c;
    }

    public void setVerticalOverScrollMode(OverScrollMode overScrollMode) {
        OverScrollMode overScrollMode2 = this.c;
        this.c = overScrollMode;
        if (super.getVerticalOverScrollMode() == overScrollMode2) {
            super.setVerticalOverScrollMode(this.c);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        if (this.b.a != null) {
            this.b.a.measure(MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.b.a != null) {
            this.b.a.layout(0, -this.b.a.getMeasuredHeight(), i3 - i, 0);
        }
    }

    protected jw b(fx fxVar) {
        return new jw(this, fxVar);
    }
}
