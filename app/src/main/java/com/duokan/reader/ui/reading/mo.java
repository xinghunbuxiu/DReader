package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.reader.domain.document.aj;
import com.duokan.reader.ui.general.a.a;

public class mo extends FrameLayout implements mq {
    private mn a;

    public mo(Context context, aj ajVar, mn mnVar) {
        int i = 0;
        super(context);
        setWillNotDraw(false);
        setClipChildren(false);
        setStaticTransformationsEnabled(true);
        this.a = mnVar;
        int a = ajVar.a();
        while (i < a) {
            addView(new bk(getContext(), ajVar.a(i), i + 1), new LayoutParams(-2, -2, 48));
            i++;
        }
    }

    public void a() {
        if (getVisibility() != 0) {
            clearAnimation();
            setVisibility(0);
            a.a(this, 0.0f, 1.0f, 300, Boolean.valueOf(false), null);
        }
    }

    public void b() {
        if (getVisibility() != 4) {
            clearAnimation();
            a.a(this, 1.0f, 0.0f, 300, Boolean.valueOf(false), new mp(this));
        }
    }

    public void c() {
        clearAnimation();
        setVisibility(4);
    }

    public void a(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            boolean z;
            bk bkVar = (bk) getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            bkVar.setShowTextView(z);
        }
    }

    public void invalidate() {
        super.invalidate();
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).invalidate();
        }
    }

    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        PointF a = this.a.a(this, indexOfChild(view));
        float width = a.x - ((float) (view.getWidth() / 2));
        float f = a.y;
        transformation.clear();
        transformation.setTransformationType(2);
        transformation.getMatrix().setTranslate(width, f);
        return true;
    }
}
