package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public class a extends cz {
    private final Drawable a;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new b(this, getContext());
    }

    protected Drawable getCoverDrawable() {
        return this.a;
    }
}
