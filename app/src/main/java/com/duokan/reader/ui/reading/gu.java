package com.duokan.reader.ui.reading;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.format.DateFormat;
import android.widget.FrameLayout;
import com.duokan.core.ui.dv;
import com.duokan.reader.domain.document.C0917k;
import com.duokan.reader.domain.document.C0923m;
import com.duokan.reader.ui.general.io;

public class gu extends FrameLayout {
    /* renamed from: a */
    private final bc f10271a;
    /* renamed from: b */
    private final io f10272b;
    /* renamed from: c */
    private final su f10273c;
    /* renamed from: d */
    private final BroadcastReceiver f10274d = new gv(this);
    /* renamed from: e */
    private final BroadcastReceiver f10275e = new gw(this);
    /* renamed from: f */
    private boolean f10276f = true;

    public gu(Context context, su suVar) {
        super(context);
        this.f10273c = suVar;
        this.f10271a = new bc(getContext());
        this.f10272b = new io(getContext());
        this.f10272b.m10797a().setSubpixelText(true);
        this.f10272b.m10797a().setTextSize((float) suVar.getDocument().mo1246l().f4358f);
        this.f10272b.m10797a().setAntiAlias(true);
        this.f10272b.m10798a(19);
        setWillNotDraw(false);
        setDrawingCacheEnabled(false);
        setAnimationCacheEnabled(false);
    }

    public void setStatusColor(int i) {
        this.f10272b.m10797a().setColor(i);
        this.f10271a.m13767b(i);
        invalidate();
    }

    public void setShowStatus(boolean z) {
        this.f10276f = z;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().unregisterReceiver(this.f10274d);
        getContext().unregisterReceiver(this.f10275e);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getContext().registerReceiver(this.f10274d, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        getContext().registerReceiver(this.f10275e, new IntentFilter("android.intent.action.TIME_TICK"));
        m14268a(getSystemTime());
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f10276f && this.f10273c != null && this.f10273c.getDocument() != null) {
            C0917k k = this.f10273c.getDocument().mo1245k();
            C0923m l = this.f10273c.getDocument().mo1246l();
            if (!k.mo1274c() && !k.f4334e) {
                if (k.f4332c.bottom >= l.f4358f) {
                    Rect rect = k.f4332c;
                    int height = (getHeight() - getPaddingBottom()) - rect.bottom;
                    this.f10271a.m13768c(l.f4358f - dv.m1963g(getContext(), 2.0f));
                    Rect rect2 = (Rect) dv.f1198g.addAnimation();
                    rect2.set(getPaddingLeft() + rect.left, height, (getPaddingLeft() + rect.left) + this.f10271a.getIntrinsicWidth(), ((int) this.f10272b.m10797a().getTextSize()) + height);
                    Rect rect3 = (Rect) dv.f1198g.addAnimation();
                    rect3.set(rect2.right + dv.m1932b(getContext(), 8.0f), height, (getWidth() - getPaddingRight()) - rect.right, ((int) this.f10272b.m10797a().getTextSize()) + height);
                    if (this.f10273c.bg()) {
                        this.f10273c.mo2017a(canvas, getWidth() / 2, height + (((int) this.f10272b.m10797a().getTextSize()) / 2), getHeight() - dv.m1932b(getContext(), 65.0f), getHeight(), this.f10272b.m10797a().getColor());
                    }
                    this.f10271a.setBounds(rect2);
                    this.f10271a.draw(canvas);
                    this.f10272b.setBounds(rect3);
                    this.f10272b.draw(canvas);
                    dv.f1198g.clearAnimation(rect3);
                    dv.f1198g.clearAnimation(rect2);
                } else if (this.f10273c.bg()) {
                    this.f10273c.mo2017a(canvas, getWidth() / 2, getHeight() - (k.m6083a().bottom / 2), getHeight() - dv.m1932b(getContext(), 65.0f), getHeight(), this.f10272b.m10797a().getColor());
                }
            }
        }
    }

    /* renamed from: a */
    protected void m14268a(String str) {
        this.f10272b.m10799a(getSystemTime());
        invalidate();
    }

    /* renamed from: a */
    protected void m14267a(int i) {
        this.f10271a.m13766a(i);
        invalidate();
    }

    private String getSystemTime() {
        if (DateFormat.is24HourFormat(getContext())) {
            return (String) DateFormat.format("kk:mm", System.currentTimeMillis());
        }
        return (String) DateFormat.format("hh:mm", System.currentTimeMillis());
    }
}
