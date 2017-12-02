package com.duokan.reader.ui.reading;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.x;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.fv;
import com.duokan.reader.domain.bookshelf.it;

public class gz extends FrameLayout implements it {
    private final fv a = ((fv) ((sh) x.a(getContext()).queryFeature(sh.class)).G());
    private final View b = LayoutInflater.from(getContext()).inflate(h.reading__download_full_book_view, this, false);
    private final TextView c = ((TextView) this.b.findViewById(g.reading__download_full_book_view__name));
    private final TextView d = ((TextView) this.b.findViewById(g.reading__download_full_book_view__download));

    public gz(Context context) {
        super(context);
        this.c.setText(this.a.aw());
        addView(this.b, new LayoutParams(-1, -1));
        this.d.setOnClickListener(new ha(this));
    }

    public void a(int i) {
        this.c.setTextColor(i);
        a();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ai.a().a((it) this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ai.a().b((it) this);
    }

    public void a(c cVar) {
        if (this.a == cVar) {
            a();
        }
    }

    private void a() {
        if (this.a.U()) {
            this.d.setText(String.format(getResources().getString(j.reading__shared__downloading), new Object[]{Float.valueOf(this.a.m())}));
            return;
        }
        this.d.setText(getResources().getString(j.reading__shared__download_full_book));
    }
}
