package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.IFeature;
import com.duokan.reader.domain.cloud.DkCloudRedeemFund;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.bo;
import com.duokan.reader.ui.general.cc;

import java.util.LinkedList;
import java.util.List;

public class gp extends bo {
    private IFeature a;
    private String c = "";
    private List d = new LinkedList();
    private final gr e;

    public /* synthetic */ Object d(int i) {
        return c(i);
    }

    public gp(IFeature featrue) {
        this.a = featrue;
        this.e = (gr) this.a.queryFeature(gr.class);
    }

    public int a() {
        return this.d.size() == 0 ? 0 : 1;
    }

    public int a(int i) {
        return this.d.size();
    }

    public int c() {
        return this.d.size();
    }

    protected void b() {
        this.d.clear();
    }

    protected boolean e() {
        this.e.a(0, 50, this.d);
        return true;
    }

    public DkCloudRedeemFund c(int i) {
        return (DkCloudRedeemFund) this.d.get(i);
    }

    protected void e(int i) {
        this.e.a(c(), i, this.d);
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            return LayoutInflater.from((Context) this.a).inflate(h.personal__personal_redeem_listview__header, viewGroup, false);
        }
        return view;
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        return a(i, view, viewGroup, false);
    }

    public View a(int i, View view, ViewGroup viewGroup, boolean z) {
        if (view == null || view.findViewById(g.personal__personal_redeem_item_view__cover) == null) {
            view = LayoutInflater.from((Context) this.a).inflate(h.personal__personal_redeem_item_view, viewGroup, false);
        }
        if (z) {
            view.findViewById(g.personal__personal_redeem_item_view__group_title).setVisibility(0);
        } else {
            view.findViewById(g.personal__personal_redeem_item_view__group_title).setVisibility(8);
        }
        int color = ((Context) this.a).getResources().getColor(d.general__shared__ed6c00);
        DkCloudRedeemFund c = c(i);
        BookCoverView bookCoverView = (BookCoverView) view.findViewById(g.personal__personal_redeem_item_view__cover);
        TextView textView = (TextView) view.findViewById(g.personal__personal_redeem_item_view__title);
        TextView textView2 = (TextView) view.findViewById(g.personal__personal_redeem_item_view__author);
        bookCoverView.setOnlineCoverUri(c.getBookCoverUrl());
        bookCoverView.setCoverBackgroundResource(f.general__book_cover_view__duokan_cover);
        bookCoverView.a();
        textView.setText(ReaderUi.a(c.getTitle(), this.c, color));
        if (TextUtils.isEmpty(c.getNameLine())) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(c.getNameLine());
        }
        TextView textView3 = (TextView) view.findViewById(g.personal__personal_redeem_item_view__state);
        if (c.isUsed()) {
            textView3.setText(j.personal__personal_redeem_item_view__status_received);
            textView3.setBackgroundResource(f.personal__purchased_book_item__tag_background_orange);
        } else {
            textView3.setBackgroundResource(f.personal__purchased_book_item__tag_background_grey);
            textView3.setText(j.personal__personal_redeem_item_view__status_unused);
        }
        ((TextView) view.findViewById(g.personal__personal_redeem_item_view__date)).setText(ReaderUi.a((Context) this.a, c.getReceivedTime().getTime(), false));
        return view;
    }

    public View a(View view, ViewGroup viewGroup) {
        cc ccVar = new cc((Context) this.a);
        ccVar.b(j.personal__personal_redeems_view__empty_first_line);
        ccVar.a().findViewById(g.general__emtpy_view__line_2).setVisibility(8);
        TextView textView = (TextView) ccVar.a().findViewById(g.general__emtpy_view__line_3);
        textView.setVisibility(0);
        textView.setText(j.personal__personal_redeems_view__empty_second_line);
        textView.setOnClickListener(new gq(this));
        return ccVar.a();
    }
}
