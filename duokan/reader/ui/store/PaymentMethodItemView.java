package com.duokan.reader.ui.store;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.duokan.reader.domain.payment.q;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.az;
import com.duokan.reader.ui.general.ba;

public class PaymentMethodItemView extends LinearLayout implements az {
    private RadioButton a;
    private RadioGroup b;
    private DkLabelView c;
    private DkLabelView d;
    private ba e;
    private q f;

    public PaymentMethodItemView(Context context) {
        super(context);
    }

    public PaymentMethodItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (RadioButton) findViewById(f.store__payment_method_item_view__select);
        this.b = (RadioGroup) findViewById(f.store__payment_method_item_view__select_container);
        this.c = (DkLabelView) findViewById(f.store__payment_method_item_view__method_display_name);
        this.d = (DkLabelView) findViewById(f.store__payment_method_item_view__balance_status);
        this.a.setOnCheckedChangeListener(new bk(this));
        this.b.clearCheck();
    }

    public void setChecked(boolean z) {
        if (z) {
            this.a.setChecked(true);
        } else {
            this.b.clearCheck();
        }
    }

    public boolean isChecked() {
        return this.a.isChecked();
    }

    public void toggle() {
        if (isChecked()) {
            this.b.clearCheck();
        } else {
            this.a.setChecked(true);
        }
    }

    public void setOnCheckedChangeListener(ba baVar) {
        this.e = baVar;
    }

    public String getDataObjectId() {
        return this.f.a();
    }

    public q getDataObject() {
        return this.f;
    }
}
