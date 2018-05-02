package com.duokan.reader.ui.bookshelf;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.ui.C0435s;

/* renamed from: com.duokan.reader.ui.bookshelf.do */
public class C1287do extends he {
    /* renamed from: a */
    private final ReaderFeature f6348a = ((ReaderFeature) getContext().queryFeature(ReaderFeature.class));
    /* renamed from: b */
    private final cw f6349b = ((cw) getContext().queryFeature(cw.class));
    /* renamed from: c */
    private final cz f6350c = ((cz) getContext().queryFeature(cz.class));
    /* renamed from: d */
    private final TextView f6351d;
    /* renamed from: e */
    private final TextView f6352e;
    /* renamed from: f */
    private final View f6353f;

    public C1287do(IFeature mFeature) {
        super(mFeature);
        View inflate = LayoutInflater.from(getContext()).inflate(C0256h.bookshelf__bookshelf_menu_view, null);
        this.f6351d = (TextView) inflate.findViewById(C0255g.bookshelf__bookshelf_menu_view__show_books);
        TextView textView = (TextView) inflate.findViewById(C0255g.bookshelf__bookshelf_menu_view__show_sign_in);
        this.f6352e = (TextView) inflate.findViewById(C0255g.bookshelf__bookshelf_menu_view__purchased_books_text);
        this.f6353f = inflate.findViewById(C0255g.bookshelf__bookshelf_menu_view__purchased_books_dot);
        inflate.findViewById(C0255g.bookshelf__bookshelf_menu_view__purchased_books).setOnClickListener(new dp(this));
        if (this.f6349b.m9445e()) {
            Drawable drawable = getResources().getDrawable(C0254f.bookshelf__bookshelf_menu_view__show);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.f6351d.setCompoundDrawables(null, drawable, null, null);
            this.f6351d.setTextColor(Color.rgb(240, 130, 24));
        }
        this.f6351d.setOnClickListener(new ds(this));
        inflate.findViewById(C0255g.bookshelf__bookshelf_menu_view__import_local_books).setOnClickListener(new dt(this));
        inflate.findViewById(C0255g.bookshelf__bookshelf_menu_view__show_wifi).setOnClickListener(new dv(this));
        textView.setOnClickListener(new dw(this));
        inflate.findViewById(C0255g.bookshelf__bookshelf_menu_view__bookshelf_style).setOnClickListener(new dy(this));
        m9490a(inflate);
        m9489a(((C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class)).getTheme().getPageHeaderHeight());
    }

    /* renamed from: e */
    private void m9501e() {
        if (this.f6349b.m9445e()) {
            Drawable drawable = getResources().getDrawable(C0254f.bookshelf__bookshelf_menu_view__show);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.f6351d.setCompoundDrawables(null, drawable, null, null);
            this.f6351d.setTextColor(Color.rgb(240, 130, 24));
            return;
        }
        drawable = getResources().getDrawable(C0254f.bookshelf__bookshelf_menu_view__hide);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.f6351d.setCompoundDrawables(null, drawable, null, null);
        this.f6351d.setTextColor(Color.rgb(141, 141, 141));
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z && !PersonalPrefs.m5175a().m5241q()) {
            PersonalPrefs.m5175a().m5226e(true);
        }
        if (C0709k.m3476a().m3501b().equals(AccountType.ANONYMOUS)) {
            this.f6352e.setText(C0258j.surfing__shared__purchased);
        } else {
            this.f6352e.setText(C0258j.bookshelf__add_book_menu_view__to_own);
        }
        if (PersonalPrefs.m5175a().m5248x()) {
            this.f6353f.setVisibility(0);
        }
    }

    /* renamed from: a */
    public void m9502a(he heVar) {
        heVar.m9489a(m9496d());
        heVar.m9491a(m9495c());
        m9491a(new dz(this, heVar));
        requestBack();
    }
}
