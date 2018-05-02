package com.duokan.reader.ui.reading;

import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;

class ob extends ny {
    final /* synthetic */ nk e;

    private ob(nk nkVar) {
        this.e = nkVar;
        super(nkVar);
    }

    public void d() {
        this.e.f();
        super.d();
    }

    public View a(View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.e.getContext()).inflate(h.reading__comment_empty_view, viewGroup, false);
        ((ImageView) inflate.findViewById(g.reading__comment_empty_view__icon)).setColorFilter(Color.argb((int) Math.round(25.5d), Color.red(this.e.u), Color.green(this.e.u), Color.blue(this.e.u)), Mode.SRC_IN);
        ((TextView) inflate.findViewById(g.reading__comment_empty_view__no_comment)).setTextColor(Color.argb((int) Math.round(102.0d), Color.red(this.e.u), Color.green(this.e.u), Color.blue(this.e.u)));
        ((TextView) inflate.findViewById(g.reading__comment_empty_view__hint)).setTextColor(Color.argb((int) Math.round(102.0d), Color.red(this.e.u), Color.green(this.e.u), Color.blue(this.e.u)));
        return inflate;
    }
}
