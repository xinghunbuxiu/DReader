package com.duokan.reader.domain.store;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.DkListView;
import com.duokan.reader.ui.general.ak;

/* renamed from: com.duokan.reader.domain.store.r */
public class C1192r extends ak {
    /* renamed from: a */
    private TextView f5678a = ((TextView) findViewById(C0244f.store__price_changed_view__title1));
    /* renamed from: b */
    private View f5679b = findViewById(C0244f.store__price_changed_view__continue_purchase);
    /* renamed from: c */
    private TextView f5680c;
    /* renamed from: d */
    private DkLabelView f5681d = ((DkLabelView) findViewById(C0244f.store__price_changed_view__price));
    /* renamed from: e */
    private DkListView f5682e;
    /* renamed from: f */
    private TextView f5683f;

    public C1192r(Context context) {
        super(context);
        setExtraContentResource(C0245g.store__price_changed_view);
        this.f5679b.setOnClickListener(new C1193s(this));
        this.f5680c = (TextView) findViewById(C0244f.store__price_changed_view__cancel_purchase);
        this.f5680c.setOnClickListener(new C1194t(this));
        this.f5682e = (DkListView) findViewById(C0244f.store__price_changed_view__list);
        this.f5683f = (TextView) findViewById(C0244f.store__price_changed_view__single_message);
        this.f5683f.setVisibility(8);
    }

    public void cancel() {
        super.cancel();
        onCancel();
    }

    /* renamed from: a */
    public void mo2541a() {
    }

    public void onCancel() {
    }

    public void setTitle(int resId) {
        this.f5678a.setText(resId);
    }

    /* renamed from: a */
    public void m8740a(int i) {
        m8741a(getContext().getString(i));
    }

    /* renamed from: a */
    public void m8741a(String str) {
        this.f5680c.setText(str);
    }

    /* renamed from: b */
    public void m8742b(String str) {
        this.f5683f.setText(str);
        this.f5683f.setVisibility(0);
    }
}
