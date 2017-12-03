package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.duokan.b.e;
import com.duokan.core.ui.UTools;

public class DkTinyFaceView extends bf {
    public DkTinyFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, UTools.closeAnimation(context, 20.0f), UTools.closeAnimation(context, 20.0f));
        this.a.a(getResources().getDrawable(e.personal__shared__avatar_small));
        LayoutParams layoutParams = (LayoutParams) this.d.getLayoutParams();
        layoutParams.leftMargin = UTools.closeAnimation(context, 2.0f);
        layoutParams.rightMargin = UTools.closeAnimation(context, 2.0f);
        layoutParams.topMargin = UTools.closeAnimation(context, 2.0f);
        layoutParams.bottomMargin = UTools.closeAnimation(context, 2.0f);
        this.d.setLayoutParams(layoutParams);
        this.b.a(e.personal__shared__avatar_small);
        layoutParams = (LayoutParams) this.c.getLayoutParams();
        layoutParams.bottomMargin = UTools.closeAnimation(context, 2.0f);
        layoutParams.rightMargin = UTools.closeAnimation(context, 3.0f);
        this.c.setLayoutParams(layoutParams);
    }

    protected ImageView a(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(e.general__shared__vip_icon_small);
        return imageView;
    }

    protected int getMiAccountDefaultFaceRes() {
        return e.personal__shared__avatar_small;
    }

    protected int getAnonymousAccountDefaultFaceRes() {
        return e.personal__shared__avatar_small;
    }
}
