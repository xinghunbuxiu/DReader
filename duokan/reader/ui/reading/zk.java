package com.duokan.reader.ui.reading;

import android.widget.EditText;
import android.widget.TextView;

import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.ReaderUi;

public class zk extends ActivatedController {
    private final c a;
    private final com.duokan.reader.domain.document.epub.c b;
    private final String c;
    private final String d;
    private final boolean e;
    private final TextView f;
    private final EditText g = ((EditText) findViewById(g.reading__send_error_view__text));

    public zk(IFeature featrue, c cVar, com.duokan.reader.domain.document.epub.c cVar2, String str, String str2, boolean z) {
        super(featrue);
        this.a = cVar;
        this.b = cVar2;
        this.c = str;
        this.d = str2;
        this.e = z;
        setContentView(h.reading__send_error_view);
        HeaderView headerView = (HeaderView) findViewById(g.reading__send_error_view__title);
        headerView.setLeftTitle(j.reading__send_error_view__title);
        this.f = headerView.b(getString(j.general__shared__send));
        this.f.setTextColor(getResources().getColor(d.general__shared__publish_button_confirm));
        this.f.setOnClickListener(new zl(this));
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        a();
    }

    protected void onDeactive() {
        super.onDeactive();
        b();
    }

    private void a() {
        this.g.postDelayed(new zm(this), 300);
    }

    private void b() {
        ReaderUi.a(getContext(), this.g);
    }

    private void a(String str) {
        DkCloudStorage.a().a(this.a, this.b, this.c, this.d, str, this.e, new zn(this));
    }
}
