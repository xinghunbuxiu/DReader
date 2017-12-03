package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;

import com.duokan.b.e;
import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.document.c;
import com.duokan.reader.ui.general.DkNumView;

public class bk extends FrameLayout {
    private final DkNumView a;
    private final bl b;

    public bk(Context context, c cVar, int i) {
        super(context);
        setClipChildren(false);
        this.a = a(context);
        this.a.setText(Integer.toString(i));
        this.b = new bl(this, context, cVar);
        addView(this.a, new LayoutParams(-2, -2, 49));
        addView(this.b, new LayoutParams(-2, -2, 49));
        setShowTextView(false);
    }

    public void setShowTextView(boolean z) {
        int i;
        int i2 = 0;
        DkNumView dkNumView = this.a;
        if (z) {
            i = 4;
        } else {
            i = 0;
        }
        dkNumView.setVisibility(i);
        bl blVar = this.b;
        if (!z) {
            i2 = 4;
        }
        blVar.setVisibility(i2);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (view != this.a) {
            return super.drawChild(canvas, view, j);
        }
        canvas.save();
        canvas.translate(0.0f, (float) ((-view.getHeight()) / 2));
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }

    private DkNumView a(Context context) {
        DkNumView dkNumView = new DkNumView(context, null);
        dkNumView.setTextColor(-1);
        dkNumView.setGravity(17);
        dkNumView.setTextSize((float) UTools.closeAnimation(context, 8.0f));
        dkNumView.setBackgroundResource(e.reading__callout_indicator_view__item_bg_1);
        return dkNumView;
    }
}
