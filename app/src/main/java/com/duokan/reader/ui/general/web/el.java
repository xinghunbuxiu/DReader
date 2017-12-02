package com.duokan.reader.ui.general.web;

import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.reader.ui.s;

class el implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ a d;
    final /* synthetic */ ef e;

    el(ef efVar, String str, String str2, String str3, a aVar) {
        this.e = efVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = aVar;
    }

    public void run() {
        View inflate = LayoutInflater.from(this.e.b.b.getContext()).inflate(h.general__dk_text_input_dialog_view, null);
        EditText editText = (EditText) inflate.findViewById(g.general__shared_text_input_dialog_view__edit);
        TextView textView = (TextView) inflate.findViewById(g.general__shared_text_input_dialog_view__confirm);
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -2, true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setSoftInputMode(16);
        popupWindow.setInputMethodMode(0);
        if (!TextUtils.isEmpty(this.a)) {
            editText.setHint(this.a);
        }
        if (!TextUtils.isEmpty(this.b)) {
            editText.setText(this.b);
        }
        if (!TextUtils.isEmpty(this.c)) {
            textView.setText(this.c);
        }
        s sVar = (s) this.e.b.b.getContext().queryFeature(s.class);
        popupWindow.showAtLocation(this.e.b.b.js_getContentView(), 80, 0, sVar == null ? 0 : sVar.getTheme().getPagePaddingBottom());
        editText.postDelayed(new em(this, editText), 200);
        textView.setOnClickListener(new en(this, editText, popupWindow));
    }
}
