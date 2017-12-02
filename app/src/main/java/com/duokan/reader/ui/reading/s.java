package com.duokan.reader.ui.reading;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import com.duokan.core.app.x;
import com.duokan.core.ui.t;
import com.duokan.reader.domain.bookshelf.a;
import com.duokan.reader.domain.bookshelf.ef;
import com.duokan.reader.domain.bookshelf.eg;
import com.duokan.reader.domain.document.d;

public class s {
    private final yj a;
    private Rect[] b;
    private ef c;
    private t d;
    private final sh e;

    public s(Activity activity, sh shVar, acv com_duokan_reader_ui_reading_acv) {
        this.e = shVar;
        this.a = new yj(x.a((Context) activity), new t(this, com_duokan_reader_ui_reading_acv));
        this.d = new u(this, activity);
        this.d.setContentView(this.a.getContentView());
        this.a.getContentView().setOnClickListener(new v(this));
    }

    public void a(a aVar, View view) {
        this.e.aU();
        this.c = (ef) aVar;
        this.b = this.e.b(this.e.getDocument().a((d) aVar.d(), (d) aVar.e()));
        this.a.a(eg.a().c(this.c.n()));
        this.a.a(this.c.f(), false, new w(this));
    }
}
