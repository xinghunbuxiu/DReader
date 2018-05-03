package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;
import com.duokan.core.app.C0306j;
import com.duokan.core.app.ad;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0240b;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;

public class bz extends ak implements C0306j {
    /* renamed from: a */
    private final EditText f7016a;
    /* renamed from: b */
    private ad f7017b = null;

    public bz(Context context) {
        super(context);
        setContentView(C0245g.general__edit_dialog_view);
        int b = AnimUtils.m1932b(getContext(), 6.0f);
        getContentView().setBackgroundDrawable(new hb(new ColorDrawable(getContext().getResources().getColor(C0241c.general__shared__dialog)), (float) b));
        this.f7016a = (EditText) findViewById(C0244f.general__edit_dialog_view__edit);
        setResizeForSoftInput(true);
        TextView textView = (TextView) findViewById(C0244f.general__edit_dialog_view__cancel);
        textView.getPaint().setFakeBoldText(true);
        textView.setBackgroundDrawable(new hb(getContext().getResources().getDrawable(C0243e.general__shared__dialog_button_background), (float) AnimUtils.m1932b(getContext(), 6.0f), 4));
        textView.setOnClickListener(new ca(this));
        textView = (TextView) findViewById(C0244f.general__edit_dialog_view__ok);
        textView.getPaint().setFakeBoldText(true);
        textView.setBackgroundDrawable(new hb(getContext().getResources().getDrawable(C0243e.general__shared__dialog_button_background), (float) AnimUtils.m1932b(getContext(), 6.0f), 8));
        textView.setOnClickListener(new cb(this));
        setEnterAnimation(C0240b.general__shared__scale_center_in);
        setExitAnimation(C0240b.general__shared__scale_center_out);
    }

    protected void onShow() {
        super.onShow();
        AnimUtils.m1920a(this.f7016a, 1);
    }

    protected void onDismiss() {
        super.onDismiss();
        AnimUtils.m1909a(getContext());
    }

    /* renamed from: a */
    public Editable m10327a() {
        return this.f7016a.getText();
    }

    /* renamed from: a */
    public void m10329a(CharSequence charSequence) {
        this.f7016a.setText(charSequence);
        this.f7016a.setSelection(charSequence.length());
    }

    /* renamed from: a */
    public void m10328a(ad adVar) {
        this.f7017b = adVar;
        show();
    }

    protected void onCancel() {
        super.onCancel();
        m10325b();
        dismiss();
    }

    /* renamed from: b */
    private void m10325b() {
        if (this.f7017b != null) {
            this.f7017b.mo1554b(this);
        }
    }

    /* renamed from: c */
    private void m10326c() {
        if (this.f7017b != null) {
            this.f7017b.mo1553a(this);
        }
    }
}
