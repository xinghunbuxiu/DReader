package com.duokan.reader.ui.bookshelf;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.y;
import com.duokan.core.ui.dv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.PersonalPrefs;

public class dh extends gx {
    private final ReaderFeature a = ((ReaderFeature) getContext().queryFeature(ReaderFeature.class));
    private final cr b = ((cr) getContext().queryFeature(cr.class));
    private final cu c = ((cu) getContext().queryFeature(cu.class));
    private final TextView d;
    private final TextView e;
    private final View f;

    public dh(y yVar) {
        super(yVar);
        View inflate = LayoutInflater.from(getContext()).inflate(h.bookshelf__bookshelf_menu_view, null);
        this.d = (TextView) inflate.findViewById(g.bookshelf__bookshelf_menu_view__show_books);
        TextView textView = (TextView) inflate.findViewById(g.bookshelf__bookshelf_menu_view__show_sign_in);
        this.e = (TextView) inflate.findViewById(g.bookshelf__bookshelf_menu_view__purchased_books_text);
        this.f = inflate.findViewById(g.bookshelf__bookshelf_menu_view__purchased_books_dot);
        inflate.findViewById(g.bookshelf__bookshelf_menu_view__purchased_books).setOnClickListener(new di(this));
        if (this.b.e()) {
            Drawable drawable = getResources().getDrawable(f.bookshelf__bookshelf_menu_view__show);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.d.setCompoundDrawables(null, drawable, null, null);
            this.d.setTextColor(Color.rgb(240, 130, 24));
        }
        this.d.setOnClickListener(new dl(this));
        inflate.findViewById(g.bookshelf__bookshelf_menu_view__import_local_books).setOnClickListener(new dm(this));
        inflate.findViewById(g.bookshelf__bookshelf_menu_view__show_wifi).setOnClickListener(new do(this));
        textView.setOnClickListener(new dp(this));
        inflate.findViewById(g.bookshelf__bookshelf_menu_view__bookshelf_style).setOnClickListener(new dq(this));
        a(inflate);
        a(dv.b(getContext(), 65.0f));
    }

    private void c() {
        if (this.b.e()) {
            Drawable drawable = getResources().getDrawable(f.bookshelf__bookshelf_menu_view__show);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.d.setCompoundDrawables(null, drawable, null, null);
            this.d.setTextColor(Color.rgb(240, 130, 24));
            return;
        }
        drawable = getResources().getDrawable(f.bookshelf__bookshelf_menu_view__hide);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.d.setCompoundDrawables(null, drawable, null, null);
        this.d.setTextColor(Color.rgb(141, 141, 141));
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z && !PersonalPrefs.a().q()) {
            PersonalPrefs.a().e(true);
        }
        if (i.f().a().equals(AccountType.ANONYMOUS)) {
            this.e.setText(j.surfing__shared__purchased);
        } else {
            this.e.setText(j.bookshelf__add_book_menu_view__to_own);
        }
        if (PersonalPrefs.a().w()) {
            this.f.setVisibility(0);
        }
    }

    public void a(gx gxVar) {
        gxVar.a(f());
        gxVar.a(e());
        a(new dr(this, gxVar));
        requestBack();
    }
}
