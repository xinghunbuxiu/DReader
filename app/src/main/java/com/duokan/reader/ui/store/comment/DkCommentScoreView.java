package com.duokan.reader.ui.store.comment;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.duokan.b.e;
import com.duokan.core.ui.ct;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.et;

public class DkCommentScoreView extends View {
    static final /* synthetic */ boolean a = (!DkCommentScoreView.class.desiredAssertionStatus());
    private final boolean b;
    private final Drawable c;
    private final Drawable d;
    private final int e;
    private int f;
    private int g;
    private float h = 0.0f;
    private e i;
    private et j = null;

    public DkCommentScoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.DkCommentScoreView);
        this.b = obtainStyledAttributes.getBoolean(j.DkCommentScoreView_custom_operation, false);
        boolean z = obtainStyledAttributes.getBoolean(j.DkCommentScoreView_need_login, true);
        this.c = getResources().getDrawable(obtainStyledAttributes.getResourceId(j.DkCommentScoreView_high_score, e.bookcity_comment__shared__red_star));
        this.d = getResources().getDrawable(obtainStyledAttributes.getResourceId(j.DkCommentScoreView_normal_score, e.bookcity_comment__shared__small_gray_star));
        this.e = obtainStyledAttributes.getDimensionPixelSize(j.DkCommentScoreView_score_space, 5);
        obtainStyledAttributes.recycle();
        if (this.b) {
            this.j = new et();
            this.j.a(new ct());
            this.j.b(this);
            this.j.a(new c(this, z));
        }
    }

    public void setScore(float f) {
        if (!a && (0.0f > f || f > 5.0f)) {
            throw new AssertionError();
        } else if (!a(false)) {
            this.h = a(f);
            b(false);
            invalidate();
        }
    }

    public void setScore(int i) {
        setScore((float) i);
    }

    public float getScore() {
        return this.h;
    }

    public void setScoreChangeListener(e eVar) {
        if (a || eVar != null) {
            this.i = eVar;
            return;
        }
        throw new AssertionError();
    }

    protected void onDraw(Canvas canvas) {
        int i;
        int i2 = 0;
        int paddingLeft = (this.e / 2) + getPaddingLeft();
        int intrinsicWidth = this.d.getIntrinsicWidth();
        for (i = 0; i < 5; i++) {
            int i3 = ((this.e + intrinsicWidth) * i) + paddingLeft;
            this.d.setBounds(i3, getPaddingTop(), this.d.getIntrinsicWidth() + i3, getPaddingTop() + this.d.getIntrinsicHeight());
            this.d.draw(canvas);
        }
        i = (int) Math.floor((double) this.h);
        while (i2 < i) {
            i3 = ((this.e + intrinsicWidth) * i2) + paddingLeft;
            this.c.setBounds(i3, getPaddingTop(), this.c.getIntrinsicWidth() + i3, getPaddingTop() + this.c.getIntrinsicHeight());
            this.c.draw(canvas);
            i2++;
        }
        if (((double) (this.h - ((float) i))) >= 0.5d) {
            i = paddingLeft + ((this.e + intrinsicWidth) * i);
            Rect rect = (Rect) UTools.g.getRect();
            rect.set(i, getPaddingTop(), (this.c.getIntrinsicWidth() / 2) + i, this.c.getIntrinsicHeight() + getPaddingTop());
            canvas.save();
            canvas.clipRect(rect);
            this.c.setBounds(i, getPaddingTop(), this.c.getIntrinsicWidth() + i, getPaddingTop() + this.c.getIntrinsicHeight());
            this.c.draw(canvas);
            canvas.restore();
            UTools.g.getRect(rect);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            this.f = size;
        } else {
            this.f = (getPaddingLeft() + getPaddingRight()) + ((this.c.getIntrinsicWidth() + this.e) * 5);
        }
        if (mode2 == 1073741824) {
            this.g = size2;
        } else {
            this.g = (getPaddingTop() + getPaddingBottom()) + this.c.getIntrinsicHeight();
        }
        setMeasuredDimension(this.f, this.g);
    }

    private void a(PointF pointF) {
        int i = 5;
        int width = getWidth();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i2 = (int) pointF.x;
        if (i2 < paddingLeft) {
            width = 1;
        } else if (i2 > width - paddingRight) {
            width = 5;
        } else {
            width = (int) Math.ceil((double) (((((float) i2) - ((float) paddingLeft)) - ((float) paddingRight)) / ((float) (this.c.getIntrinsicWidth() + this.e))));
        }
        if (width <= 0) {
            i = 1;
        } else if (width <= 5) {
            i = width;
        }
        if (this.h != ((float) i) && !a(true)) {
            this.h = (float) i;
            invalidate();
            b(true);
        }
    }

    private float a(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 5.0f) {
            return 5.0f;
        }
        return f;
    }

    private boolean a(boolean z) {
        if (this.i != null) {
            return this.i.a(this, z);
        }
        return false;
    }

    private void b(boolean z) {
        if (this.i != null) {
            this.i.a(this, (int) this.h, z);
        }
    }
}
