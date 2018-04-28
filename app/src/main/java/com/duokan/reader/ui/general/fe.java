package com.duokan.reader.ui.general;

import android.text.InputFilter;
import android.text.Spanned;

class fe implements InputFilter {
    /* renamed from: a */
    final /* synthetic */ fa f7211a;

    fe(fa faVar) {
        this.f7211a = faVar;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (i3 >= this.f7211a.f7204d.length()) {
            return charSequence.subSequence(i, i2);
        }
        if (i4 <= this.f7211a.f7204d.length()) {
            return spanned.subSequence(i3, i4);
        }
        CharSequence stringBuilder = new StringBuilder();
        stringBuilder.append(spanned.subSequence(i3, this.f7211a.f7204d.length()));
        stringBuilder.append(charSequence.subSequence(i, i2));
        return stringBuilder;
    }
}
