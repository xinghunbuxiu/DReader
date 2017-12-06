package com.duokan.reader.ui.reading;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.format.DateFormat;
import android.widget.FrameLayout;

import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.document.k;
import com.duokan.reader.domain.document.m;
import com.duokan.reader.ui.general.je;

public class gp extends FrameLayout {
    private final bc a;
    private final je b;
    private final sh c;
    private final BroadcastReceiver d = new gq(this);
    private final BroadcastReceiver e = new gr(this);
    private boolean f = true;

    public gp(Context context, sh shVar) {
        super(context);
        this.c = shVar;
        this.a = new bc(getContext());
        this.b = new je(getContext());
        this.b.a().setSubpixelText(true);
        this.b.a().setTextSize((float) shVar.getDocument().l().f);
        this.b.a().setAntiAlias(true);
        this.b.a(19);
        setWillNotDraw(false);
        setDrawingCacheEnabled(false);
        setAnimationCacheEnabled(false);
    }

    public void setStatusColor(int i) {
        this.b.a().setColor(i);
        this.a.b(i);
        invalidate();
    }

    public void setShowStatus(boolean z) {
        this.f = z;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().unregisterReceiver(this.d);
        getContext().unregisterReceiver(this.e);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getContext().registerReceiver(this.d, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        getContext().registerReceiver(this.e, new IntentFilter("android.intent.action.TIME_TICK"));
        a(getSystemTime());
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f && this.c != null && this.c.getDocument() != null) {
            k k = this.c.getDocument().k();
            m l = this.c.getDocument().l();
            if (!k.c() && !k.e) {
                if (k.c.bottom >= l.f) {
                    Rect rect = k.c;
                    int height = (getHeight() - getPaddingBottom()) - rect.bottom;
                    this.a.c(l.f - UTools.g(getContext(), 2.0f));
                    Rect rect2 = (Rect) UTools.g.getRect();
                    rect2.set(getPaddingLeft() + rect.left, height, (getPaddingLeft() + rect.left) + this.a.getIntrinsicWidth(), ((int) this.b.a().getTextSize()) + height);
                    Rect rect3 = (Rect) UTools.g.getRect();
                    rect3.set(rect2.right + UTools.getMinimumHeight(getContext(), 8.0f), height, (getWidth() - getPaddingRight()) - rect.right, ((int) this.b.a().getTextSize()) + height);
                    if (this.c.bf()) {
                        this.c.a(canvas, getWidth() / 2, height + (((int) this.b.a().getTextSize()) / 2), getHeight() - UTools.getMinimumHeight(getContext(), 65.0f), getHeight(), this.b.a().getColor());
                    }
                    this.a.setBounds(rect2);
                    this.a.draw(canvas);
                    this.b.setBounds(rect3);
                    this.b.draw(canvas);
                    UTools.g.getRect(rect3);
                    UTools.g.getRect(rect2);
                } else if (this.c.bf()) {
                    this.c.a(canvas, getWidth() / 2, getHeight() - (k.a().bottom / 2), getHeight() - UTools.getMinimumHeight(getContext(), 65.0f), getHeight(), this.b.a().getColor());
                }
            }
        }
    }

    protected void a(String str) {
        this.b.a(getSystemTime());
        invalidate();
    }

    protected void a(int i) {
        this.a.a(i);
        invalidate();
    }

    private String getSystemTime() {
        if (DateFormat.is24HourFormat(getContext())) {
            return (String) DateFormat.format("kk:mm", System.currentTimeMillis());
        }
        return (String) DateFormat.format("hh:mm", System.currentTimeMillis());
    }
}
