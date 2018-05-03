package com.duokan.reader.ui.account;

import android.content.Context;
import android.text.TextPaint;
import android.widget.LinearLayout;
import com.duokan.core.ui.AnimUtils;

/* renamed from: com.duokan.reader.ui.account.w */
class C1271w extends LinearLayout {
    /* renamed from: a */
    final /* synthetic */ C1270v f5992a;

    C1271w(C1270v c1270v, Context context) {
        this.f5992a = c1270v;
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f5992a.f5981c.getMeasuredWidth() == 0) {
            TextPaint paint = this.f5992a.f5981c.getPaint();
            int ceil = (int) Math.ceil((double) paint.measureText(String.valueOf(this.f5992a.f5981c.getText())));
            if ((this.f5992a.f5982d.getMeasuredWidth() + ceil) + this.f5992a.f5983e.getMeasuredWidth() > getMeasuredWidth()) {
                int measuredWidth = (getMeasuredWidth() - this.f5992a.f5982d.getMeasuredWidth()) - this.f5992a.f5983e.getMeasuredWidth();
                int i3 = 15;
                while (ceil > measuredWidth && i3 > 12) {
                    paint.setTextSize((float) AnimUtils.m1932b(getContext(), (float) i3));
                    ceil = (int) Math.ceil((double) paint.measureText(String.valueOf(this.f5992a.f5981c.getText())));
                    i3--;
                }
                this.f5992a.f5981c.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - this.f5992a.f5982d.getMeasuredWidth()) - this.f5992a.f5983e.getMeasuredWidth(), 1073741824), i2);
                return;
            }
            this.f5992a.f5981c.measure(MeasureSpec.makeMeasureSpec(ceil, 1073741824), i2);
            this.f5992a.f5983e.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - this.f5992a.f5982d.getMeasuredWidth()) - ceil, 1073741824), MeasureSpec.makeMeasureSpec(this.f5992a.f5983e.getMeasuredHeight(), Integer.MIN_VALUE));
        }
    }
}
