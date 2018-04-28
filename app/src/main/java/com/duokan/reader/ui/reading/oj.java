package com.duokan.reader.ui.reading;

import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;

class oj extends oi {
    /* renamed from: e */
    final /* synthetic */ nu f10740e;

    private oj(nu nuVar) {
        this.f10740e = nuVar;
        super(nuVar);
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f10740e.getContext()).inflate(C0256h.reading__bookmark_empty_view, viewGroup, false);
        ((ImageView) inflate.findViewById(C0255g.reading__bookmark_empty_view__icon)).setColorFilter(Color.argb((int) Math.round(25.5d), Color.red(this.f10740e.f10719u), Color.green(this.f10740e.f10719u), Color.blue(this.f10740e.f10719u)), Mode.SRC_IN);
        ((TextView) inflate.findViewById(C0255g.reading__bookmark_empty_view__no_bookmark)).setTextColor(Color.argb((int) Math.round(102.0d), Color.red(this.f10740e.f10719u), Color.green(this.f10740e.f10719u), Color.blue(this.f10740e.f10719u)));
        ((TextView) inflate.findViewById(C0255g.reading__bookmark_empty_view__hint)).setTextColor(Color.argb((int) Math.round(102.0d), Color.red(this.f10740e.f10719u), Color.green(this.f10740e.f10719u), Color.blue(this.f10740e.f10719u)));
        return inflate;
    }
}
