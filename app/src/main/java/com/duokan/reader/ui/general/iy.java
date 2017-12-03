package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.duokan.core.ui.UTools;

final class iy extends View {
    final /* synthetic */ iu a;
    private View b;

    public iy(iu iuVar, Context context, View view) {
        this(iuVar, context);
        this.b = view;
    }

    public iy(iu iuVar, Context context) {
        this(iuVar, context, (AttributeSet) null);
    }

    public iy(iu iuVar, Context context, AttributeSet attributeSet) {
        this.a = iuVar;
        super(context, attributeSet);
        a(context);
    }

    public View a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup) || this.b == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        UTools.showAnimation((View) this, new iz(this, viewGroup, viewGroup.indexOfChild(this)));
        return this.b;
    }

    public void draw(Canvas canvas) {
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    private void a(Context context) {
        setVisibility(4);
        setWillNotDraw(true);
    }
}
