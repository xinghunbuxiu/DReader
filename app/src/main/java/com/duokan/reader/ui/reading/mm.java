package com.duokan.reader.ui.reading;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.duokan.b.d;
import com.duokan.reader.ui.general.DkLabelView;

class mm extends FrameLayout {
    final /* synthetic */ mh a;
    private DkLabelView b;
    private ImageView c;

    public mm(mh mhVar, Context context) {
        this.a = mhVar;
        super(context);
    }

    public void a(String str) {
        b().setText(str);
    }

    public void a(int i) {
        b().setTextColor(i);
    }

    public void b(int i) {
        a().setImageResource(i);
    }

    public void a(boolean z) {
        a().setAdjustViewBounds(z);
    }

    private ImageView a() {
        if (this.c == null) {
            this.c = new ImageView(getContext());
            this.c.setScaleType(ScaleType.FIT_CENTER);
            a().setAdjustViewBounds(true);
            addView(this.c, new LayoutParams(-2, -1, 17));
        }
        return this.c;
    }

    private DkLabelView b() {
        if (this.b == null) {
            this.b = new DkLabelView(getContext());
            this.b.setTextSize(0, getResources().getDimension(d.general_font__shared__e));
            this.b.setTextColor(-16777216);
            this.b.setGravity(17);
            addView(this.b, new LayoutParams(-2, -1, 17));
        }
        return this.b;
    }
}
