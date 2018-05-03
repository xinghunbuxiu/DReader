package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.duokan.core.ui.AnimUtils;

final class ii extends View {
    /* renamed from: a */
    final /* synthetic */ ie f7378a;
    /* renamed from: b */
    private View f7379b;

    public ii(ie ieVar, Context context, View view) {
        this(ieVar, context);
        this.f7379b = view;
    }

    public ii(ie ieVar, Context context) {
        this(ieVar, context, (AttributeSet) null);
    }

    public ii(ie ieVar, Context context, AttributeSet attributeSet) {
        this.f7378a = ieVar;
        super(context, attributeSet);
        m10789a(context);
    }

    /* renamed from: a */
    public View m10790a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup) || this.f7379b == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        AnimUtils.hideAnimation((View) this, new ij(this, viewGroup, viewGroup.indexOfChild(this)));
        return this.f7379b;
    }

    public void draw(Canvas canvas) {
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    /* renamed from: a */
    private void m10789a(Context context) {
        setVisibility(4);
        setWillNotDraw(true);
    }
}
