package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.duokan.core.ui.dv;
import com.duokan.p023b.C0243e;

public class DkBigFaceView extends bf {
    public DkBigFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, dv.m1932b(context, 72.0f), dv.m1932b(context, 72.0f));
        this.a.m10568a(getResources().getDrawable(C0243e.personal__shared__avatar));
        LayoutParams layoutParams = (LayoutParams) this.d.getLayoutParams();
        layoutParams.leftMargin = dv.m1932b(context, 5.0f);
        layoutParams.rightMargin = dv.m1932b(context, 5.0f);
        layoutParams.topMargin = dv.m1932b(context, 5.0f);
        layoutParams.bottomMargin = dv.m1932b(context, 5.0f);
        this.d.setLayoutParams(layoutParams);
        this.b.m10713a(C0243e.personal__shared__avatar);
        layoutParams = (LayoutParams) this.c.getLayoutParams();
        layoutParams.rightMargin = dv.m1932b(context, 2.0f);
        layoutParams.bottomMargin = dv.m1932b(context, 4.0f);
        this.c.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    protected ImageView mo1731a(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(C0243e.general__shared__vip_icon_normal);
        return imageView;
    }

    protected int getMiAccountDefaultFaceRes() {
        return C0243e.personal__shared__avatar;
    }

    protected int getAnonymousAccountDefaultFaceRes() {
        return C0243e.personal__shared__anonymous_avatar;
    }
}
