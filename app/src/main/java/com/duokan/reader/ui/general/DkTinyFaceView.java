package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0243e;

public class DkTinyFaceView extends bf {
    public DkTinyFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, AnimUtils.m1932b(context, 20.0f), AnimUtils.m1932b(context, 20.0f));
        this.a.m10568a(getResources().getDrawable(C0243e.personal__shared__avatar_small));
        LayoutParams layoutParams = (LayoutParams) this.d.getLayoutParams();
        layoutParams.leftMargin = AnimUtils.m1932b(context, 2.0f);
        layoutParams.rightMargin = AnimUtils.m1932b(context, 2.0f);
        layoutParams.topMargin = AnimUtils.m1932b(context, 2.0f);
        layoutParams.bottomMargin = AnimUtils.m1932b(context, 2.0f);
        this.d.setLayoutParams(layoutParams);
        this.b.m10713a(C0243e.personal__shared__avatar_small);
        layoutParams = (LayoutParams) this.c.getLayoutParams();
        layoutParams.bottomMargin = AnimUtils.m1932b(context, 2.0f);
        layoutParams.rightMargin = AnimUtils.m1932b(context, 3.0f);
        this.c.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    protected ImageView mo1731a(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(C0243e.general__shared__vip_icon_small);
        return imageView;
    }

    protected int getMiAccountDefaultFaceRes() {
        return C0243e.personal__shared__avatar_small;
    }

    protected int getAnonymousAccountDefaultFaceRes() {
        return C0243e.personal__shared__avatar_small;
    }
}
