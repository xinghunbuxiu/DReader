package com.duokan.reader.ui.bookshelf;

import android.text.TextUtils;
import com.duokan.p024c.C0251c;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.iq;
import java.util.Arrays;

class en implements iq {
    /* renamed from: a */
    final /* synthetic */ em f6397a;

    en(em emVar) {
        this.f6397a = emVar;
    }

    /* renamed from: a */
    public boolean mo1688a(String str) {
        if (TextUtils.isEmpty(str)) {
            be.m10286a(this.f6397a.f6396a.getContext(), C0258j.bookshelf__category_selection_view__enter_name, 0).show();
            return false;
        } else if (ai.m3980a().m3929g(str) != null || Arrays.asList(this.f6397a.f6396a.getResources().getStringArray(C0251c.bookshelf__general_shared__main_categories)).contains(str)) {
            be.m10287a(this.f6397a.f6396a.getContext(), this.f6397a.f6396a.getResources().getString(C0258j.bookshelf__category_rename_view__name_exists), 0).show();
            return false;
        } else {
            this.f6397a.f6396a.f6387a.mo1633a(ai.m3980a().m3932h(str));
            return true;
        }
    }
}
