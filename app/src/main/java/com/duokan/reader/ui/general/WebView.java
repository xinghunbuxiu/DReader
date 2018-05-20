package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.duokan.core.ui.fr;
import com.duokan.core.ui.fv;
import com.duokan.core.ui.DkWebView;

public class WebView extends fr {
    /* renamed from: b */
    private final jh f6886b;
    /* renamed from: c */
    private OverScrollMode f6887c;
    /* renamed from: d */
    private int f6888d;

    public enum PullDownHeaderState {
        NONE,
        UNDOCKED,
        UNDOCKING,
        DOCKING,
        DOCKED
    }

    /* renamed from: a */
    protected /* synthetic */ fv mo1744a(DkWebView webView) {
        return mo1816b(webView);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6886b = new jh();
        this.f6887c = OverScrollMode.ALWAYS;
        this.f6888d = 0;
        this.f6887c = super.getVerticalOverScrollMode();
    }

    public View getPullDownHeaderView() {
        return this.f6886b.f7432a;
    }

    public void setPullDownHeaderView(View view) {
        if (this.f6886b.f7432a != view) {
            if (this.f6886b.f7432a != null) {
                removeView(this.f6886b.f7432a);
                this.f6886b.f7432a = null;
            }
            this.f6886b.f7432a = view;
            if (this.f6886b.f7432a != null) {
                addView(this.f6886b.f7432a);
            }
        }
    }

    public boolean getPullDownHeaderDockable() {
        return this.f6886b.f7434c;
    }

    public void setPullDownHeaderDockable(boolean z) {
        if (this.f6886b.f7434c != z) {
            this.f6886b.f7434c = z;
            if (!this.f6886b.f7434c) {
                m10177a(PullDownHeaderState.UNDOCKING);
                if (getScrollState() != ScrollState.DRAG) {
                    m2110a();
                }
            }
        }
    }

    public void setPullDownHeaderDockableHeight(int i) {
        this.f6886b.f7435d = i;
    }

    /* renamed from: i */
    public void m10190i() {
        m10177a(PullDownHeaderState.UNDOCKING);
        if (getScrollState() != ScrollState.DRAG) {
            m2110a();
        }
    }

    public PullDownHeaderState getPullDownHeaderState() {
        return m10185l();
    }

    /* renamed from: j */
    public boolean m10191j() {
        return mo1822k();
    }

    public void setOnPullDownHeaderStateChangedListener(jf jfVar) {
        this.f6886b.f7436e = jfVar;
    }

    /* renamed from: k */
    private final boolean mo1822k() {
        if (this.f6886b.f7432a != null && (-getScrollY()) >= this.f6886b.f7432a.getHeight()) {
            return true;
        }
        return false;
    }

    /* renamed from: l */
    private PullDownHeaderState m10185l() {
        return this.f6886b.f7432a == null ? PullDownHeaderState.NONE : this.f6886b.f7433b;
    }

    /* renamed from: a */
    private void m10177a(PullDownHeaderState pullDownHeaderState) {
        if (this.f6886b.f7433b != pullDownHeaderState) {
            PullDownHeaderState pullDownHeaderState2 = this.f6886b.f7433b;
            if (pullDownHeaderState2 != PullDownHeaderState.DOCKING || pullDownHeaderState != PullDownHeaderState.UNDOCKED) {
                if (pullDownHeaderState2 != PullDownHeaderState.DOCKED || pullDownHeaderState != PullDownHeaderState.UNDOCKED) {
                    if (pullDownHeaderState2 != PullDownHeaderState.UNDOCKING || pullDownHeaderState != PullDownHeaderState.DOCKED) {
                        if (pullDownHeaderState2 != PullDownHeaderState.UNDOCKED || pullDownHeaderState != PullDownHeaderState.DOCKED) {
                            this.f6886b.f7433b = pullDownHeaderState;
                            if (this.f6886b.f7436e != null) {
                                this.f6886b.f7436e.m10845a(this, pullDownHeaderState2, this.f6886b.f7433b);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: m */
    private int m10186m() {
        if (getVerticalOverScrollMode() == OverScrollMode.NEVER) {
            return 0;
        }
        return this.f6886b.f7435d >= 0 ? Math.max(this.f6886b.f7435d, m10187n()) : m10187n();
    }

    /* renamed from: n */
    private int m10187n() {
        if (getVerticalOverScrollMode() == OverScrollMode.NEVER || this.f6886b.f7432a == null) {
            return 0;
        }
        return this.f6886b.f7432a.getHeight();
    }

    public OverScrollMode getVerticalOverScrollMode() {
        return this.f6887c;
    }

    public void setVerticalOverScrollMode(OverScrollMode overScrollMode) {
        OverScrollMode overScrollMode2 = this.f6887c;
        this.f6887c = overScrollMode;
        if (super.getVerticalOverScrollMode() == overScrollMode2) {
            super.setVerticalOverScrollMode(this.f6887c);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        if (this.f6886b.f7432a != null) {
            this.f6886b.f7432a.measure(MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f6886b.f7432a != null) {
            this.f6886b.f7432a.layout(0, -this.f6886b.f7432a.getMeasuredHeight(), i3 - i, 0);
        }
    }

    /* renamed from: b */
    protected jg mo1816b(DkWebView webView) {
        return new jg(this, webView);
    }
}
