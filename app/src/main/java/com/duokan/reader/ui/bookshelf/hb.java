package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import com.duokan.core.app.AppContext;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.ui.general.hp;

public class hb extends hp {
    /* renamed from: a */
    private C0800c f6539a;
    /* renamed from: b */
    private cz f6540b = ((cz) AppContext.getAppContext(getContext()).queryFeature(cz.class));

    public hb(Context context, an anVar) {
        super(context);
        this.f6539a = (C0800c) anVar;
        m9769b(C0258j.bookshelf__list_item_menu_view__delete);
        m9769b(C0258j.bookshelf__list_item_menu_view__change_group);
        m9767a(new hc(this));
    }
}
