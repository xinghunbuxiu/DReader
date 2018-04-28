package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.eb;
import com.duokan.reader.domain.cloud.DkCloudComment;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.PinView;
import com.duokan.reader.ui.general.bo;
import com.duokan.reader.ui.general.deprecatedDkTextView;
import com.duokan.reader.ui.general.dk;
import com.duokan.reader.ui.general.hc;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public abstract class mz extends LinearLayout {
    /* renamed from: b */
    protected HeaderView f8947b;
    /* renamed from: c */
    protected DkWebListView f8948c;
    /* renamed from: d */
    protected SimpleDateFormat f8949d = new SimpleDateFormat("yyyy-MM-dd");
    /* renamed from: e */
    protected List<DkCloudComment> f8950e = new LinkedList();

    /* renamed from: a */
    protected abstract void mo1965a(int i);

    /* renamed from: a */
    protected abstract void mo1966a(View view);

    public mz(Context context) {
        super(context);
        setOrientation(1);
        setBackgroundColor(getResources().getColor(C0252d.general__shared__ffffff));
        this.f8947b = new PageHeaderView(getContext());
        this.f8947b.setLeftTitle(getHeaderViewTitle());
        addView(this.f8947b);
        addView(getListView(), new LayoutParams(-1, 0, 1.0f));
    }

    /* renamed from: b */
    public void m12291b() {
        this.f8948c.m9954a();
    }

    protected String getHeaderViewTitle() {
        return getResources().getString(C0258j.personal__reading_note_info_view__title);
    }

    /* renamed from: a */
    protected void mo1967a(View view, int i) {
        DkCloudComment dkCloudComment = (DkCloudComment) this.f8950e.get(i);
        ((ImageView) view.findViewById(C0255g.personal__notes_info_item_view__color)).setImageDrawable(new ColorDrawable(eb.m4386a().m4392d(dkCloudComment.getHighlightColor())));
        Drawable hcVar = new hc();
        hcVar.m10739a(eb.m4386a().m4392d(dkCloudComment.getHighlightColor()));
        view.findViewById(C0255g.personal__notes_info_item_view__read).setBackgroundDrawable(hcVar);
        ((TextView) view.findViewById(C0255g.personal__notes_info_item_view__time)).setText(this.f8949d.format(dkCloudComment.getCreationDate()));
        ((PinView) view.findViewById(C0255g.personal__notes_info_item_view__sample)).setText(dkCloudComment.getSample());
        deprecatedDkTextView deprecateddktextview = (deprecatedDkTextView) view.findViewById(C0255g.personal__notes_info_item_view__note);
        if (TextUtils.isEmpty(dkCloudComment.getNoteText())) {
            deprecateddktextview.setVisibility(8);
            deprecateddktextview.setUseBitmapCache(false);
            deprecateddktextview.setText("");
            return;
        }
        deprecateddktextview.setUseBitmapCache(true);
        deprecateddktextview.setUsePartialDraw(true);
        deprecateddktextview.setText(dkCloudComment.getNoteText());
        deprecateddktextview.setVisibility(0);
    }

    /* renamed from: a */
    protected void mo1964a() {
        this.f8947b.setLeftTitle(getHeaderViewTitle());
        int c = this.f8948c.getAdapter().mo506c();
        ((TextView) this.f8948c.findViewById(C0255g.personal__notes_info_header_view__count)).setText(String.format(getContext().getString(C0258j.personal__reading_notes_header_view__count), new Object[]{Integer.valueOf(c)}));
    }

    private DkWebListView getListView() {
        if (this.f8948c == null) {
            this.f8948c = new DkWebListView(getContext());
            this.f8948c.setBackgroundColor(-1);
            C0435s c0435s = (C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class);
            this.f8948c.m9955a(0, 0, 0, c0435s == null ? 0 : c0435s.getTheme().getPagePaddingBottom());
            this.f8948c.setRowDivider(new InsetDrawable(new dk(getResources().getColor(C0252d.general__shared__cccccc)), dv.m1932b(getContext(), 15.0f), 0, dv.m1932b(getContext(), 15.0f), 0));
            View inflate = inflate(getContext(), C0256h.personal__notes_info_header_view, null);
            mo1966a(inflate);
            this.f8948c.setHatBodyView(inflate);
            this.f8948c.setAdapter(getAdapter());
        }
        return this.f8948c;
    }

    private bo getAdapter() {
        return new na(this);
    }
}
