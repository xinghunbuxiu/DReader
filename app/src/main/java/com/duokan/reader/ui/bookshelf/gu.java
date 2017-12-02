package com.duokan.reader.ui.bookshelf;

import android.content.Context;

import com.duokan.c.j;
import com.duokan.core.app.x;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.ia;

public class gu extends ia {
    private c a;
    private cu b = ((cu) x.a(getContext()).queryFeature(cu.class));

    public gu(Context context, an anVar) {
        super(context);
        this.a = (c) anVar;
        b(j.bookshelf__list_item_menu_view__delete);
        b(j.bookshelf__list_item_menu_view__change_group);
        a(new gv(this));
    }
}
