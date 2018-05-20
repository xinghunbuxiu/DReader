package com.duokan.reader.ui.general;

import android.view.MotionEvent;
import android.view.ViewGroup;

import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.fv;
import com.duokan.reader.ui.general.WebView.PullDownHeaderState;

public class jg extends fv {
    /* renamed from: b */
    final /* synthetic */ WebView f7431b;

    public jg(WebView webView, ViewGroup viewGroup) {
        this.f7431b = webView;
        super(webView, viewGroup);
    }

    /* renamed from: a */
    protected void mo502a(MotionEvent motionEvent) {
        super.mo502a(motionEvent);
        if (motionEvent.getActionMasked() == 0) {
            if (this.f7431b.f6886b.f7432a == null || !this.f7431b.f6886b.f7434c) {
                super.setVerticalOverScrollMode(this.f7431b.f6887c);
            } else {
                super.setVerticalOverScrollMode(OverScrollMode.ALWAYS);
            }
        } else if (motionEvent.getActionMasked() != 1 && motionEvent.getActionMasked() == 3) {
        }
    }

    /* renamed from: a */
    protected void mo501a(float f, float f2) {
        this.f7431b.f6888d = (int) (((float) this.f7431b.f6888d) + f2);
        if (Math.abs(this.f7431b.f6888d) > AnimUtils.getScaledTouchSlop(this.f7431b.getContext())) {
            if (this.f7431b.f6886b.f7432a == null) {
                this.f7431b.m10177a(PullDownHeaderState.NONE);
            } else if (!this.f7431b.f6886b.f7434c) {
                this.f7431b.m10177a(PullDownHeaderState.UNDOCKED);
            } else if (this.f7431b.f6888d > 0) {
                if (this.f7431b.mo1822k()) {
                    this.f7431b.m10177a(PullDownHeaderState.DOCKING);
                } else {
                    this.f7431b.m10177a(PullDownHeaderState.UNDOCKING);
                }
            } else if (this.f7431b.f6888d < 0) {
                this.f7431b.m10177a(PullDownHeaderState.UNDOCKING);
            }
            this.f7431b.f6888d = 0;
        }
        int min = Math.min(0, m1553k().top);
        if (Float.compare(((float) getViewportBounds().top) - f2, (float) min) >= 0) {
            super.setVerticalOverScrollMode(this.f7431b.f6887c);
        } else if (Float.compare(((float) getViewportBounds().top) - f2, (float) min) < 0 && this.f7431b.f6886b.f7432a != null && this.f7431b.f6886b.f7434c) {
            super.setVerticalOverScrollMode(OverScrollMode.ALWAYS);
        }
        super.mo501a(f, f2);
    }

    /* renamed from: a */
    protected void mo494a(ScrollState scrollState, ScrollState scrollState2) {
        super.mo494a(scrollState, scrollState2);
        if (scrollState2 == ScrollState.IDLE) {
            if (this.f7431b.f6886b.f7433b == PullDownHeaderState.DOCKING) {
                this.f7431b.m10177a(PullDownHeaderState.DOCKED);
            } else if (this.f7431b.f6886b.f7433b == PullDownHeaderState.UNDOCKING) {
                this.f7431b.m10177a(PullDownHeaderState.UNDOCKED);
            }
        }
        if (scrollState == ScrollState.DRAG) {
            this.f7431b.f6888d = 0;
            if (this.f7431b.f6886b.f7432a == null) {
                this.f7431b.m10177a(PullDownHeaderState.NONE);
            } else if (!this.f7431b.f6886b.f7434c) {
                this.f7431b.m10177a(PullDownHeaderState.UNDOCKED);
            } else if (!this.f7431b.mo1822k()) {
                this.f7431b.m10177a(PullDownHeaderState.UNDOCKING);
            }
        }
    }

    /* renamed from: a */
    protected int mo500a() {
        if (!this.f7431b.f6886b.f7434c) {
            return super.mo500a();
        }
        if (this.f7431b.f6886b.f7433b == PullDownHeaderState.DOCKED || this.f7431b.f6886b.f7433b == PullDownHeaderState.DOCKING) {
            return (this.f7431b.m10187n() - this.f7431b.m10186m()) + super.mo500a();
        }
        return this.f7431b.m10187n() + super.mo500a();
    }

    /* renamed from: b */
    protected int mo504b() {
        if (this.f7431b.f6886b.f7433b == PullDownHeaderState.DOCKED || this.f7431b.f6886b.f7433b == PullDownHeaderState.DOCKING) {
            return super.mo504b() - this.f7431b.m10186m();
        }
        return super.mo504b();
    }
}
