package com.duokan.reader.ui.store;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.duokan.p023b.C0244f;
import com.duokan.reader.domain.payment.C1085q;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.az;
import com.duokan.reader.ui.general.ba;

public class PaymentMethodItemView extends LinearLayout implements az<C1085q> {
    /* renamed from: a */
    private RadioButton f11292a;
    /* renamed from: b */
    private RadioGroup f11293b;
    /* renamed from: c */
    private DkLabelView f11294c;
    /* renamed from: d */
    private DkLabelView f11295d;
    /* renamed from: e */
    private ba<C1085q> f11296e;
    /* renamed from: f */
    private C1085q f11297f;

    public PaymentMethodItemView(Context context) {
        super(context);
    }

    public PaymentMethodItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f11292a = (RadioButton) findViewById(C0244f.store__payment_method_item_view__select);
        this.f11293b = (RadioGroup) findViewById(C0244f.store__payment_method_item_view__select_container);
        this.f11294c = (DkLabelView) findViewById(C0244f.store__payment_method_item_view__method_display_name);
        this.f11295d = (DkLabelView) findViewById(C0244f.store__payment_method_item_view__balance_status);
        this.f11292a.setOnCheckedChangeListener(new bk(this));
        this.f11293b.clearCheck();
    }

    public void setChecked(boolean z) {
        if (z) {
            this.f11292a.setChecked(true);
        } else {
            this.f11293b.clearCheck();
        }
    }

    public boolean isChecked() {
        return this.f11292a.isChecked();
    }

    public void toggle() {
        if (isChecked()) {
            this.f11293b.clearCheck();
        } else {
            this.f11292a.setChecked(true);
        }
    }

    public void setOnCheckedChangeListener(ba<C1085q> baVar) {
        this.f11296e = baVar;
    }

    public String getDataObjectId() {
        return this.f11297f.mo1499a();
    }

    public C1085q getDataObject() {
        return this.f11297f;
    }
}
