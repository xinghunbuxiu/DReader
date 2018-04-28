package com.duokan.core.sys;

import java.util.ArrayList;

public abstract class BaseAnimation<T> {
    static final boolean assertionStatus = (!BaseAnimation.class.desiredAssertionStatus());
    private final ArrayList<T> animations = new ArrayList(10);
    private int oldP = 0;
    private int p = 0;

    protected abstract T createAnimation();

    protected abstract void destroyAnimation(T t);

    public T addAnimation() {
        if (this.oldP >= this.p - 1) {
            this.animations.add(createAnimation());
            this.p++;
        }
        this.oldP = oldP + 1;
        return animations.get(oldP);
    }

    public void clearAnimation(T t) {
        int preP = this.p - 1;
        while (preP >= 0 && this.animations.get(preP) != t) {
            preP--;
        }
        if (!assertionStatus && preP < 0) {
            throw new AssertionError();
        } else if (preP >= 0) {
            destroyAnimation(t);
            if (preP != this.oldP - 1) {
                T obj = this.animations.get(preP);
                this.animations.set(preP, this.animations.get(this.oldP - 1));
                this.animations.set(this.oldP - 1, obj);
            }
            this.oldP--;
        }
    }
}
