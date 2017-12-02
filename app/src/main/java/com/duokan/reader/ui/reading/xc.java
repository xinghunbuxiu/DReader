package com.duokan.reader.ui.reading;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.core.app.y;
import com.duokan.core.ui.dv;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.hh;
import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;

public class xc extends wk {
    private final View a;
    private final View b;
    private final sh c = ((sh) getContext().queryFeature(sh.class));

    public xc(y yVar) {
        super(yVar);
        View inflate = LayoutInflater.from(getContext()).inflate(g.reading__reading_viewtype_view, null);
        inflate.setLayoutParams(new LayoutParams(ReaderEnv.get().forHd() ? dv.b(getContext(), 240.0f) : -1, -2));
        setContentView(inflate);
        this.a = findViewById(f.reading__reading_viewtype_view__single_page);
        this.b = findViewById(f.reading__reading_viewtype_view__scroll);
        this.a.setOnClickListener(new xd(this));
        this.b.setOnClickListener(new xf(this));
    }

    protected void onActive(boolean z) {
        a();
        super.onActive(z);
    }

    private final void a() {
        boolean z;
        boolean z2 = true;
        hh b = this.c.b();
        View view = this.a;
        if (b.e() == PageScaleType.MATCH_INSIDE) {
            z = true;
        } else {
            z = false;
        }
        view.setSelected(z);
        View view2 = this.b;
        if (b.e() != PageScaleType.MATCH_WIDTH) {
            z2 = false;
        }
        view2.setSelected(z2);
    }
}
