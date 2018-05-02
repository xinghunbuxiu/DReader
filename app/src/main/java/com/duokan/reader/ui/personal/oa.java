package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.DkEditorView;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.C0436e;
import com.duokan.reader.ui.bookshelf.hd;
import com.duokan.reader.ui.bookshelf.hu;
import com.duokan.reader.ui.bookshelf.hv;
import com.duokan.reader.ui.bookshelf.jj;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.eg;
import com.duokan.reader.ui.general.expandable.ViewMode;

public class oa extends FrameLayout {
    /* renamed from: a */
    private hd f8367a;
    /* renamed from: b */
    protected final PageHeaderView f8368b;
    /* renamed from: c */
    protected final LinearLayout f8369c;
    /* renamed from: d */
    protected final FrameLayout f8370d;
    /* renamed from: e */
    protected final FrameLayout f8371e;
    /* renamed from: f */
    protected final DkWebListView f8372f;
    /* renamed from: g */
    protected final DkEditorView f8373g;
    /* renamed from: h */
    protected final View f8374h;
    /* renamed from: i */
    protected final hv f8375i;
    /* renamed from: j */
    protected hu f8376j;
    /* renamed from: k */
    protected jj f8377k = null;
    /* renamed from: l */
    private hd f8378l;

    public oa(Context context, hv hvVar) {
        super(context);
        this.f8375i = hvVar;
        LayoutInflater.from(context).inflate(C0256h.bookshelf__book_list_base_view, this);
        this.f8368b = (PageHeaderView) findViewById(C0255g.bookshelf__weblist_base_view__header);
        this.f8368b.setHasBackButton(true);
        this.f8369c = (LinearLayout) findViewById(C0255g.bookshelf__weblist_base_view__search);
        this.f8370d = (FrameLayout) findViewById(C0255g.bookshelf__weblist_base_view__body_top);
        this.f8371e = (FrameLayout) findViewById(C0255g.bookshelf__weblist_base_view__body_bottom);
        this.f8373g = (DkEditorView) findViewById(C0255g.bookshelf__weblist_base_view__search_input);
        this.f8372f = (DkWebListView) findViewById(C0255g.bookshelf__weblist_base_view__weblist);
        this.f8372f.setBackgroundColor(getResources().getColor(C0252d.general__shared__ffffff));
        this.f8373g.addTextChangedListener(new ob(this));
        this.f8374h = findViewById(C0255g.bookshelf__weblist_base_view__search_cancel);
        this.f8374h.setOnClickListener(new oc(this));
        m11517a(this.f8372f);
    }

    /* renamed from: a */
    public void mo1901a(boolean z) {
        getAdapter().m8785a(false);
    }

    /* renamed from: i */
    public void m11528i() {
        getAdapter().mo1691d();
    }

    /* renamed from: b */
    public void m11523b(boolean z) {
        this.f8372f.m9960a(z);
    }

    /* renamed from: j */
    public boolean m11529j() {
        if (getAdapter().mo1714f() != ViewMode.Edit) {
            return false;
        }
        mo1903d();
        return true;
    }

    public HeaderView getHeaderView() {
        return this.f8368b;
    }

    /* renamed from: a */
    public void mo1891a() {
        this.f8373g.setEnabled(false);
        this.f8374h.setEnabled(false);
    }

    /* renamed from: b */
    public void mo1892b() {
        this.f8373g.setEnabled(true);
        this.f8374h.setEnabled(true);
    }

    /* renamed from: k */
    public boolean m11530k() {
        return getAdapter() == this.f8378l;
    }

    /* renamed from: l */
    public void m11531l() {
        this.f8373g.getText().clear();
    }

    /* renamed from: e */
    public void mo1940e() {
        if (this.f8372f.getAdapter() == this.f8367a) {
            this.f8372f.setAdapter(this.f8378l);
            this.f8372f.setPullDownRefreshEnabled(false);
            this.f8378l.m8785a(false);
            this.f8372f.scrollTo(0, 0);
        }
    }

    /* renamed from: f */
    public void mo1941f() {
        if (this.f8372f.getAdapter() == this.f8378l) {
            this.f8372f.setAdapter(this.f8367a);
            this.f8372f.setPullDownRefreshEnabled(true);
            this.f8367a.m8785a(false);
            this.f8372f.scrollTo(0, 0);
        }
    }

    /* renamed from: m */
    public void m11532m() {
        getAdapter().mo1949h();
    }

    /* renamed from: n */
    public void m11533n() {
        getAdapter().m9787i();
    }

    /* renamed from: c */
    public boolean mo1939c() {
        return getAdapter().mo1715g() == getAdapter().mo506c();
    }

    public int getSelectedCount() {
        return getAdapter().mo1715g();
    }

    /* renamed from: o */
    public void m11534o() {
        String trim = this.f8373g.getText().toString().trim();
        if (this.f8376j != null) {
            this.f8376j.mo1719a(trim);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo2232q();
    }

    /* renamed from: p */
    public void m11535p() {
        ReaderUi.m10161a(getContext(), this.f8373g);
    }

    public ViewMode getViewMode() {
        return getAdapter().mo1714f();
    }

    protected hd getAdapter() {
        return (hd) this.f8372f.getAdapter();
    }

    protected hd getNormalAdapter() {
        return this.f8367a;
    }

    protected void setSearchAdapter(hd hdVar) {
        this.f8378l = hdVar;
    }

    protected void setAdapter(hd hdVar) {
        this.f8367a = hdVar;
        this.f8372f.setAdapter(this.f8367a);
        this.f8367a.mo1691d();
    }

    protected DkWebListView getListView() {
        return this.f8372f;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i3 != i) {
            this.f8372f.setNumColumns(eg.m10551a(getContext(), i));
        }
    }

    /* renamed from: a */
    private void mo1924a(int i, int i2) {
        if (this.f8377k == null) {
            getAdapter().m9777a(i, i2, true);
            getAdapter().m9779a(ViewMode.Edit);
            this.f8377k = new jj(AppContext.getAppContext(getContext()), this.f8375i);
            ((C0436e) AppContext.getAppContext(getContext()).queryFeature(C0436e.class)).showPopup(this.f8377k, 119, 0);
        }
    }

    /* renamed from: d */
    private void mo1903d() {
        if (this.f8377k != null) {
            this.f8377k.m9876d();
            getAdapter().m9779a(ViewMode.Normal);
            getAdapter().m9787i();
            this.f8377k = null;
        }
    }

    /* renamed from: a */
    private void m11517a(DkWebListView dkWebListView) {
        dkWebListView.setSeekEnabled(true);
        dkWebListView.setVerticalSeekDrawable(getResources().getDrawable(C0254f.general__shared__thumb_seek_vert));
        eg.m10556a(dkWebListView);
        C0435s c0435s = (C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class);
        dkWebListView.m9955a(0, 0, 0, c0435s == null ? 0 : c0435s.getTheme().getPagePaddingBottom());
        dkWebListView.setOnItemClickListener(new od(this));
        dkWebListView.setOnItemLongPressListener(new oe(this));
        dkWebListView.setOnScrollListener(new of(this));
    }

    /* renamed from: b */
    public void m11522b(int i, int i2) {
        ReaderUi.m10161a(getContext(), this.f8373g);
        if (getAdapter().mo1714f() != ViewMode.Edit) {
            return;
        }
        if (getAdapter().mo1713b(i, i2)) {
            getAdapter().m9777a(i, i2, false);
            if (this.f8377k != null) {
                this.f8377k.m9874b();
                return;
            }
            return;
        }
        getAdapter().m9777a(i, i2, true);
        if (this.f8377k != null) {
            this.f8377k.m9873a();
        }
    }

    /* renamed from: c */
    public void mo2231c(int i, int i2) {
        ReaderUi.m10161a(getContext(), this.f8373g);
        if (getAdapter().mo1714f() != ViewMode.Edit) {
            mo1924a(i, i2);
        }
    }

    /* renamed from: q */
    public void mo2232q() {
        if (getAdapter().mo1714f() == ViewMode.Edit) {
            mo1903d();
        }
    }
}
