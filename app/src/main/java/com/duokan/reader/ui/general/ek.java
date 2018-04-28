package com.duokan.reader.ui.general;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;

public class ek extends PagesController {
    public ek(IFeature mFeature) {
        super(mFeature);
    }

    /* renamed from: a */
    protected Animation mo1640a(AnimationType animationType, ActivatedController c0303e) {
        switch (el.f7154a[animationType.ordinal()]) {
            case 1:
                return new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            case 2:
                return new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            case 3:
                return new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
            case 4:
                return new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            default:
                return super.mo1640a(animationType, c0303e);
        }
    }

    /* renamed from: a */
    protected Animation mo1639a(AnimationType animationType) {
        switch (el.f7154a[animationType.ordinal()]) {
            case 1:
                return new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            case 2:
                return new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            case 3:
                return new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
            case 4:
                return new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            default:
                return super.mo1639a(animationType);
        }
    }
}
