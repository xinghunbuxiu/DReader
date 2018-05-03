package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.duokan.core.sys.UThread;
import com.duokan.core.ui.AnimUtils;


public abstract class C1283z extends Drawable {
    
    protected static final int f6097b = ((int) Math.round(76.5d));
    
    private int alpha = 255;
    
    protected final Context context;
    
    protected final ab mDrawable;
    
    protected final Rect oldBounds = new Rect();
    
    protected final Rect mBounds = new Rect();
    
    protected boolean f6103g = false;
    
    private final Callback callback = new Callback() {
        @Override
        public void invalidateDrawable(@NonNull Drawable who) {
            invalidateSelf();
        }

        @Override
        public void scheduleDrawable(@NonNull Drawable who, @NonNull Runnable what, long when) {
            UThread.postDelayed(what, when);
        }

        @Override
        public void unscheduleDrawable(@NonNull Drawable who, @NonNull Runnable what) {
            UThread.removeCallbacks(what);

        }
    };

    public C1283z(Context context, boolean z) {
        this.context = context;
        int b = AnimUtils.m1932b(this.context, 5.0f);
        this.oldBounds.set(b, b, b, b);
        this.mDrawable = new ab(this);
        this.mDrawable.setCallback(this.callback);
        this.mDrawable.getPadding(this.mBounds);
        this.f6103g = z;
    }

    
    public void m9130f() {
        this.mDrawable.m10213b();
    }

    
    public void reset() {
        this.mDrawable.reset();
    }

    
    protected void m9129a(boolean z) {
        this.f6103g = z;
    }

    @Override
    public boolean getPadding(Rect rect) {
        if (this.f6103g) {
            rect.set(this.mBounds);
        }
        return !rect.isEmpty();
    }

    @Override
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.mDrawable.setBounds(getBounds());
    }

    @Override
    public void draw(Canvas canvas) {
        if (this.f6103g || this.mDrawable.m10212a()) {
            canvas.save();
            this.mDrawable.draw(canvas);
            canvas.restore();
        }
    }

    @Override
    public void setAlpha(int alpha) {
        this.mDrawable.setAlpha(alpha);
    }
}
