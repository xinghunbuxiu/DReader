package com.duokan.reader.ui.general;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;

public class hs extends PagesController {
    public hs(IFeature mFeature) {
        super(mFeature);
    }

    /* renamed from: a */
    protected Animation mo1640a(AnimationType animationType, ActivatedController c0303e) {
        switch (ht.f7349a[animationType.ordinal()]) {
            case 1:
                return new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            case 2:
                return new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            default:
                return super.mo1640a(animationType, c0303e);
        }
    }
}
