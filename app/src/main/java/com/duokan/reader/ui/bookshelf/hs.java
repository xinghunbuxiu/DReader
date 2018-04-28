package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.p024c.C0256h;
import java.util.List;

public class hs extends FrameLayout {
    /* renamed from: a */
    private View f6570a = LayoutInflater.from(getContext()).inflate(C0256h.bookshelf__recently_reading_empty_view, this, false);
    /* renamed from: b */
    private bh f6571b;
    /* renamed from: c */
    private cw f6572c;

    public hs(Context context, cw cwVar, bn bnVar) {
        super(context);
        this.f6572c = cwVar;
        this.f6571b = new bh(context);
        this.f6571b.setOnItemClickListener(bnVar);
        addView(this.f6570a);
        addView(this.f6571b, new LayoutParams(-1, -1, 81));
    }

    /* renamed from: a */
    public void m9804a(boolean z) {
        List b = this.f6572c.m9441b();
        if (b == null || b.size() <= 0) {
            m9803b(this.f6570a);
            m9802a(this.f6571b);
            return;
        }
        m9803b(this.f6571b);
        m9802a(this.f6570a);
        this.f6571b.m9200a(b, z);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setEnabled(z);
        }
    }

    /* renamed from: a */
    private void m9802a(View view) {
        if (view.getVisibility() == 0) {
            view.setVisibility(4);
        }
    }

    /* renamed from: b */
    private void m9803b(View view) {
        if (view.getVisibility() != 0) {
            view.setVisibility(0);
        }
    }
}
