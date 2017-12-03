package com.duokan.reader.ui.general;

import android.view.MotionEvent;
import android.view.ViewGroup;

import com.duokan.core.ui.UTools;
import com.duokan.core.ui.ft;
import com.duokan.reader.ui.general.WebView.PullDownHeaderState;

public class jw extends ft {
    final /* synthetic */ WebView b;

    public jw(WebView webView, ViewGroup viewGroup) {
        this.b = webView;
        super(webView, viewGroup);
    }

    protected void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        if (motionEvent.getActionMasked() == 0) {
            if (this.b.b.a == null || !this.b.b.c) {
                super.b(this.b.c);
            } else {
                super.b(OverScrollMode.ALWAYS);
            }
        } else if (motionEvent.getActionMasked() != 1 && motionEvent.getActionMasked() == 3) {
        }
    }

    protected void a(float f, float f2) {
        this.b.d = (int) (((float) this.b.d) + f2);
        if (Math.abs(this.b.d) > UTools.getScaledTouchSlop(this.b.getContext())) {
            if (this.b.b.a == null) {
                this.b.a(PullDownHeaderState.NONE);
            } else if (!this.b.b.c) {
                this.b.a(PullDownHeaderState.UNDOCKED);
            } else if (this.b.d > 0) {
                if (this.b.k()) {
                    this.b.a(PullDownHeaderState.DOCKING);
                } else {
                    this.b.a(PullDownHeaderState.UNDOCKING);
                }
            } else if (this.b.d < 0) {
                this.b.a(PullDownHeaderState.UNDOCKING);
            }
            this.b.d = 0;
        }
        int min = Math.min(0, k().top);
        if (Float.compare(((float) getViewportBounds().top) - f2, (float) min) >= 0) {
            super.b(this.b.c);
        } else if (Float.compare(((float) getViewportBounds().top) - f2, (float) min) < 0 && this.b.b.a != null && this.b.b.c) {
            super.b(OverScrollMode.ALWAYS);
        }
        super.a(f, f2);
    }

    protected void a(ScrollState scrollState, ScrollState scrollState2) {
        super.a(scrollState, scrollState2);
        if (scrollState2 == ScrollState.IDLE) {
            if (this.b.b.b == PullDownHeaderState.DOCKING) {
                this.b.a(PullDownHeaderState.DOCKED);
            } else if (this.b.b.b == PullDownHeaderState.UNDOCKING) {
                this.b.a(PullDownHeaderState.UNDOCKED);
            }
        }
        if (scrollState == ScrollState.DRAG) {
            this.b.d = 0;
            if (this.b.b.a == null) {
                this.b.a(PullDownHeaderState.NONE);
            } else if (!this.b.b.c) {
                this.b.a(PullDownHeaderState.UNDOCKED);
            } else if (!this.b.k()) {
                this.b.a(PullDownHeaderState.UNDOCKING);
            }
        }
    }

    protected int a() {
        if (!this.b.b.c) {
            return super.a();
        }
        if (this.b.b.b == PullDownHeaderState.DOCKED || this.b.b.b == PullDownHeaderState.DOCKING) {
            return (this.b.n() - this.b.m()) + super.a();
        }
        return this.b.n() + super.a();
    }

    protected int b() {
        if (this.b.b.b == PullDownHeaderState.DOCKED || this.b.b.b == PullDownHeaderState.DOCKING) {
            return super.b() - this.b.m();
        }
        return super.b();
    }
}
