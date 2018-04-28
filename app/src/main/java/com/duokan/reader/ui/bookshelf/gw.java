package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.cloud.DkCloudRedeemFund;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.bo;
import com.duokan.reader.ui.general.cc;
import java.util.LinkedList;
import java.util.List;

public class gw extends bo {
    /* renamed from: a */
    private IFeature f6530a;
    /* renamed from: c */
    private String f6531c = "";
    /* renamed from: d */
    private List<DkCloudRedeemFund> f6532d = new LinkedList();
    /* renamed from: e */
    private final gy f6533e;

    /* renamed from: d */
    public /* synthetic */ Object mo509d(int i) {
        return mo1556c(i);
    }

    public gw(IFeature mFeature) {
        this.f6530a = mFeature;
        this.f6533e = (gy) this.f6530a.queryFeature(gy.class);
    }

    /* renamed from: a */
    public int mo486a() {
        return this.f6532d.size() == 0 ? 0 : 1;
    }

    /* renamed from: a */
    public int mo487a(int i) {
        return this.f6532d.size();
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f6532d.size();
    }

    /* renamed from: b */
    protected void mo1555b() {
        this.f6532d.clear();
    }

    /* renamed from: e */
    protected boolean mo1712e() {
        this.f6533e.mo1929a(0, 50, this.f6532d);
        return true;
    }

    /* renamed from: c */
    public DkCloudRedeemFund mo1556c(int i) {
        return (DkCloudRedeemFund) this.f6532d.get(i);
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
        this.f6533e.mo1929a(mo506c(), i, this.f6532d);
    }

    /* renamed from: a */
    public View mo488a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            return LayoutInflater.from((Context) this.f6530a).inflate(C0256h.personal__personal_redeem_listview__header, viewGroup, false);
        }
        return view;
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        return m9748a(i, view, viewGroup, false);
    }

    /* renamed from: a */
    public View m9748a(int i, View view, ViewGroup viewGroup, boolean z) {
        if (view == null || view.findViewById(C0255g.personal__personal_redeem_item_view__cover) == null) {
            view = LayoutInflater.from((Context) this.f6530a).inflate(C0256h.personal__personal_redeem_item_view, viewGroup, false);
        }
        if (z) {
            view.findViewById(C0255g.personal__personal_redeem_item_view__group_title).setVisibility(0);
        } else {
            view.findViewById(C0255g.personal__personal_redeem_item_view__group_title).setVisibility(8);
        }
        int color = ((Context) this.f6530a).getResources().getColor(C0252d.general__shared__ed6c00);
        DkCloudRedeemFund c = mo1556c(i);
        BookCoverView bookCoverView = (BookCoverView) view.findViewById(C0255g.personal__personal_redeem_item_view__cover);
        TextView textView = (TextView) view.findViewById(C0255g.personal__personal_redeem_item_view__title);
        TextView textView2 = (TextView) view.findViewById(C0255g.personal__personal_redeem_item_view__author);
        bookCoverView.setOnlineCoverUri(c.getBookCoverUrl());
        bookCoverView.setCoverBackgroundResource(C0254f.general__book_cover_view__duokan_cover);
        bookCoverView.m9919a();
        textView.setText(ReaderUi.m10156a(c.getTitle(), this.f6531c, color));
        if (TextUtils.isEmpty(c.getNameLine())) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(c.getNameLine());
        }
        TextView textView3 = (TextView) view.findViewById(C0255g.personal__personal_redeem_item_view__state);
        if (c.isUsed()) {
            textView3.setText(C0258j.personal__personal_redeem_item_view__status_received);
            textView3.setBackgroundResource(C0254f.personal__purchased_book_item__tag_background_orange);
        } else {
            textView3.setBackgroundResource(C0254f.personal__purchased_book_item__tag_background_grey);
            textView3.setText(C0258j.personal__personal_redeem_item_view__status_unused);
        }
        ((TextView) view.findViewById(C0255g.personal__personal_redeem_item_view__date)).setText(ReaderUi.m10159a((Context) this.f6530a, c.getReceivedTime().getTime(), false));
        return view;
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        cc ccVar = new cc((Context) this.f6530a);
        ccVar.m10335b(C0258j.personal__personal_redeems_view__empty_first_line);
        ccVar.m10333a().findViewById(C0255g.general__emtpy_view__line_2).setVisibility(8);
        TextView textView = (TextView) ccVar.m10333a().findViewById(C0255g.general__emtpy_view__line_3);
        textView.setVisibility(0);
        textView.setText(C0258j.personal__personal_redeems_view__empty_second_line);
        textView.setOnClickListener(new gx(this));
        return ccVar.m10333a();
    }
}
