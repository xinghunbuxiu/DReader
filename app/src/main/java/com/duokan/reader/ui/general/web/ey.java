package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.PopupWindow;

class ey implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ EditText f7811a;
    /* renamed from: b */
    final /* synthetic */ PopupWindow f7812b;
    /* renamed from: c */
    final /* synthetic */ ew f7813c;

    ey(ew ewVar, EditText editText, PopupWindow popupWindow) {
        this.f7813c = ewVar;
        this.f7811a = editText;
        this.f7812b = popupWindow;
    }

    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.f7811a.getText().toString())) {
            this.f7813c.f7807d.mo1839a(r0);
        }
        this.f7812b.dismiss();
    }
}
