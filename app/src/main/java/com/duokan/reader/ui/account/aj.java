package com.duokan.reader.ui.account;

import android.content.Context;
import android.text.TextPaint;
import android.widget.LinearLayout;

import com.duokan.core.ui.UTools;

class aj extends LinearLayout {
    final /* synthetic */ ai a;

    aj(ai aiVar, Context context) {
        this.a = aiVar;
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.a.c.getMeasuredWidth() == 0) {
            TextPaint paint = this.a.c.getPaint();
            int ceil = (int) Math.ceil((double) paint.measureText(String.valueOf(this.a.c.getText())));
            if ((this.a.d.getMeasuredWidth() + ceil) + this.a.e.getMeasuredWidth() > getMeasuredWidth()) {
                int measuredWidth = (getMeasuredWidth() - this.a.d.getMeasuredWidth()) - this.a.e.getMeasuredWidth();
                int i3 = 15;
                while (ceil > measuredWidth && i3 > 12) {
                    paint.setTextSize((float) UTools.getMinimumHeight(getContext(), (float) i3));
                    ceil = (int) Math.ceil((double) paint.measureText(String.valueOf(this.a.c.getText())));
                    i3--;
                }
                this.a.c.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - this.a.d.getMeasuredWidth()) - this.a.e.getMeasuredWidth(), 1073741824), i2);
                return;
            }
            this.a.c.measure(MeasureSpec.makeMeasureSpec(ceil, 1073741824), i2);
            this.a.e.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - this.a.d.getMeasuredWidth()) - ceil, 1073741824), MeasureSpec.makeMeasureSpec(this.a.e.getMeasuredHeight(), Integer.MIN_VALUE));
        }
    }
}
