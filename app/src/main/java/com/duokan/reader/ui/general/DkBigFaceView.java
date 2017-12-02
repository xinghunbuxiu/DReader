package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

import com.duokan.b.e;
import com.duokan.core.ui.dv;

public class DkBigFaceView extends bf {
    public DkBigFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, dv.b(context, 72.0f), dv.b(context, 72.0f));
        this.a.a(getResources().getDrawable(e.personal__shared__avatar));
        LayoutParams layoutParams = (LayoutParams) this.d.getLayoutParams();
        layoutParams.leftMargin = dv.b(context, 5.0f);
        layoutParams.rightMargin = dv.b(context, 5.0f);
        layoutParams.topMargin = dv.b(context, 5.0f);
        layoutParams.bottomMargin = dv.b(context, 5.0f);
        this.d.setLayoutParams(layoutParams);
        this.b.a(e.personal__shared__avatar);
        layoutParams = (LayoutParams) this.c.getLayoutParams();
        layoutParams.rightMargin = dv.b(context, 2.0f);
        layoutParams.bottomMargin = dv.b(context, 4.0f);
        this.c.setLayoutParams(layoutParams);
    }

    protected ImageView a(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(e.general__shared__vip_icon_normal);
        return imageView;
    }

    protected int getMiAccountDefaultFaceRes() {
        return e.personal__shared__avatar;
    }

    protected int getAnonymousAccountDefaultFaceRes() {
        return e.personal__shared__anonymous_avatar;
    }
}
