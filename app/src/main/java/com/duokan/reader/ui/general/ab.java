package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;

import com.duokan.core.sys.UThread;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0243e;
import com.duokan.reader.ui.general.DkSimulationInterpolator.Mode;

final class ab extends Drawable {

    final C1283z f6901a;

    private final Drawable drawable;

    private final Rect mBounds = new Rect(0, 0, 0, 0);

    private AlphaAnimation alphaAnimation = null;

    private int f6905e = 0;

    private int f6906f = 0;

    private boolean f6907g = false;

    private int alpha = 255;

    public ab(C1283z c1283z) {
        this.f6901a = c1283z;
        this.drawable = cn.m10370a(c1283z.context, C0243e.general__shared__book_category_shadow);
    }


    public boolean m10212a() {
        return this.f6907g;
    }


    public void m10213b() {
        this.f6907g = true;
        m10205a(this.mBounds.width(), (this.mBounds.width() + this.f6901a.oldBounds.left) + this.f6901a.oldBounds.right, this.mBounds.height(), (this.mBounds.height() + this.f6901a.oldBounds.top) + this.f6901a.oldBounds.bottom);
    }


    public void reset() {
        m10205a((this.mBounds.width() + this.f6901a.oldBounds.left) + this.f6901a.oldBounds.right, this.mBounds.width(), (this.mBounds.height() + this.f6901a.oldBounds.top) + this.f6901a.oldBounds.bottom, this.mBounds.height());
    }

    public boolean getPadding(Rect rect) {
        if (this.drawable != null) {
            return this.drawable.getPadding(rect);
        }
        return false;
    }

    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        this.mBounds.set(getBounds());
    }

    @Override
    public void draw(Canvas canvas) {
        if (this.drawable != null) {
            int i;
            int i2;
            if (this.f6905e != 0) {
                i = this.f6905e;
                i2 = this.f6906f;
            } else {
                i = this.mBounds.width();
                i2 = this.mBounds.height();
            }
            canvas.save();
            int width = (this.mBounds.width() - i) / 2;
            int height = (this.mBounds.height() - i2) / 2;
            Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
            rect.set(width, height, i + width, i2 + height);
            this.drawable.setBounds(rect);
            this.drawable.draw(canvas);
            canvas.restore();
            AnimUtils.f1198g.clearAnimation(rect);
        }
    }

    public void setAlpha(int alpha) {
        if (this.alpha != alpha && this.drawable != null) {
            this.alpha = alpha;
            this.drawable.setAlpha(alpha);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }


    private void m10205a(int i, int i2, int i3, int i4) {
        this.alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.alphaAnimation.setFillEnabled(true);
        this.alphaAnimation.setFillAfter(true);
        this.alphaAnimation.setDuration(250);
        this.alphaAnimation.setInterpolator(new DkSimulationInterpolator(Mode.ACCELERATE));
        Runnable acVar = new Runnable() {
            @Override
            public void run() {
                if (!hasEnded() && f6905e != this.f6910b) {
                    this.f6914f.f6904d.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.f6909a);
                    this.f6914f.f6905e = Math.round((((float) (this.f6910b - this.f6911c)) * this.f6909a.getAlpha()) + ((float) this.f6911c));
                    this.f6914f.f6906f = Math.round((((float) (this.f6912d - this.f6913e)) * this.f6909a.getAlpha()) + ((float) this.f6913e));
                    this.f6914f.invalidateSelf();
                    UThread.post((Runnable) this);
                } else if (this.f6914f.f6907g && this.f6911c > this.f6910b) {
                    this.f6914f.f6907g = this.f6910b > this.f6911c;
                    this.f6914f.m10210d();
                    this.f6914f.invalidateSelf();
                }
            }
        };
        this.alphaAnimation.start();
        UThread.runOnThread(acVar);
    }


    private void m10210d() {
        this.f6906f = 0;
        this.f6905e = 0;
    }
}
