package com.duokan.core.ui;

import android.view.animation.Transformation;

import com.duokan.core.sys.BaseAnimation;

final class ei extends BaseAnimation<Transformation> {
    ei() {
    }

    protected Transformation createAnimation() {
        return getTransformation();
    }

    protected void destroyAnimation(Transformation transformation) {
        transformation.clear();
    }


    protected Transformation getTransformation() {
        return new Transformation();
    }


}
