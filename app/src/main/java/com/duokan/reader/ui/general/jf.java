package com.duokan.reader.ui.general;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;

import com.duokan.b.g;
import com.duokan.b.i;
import com.duokan.core.ui.dv;

public class jf extends ak {
    final int a;
    final int b;
    private String c;
    private EditText d;
    private jg e;

    public jf(Context context, String str, String str2, jg jgVar) {
        super(context);
        setTitle(str);
        this.c = str2;
        this.e = jgVar;
        this.d = (EditText) LayoutInflater.from(context).inflate(g.general__dk_text_input_view, null);
        setResizeForSoftInput(true);
        setExtraContentView(this.d);
        this.d.setText(this.c);
        this.b = addButtonView(context.getString(i.general__shared__cancel), getContext().getResources().getColor(c.general__shared__c6));
        this.a = addButtonView(context.getString(i.general__shared__ok), getContext().getResources().getColor(c.general__shared__c1));
    }

    protected void onButtonClicked(int i) {
        if (i == this.a) {
            this.c = this.d.getText().toString();
            if (this.e.a(this.c)) {
                dismiss();
                return;
            }
            return;
        }
        dismiss();
    }

    public void dismiss() {
        dv.a(getContext());
        super.dismiss();
    }
}
