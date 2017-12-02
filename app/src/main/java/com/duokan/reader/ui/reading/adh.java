package com.duokan.reader.ui.reading;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;

import com.duokan.c.f;
import com.duokan.c.j;
import com.duokan.reader.domain.plugins.dict.r;
import com.duokan.reader.domain.plugins.dict.s;
import com.duokan.reader.domain.plugins.dict.v;
import com.duokan.reader.domain.plugins.dict.w;
import com.duokan.reader.domain.plugins.dict.x;

class adh implements r {
    final /* synthetic */ adl a;
    final /* synthetic */ TranslationController b;

    adh(TranslationController translationController, adl com_duokan_reader_ui_reading_adl) {
        this.b = translationController;
        this.a = com_duokan_reader_ui_reading_adl;
    }

    public void a(s sVar) {
        if (sVar.a) {
            if (this.b.a(this.b.d)) {
                this.b.c();
            }
            this.b.a.setVisibility(0);
            this.b.f.setVisibility(8);
            this.b.b.setVisibility(0);
            boolean T = this.b.d().T();
            this.b.a.setText(sVar.b);
            this.b.a.setChsToChtChars(T);
            if (sVar.d != null) {
                for (w wVar : sVar.d.a) {
                    this.b.a(LineType.PRONOUN, wVar.b);
                    this.b.a(LineType.MEANING, wVar.a);
                    if (!TextUtils.isEmpty(wVar.c)) {
                        this.b.a(LineType.EXTRA, this.b.getString(j.reading__translation_view__ccmean_words) + wVar.c);
                    }
                }
                if (!TextUtils.isEmpty(sVar.d.c)) {
                    this.b.a(LineType.EXTRA, this.b.getString(j.reading__translation_view__ccmean_radical) + sVar.d.c);
                }
                if (!TextUtils.isEmpty(sVar.d.d)) {
                    this.b.a(LineType.EXTRA, this.b.getString(j.reading__translation_view__ccmean_strokes) + sVar.d.d);
                }
                if (!TextUtils.isEmpty(sVar.d.e)) {
                    this.b.a(LineType.EXTRA, this.b.getString(j.reading__translation_view__ccmean_wubi) + sVar.d.e);
                }
                if (!TextUtils.isEmpty(sVar.d.b)) {
                    this.b.a(LineType.EXTRA, this.b.getString(j.reading__translation_view__ccmean_structure) + sVar.d.b);
                }
            }
            if (sVar.c != null) {
                for (x xVar : sVar.c.d) {
                    this.b.a(LineType.PRONOUN, xVar.a);
                    for (v vVar : xVar.b) {
                        this.b.a(LineType.ATTR, vVar.b);
                        this.b.a(LineType.MEANING, vVar.a);
                    }
                }
                if (!TextUtils.isEmpty(sVar.c.e)) {
                    this.b.a(LineType.EXTRA, sVar.c.e);
                }
                if (sVar.c.a == 2 && !TextUtils.isEmpty(sVar.c.b)) {
                    this.b.a(LineType.MEANING, sVar.c.b);
                    if (!TextUtils.isEmpty(sVar.c.c)) {
                        this.b.a(LineType.ATTR, sVar.c.c);
                    }
                }
            }
        }
        if (this.b.b.getChildCount() == 0) {
            this.b.b.setVisibility(8);
            this.b.g.setVisibility(8);
            this.b.a.setVisibility(8);
            this.b.f.setVisibility(0);
            Drawable drawable = this.b.getDrawable(f.reading__dict_book_not_found);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.b.f.setText(j.reading__translation_view__no_result);
            this.b.f.setCompoundDrawables(drawable, null, null, null);
        }
        if (this.a != null && !this.b.i) {
            this.a.b();
            this.b.i = true;
        }
    }
}
