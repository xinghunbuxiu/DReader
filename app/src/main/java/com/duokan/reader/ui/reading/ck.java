package com.duokan.reader.ui.reading;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.core.app.x;
import com.duokan.core.app.y;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.bookshelf.BookContent;

public class ck extends wk {
    private final sh a = ((sh) getContext().queryFeature(sh.class));
    private final View b;
    private final View c;
    private final View d;
    private boolean e = false;

    public ck(y yVar) {
        super(yVar);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(this.a.am() ? h.reading__comic_option_horizontal_view : h.reading__comic_option_vertical_view, null);
        viewGroup.setLayoutParams(new LayoutParams(-1, -2));
        setContentView((View) viewGroup);
        this.b = findViewById(g.reading__comic_option_view__horizontal);
        this.b.setOnClickListener(new cl(this));
        this.c = findViewById(g.reading__comic_option_view__vertical);
        this.c.setOnClickListener(new cm(this));
        this.d = findViewById(g.reading__comic_option_view__landscape);
        this.d.setOnClickListener(new cn(this));
        a();
    }

    protected void onDetachFromStub() {
        if (this.e) {
            this.a.aA();
            ((sh) x.a(getContext()).queryFeature(sh.class)).a(128, 0);
        }
    }

    private void a() {
        if (!ReaderEnv.get().forHd()) {
            this.d.setVisibility(0);
        }
        if (this.a.G().r() == BookContent.VERTICAL_COMIC) {
            this.b.setVisibility(8);
        }
        if (!ReaderEnv.get().forHd() && this.a.am()) {
            this.d.setSelected(true);
        } else if (this.b.getVisibility() == 0 && this.a.U() == PageAnimationMode.HSCROLL) {
            this.b.setSelected(true);
        } else {
            this.c.setSelected(true);
        }
    }
}
