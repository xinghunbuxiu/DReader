package com.duokan.reader.ui.account;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.core.sys.ag;
import com.duokan.core.ui.dv;
import com.duokan.reader.DkPublic;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.bh;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.store.DkStoreAbsBook;
import com.duokan.reader.domain.store.DkStoreBook;
import com.duokan.reader.ui.account.ShareEntranceController.ShareType;
import com.duokan.reader.ui.general.DkTextView;
import com.duokan.reader.ui.general.f;

public class ai extends RelativeLayout {
    private final DkTextView a;
    private final DkTextView b;
    private final TextView c;
    private final TextView d;
    private final TextView e;
    private final ImageView f;
    private final TextView g;
    private final TextView h;
    private final ImageView i;
    private final TextView j;
    private final f k;
    private final String l;
    private boolean m;

    public ai(Context context, String str) {
        this(context, null, str);
    }

    public ai(Context context, AttributeSet attributeSet, String str) {
        super(context, attributeSet);
        this.m = true;
        this.l = str;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(h.account__share_bitmap_factory_view, this, false);
        linearLayout.setBackgroundColor(-1);
        addView(linearLayout);
        this.a = (DkTextView) findViewById(g.account__share_bitmap_factory_view__pub_text);
        this.f = (ImageView) findViewById(g.account__share_bitmap_factory_view__cover);
        this.i = (ImageView) findViewById(g.account__share_bitmap_factory_view__qrcode);
        this.b = (DkTextView) findViewById(g.account__share_bitmap_factory_view__pub_content);
        this.g = (TextView) findViewById(g.account__share_bitmap_factory_view__title);
        this.h = (TextView) findViewById(g.account__share_bitmap_factory_view__author);
        this.j = (TextView) findViewById(g.account__share_bitmap_factory_view__hint);
        this.k = new f(getContext(), 0);
        setBackgroundColor(0);
        this.a.setLineGap(1.6d);
        this.a.setFirstLineIndent(2.0d);
        this.a.setGravity(7);
        this.b.setLineGap(1.6d);
        this.b.setFirstLineIndent(2.0d);
        this.b.setGravity(7);
        View ajVar = new aj(this, getContext());
        ajVar.setGravity(80);
        this.c = new TextView(getContext());
        this.c.setTextColor(getResources().getColor(d.general__shared__c1));
        this.c.getPaint().setFakeBoldText(true);
        this.c.setSingleLine(true);
        this.c.setEllipsize(TruncateAt.MIDDLE);
        this.c.setTextSize(1, 16.0f);
        ajVar.addView(this.c, new LayoutParams(0, -2));
        this.d = new TextView(getContext());
        this.d.setTextColor(getResources().getColor(d.general__shared__c7));
        this.d.setPadding(dv.b(getContext(), 6.0f), 0, dv.b(getContext(), 10.0f), 0);
        this.d.setTextSize(1, 12.0f);
        ajVar.addView(this.d);
        this.e = new TextView(getContext());
        this.e.setTextColor(getResources().getColor(d.general__shared__c7));
        this.e.setTextSize(1, 12.0f);
        this.e.setGravity(5);
        ajVar.addView(this.e);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(dv.b(getContext(), 28.0f), dv.b(getContext(), 40.0f), dv.b(getContext(), 28.0f), dv.b(getContext(), 25.0f));
        linearLayout.addView(ajVar, 0, layoutParams);
    }

    public void setAccount(a aVar) {
        com.duokan.reader.domain.account.g f = aVar.f();
        if (f instanceof bh) {
            this.c.setText(((bh) f).e.a.mNickName);
            return;
        }
        CharSequence c;
        String a = aVar.f().a();
        if (TextUtils.isEmpty(a) || a.equals(aVar.c())) {
            c = aVar.c();
            if (TextUtils.isEmpty(c)) {
                c = "";
            } else {
                String[] split = a.split("@");
                if (split != null && split.length > 0) {
                    c = split[0];
                }
            }
        } else {
            Object obj = a;
        }
        this.c.setText(c);
    }

    public void a(ShareType shareType, Object obj, String[] strArr, String str) {
        if (shareType != ShareType.BITMAP && shareType != ShareType.STATISTICS) {
            CharSequence string;
            if (TextUtils.isEmpty(str)) {
                this.e.setVisibility(8);
            } else {
                this.e.setText(str);
            }
            if (strArr != null && strArr.length > 0) {
                if (TextUtils.isEmpty(strArr[0].trim())) {
                    this.b.setMaxLines(27);
                    this.a.setVisibility(8);
                    findViewById(g.account__share_bitmap_factory_view__pub_text_gap).setVisibility(8);
                } else {
                    this.a.setText(strArr[0]);
                }
            }
            String str2 = "";
            if (shareType == ShareType.BOOK) {
                string = getResources().getString(j.share_source_book);
            } else if (TextUtils.isEmpty(strArr[0].trim())) {
                string = getResources().getString(j.share_source_comment);
            } else {
                string = getResources().getString(j.share_source_note);
            }
            this.d.setText(string);
            a(shareType, obj, strArr);
        }
    }

    public final boolean a() {
        return this.k.e() || this.m;
    }

    public void a(ShareType shareType, Object obj, String[] strArr) {
        boolean z;
        Object obj2;
        CharSequence charSequence;
        String str = "";
        String str2 = "";
        String str3 = "";
        String str4;
        if (obj instanceof c) {
            c cVar = (c) obj;
            this.k.a(cVar, true);
            str2 = cVar.aw();
            str3 = cVar.B();
            if (cVar.ai()) {
                str = cVar.H();
            }
            z = true;
            str4 = str2;
            obj2 = str;
            str = str3;
            charSequence = str4;
        } else if (obj instanceof DkStoreBook) {
            DkStoreAbsBook dkStoreAbsBook = (DkStoreBook) obj;
            this.k.a(dkStoreAbsBook);
            charSequence = dkStoreAbsBook.getTitle();
            str = dkStoreAbsBook.getAuthorLine();
            obj2 = dkStoreAbsBook.getSourceId();
            z = true;
        } else if (obj instanceof DkCloudNoteBookInfo) {
            DkCloudNoteBookInfo dkCloudNoteBookInfo = (DkCloudNoteBookInfo) obj;
            this.k.a(dkCloudNoteBookInfo);
            str2 = dkCloudNoteBookInfo.getTitle();
            str3 = dkCloudNoteBookInfo.getBookAuthor();
            if (dkCloudNoteBookInfo.isDuokanBookNote()) {
                str = dkCloudNoteBookInfo.getBookUuid();
            }
            z = true;
            str4 = str2;
            str2 = str;
            str = str3;
            r1 = str4;
        } else {
            z = false;
            str4 = str2;
            str2 = str;
            str = str3;
            r1 = str4;
        }
        if (z) {
            this.f.setImageDrawable(this.k);
            this.g.setText(charSequence);
            this.h.setText(a(str));
        } else {
            findViewById(g.account__share_bitmap_factory_view__content).setVisibility(8);
        }
        if (strArr == null || strArr.length <= 1 || TextUtils.isEmpty(strArr[1].trim())) {
            this.a.setMaxLines(27);
            this.b.setVisibility(8);
            findViewById(g.account__share_bitmap_factory_view__pub_text_gap).setVisibility(8);
        } else {
            if (!TextUtils.isEmpty(strArr[0].trim())) {
                int min = Math.min(27 - ((int) Math.min(Math.ceil((double) (((float) strArr[1].length()) / 17.0f)), 5.0d)), Math.max(Math.round((((float) strArr[0].length()) / ((float) (strArr[1].length() + strArr[0].length()))) * 27.0f), (int) Math.min(Math.ceil((double) (((float) strArr[0].length()) / 17.0f)), 5.0d)));
                this.a.setMaxLines(min);
                this.b.setMaxLines(27 - min);
            }
            this.b.setText(strArr[1]);
        }
        ag akVar = new ak(this, b(this.l));
        if (TextUtils.isEmpty(obj2)) {
            akVar.a(p.i().h());
            this.m = false;
            return;
        }
        DkPublic.exchangeNewIdThenDo(obj2, "", new al(this, shareType, akVar), new am(this));
    }

    private String a(String str) {
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

    private String b(String str) {
        int i;
        if (str.equals("sina")) {
            i = j.share_qrcode_sina_hint;
        } else {
            i = j.share_qrcode_hint;
        }
        return getResources().getString(i);
    }
}
