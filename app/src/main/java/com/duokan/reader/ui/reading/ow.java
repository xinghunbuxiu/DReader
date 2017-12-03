package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.duokan.b.e;
import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.domain.document.aw;

public class ow extends fu {
    private final aw a;
    private final oy b = new oy(this, getContext());

    public ow(Context context, gn gnVar, aw awVar, Rect rect) {
        super(context, gnVar, rect, awVar);
        this.a = awVar;
        getWatchingView().a(this.b, new LayoutParams(-2, -2));
        setDrawBorder(false);
        View imageView = new ImageView(getContext());
        imageView.setScaleType(ScaleType.CENTER);
        imageView.setImageDrawable(getResources().getDrawable(e.reading__shared__expand_poster));
        imageView.setOnClickListener(new ox(this));
        Rect a = gnVar.h().a(this.a);
        int b = UTools.closeAnimation(context, 15.0f);
        View frameLayout = new FrameLayout(context);
        frameLayout.setPadding(b, b, (rect.right - a.right) + b, (rect.bottom - a.bottom) + b);
        frameLayout.addView(imageView, new LayoutParams(-2, -2));
        a(frameLayout, new LayoutParams(-2, -2, 85));
        n();
    }

    public fy a(au auVar) {
        return new pb(this, getContext());
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public void d() {
    }

    public void e() {
    }
}
