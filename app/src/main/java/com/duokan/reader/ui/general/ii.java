package com.duokan.reader.ui.general;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;

public class ii extends PagesController {
    public ii(IFeature featrue) {
        super(featrue);
    }

    protected Animation a(AnimationType animationType, ActivatedController controller) {
        switch (ij.a[animationType.ordinal()]) {
            case 1:
                return new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            case 2:
                return new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            default:
                return super.a(animationType, controller);
        }
    }
}
