package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.jz;
import com.duokan.reader.domain.bookshelf.ka;
import com.duokan.reader.domain.store.DkStoreBookDetail;

public class xu extends em {
    /* renamed from: h */
    private final jz f11159h;
    /* renamed from: i */
    private final ka f11160i;
    /* renamed from: j */
    private final TextView f11161j = ((TextView) findViewById(C0255g.reading__repair_cert_view__reason));

    public xu(IFeature mFeature, wy wyVar, DkStoreBookDetail dkStoreBookDetail, String str, jz jzVar, ka kaVar) {
        super(mFeature, wyVar);
        this.f11159h = jzVar;
        this.f11160i = kaVar;
        this.e.addView(LayoutInflater.from(getContext()).inflate(C0256h.reading__repair_cert_view, null), new LayoutParams(-1, -1));
        TextView textView = (TextView) findViewById(C0255g.reading__repair_cert_view__retry);
        textView.setOnClickListener(new xv(this));
        findViewById(C0255g.reading__repair_cert_view__back).setOnClickListener(new xw(this));
        this.f11161j.setTextColor(this.a.mo2001R());
        if (TextUtils.isEmpty(str)) {
            this.f11161j.setText(C0258j.reading__repair_cert_view__default_reason);
            textView.setText(C0258j.general__shared__repair);
            return;
        }
        this.f11161j.setText(str);
        textView.setText(C0258j.general__shared__retry);
    }

    protected boolean onBack() {
        this.f11160i.mo1066b(this.f11159h);
        return super.onBack();
    }
}
