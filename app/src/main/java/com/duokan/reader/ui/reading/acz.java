package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;

import com.duokan.b.e;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ui.general.ep;

class acz extends FrameLayout {
    private final FrameLayout a;
    private final FrameLayout b;

    public acz(Context context, int i) {
        this(context, new ColorDrawable(i));
    }

    public acz(Context context, Drawable drawable) {
        super(context);
        this.a = new FrameLayout(context);
        View epVar = new ep(getContext());
        epVar.setBackgroundDrawable(drawable);
        epVar.setForeground(getResources().getDrawable(e.reading__color_view__mask_small));
        this.a.addView(epVar, new LayoutParams(UTools.closeAnimation(getContext(), 32.0f), UTools.closeAnimation(getContext(), 32.0f), 17));
        this.a.setForeground(getResources().getDrawable(e.reading__reading_options_view__icon_border_selected));
        this.a.setForegroundGravity(17);
        addView(this.a);
        this.b = new FrameLayout(context);
        epVar = new ep(getContext());
        epVar.setBackgroundDrawable(drawable);
        epVar.setForeground(getResources().getDrawable(e.reading__color_view__mask));
        this.b.addView(epVar, new LayoutParams(UTools.closeAnimation(getContext(), 32.0f), UTools.closeAnimation(getContext(), 32.0f), 17));
        addView(this.b);
    }

    public void setSelected(boolean z) {
        int i;
        int i2 = 4;
        super.setSelected(z);
        FrameLayout frameLayout = this.a;
        if (z) {
            i = 0;
        } else {
            i = 4;
        }
        frameLayout.setVisibility(i);
        FrameLayout frameLayout2 = this.b;
        if (!z) {
            i2 = 0;
        }
        frameLayout2.setVisibility(i2);
    }
}
