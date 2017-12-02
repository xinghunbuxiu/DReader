package com.duokan.reader.ui.bookshelf;

import android.text.TextUtils;

import com.duokan.c.c;
import com.duokan.c.j;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.jg;

import java.util.Arrays;

class ef implements jg {
    final /* synthetic */ ee a;

    ef(ee eeVar) {
        this.a = eeVar;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            be.a(this.a.a.getContext(), j.bookshelf__category_selection_view__enter_name, 0).show();
            return false;
        } else if (ai.a().g(str) != null || Arrays.asList(this.a.a.getResources().getStringArray(c.bookshelf__general_shared__main_categories)).contains(str)) {
            be.a(this.a.a.getContext(), this.a.a.getResources().getString(j.bookshelf__category_rename_view__name_exists), 0).show();
            return false;
        } else {
            this.a.a.a.a(ai.a().h(str));
            return true;
        }
    }
}
