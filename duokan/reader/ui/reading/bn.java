package com.duokan.reader.ui.reading;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duokan.core.sys.af;
import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.bookshelf.BookFormat;
import com.duokan.reader.domain.bookshelf.BookLimitType;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.ej;
import com.duokan.reader.domain.bookshelf.fv;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.document.ba;
import com.duokan.reader.domain.document.epub.EpubResourceType;
import com.duokan.reader.domain.document.epub.av;
import com.duokan.reader.domain.document.epub.az;
import com.duokan.reader.domain.document.k;
import com.duokan.reader.domain.document.m;
import com.duokan.reader.ui.general.DkTextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;

import miuipub.date.Calendar;

public class bn extends go {
    private de e = null;
    private gz f = null;
    private View g = null;
    private TextView h = null;
    private TextView i = null;
    private View j = null;
    private DkTextView k = null;
    private DkTextView l = null;
    private View m = null;
    private TextView n = null;
    private LinearLayout o = null;
    private af p = new af();

    public bn(Context context) {
        super(context);
    }

    protected void a() {
        switch (this.d) {
            case 0:
                this.p = new af();
                break;
            case 4:
                f();
                return;
            case 7:
                l();
                return;
            case 8:
                i();
                return;
            case 9:
                h();
                return;
            case 10:
            case 11:
            case 12:
            case 13:
                g();
                return;
        }
        if (this.d >= 10000) {
            g();
        } else {
            super.a();
        }
    }

    protected int b() {
        int b = super.b();
        if (b == 5) {
            return b;
        }
        ej ejVar = (ej) this.b.G();
        if (b == 4) {
            if (ejVar.o() == BookType.SERIAL) {
                return b;
            }
            if (ejVar.s() == BookPackageType.EPUB_OPF) {
                return b;
            }
            if (ejVar.P()) {
                if (ejVar.aX()) {
                    return 9;
                }
                return DkUserPurchasedBooksManager.a().a(ejVar.H()) != null ? 11 : 8;
            } else if (ejVar.p() != BookLimitType.NONE) {
                return b;
            }
        } else if (b == 3) {
            if (ejVar.o() == BookType.SERIAL) {
                return q();
            }
            if (ejVar.s() == BookPackageType.EPUB_OPF) {
                return p();
            }
            if (ejVar.P()) {
                return b;
            }
            if (ejVar.p() != BookLimitType.NONE) {
                az azVar = (az) this.c;
                if (azVar.b() && azVar.P() && !ejVar.aX()) {
                    return 8;
                }
                return b;
            }
        }
        return b;
    }

    protected void c() {
        super.c();
        if (this.e != null) {
            this.e.setVisibility(4);
        }
        if (this.f != null) {
            this.f.setVisibility(4);
        }
        if (this.j != null) {
            this.j.setVisibility(4);
        }
        if (this.g != null) {
            this.g.setVisibility(4);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.j != null && this.j.getVisibility() == 0) {
            k k = this.b.getDocument().k();
            if (k.a < k.b) {
                this.m.setTranslationY((float) ((-(this.l.getMeasuredHeight() - this.l.getTextBounds().height())) / 2));
                return;
            }
            this.m.setTranslationY(0.0f);
        }
    }

    public void d() {
        if (this.e != null) {
            this.e.a();
        }
    }

    public void e() {
        if (this.e != null && this.e.getVisibility() == 0) {
            this.e.b();
        }
    }

    protected void f() {
        c();
        if (this.b.G().ai() && !this.b.G().P() && s() > 0) {
            if (this.e == null) {
                this.e = new de(getContext());
                addView(this.e);
            }
            this.e.setVisibility(0);
        }
    }

    protected void g() {
        c();
        if (this.g == null) {
            this.g = LayoutInflater.from(getContext()).inflate(h.reading__chapter_error_view, this, false);
            this.h = (TextView) this.g.findViewById(g.reading__chapter_error_view__name);
            this.i = (TextView) this.g.findViewById(g.reading__chapter_error_view__tip);
            addView(this.g);
        }
        int i = this.d;
        String a = v().a(s());
        switch (i) {
            case 11:
                this.i.setText(j.reading__chapter_error_view__drm_error);
                break;
            case 13:
                this.i.setText(j.reading__chapter_error_view__content_error);
                a.k().a(this.b.G(), a);
                break;
            case 11001:
                this.i.setText(j.reading__chapter_error_view__login_invalid);
                break;
            case 11003:
                this.i.setText(j.reading__chapter_error_view__nolink);
                break;
            case 11006:
                this.i.setText(j.reading__chapter_error_view__flashmem_error);
                break;
            case 11007:
            case 11008:
                this.i.setText(j.reading__chapter_error_view__content_error);
                break;
            default:
                if (i != 10) {
                    if (i < 12000) {
                        this.i.setText(j.reading__chapter_error_view__network_error);
                        break;
                    }
                    this.i.setText(getResources().getString(j.reading__chapter_error_view__server_error) + (i - 12000));
                    break;
                }
                this.i.setText(getResources().getString(j.reading__chapter_error_view__network_nowifi));
                break;
        }
        if (this.b.G().P()) {
            this.h.setText(this.b.G().aw());
        } else {
            this.h.setText(r());
        }
        this.h.setTextColor(n());
        this.i.setTextColor(o());
        this.g.setVisibility(0);
        this.g.findViewById(g.reading__chapter_error_view__retry).setOnClickListener(new bo(this, i, a));
    }

    protected void h() {
        c();
        k k = this.b.getDocument().k();
        if (this.f == null) {
            this.f = new gz(getContext());
            addView(this.f);
        }
        this.f.setPadding(k.a().left, k.a().top, k.a().right, k.a().bottom);
        this.f.setVisibility(0);
        this.f.a(n());
    }

    protected void i() {
        c();
        if (!this.p.b()) {
            this.p = new af();
        }
        k k = this.b.getDocument().k();
        m l = this.b.getDocument().l();
        boolean k2 = this.b.G().k();
        boolean aj = this.b.G().aj();
        boolean z = !i.f().a(PersonalAccount.class) || (aj && !i.f().b());
        int i = aj ? h.reading__chapter_not_purchased_view_cmbook : k2 ? this.b.G().q() == BookFormat.SBK ? h.reading__chapter_not_purchased_view_comic : k.a < k.b ? h.reading__chapter_not_purchased_view_fiction : h.reading__chapter_not_purchased_view_fiction_landscape : h.reading__chapter_not_purchased_view_book;
        if (!(this.j == null || this.j.getId() == i)) {
            removeView(this.j);
            this.j = null;
        }
        if (this.j == null) {
            this.j = LayoutInflater.from(getContext()).inflate(i, this, false);
            this.j.setId(i);
            this.j.setVisibility(4);
            this.k = (DkTextView) this.j.findViewById(g.reading__chapter_not_purchased_view__name);
            this.l = (DkTextView) this.j.findViewById(g.reading__chapter_not_purchased_view__tip);
            this.m = this.j.findViewById(g.reading__chapter_not_purchased_view__divider);
            this.n = (TextView) this.j.findViewById(g.reading__chapter_not_purchased_view__login_or_buy);
            this.o = (LinearLayout) this.j.findViewById(g.reading__chapter_not_purchased_view__server_info);
            addView(this.j);
        }
        this.j.setPadding(0, k.a().top + UTools.getMinimumHeight(getContext(), 10.0f), 0, k.a().bottom + UTools.getMinimumHeight(getContext(), 10.0f));
        this.k.setPadding(k.a().left, 0, k.a().right, 0);
        this.k.setChsToChtChars(l.k);
        this.k.setText(r());
        this.k.setTextColor(n());
        this.l.setPadding(k.a().left, 0, k.a().right, 0);
        this.l.setChsToChtChars(l.k);
        this.l.setFirstLineIndent(2.0d);
        this.l.setLineGap(k.g);
        this.l.setTextColor(o());
        this.m.setBackgroundColor(m());
        if (z && (aj || !k2)) {
            this.j.setVisibility(0);
            this.l.setText(j.reading__chapter_not_purchased_view__login_to_read);
            this.o.removeAllViews();
            this.n.setText(j.general__shared__login);
            this.n.setVisibility(0);
            this.n.setOnClickListener(new bq(this));
        } else if (z || !aj) {
            this.n.setVisibility(8);
            if (!this.p.b()) {
                l();
                getPaymentInfo();
            } else if (this.p.a() == null) {
                g();
            } else {
                String string;
                this.o.removeAllViews();
                this.j.setVisibility(0);
                JSONObject jSONObject = (JSONObject) this.p.a();
                CharSequence b = com.duokan.reader.common.i.b(jSONObject, "preview");
                JSONArray a = com.duokan.reader.common.i.a(jSONObject, "ui", new JSONArray());
                DkTextView dkTextView = this.l;
                if (TextUtils.isEmpty(b)) {
                    string = getContext().getString(j.reading__chapter_not_purchased_view__pay_to_read);
                } else {
                    CharSequence charSequence = b;
                }
                dkTextView.setText(string);
                a(a, this.o);
            }
        } else {
            this.j.setVisibility(0);
            this.l.setText(j.reading__chapter_not_purchased_view__pay_to_read_cmbook);
            this.n.setText(j.general__shared__buy);
            this.n.setVisibility(0);
            this.n.setOnClickListener(new bs(this, s()));
        }
    }

    protected void j() {
        Iterator it = a.iterator();
        while (it.hasNext()) {
            TextView textView = (TextView) ((View) it.next()).findViewWithTag("autopay");
            if (textView != null) {
                textView.setSelected(this.b.ag());
            }
        }
    }

    private void a(JSONArray jSONArray, LinearLayout linearLayout) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Object obj;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                CharSequence optString = jSONObject.optString("type", "text");
                String optString2 = jSONObject.optString("msg", "");
                Object optString3 = jSONObject.optString("click", "");
                String optString4 = jSONObject.optString("divider", "br");
                CharSequence optString5 = jSONObject.optString("style", "");
                View textView = new TextView(getContext());
                textView.setPadding(UTools.getMinimumHeight(getContext(), 5.0f), 0, UTools.getMinimumHeight(getContext(), 5.0f), UTools.getMinimumHeight(getContext(), 5.0f));
                textView.setText(Html.fromHtml(optString2));
                textView.setTextColor(o());
                textView.setTextSize(0, (float) getResources().getDimensionPixelSize(e.general_font__shared__c));
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                textView.setLayoutParams(layoutParams);
                textView.setTag(optString);
                if (TextUtils.equals(optString, "button")) {
                    textView.setPadding(0, 0, 0, 0);
                    textView.setGravity(17);
                    textView.setTextSize(0, (float) getResources().getDimensionPixelSize(e.general_font__shared__b));
                    int b = UTools.getMinimumHeight(getContext(), 10.0f);
                    layoutParams.bottomMargin = b;
                    layoutParams.rightMargin = b;
                    layoutParams.leftMargin = b;
                    layoutParams.width = UTools.getMinimumHeight(getContext(), 207.0f);
                    layoutParams.height = UTools.getMinimumHeight(getContext(), 36.0f);
                    if (TextUtils.equals(optString5, "hollow")) {
                        textView.setBackgroundResource(f.general__shared__rounded_hollow_button_orange);
                        textView.setTextColor(getResources().getColor(d.general__shared__orange));
                    } else {
                        textView.setBackgroundResource(f.general__shared__rounded_button_orange);
                        textView.setTextColor(-1);
                    }
                    if (linkedList.size() > 0 && ((View) linkedList.getLast()).findViewWithTag("button") == null) {
                        layoutParams.topMargin = UTools.getMinimumHeight(getContext(), 25.0f);
                    }
                } else if (TextUtils.equals(optString, "autopay")) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(f.general__shared__small_checkbox, 0, 0, 0);
                    textView.setCompoundDrawablePadding(UTools.getMinimumHeight(getContext(), 5.0f));
                    textView.setSelected(this.b.ag());
                }
                ej ejVar = (ej) this.b.G();
                String aw = ejVar.aw();
                String H = ejVar.H();
                String r = r();
                long s = s();
                String a = v().a(s);
                boolean z = TextUtils.equals(optString, "autopay") || !TextUtils.isEmpty(optString3);
                textView.setOnClickListener(new bt(this, optString, optString3, aw, H, r, s, a));
                textView.setClickable(z);
                View view;
                if (!TextUtils.equals(optString4, "tab")) {
                    view = textView;
                } else if (linkedList.size() > 0) {
                    if (linkedList.getLast() instanceof LinearLayout) {
                        obj = (LinearLayout) linkedList.getLast();
                    } else {
                        LinearLayout linearLayout2 = new LinearLayout(getContext());
                        linearLayout2.setOrientation(0);
                        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                        linearLayout2.addView((View) linkedList.getLast());
                        LinearLayout linearLayout3 = linearLayout2;
                    }
                    linkedList.removeLast();
                    obj.addView(textView);
                } else {
                    view = textView;
                }
                linkedList.add(obj);
            } catch (Throwable th) {
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            linearLayout.addView((View) it.next());
        }
    }

    private void getPaymentInfo() {
        ej ejVar = (ej) this.b.G();
        if (!this.c.F() && this.c.G()) {
            String H = ejVar.H();
            long s = s();
            String a = v().a(s);
            new bu(this, this.p, new ab((PersonalAccount) i.f().b(PersonalAccount.class)), ejVar, s, H, a).open();
        }
    }

    private void a(String str) {
        i.f().a(PersonalAccount.class, new bv(this, str));
    }

    private int p() {
        fv fvVar = (fv) this.b.G();
        az azVar = (az) this.c;
        if (!azVar.b() || !azVar.P() || fvVar.aX()) {
            for (av avVar : azVar.R()) {
                EpubResourceType epubResourceType = avVar.g().b;
                if (!avVar.i() && (avVar.l() == null || !avVar.l().i())) {
                    int a = u().a(avVar);
                    if (azVar.k()) {
                        return a >= Calendar.MILLISECOND_OF_SECOND ? a + 10000 : 6;
                    } else {
                        if (epubResourceType == EpubResourceType.TEXT || epubResourceType == EpubResourceType.STRUCT || epubResourceType == EpubResourceType.FONT) {
                            return a >= Calendar.MILLISECOND_OF_SECOND ? a + 10000 : 6;
                        }
                    }
                }
            }
            return 3;
        } else if (DkUserPurchasedBooksManager.a().a(fvVar.H()) != null) {
            return 11;
        } else {
            return 8;
        }
    }

    private int q() {
        boolean a = ((ba) this.c).a();
        if (((ba) this.c).b()) {
            return 13;
        }
        if (!a) {
            return 3;
        }
        long a2 = t().a((ba) this.c);
        if (t().b((ba) this.c)) {
            return 6;
        }
        int c = t().c((ba) this.c);
        if (c == 1002) {
            if (t().c(a2)) {
                af i = t().i(a2);
                if (i == null) {
                    return 7;
                }
                if (!i.b()) {
                    return 7;
                }
                if (((Integer) i.a()).intValue() == 0) {
                    return 7;
                }
                if (((Integer) i.a()).intValue() < 0) {
                    return 12;
                }
            }
            return 8;
        } else if (c == 1004) {
            return 10;
        } else {
            return c >= Calendar.MILLISECOND_OF_SECOND ? c + 10000 : 6;
        }
    }

    private String r() {
        String b = v().b(s());
        return TextUtils.isEmpty(b) ? this.b.G().aw() : b;
    }

    private long s() {
        return v().a((ba) this.c);
    }

    private aaq t() {
        return (aaq) this.b;
    }

    private ho u() {
        return (ho) this.b;
    }

    private bm v() {
        return (bm) this.b;
    }
}
