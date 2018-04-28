package com.duokan.reader.ui.reading;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.plugins.dict.C1123r;
import com.duokan.reader.domain.plugins.dict.C1124s;
import com.duokan.reader.domain.plugins.dict.C1127v;
import com.duokan.reader.domain.plugins.dict.C1128w;
import com.duokan.reader.domain.plugins.dict.C1129x;

class adu implements C1123r {
    /* renamed from: a */
    final /* synthetic */ ady f9537a;
    /* renamed from: b */
    final /* synthetic */ TranslationController f9538b;

    adu(TranslationController translationController, ady ady) {
        this.f9538b = translationController;
        this.f9537a = ady;
    }

    /* renamed from: a */
    public void mo2221a(C1124s c1124s) {
        if (c1124s.f5423a) {
            if (this.f9538b.m12593a(this.f9538b.f9170d)) {
                this.f9538b.m12597c();
            }
            this.f9538b.f9167a.setVisibility(0);
            this.f9538b.f9172f.setVisibility(8);
            this.f9538b.f9168b.setVisibility(0);
            boolean T = this.f9538b.m12602d().mo2003T();
            this.f9538b.f9167a.setText(c1124s.f5424b);
            this.f9538b.f9167a.setChsToChtChars(T);
            if (c1124s.f5426d != null) {
                for (C1128w c1128w : c1124s.f5426d.f5432a) {
                    this.f9538b.m12589a(LineType.PRONOUN, c1128w.b);
                    this.f9538b.m12589a(LineType.MEANING, c1128w.a);
                    if (!TextUtils.isEmpty(c1128w.f5439c)) {
                        this.f9538b.m12589a(LineType.EXTRA, this.f9538b.getString(C0258j.reading__translation_view__ccmean_words) + c1128w.f5439c);
                    }
                }
                if (!TextUtils.isEmpty(c1124s.f5426d.f5434c)) {
                    this.f9538b.m12589a(LineType.EXTRA, this.f9538b.getString(C0258j.reading__translation_view__ccmean_radical) + c1124s.f5426d.f5434c);
                }
                if (!TextUtils.isEmpty(c1124s.f5426d.f5435d)) {
                    this.f9538b.m12589a(LineType.EXTRA, this.f9538b.getString(C0258j.reading__translation_view__ccmean_strokes) + c1124s.f5426d.f5435d);
                }
                if (!TextUtils.isEmpty(c1124s.f5426d.f5436e)) {
                    this.f9538b.m12589a(LineType.EXTRA, this.f9538b.getString(C0258j.reading__translation_view__ccmean_wubi) + c1124s.f5426d.f5436e);
                }
                if (!TextUtils.isEmpty(c1124s.f5426d.f5433b)) {
                    this.f9538b.m12589a(LineType.EXTRA, this.f9538b.getString(C0258j.reading__translation_view__ccmean_structure) + c1124s.f5426d.f5433b);
                }
            }
            if (c1124s.f5425c != null) {
                for (C1129x c1129x : c1124s.f5425c.f5430d) {
                    this.f9538b.m12589a(LineType.PRONOUN, c1129x.f5440a);
                    for (C1127v c1127v : c1129x.f5441b) {
                        this.f9538b.m12589a(LineType.ATTR, c1127v.f5438b);
                        this.f9538b.m12589a(LineType.MEANING, c1127v.f5437a);
                    }
                }
                if (!TextUtils.isEmpty(c1124s.f5425c.f5431e)) {
                    this.f9538b.m12589a(LineType.EXTRA, c1124s.f5425c.f5431e);
                }
                if (c1124s.f5425c.f5427a == 2 && !TextUtils.isEmpty(c1124s.f5425c.f5428b)) {
                    this.f9538b.m12589a(LineType.MEANING, c1124s.f5425c.f5428b);
                    if (!TextUtils.isEmpty(c1124s.f5425c.f5429c)) {
                        this.f9538b.m12589a(LineType.ATTR, c1124s.f5425c.f5429c);
                    }
                }
            }
        }
        if (this.f9538b.f9168b.getChildCount() == 0) {
            this.f9538b.f9168b.setVisibility(8);
            this.f9538b.f9173g.setVisibility(8);
            this.f9538b.f9167a.setVisibility(8);
            this.f9538b.f9172f.setVisibility(0);
            Drawable drawable = this.f9538b.getDrawable(C0254f.reading__dict_book_not_found);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.f9538b.f9172f.setText(C0258j.reading__translation_view__no_result);
            this.f9538b.f9172f.setCompoundDrawables(drawable, null, null, null);
        }
        if (this.f9537a != null && !this.f9538b.f9175i) {
            this.f9537a.mo2220b();
            this.f9538b.f9175i = true;
        }
    }
}
