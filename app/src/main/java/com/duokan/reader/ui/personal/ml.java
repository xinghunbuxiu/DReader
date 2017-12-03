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

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.bookshelf.eg;
import com.duokan.reader.domain.cloud.DkCloudComment;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.PinView;
import com.duokan.reader.ui.general.bo;
import com.duokan.reader.ui.general.deprecatedDkTextView;
import com.duokan.reader.ui.general.dk;
import com.duokan.reader.ui.general.hn;
import com.duokan.reader.ui.s;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public abstract class ml extends LinearLayout {
    protected HeaderView b;
    protected DkWebListView c;
    protected SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
    protected List e = new LinkedList();

    protected abstract void a(int i);

    protected abstract void a(View view);

    public ml(Context context) {
        super(context);
        setOrientation(1);
        setBackgroundColor(getResources().getColor(d.general__shared__ffffff));
        this.b = new PageHeaderView(getContext());
        this.b.setLeftTitle(getHeaderViewTitle());
        addView(this.b);
        addView(getListView(), new LayoutParams(-1, 0, 1.0f));
    }

    public void b() {
        this.c.a();
    }

    protected String getHeaderViewTitle() {
        return getResources().getString(j.personal__reading_note_info_view__title);
    }

    protected void a(View view, int i) {
        DkCloudComment dkCloudComment = (DkCloudComment) this.e.get(i);
        ((ImageView) view.findViewById(g.personal__notes_info_item_view__color)).setImageDrawable(new ColorDrawable(eg.a().d(dkCloudComment.getHighlightColor())));
        Drawable hnVar = new hn();
        hnVar.a(eg.a().d(dkCloudComment.getHighlightColor()));
        view.findViewById(g.personal__notes_info_item_view__read).setBackgroundDrawable(hnVar);
        ((TextView) view.findViewById(g.personal__notes_info_item_view__time)).setText(this.d.format(dkCloudComment.getCreationDate()));
        PinView pinView = (PinView) view.findViewById(g.personal__notes_info_item_view__sample);
        pinView.setText(dkCloudComment.getSample());
        pinView.setUseBitmapCache(true);
        pinView.setUsePartialDraw(true);
        deprecatedDkTextView com_duokan_reader_ui_general_deprecatedDkTextView = (deprecatedDkTextView) view.findViewById(g.personal__notes_info_item_view__note);
        if (TextUtils.isEmpty(dkCloudComment.getNoteText())) {
            com_duokan_reader_ui_general_deprecatedDkTextView.setVisibility(8);
            com_duokan_reader_ui_general_deprecatedDkTextView.setUseBitmapCache(false);
            com_duokan_reader_ui_general_deprecatedDkTextView.setText("");
            return;
        }
        com_duokan_reader_ui_general_deprecatedDkTextView.setUseBitmapCache(true);
        com_duokan_reader_ui_general_deprecatedDkTextView.setUsePartialDraw(true);
        com_duokan_reader_ui_general_deprecatedDkTextView.setText(dkCloudComment.getNoteText());
        com_duokan_reader_ui_general_deprecatedDkTextView.setVisibility(0);
    }

    protected void a() {
        this.b.setLeftTitle(getHeaderViewTitle());
        int c = this.c.getAdapter().c();
        ((TextView) this.c.findViewById(g.personal__notes_info_header_view__count)).setText(String.format(getContext().getString(j.personal__reading_notes_header_view__count), new Object[]{Integer.valueOf(c)}));
    }

    private DkWebListView getListView() {
        if (this.c == null) {
            this.c = new DkWebListView(getContext());
            this.c.setBackgroundColor(-1);
            s sVar = (s) MyContextWrapper.getFeature(getContext()).queryFeature(s.class);
            this.c.a(0, 0, 0, sVar == null ? 0 : sVar.getTheme().getPagePaddingBottom());
            this.c.setRowDivider(new InsetDrawable(new dk(getResources().getColor(d.general__shared__cccccc)), UTools.closeAnimation(getContext(), 15.0f), 0, UTools.closeAnimation(getContext(), 15.0f), 0));
            View inflate = inflate(getContext(), h.personal__notes_info_header_view, null);
            a(inflate);
            this.c.setHatBodyView(inflate);
            this.c.setAdapter(getAdapter());
        }
        return this.c;
    }

    private bo getAdapter() {
        return new mm(this);
    }
}
