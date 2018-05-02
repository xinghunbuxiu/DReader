package com.duokan.reader.ui.general;

import android.text.InputFilter;
import android.text.Spanned;

class fg implements InputFilter {
    final /* synthetic */ fc a;

    fg(fc fcVar) {
        this.a = fcVar;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (i3 >= this.a.d.length()) {
            return charSequence.subSequence(i, i2);
        }
        if (i4 <= this.a.d.length()) {
            return spanned.subSequence(i3, i4);
        }
        CharSequence stringBuilder = new StringBuilder();
        stringBuilder.append(spanned.subSequence(i3, this.a.d.length()));
        stringBuilder.append(charSequence.subSequence(i, i2));
        return stringBuilder;
    }
}
