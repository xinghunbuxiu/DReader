package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* renamed from: com.duokan.reader.ui.bookshelf.a */
public class C1282a extends de {
    /* renamed from: a */
    private final Drawable f6078a;

    public C1282a(Context context) {
        this(context, null);
    }

    public C1282a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6078a = new C1284b(this, getContext());
    }

    protected Drawable getCoverDrawable() {
        return this.f6078a;
    }
}
