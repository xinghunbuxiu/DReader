package com.duokan.reader.ui.general;

import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.MyExtendView;

class hf extends hj {
    final /* synthetic */ hd a;
    private final MyExtendView c = new MyExtendView(getContext());

    public hf(hd hdVar, IFeature featrue, ActivatedController activatedControllerVar, int i, int i2) {
        this.a = hdVar;
        super(hdVar, featrue, activatedControllerVar);
        this.c.setIndicator(com.duokan.b.e.general__shared__balloon_indicator);
        this.c.setBackgroundResource(com.duokan.b.e.general__shared__balloon_background);
        this.c.setIndicatorMargin(UTools.closeAnimation(getContext(), 5.0f));
        this.c.addView(b());
        LayoutParams marginLayoutParams = new MarginLayoutParams(-2, -2);
        switch (i) {
            case 3:
                this.c.setGravity(5);
                marginLayoutParams.rightMargin = i2;
                break;
            case 5:
                this.c.setGravity(3);
                marginLayoutParams.leftMargin = i2;
                break;
            case j.a /*48*/:
                this.c.setGravity(80);
                marginLayoutParams.bottomMargin = i2;
                break;
            case 80:
                this.c.setGravity(48);
                marginLayoutParams.topMargin = i2;
                break;
            default:
                this.c.setGravity(17);
                marginLayoutParams.bottomMargin = i2;
                marginLayoutParams.rightMargin = i2;
                marginLayoutParams.topMargin = i2;
                marginLayoutParams.leftMargin = i2;
                break;
        }
        this.c.setLayoutParams(marginLayoutParams);
        this.c.setClickable(true);
        this.c.setEnabled(false);
        setContentView(this.c);
        addSubController(a());
        activate(a());
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        this.c.removeAllViews();
    }
}
