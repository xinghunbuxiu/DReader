package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0243e;
import com.duokan.reader.domain.document.C0931c;
import com.duokan.reader.ui.general.DkNumView;

public class bk extends FrameLayout {
    /* renamed from: a */
    private final DkNumView f9855a;
    /* renamed from: b */
    private final bl f9856b;

    public bk(Context context, C0931c c0931c, int i) {
        super(context);
        setClipChildren(false);
        this.f9855a = m13798a(context);
        this.f9855a.setText(Integer.toString(i));
        this.f9856b = new bl(this, context, c0931c);
        addView(this.f9855a, new LayoutParams(-2, -2, 49));
        addView(this.f9856b, new LayoutParams(-2, -2, 49));
        setShowTextView(false);
    }

    public void setShowTextView(boolean z) {
        int i;
        int i2 = 0;
        DkNumView dkNumView = this.f9855a;
        if (z) {
            i = 4;
        } else {
            i = 0;
        }
        dkNumView.setVisibility(i);
        bl blVar = this.f9856b;
        if (!z) {
            i2 = 4;
        }
        blVar.setVisibility(i2);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (view != this.f9855a) {
            return super.drawChild(canvas, view, j);
        }
        canvas.save();
        canvas.translate(0.0f, (float) ((-view.getHeight()) / 2));
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }

    /* renamed from: a */
    private DkNumView m13798a(Context context) {
        DkNumView dkNumView = new DkNumView(context, null);
        dkNumView.setTextColor(-1);
        dkNumView.setGravity(17);
        dkNumView.setTextSize((float) dv.m1932b(context, 8.0f));
        dkNumView.setBackgroundResource(C0243e.reading__callout_indicator_view__item_bg_1);
        return dkNumView;
    }
}
