package com.duokan.reader.ui.reading;

import android.widget.EditText;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.cloud.DkCloudStorage;
import com.duokan.reader.domain.document.epub.C0936c;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.ReaderUi;

public class zx extends ActivatedController {
    /* renamed from: a */
    private final C0800c f11282a;
    /* renamed from: b */
    private final C0936c f11283b;
    /* renamed from: c */
    private final String f11284c;
    /* renamed from: d */
    private final String f11285d;
    /* renamed from: e */
    private final boolean f11286e;
    /* renamed from: f */
    private final TextView f11287f;
    /* renamed from: g */
    private final EditText f11288g = ((EditText) findViewById(C0255g.reading__send_error_view__text));

    public zx(IFeature mFeature, C0800c c0800c, C0936c c0936c, String str, String str2, boolean z) {
        super(mFeature);
        this.f11282a = c0800c;
        this.f11283b = c0936c;
        this.f11284c = str;
        this.f11285d = str2;
        this.f11286e = z;
        setContentView(C0256h.reading__send_error_view);
        HeaderView headerView = (HeaderView) findViewById(C0255g.reading__send_error_view__title);
        headerView.setLeftTitle(C0258j.reading__send_error_view__title);
        this.f11287f = headerView.m10148b(getString(C0258j.general__shared__send));
        this.f11287f.setTextColor(getResources().getColor(C0252d.general__shared__publish_button_confirm));
        this.f11287f.setOnClickListener(new zy(this));
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        m15232a();
    }

    protected void onDeactive() {
        super.onDeactive();
        m15236b();
    }

    /* renamed from: a */
    private void m15232a() {
        this.f11288g.postDelayed(new zz(this), 300);
    }

    /* renamed from: b */
    private void m15236b() {
        ReaderUi.m10161a(getContext(), this.f11288g);
    }

    /* renamed from: a */
    private void m15234a(String str) {
        DkCloudStorage.m4994a().m5011a(this.f11282a, this.f11283b, this.f11284c, this.f11285d, str, this.f11286e, new aaa(this));
    }
}
