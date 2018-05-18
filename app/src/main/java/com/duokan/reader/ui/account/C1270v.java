package com.duokan.reader.ui.account;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.duokan.core.sys.ag;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkPublic;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0705g;
import com.duokan.reader.domain.account.bd;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.store.DkStoreAbsBook;
import com.duokan.reader.domain.store.DkStoreBook;
import com.duokan.reader.ui.account.ShareEntranceController.ShareType;
import com.duokan.reader.ui.general.C1332f;
import com.duokan.reader.ui.general.DkTextView;

/* renamed from: com.duokan.reader.ui.account.v */
public class C1270v extends RelativeLayout {
    /* renamed from: a */
    private final DkTextView f5979a;
    /* renamed from: b */
    private final DkTextView f5980b;
    /* renamed from: c */
    private final TextView f5981c;
    /* renamed from: d */
    private final TextView f5982d;
    /* renamed from: e */
    private final TextView f5983e;
    /* renamed from: f */
    private final ImageView f5984f;
    /* renamed from: g */
    private final TextView f5985g;
    /* renamed from: h */
    private final TextView f5986h;
    /* renamed from: i */
    private final ImageView f5987i;
    /* renamed from: j */
    private final TextView f5988j;
    /* renamed from: k */
    private final C1332f f5989k;
    /* renamed from: l */
    private final String f5990l;
    /* renamed from: m */
    private boolean f5991m;

    public C1270v(Context context, String str) {
        this(context, null, str);
    }

    public C1270v(Context context, AttributeSet attributeSet, String str) {
        super(context, attributeSet);
        this.f5991m = true;
        this.f5990l = str;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(C0256h.account__share_bitmap_factory_view, this, false);
        linearLayout.setBackgroundColor(-1);
        addView(linearLayout);
        this.f5979a = (DkTextView) findViewById(C0255g.account__share_bitmap_factory_view__pub_text);
        this.f5984f = (ImageView) findViewById(C0255g.account__share_bitmap_factory_view__cover);
        this.f5987i = (ImageView) findViewById(C0255g.account__share_bitmap_factory_view__qrcode);
        this.f5980b = (DkTextView) findViewById(C0255g.account__share_bitmap_factory_view__pub_content);
        this.f5985g = (TextView) findViewById(C0255g.account__share_bitmap_factory_view__title);
        this.f5986h = (TextView) findViewById(C0255g.account__share_bitmap_factory_view__author);
        this.f5988j = (TextView) findViewById(C0255g.account__share_bitmap_factory_view__hint);
        this.f5989k = new C1332f(getContext(), 0);
        setBackgroundColor(0);
        this.f5979a.setLineGap(1.6d);
        this.f5979a.setFirstLineIndent(2.0d);
        this.f5979a.setGravity(7);
        this.f5980b.setLineGap(1.6d);
        this.f5980b.setFirstLineIndent(2.0d);
        this.f5980b.setGravity(7);
        View c1271w = new C1271w(this, getContext());
        c1271w.setGravity(80);
        this.f5981c = new TextView(getContext());
        this.f5981c.setTextColor(getResources().getColor(C0252d.general__shared__c1));
        this.f5981c.getPaint().setFakeBoldText(true);
        this.f5981c.setSingleLine(true);
        this.f5981c.setEllipsize(TruncateAt.MIDDLE);
        this.f5981c.setTextSize(1, 16.0f);
        c1271w.addView(this.f5981c, new LayoutParams(0, -2));
        this.f5982d = new TextView(getContext());
        this.f5982d.setTextColor(getResources().getColor(C0252d.general__shared__c7));
        this.f5982d.setPadding(AnimUtils.m1932b(getContext(), 6.0f), 0, AnimUtils.m1932b(getContext(), 10.0f), 0);
        this.f5982d.setTextSize(1, 12.0f);
        c1271w.addView(this.f5982d);
        this.f5983e = new TextView(getContext());
        this.f5983e.setTextColor(getResources().getColor(C0252d.general__shared__c7));
        this.f5983e.setTextSize(1, 12.0f);
        this.f5983e.setGravity(5);
        c1271w.addView(this.f5983e);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(AnimUtils.m1932b(getContext(), 28.0f), AnimUtils.m1932b(getContext(), 40.0f), AnimUtils.m1932b(getContext(), 28.0f), AnimUtils.m1932b(getContext(), 25.0f));
        linearLayout.addView(c1271w, 0, layoutParams);
    }

    public void setAccount(C0672a c0672a) {
        C0705g f = c0672a.mo836f();
        if (f instanceof bd) {
            this.f5981c.setText(((bd) f).f2405e.f5458a.mNickName);
            return;
        }
        CharSequence c;
        String a = c0672a.mo836f().mo871a();
        if (TextUtils.isEmpty(a) || a.equals(c0672a.mo833c())) {
            c = c0672a.mo833c();
            if (TextUtils.isEmpty(c)) {
                c = "";
            } else {
                String[] split = a.split("@");
                if (split != null && split.length > 0) {
                    c = split[0];
                }
            }
        } else {
            Object c2 = a;
        }
        this.f5981c.setText(c2);
    }

    /* renamed from: a */
    public void m9022a(ShareType shareType, Object obj, String[] strArr, String str) {
        if (shareType != ShareType.BITMAP && shareType != ShareType.STATISTICS) {
            CharSequence string;
            if (TextUtils.isEmpty(str)) {
                this.f5983e.setVisibility(8);
            } else {
                this.f5983e.setText(str);
            }
            if (strArr != null && strArr.length > 0) {
                if (TextUtils.isEmpty(strArr[0].trim())) {
                    this.f5980b.setMaxLines(27);
                    this.f5979a.setVisibility(8);
                    findViewById(C0255g.account__share_bitmap_factory_view__pub_text_gap).setVisibility(8);
                } else {
                    this.f5979a.setText(strArr[0]);
                }
            }
            String str2 = "";
            if (shareType == ShareType.BOOK) {
                string = getResources().getString(C0258j.share_source_book);
            } else if (TextUtils.isEmpty(strArr[0].trim())) {
                string = getResources().getString(C0258j.share_source_comment);
            } else {
                string = getResources().getString(C0258j.share_source_note);
            }
            this.f5982d.setText(string);
            m9021a(shareType, obj, strArr);
        }
    }

    /* renamed from: a */
    public final boolean m9023a() {
        return this.f5989k.m10614e() || this.f5991m;
    }

    /* renamed from: a */
    public void m9021a(ShareType shareType, Object obj, String[] strArr) {
        boolean z;
        Object obj2;
        CharSequence charSequence;
        String str = "";
        String str2 = "";
        String str3 = "";
        String str4;
        if (obj instanceof C0800c) {
            C0800c c0800c = (C0800c) obj;
            this.f5989k.m10608a(c0800c, true);
            str2 = c0800c.ay();
            str3 = c0800c.m4150C();
            if (c0800c.ak()) {
                str = c0800c.getId();
            }
            z = true;
            str4 = str2;
            obj2 = str;
            str = str3;
            charSequence = str4;
        } else if (obj instanceof DkStoreBook) {
            DkStoreAbsBook dkStoreAbsBook = (DkStoreBook) obj;
            this.f5989k.m10610a(dkStoreAbsBook);
            charSequence = dkStoreAbsBook.getTitle();
            str = dkStoreAbsBook.getAuthorLine();
            obj2 = dkStoreAbsBook.getSourceId();
            z = true;
        } else if (obj instanceof DkCloudNoteBookInfo) {
            DkCloudNoteBookInfo dkCloudNoteBookInfo = (DkCloudNoteBookInfo) obj;
            this.f5989k.m10609a(dkCloudNoteBookInfo);
            str2 = dkCloudNoteBookInfo.getTitle();
            str3 = dkCloudNoteBookInfo.getBookAuthor();
            if (dkCloudNoteBookInfo.isDuokanBookNote()) {
                str = dkCloudNoteBookInfo.getBookUuid();
            }
            z = true;
            str4 = str2;
            str2 = str;
            str = str3;
            charSequence = str4;
        } else {
            z = false;
            str4 = str2;
            str2 = str;
            str = str3;
            charSequence = str4;
        }
        if (z) {
            this.f5984f.setImageDrawable(this.f5989k);
            this.f5985g.setText(charSequence);
            this.f5986h.setText(m9014a(str));
        } else {
            findViewById(C0255g.account__share_bitmap_factory_view__content).setVisibility(8);
        }
        if (strArr == null || strArr.length <= 1 || TextUtils.isEmpty(strArr[1].trim())) {
            this.f5979a.setMaxLines(27);
            this.f5980b.setVisibility(8);
            findViewById(C0255g.account__share_bitmap_factory_view__pub_text_gap).setVisibility(8);
        } else {
            if (!TextUtils.isEmpty(strArr[0].trim())) {
                int min = Math.min(27 - ((int) Math.min(Math.ceil((double) (((float) strArr[1].length()) / 17.0f)), 5.0d)), Math.max(Math.round((((float) strArr[0].length()) / ((float) (strArr[1].length() + strArr[0].length()))) * 27.0f), (int) Math.min(Math.ceil((double) (((float) strArr[0].length()) / 17.0f)), 5.0d)));
                this.f5979a.setMaxLines(min);
                this.f5980b.setMaxLines(27 - min);
            }
            this.f5980b.setText(strArr[1]);
        }
        ag c1272x = new C1272x(this, m9017b(this.f5990l));
        if (TextUtils.isEmpty(obj2)) {
            c1272x.run(C0641o.m2934i().m2978h());
            this.f5991m = false;
            return;
        }
        DkPublic.exchangeNewIdThenDo(obj2, "", new C1273y(this, shareType, c1272x), new C1274z(this));
    }

    /* renamed from: a */
    private String m9014a(String str) {
        String trim = str.trim();
        if (!trim.contains("】")) {
            return trim;
        }
        String[] split = trim.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : split) {
            String[] split2 = str2.split("】");
            if (split2.length != 2) {
                stringBuilder.append(str2);
            } else {
                stringBuilder.append(split2[1]).append(split2[0]).append("】");
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    /* renamed from: b */
    private String m9017b(String str) {
        int i;
        if (str.equals("weibo")) {
            i = C0258j.share_qrcode_sina_hint;
        } else {
            i = C0258j.share_qrcode_hint;
        }
        return getResources().getString(i);
    }
}
