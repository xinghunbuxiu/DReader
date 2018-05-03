package com.duokan.reader.ui.general;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;

public class ip extends ak {
    /* renamed from: a */
    final int f7393a;
    /* renamed from: b */
    final int f7394b;
    /* renamed from: c */
    private String f7395c;
    /* renamed from: d */
    private EditText f7396d;
    /* renamed from: e */
    private iq f7397e;

    public ip(Context context, String str, String str2, iq iqVar) {
        super(context);
        setTitle(str);
        this.f7395c = str2;
        this.f7397e = iqVar;
        this.f7396d = (EditText) LayoutInflater.from(context).inflate(C0245g.general__dk_text_input_view, null);
        setResizeForSoftInput(true);
        setExtraContentView(this.f7396d);
        this.f7396d.setText(this.f7395c);
        this.f7394b = addButtonView(context.getString(C0247i.general__shared__cancel), getContext().getResources().getColor(C0241c.general__shared__c6));
        this.f7393a = addButtonView(context.getString(C0247i.general__shared__ok), getContext().getResources().getColor(C0241c.general__shared__c1));
    }

    protected void onButtonClicked(int i) {
        if (i == this.f7393a) {
            this.f7395c = this.f7396d.getText().toString();
            if (this.f7397e.mo1688a(this.f7395c)) {
                dismiss();
                return;
            }
            return;
        }
        dismiss();
    }

    public void dismiss() {
        AnimUtils.m1909a(getContext());
        super.dismiss();
    }
}
