package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.c.h;

import java.util.List;

public class hl extends FrameLayout {
    private View a = LayoutInflater.from(getContext()).inflate(h.bookshelf__recently_reading_empty_view, this, false);
    private bb b;
    private cr c;

    public hl(Context context, cr crVar, bh bhVar) {
        super(context);
        this.c = crVar;
        this.b = new bb(context);
        this.b.setOnItemClickListener(bhVar);
        addView(this.a);
        addView(this.b, new LayoutParams(-1, -1, 81));
    }

    public void a(boolean z) {
        List b = this.c.b();
        if (b == null || b.size() <= 0) {
            b(this.a);
            a(this.b);
            return;
        }
        b(this.b);
        a(this.a);
        this.b.a(b, z);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setEnabled(z);
        }
    }

    private void a(View view) {
        if (view.getVisibility() == 0) {
            view.setVisibility(4);
        }
    }

    private void b(View view) {
        if (view.getVisibility() != 0) {
            view.setVisibility(0);
        }
    }
}
