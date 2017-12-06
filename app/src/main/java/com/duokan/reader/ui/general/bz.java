package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;

import com.duokan.b.c;
import com.duokan.b.e;
import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.core.app.ac;
import com.duokan.core.app.j;
import com.duokan.core.ui.UTools;

public class bz extends ak implements j {
    private final EditText a;
    private ac b = null;

    public bz(Context context) {
        super(context);
        setContentView(g.general__edit_dialog_view);
        int b = UTools.getMinimumHeight(getContext(), 6.0f);
        getContentView().setBackgroundDrawable(new hm(new ColorDrawable(getContext().getResources().getColor(c.general__shared__dialog)), (float) b));
        this.a = (EditText) findViewById(f.general__edit_dialog_view__edit);
        setResizeForSoftInput(true);
        TextView textView = (TextView) findViewById(f.general__edit_dialog_view__cancel);
        textView.getPaint().setFakeBoldText(true);
        textView.setBackgroundDrawable(new hm(getContext().getResources().getDrawable(e.general__shared__dialog_button_background), (float) UTools.getMinimumHeight(getContext(), 6.0f), 4));
        textView.setOnClickListener(new ca(this));
        textView = (TextView) findViewById(f.general__edit_dialog_view__ok);
        textView.getPaint().setFakeBoldText(true);
        textView.setBackgroundDrawable(new hm(getContext().getResources().getDrawable(e.general__shared__dialog_button_background), (float) UTools.getMinimumHeight(getContext(), 6.0f), 8));
        textView.setOnClickListener(new cb(this));
        setEnterAnimation(b.general__shared__scale_center_in);
        setExitAnimation(b.general__shared__scale_center_out);
    }

    protected void onShow() {
        super.onShow();
        UTools.PostTask(this.a, 1);
    }

    protected void onDismiss() {
        super.onDismiss();
        UTools.hideSoftInputFromWindow(getContext());
    }

    public Editable a() {
        return this.a.getText();
    }

    public void a(CharSequence charSequence) {
        this.a.setText(charSequence);
        this.a.setSelection(charSequence.length());
    }

    public void a(ac acVar) {
        this.b = acVar;
        show();
    }

    protected void onCancel() {
        super.onCancel();
        b();
        dismiss();
    }

    private void b() {
        if (this.b != null) {
            this.b.b(this);
        }
    }

    private void c() {
        if (this.b != null) {
            this.b.a(this);
        }
    }
}
