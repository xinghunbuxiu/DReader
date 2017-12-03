package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.DkEditorView;
import com.duokan.reader.ui.bookshelf.gw;
import com.duokan.reader.ui.bookshelf.hn;
import com.duokan.reader.ui.bookshelf.ho;
import com.duokan.reader.ui.bookshelf.il;
import com.duokan.reader.ui.e;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.eh;
import com.duokan.reader.ui.general.expandable.ViewMode;
import com.duokan.reader.ui.s;

public class nm extends FrameLayout {
    private gw a;
    protected final PageHeaderView b;
    protected final LinearLayout c;
    protected final FrameLayout d;
    protected final DkWebListView e;
    protected final DkEditorView f;
    protected final View g;
    protected final ho h;
    protected hn i;
    protected il j = null;
    private gw k;

    public nm(Context context, ho hoVar) {
        super(context);
        this.h = hoVar;
        LayoutInflater.from(context).inflate(h.bookshelf__book_list_base_view, this);
        this.b = (PageHeaderView) findViewById(g.bookshelf__weblist_base_view__header);
        this.b.setHasBackButton(true);
        this.c = (LinearLayout) findViewById(g.bookshelf__weblist_base_view__search);
        this.d = (FrameLayout) findViewById(g.bookshelf__weblist_base_view__body_bottom);
        this.f = (DkEditorView) findViewById(g.bookshelf__weblist_base_view__search_input);
        this.e = (DkWebListView) findViewById(g.bookshelf__weblist_base_view__weblist);
        this.e.setBackgroundColor(getResources().getColor(d.general__shared__ffffff));
        this.f.addTextChangedListener(new nn(this));
        this.g = findViewById(g.bookshelf__weblist_base_view__search_cancel);
        this.g.setOnClickListener(new no(this));
        a(this.e);
    }

    public void a(boolean z) {
        getAdapter().a(false);
    }

    public void i() {
        getAdapter().d();
    }

    public void b(boolean z) {
        this.e.a(z);
    }

    public boolean j() {
        if (getAdapter().f() != ViewMode.Edit) {
            return false;
        }
        d();
        return true;
    }

    public HeaderView getHeaderView() {
        return this.b;
    }

    public void a() {
        this.f.setEnabled(false);
        this.g.setEnabled(false);
    }

    public void b() {
        this.f.setEnabled(true);
        this.g.setEnabled(true);
    }

    public boolean k() {
        return getAdapter() == this.k;
    }

    public void l() {
        this.f.getText().clear();
    }

    public void e() {
        if (this.e.getAdapter() == this.a) {
            this.e.setAdapter(this.k);
            this.e.setPullDownRefreshEnabled(false);
            this.k.a(false);
            this.e.scrollTo(0, 0);
        }
    }

    public void f() {
        if (this.e.getAdapter() == this.k) {
            this.e.setAdapter(this.a);
            this.e.setPullDownRefreshEnabled(true);
            this.a.a(false);
            this.e.scrollTo(0, 0);
        }
    }

    public void m() {
        getAdapter().h();
    }

    public void n() {
        getAdapter().i();
    }

    public boolean c() {
        return getAdapter().g() == getAdapter().c();
    }

    public int getSelectedCount() {
        return getAdapter().g();
    }

    public void o() {
        String trim = this.f.getText().toString().trim();
        if (this.i != null) {
            this.i.a(trim);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q();
    }

    public void p() {
        ReaderUi.a(getContext(), this.f);
    }

    public ViewMode getViewMode() {
        return getAdapter().f();
    }

    protected gw getAdapter() {
        return (gw) this.e.getAdapter();
    }

    protected gw getNormalAdapter() {
        return this.a;
    }

    protected void setSearchAdapter(gw gwVar) {
        this.k = gwVar;
    }

    protected void setAdapter(gw gwVar) {
        this.a = gwVar;
        this.e.setAdapter(this.a);
        this.a.d();
    }

    protected DkWebListView getListView() {
        return this.e;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i3 != i) {
            this.e.setNumColumns(eh.a(getContext(), i));
        }
    }

    private void a(int i, int i2) {
        if (this.j == null) {
            getAdapter().a(i, i2, true);
            getAdapter().a(ViewMode.Edit);
            this.j = new il(MyContextWrapper.getFeature(getContext()), this.h);
            ((e) MyContextWrapper.getFeature(getContext()).queryFeature(e.class)).showPopup(this.j, 119, 0);
        }
    }

    private void d() {
        if (this.j != null) {
            this.j.d();
            getAdapter().a(ViewMode.Normal);
            getAdapter().i();
            this.j = null;
        }
    }

    private void a(DkWebListView dkWebListView) {
        dkWebListView.setSeekEnabled(true);
        dkWebListView.setVerticalSeekDrawable(getResources().getDrawable(f.general__shared__thumb_seek_vert));
        eh.a(dkWebListView);
        s sVar = (s) MyContextWrapper.getFeature(getContext()).queryFeature(s.class);
        dkWebListView.a(0, 0, 0, sVar == null ? 0 : sVar.getTheme().getPagePaddingBottom());
        dkWebListView.setOnItemClickListener(new np(this));
        dkWebListView.setOnItemLongPressListener(new nq(this));
        dkWebListView.setOnScrollListener(new nr(this));
    }

    public void b(int i, int i2) {
        ReaderUi.a(getContext(), this.f);
        if (getAdapter().f() != ViewMode.Edit) {
            return;
        }
        if (getAdapter().b(i, i2)) {
            getAdapter().a(i, i2, false);
            if (this.j != null) {
                this.j.b();
                return;
            }
            return;
        }
        getAdapter().a(i, i2, true);
        if (this.j != null) {
            this.j.a();
        }
    }

    public void c(int i, int i2) {
        ReaderUi.a(getContext(), this.f);
        if (getAdapter().f() != ViewMode.Edit) {
            a(i, i2);
        }
    }

    public void q() {
        if (getAdapter().f() == ViewMode.Edit) {
            d();
        }
    }
}
