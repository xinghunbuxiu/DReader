package com.duokan.reader.ui.reading;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.duokan.core.sys.af;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0253e;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.C0611i;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.al;
import com.duokan.reader.domain.bookshelf.BookFormat;
import com.duokan.reader.domain.bookshelf.BookLimitType;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.ee;
import com.duokan.reader.domain.bookshelf.fp;
import com.duokan.reader.domain.cloud.DkUserPurchasedBooksManager;
import com.duokan.reader.domain.document.C0917k;
import com.duokan.reader.domain.document.C0923m;
import com.duokan.reader.domain.document.ba;
import com.duokan.reader.domain.document.epub.EpubResourceType;
import com.duokan.reader.domain.document.epub.av;
import com.duokan.reader.domain.document.epub.az;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.ui.general.DkTextView;
import com.wali.live.sdk.manager.IMiLiveSdk.ICallback;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class bn extends gt {
    /* renamed from: e */
    private dg f9869e = null;
    /* renamed from: f */
    private he f9870f = null;
    /* renamed from: g */
    private View f9871g = null;
    /* renamed from: h */
    private TextView f9872h = null;
    /* renamed from: i */
    private TextView f9873i = null;
    /* renamed from: j */
    private View f9874j = null;
    /* renamed from: k */
    private DkTextView f9875k = null;
    /* renamed from: l */
    private DkTextView f9876l = null;
    /* renamed from: m */
    private View f9877m = null;
    /* renamed from: n */
    private TextView f9878n = null;
    /* renamed from: o */
    private LinearLayout f9879o = null;
    /* renamed from: p */
    private af<JSONObject> f9880p = new af();

    public bn(Context context) {
        super(context);
    }

    /* renamed from: a */
    protected void mo2281a() {
        switch (this.d) {
            case 0:
                this.f9880p = new af();
                break;
            case 4:
                m13834f();
                return;
            case 7:
                m13810m();
                return;
            case 8:
                m13837i();
                return;
            case 9:
                m13836h();
                return;
            case 10:
            case 11:
            case 12:
            case 13:
                m13835g();
                return;
        }
        if (this.d >= 10000) {
            m13835g();
        } else {
            super.mo2281a();
        }
    }

    /* renamed from: b */
    protected int mo2282b() {
        int b = super.mo2282b();
        if (b == 5) {
            return b;
        }
        ee eeVar = (ee) this.b.mo1992G();
        if (b == 4) {
            if (eeVar.m4242o() == BookType.SERIAL) {
                return b;
            }
            if (eeVar.m4247s() == BookPackageType.EPUB_OPF) {
                return b;
            }
            if (eeVar.m4165R()) {
                if (eeVar.aZ()) {
                    return 9;
                }
                return DkUserPurchasedBooksManager.m5029a().m5052a(eeVar.m4156I()) != null ? 11 : 8;
            } else if (eeVar.m4243p() != BookLimitType.NONE) {
                return b;
            }
        } else if (b == 3) {
            if (eeVar.m4242o() == BookType.SERIAL) {
                return m13823r();
            }
            if (eeVar.m4247s() == BookPackageType.EPUB_OPF) {
                return m13822q();
            }
            if (eeVar.m4165R()) {
                return b;
            }
            if (eeVar.m4243p() != BookLimitType.NONE) {
                az azVar = (az) this.c;
                if (azVar.mo1305b() && azVar.m6591O() && !eeVar.aZ()) {
                    return 8;
                }
                return b;
            }
        }
        return b;
    }

    /* renamed from: c */
    protected void mo2283c() {
        super.mo2283c();
        if (this.f9869e != null) {
            this.f9869e.setVisibility(4);
        }
        if (this.f9870f != null) {
            this.f9870f.setVisibility(4);
        }
        if (this.f9874j != null) {
            this.f9874j.setVisibility(4);
        }
        if (this.f9871g != null) {
            this.f9871g.setVisibility(4);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f9874j != null && this.f9874j.getVisibility() == 0) {
            C0917k k = this.b.getDocument().mo1245k();
            if (k.f4330a < k.f4331b) {
                this.f9877m.setTranslationY((float) ((-(this.f9876l.getMeasuredHeight() - this.f9876l.getTextBounds().height())) / 2));
                return;
            }
            this.f9877m.setTranslationY(0.0f);
        }
    }

    /* renamed from: d */
    public void mo2284d() {
        if (this.f9869e != null) {
            this.f9869e.m13990a();
        }
    }

    /* renamed from: e */
    public void mo2285e() {
        if (this.f9869e != null && this.f9869e.getVisibility() == 0) {
            this.f9869e.m13992b();
        }
    }

    /* renamed from: f */
    protected void m13834f() {
        mo2283c();
        if (this.b.mo1992G().ak() && !this.b.mo1992G().m4165R() && m13825t() > 0) {
            if (this.f9869e == null) {
                this.f9869e = new dg(getContext());
                addView(this.f9869e);
            }
            this.f9869e.setVisibility(0);
        }
    }

    /* renamed from: g */
    protected void m13835g() {
        mo2283c();
        if (this.f9871g == null) {
            this.f9871g = LayoutInflater.from(getContext()).inflate(C0256h.reading__chapter_error_view, this, false);
            this.f9872h = (TextView) this.f9871g.findViewById(C0255g.reading__chapter_error_view__name);
            this.f9873i = (TextView) this.f9871g.findViewById(C0255g.reading__chapter_error_view__tip);
            addView(this.f9871g);
        }
        int i = this.d;
        String a = m13828w().mo2356a(m13825t());
        switch (i) {
            case 11:
                this.f9873i.setText(C0258j.reading__chapter_error_view__drm_error);
                break;
            case 13:
                this.f9873i.setText(C0258j.reading__chapter_error_view__content_error);
                C1163a.m8627k().m8638a(this.b.mo1992G(), a);
                break;
            case 11001:
                this.f9873i.setText(C0258j.reading__chapter_error_view__login_invalid);
                break;
            case 11003:
                this.f9873i.setText(C0258j.reading__chapter_error_view__nolink);
                break;
            case 11006:
                this.f9873i.setText(C0258j.reading__chapter_error_view__flashmem_error);
                break;
            case 11007:
            case 11008:
                this.f9873i.setText(C0258j.reading__chapter_error_view__content_error);
                break;
            default:
                if (i != 10) {
                    if (i < 12000) {
                        this.f9873i.setText(C0258j.reading__chapter_error_view__network_error);
                        break;
                    }
                    this.f9873i.setText(getResources().getString(C0258j.reading__chapter_error_view__server_error) + (i - 12000));
                    break;
                }
                this.f9873i.setText(getResources().getString(C0258j.reading__chapter_error_view__network_nowifi));
                break;
        }
        if (this.b.mo1992G().m4165R()) {
            this.f9872h.setText(this.b.mo1992G().ay());
        } else {
            this.f9872h.setText(m13824s());
        }
        this.f9872h.setTextColor(m13812o());
        this.f9873i.setTextColor(m13813p());
        this.f9871g.setVisibility(0);
        this.f9871g.findViewById(C0255g.reading__chapter_error_view__retry).setOnClickListener(new bo(this, i, a));
    }

    /* renamed from: h */
    protected void m13836h() {
        mo2283c();
        C0917k k = this.b.getDocument().mo1245k();
        if (this.f9870f == null) {
            this.f9870f = new he(getContext());
            addView(this.f9870f);
        }
        this.f9870f.setPadding(k.m6083a().left, k.m6083a().top, k.m6083a().right, k.m6083a().bottom);
        this.f9870f.setVisibility(0);
        this.f9870f.m14309a(m13812o());
    }

    /* renamed from: i */
    protected void m13837i() {
        mo2283c();
        if (!this.f9880p.m861b()) {
            this.f9880p = new af();
        }
        C0917k k = this.b.getDocument().mo1245k();
        C0923m l = this.b.getDocument().mo1246l();
        boolean k2 = this.b.mo1992G().mo1038k();
        boolean al = this.b.mo1992G().al();
        boolean z = !C0709k.m3476a().m3500a(PersonalAccount.class) || (al && !C0709k.m3476a().m3507c());
        int i = al ? C0256h.reading__chapter_not_purchased_view_cmbook : k2 ? this.b.mo1992G().mo1039q() == BookFormat.SBK ? C0256h.reading__chapter_not_purchased_view_comic : k.f4330a < k.f4331b ? C0256h.reading__chapter_not_purchased_view_fiction : C0256h.reading__chapter_not_purchased_view_fiction_landscape : C0256h.reading__chapter_not_purchased_view_book;
        if (!(this.f9874j == null || this.f9874j.getId() == i)) {
            removeView(this.f9874j);
            this.f9874j = null;
        }
        if (this.f9874j == null) {
            this.f9874j = LayoutInflater.from(getContext()).inflate(i, this, false);
            this.f9874j.setId(i);
            this.f9874j.setVisibility(4);
            this.f9875k = (DkTextView) this.f9874j.findViewById(C0255g.reading__chapter_not_purchased_view__name);
            this.f9876l = (DkTextView) this.f9874j.findViewById(C0255g.reading__chapter_not_purchased_view__tip);
            this.f9877m = this.f9874j.findViewById(C0255g.reading__chapter_not_purchased_view__divider);
            this.f9878n = (TextView) this.f9874j.findViewById(C0255g.reading__chapter_not_purchased_view__login_or_buy);
            this.f9879o = (LinearLayout) this.f9874j.findViewById(C0255g.reading__chapter_not_purchased_view__server_info);
            addView(this.f9874j);
        }
        this.f9874j.setPadding(0, k.m6083a().top + dv.m1932b(getContext(), 10.0f), 0, k.m6083a().bottom + dv.m1932b(getContext(), 10.0f));
        this.f9875k.setPadding(k.m6083a().left, 0, k.m6083a().right, 0);
        this.f9875k.setChsToChtChars(l.f4363k);
        this.f9875k.setText(m13824s());
        this.f9875k.setTextColor(m13812o());
        this.f9876l.setPadding(k.m6083a().left, 0, k.m6083a().right, 0);
        this.f9876l.setChsToChtChars(l.f4363k);
        this.f9876l.setFirstLineIndent(2.0d);
        this.f9876l.setLineGap(k.f4336g);
        this.f9876l.setTextColor(m13813p());
        this.f9877m.setBackgroundColor(m13811n());
        if (z && (al || !k2)) {
            this.f9874j.setVisibility(0);
            this.f9876l.setText(C0258j.reading__chapter_not_purchased_view__login_to_read);
            this.f9879o.removeAllViews();
            this.f9878n.setText(C0258j.general__shared__login);
            this.f9878n.setVisibility(0);
            this.f9878n.setOnClickListener(new bq(this));
        } else if (z || !al) {
            this.f9878n.setVisibility(8);
            if (!this.f9880p.m861b()) {
                m13810m();
                getPaymentInfo();
            } else if (this.f9880p.m858a() == null) {
                m13835g();
            } else {
                String string;
                this.f9879o.removeAllViews();
                this.f9874j.setVisibility(0);
                JSONObject jSONObject = (JSONObject) this.f9880p.m858a();
                CharSequence b = C0611i.m2793b(jSONObject, "preview");
                JSONArray a = C0611i.m2788a(jSONObject, "ui", new JSONArray());
                DkTextView dkTextView = this.f9876l;
                if (TextUtils.isEmpty(b)) {
                    string = getContext().getString(C0258j.reading__chapter_not_purchased_view__pay_to_read);
                } else {
                    CharSequence string2 = b;
                }
                dkTextView.setText(string2);
                m13819a(a, this.f9879o);
            }
        } else {
            this.f9874j.setVisibility(0);
            this.f9876l.setText(C0258j.reading__chapter_not_purchased_view__pay_to_read_cmbook);
            this.f9878n.setText(C0258j.general__shared__buy);
            this.f9878n.setVisibility(0);
            this.f9878n.setOnClickListener(new bs(this, m13825t()));
        }
    }

    /* renamed from: j */
    protected void m13838j() {
        Iterator it = a.iterator();
        while (it.hasNext()) {
            TextView textView = (TextView) ((View) it.next()).findViewWithTag("autopay");
            if (textView != null) {
                textView.setSelected(this.b.ag());
            }
        }
    }

    /* renamed from: a */
    private void m13819a(JSONArray jSONArray, LinearLayout linearLayout) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                LayoutParams layoutParams;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                CharSequence optString = jSONObject.optString("type", "text");
                Object optString2 = jSONObject.optString("msg", "");
                Object optString3 = jSONObject.optString("click", "");
                String optString4 = jSONObject.optString("divider", "br");
                CharSequence optString5 = jSONObject.optString("style", "");
                String optString6 = jSONObject.optString("preload_get_uri", "");
                String optString7 = jSONObject.optString("preload_post_uri", "");
                Object textView = new TextView(getContext());
                if (TextUtils.isEmpty(optString2)) {
                    LayoutParams layoutParams2 = new LayoutParams(-2, 0, 1.0f);
                    textView.setLayoutParams(new LayoutParams(-2, 0, 1.0f));
                    textView.setMaxHeight(dv.m1932b(getContext(), 20.0f));
                    layoutParams = layoutParams2;
                } else {
                    textView.setPadding(dv.m1932b(getContext(), 5.0f), 0, dv.m1932b(getContext(), 5.0f), dv.m1932b(getContext(), 5.0f));
                    textView.setText(Html.fromHtml(optString2));
                    textView.setTextColor(m13813p());
                    textView.setTextSize(0, (float) getResources().getDimensionPixelSize(C0253e.general_font__shared__c));
                    ViewGroup.LayoutParams layoutParams3 = new LayoutParams(-2, -2);
                    textView.setLayoutParams(layoutParams3);
                    textView.setTag(optString);
                    ViewGroup.LayoutParams layoutParams4 = layoutParams3;
                }
                if (TextUtils.equals(optString, "button")) {
                    textView.setPadding(0, 0, 0, 0);
                    textView.setGravity(17);
                    textView.setTextSize(0, (float) getResources().getDimensionPixelSize(C0253e.general_font__shared__b));
                    int b = dv.m1932b(getContext(), 10.0f);
                    layoutParams4.bottomMargin = b;
                    layoutParams4.rightMargin = b;
                    layoutParams4.leftMargin = b;
                    layoutParams4.width = dv.m1932b(getContext(), 207.0f);
                    layoutParams4.height = dv.m1932b(getContext(), 36.0f);
                    if (TextUtils.equals(optString5, "hollow")) {
                        textView.setBackgroundResource(C0254f.general__shared__rounded_hollow_button_orange);
                        textView.setTextColor(getResources().getColor(C0252d.general__shared__orange));
                    } else {
                        textView.setBackgroundResource(C0254f.general__shared__rounded_button_orange);
                        textView.setTextColor(-1);
                    }
                    if (linkedList.size() > 0 && ((View) linkedList.getLast()).findViewWithTag("button") == null) {
                        layoutParams4.topMargin = dv.m1932b(getContext(), 25.0f);
                    }
                } else if (TextUtils.equals(optString, "autopay")) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(C0254f.general__shared__small_checkbox, 0, 0, 0);
                    textView.setCompoundDrawablePadding(dv.m1932b(getContext(), 5.0f));
                    textView.setSelected(this.b.ag());
                }
                ee eeVar = (ee) this.b.mo1992G();
                String ay = eeVar.ay();
                String I = eeVar.m4156I();
                String s = m13824s();
                long t = m13825t();
                String a = m13828w().mo2356a(t);
                boolean z = TextUtils.equals(optString, "autopay") || !TextUtils.isEmpty(optString3);
                textView.setOnClickListener(new bt(this, optString, optString3, ay, I, s, t, a, textView, optString6, optString7));
                textView.setClickable(z);
                if (TextUtils.equals(optString4, "tab") && linkedList.size() > 0) {
                    LinearLayout linearLayout2;
                    if (linkedList.getLast() instanceof LinearLayout) {
                        linearLayout2 = (LinearLayout) linkedList.getLast();
                    } else {
                        LinearLayout linearLayout3 = new LinearLayout(getContext());
                        linearLayout3.setOrientation(0);
                        linearLayout3.setLayoutParams(new LayoutParams(-2, -2));
                        linearLayout3.addView((View) linkedList.getLast());
                        linearLayout2 = linearLayout3;
                    }
                    linkedList.removeLast();
                    linearLayout2.addView(textView);
                    textView = linearLayout2;
                }
                linkedList.add(textView);
            } catch (Throwable th) {
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            linearLayout.addView((View) it.next());
        }
    }

    /* renamed from: a */
    private void m13818a(String str, String str2) {
        C0709k.m3476a().m3497a(PersonalAccount.class, new bu(this, str, str2));
    }

    private void getPaymentInfo() {
        ee eeVar = (ee) this.b.mo1992G();
        if (!this.c.mo1283F() && this.c.mo1284G()) {
            String I = eeVar.m4156I();
            long t = m13825t();
            String a = m13828w().mo2356a(t);
            new bx(this, this.f9880p, new al((PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class)), eeVar, t, I, a).open();
        }
    }

    /* renamed from: a */
    private void m13817a(String str) {
        C0709k.m3476a().m3497a(PersonalAccount.class, new bw(this, str));
    }

    /* renamed from: q */
    private int m13822q() {
        fp fpVar = (fp) this.b.mo1992G();
        az azVar = (az) this.c;
        if (!azVar.mo1305b() || !azVar.m6591O() || fpVar.aZ()) {
            for (av avVar : azVar.mo1375Q()) {
                EpubResourceType epubResourceType = avVar.mo1071g().f4493b;
                if (!avVar.mo1073i() && (avVar.mo1076l() == null || !avVar.mo1076l().mo1073i())) {
                    int a = m13827v().mo2353a(avVar);
                    if (azVar.mo1330k()) {
                        return a >= 1000 ? a + 10000 : 6;
                    } else {
                        if (epubResourceType == EpubResourceType.TEXT || epubResourceType == EpubResourceType.STRUCT || epubResourceType == EpubResourceType.FONT) {
                            return a >= 1000 ? a + 10000 : 6;
                        }
                    }
                }
            }
            return 3;
        } else if (DkUserPurchasedBooksManager.m5029a().m5052a(fpVar.m4156I()) != null) {
            return 11;
        } else {
            return 8;
        }
    }

    /* renamed from: r */
    private int m13823r() {
        boolean a = ((ba) this.c).mo1299a();
        if (((ba) this.c).mo1305b()) {
            return 13;
        }
        if (!a) {
            return 3;
        }
        long a2 = m13826u().mo2355a((ba) this.c);
        if (m13826u().mo2187b((ba) this.c)) {
            return 6;
        }
        int c = m13826u().mo2188c((ba) this.c);
        if (c == ICallback.LOGIN_OAUTH_AIDL) {
            if (m13826u().mo2191c(a2)) {
                af i = m13826u().mo2196i(a2);
                if (i == null) {
                    return 7;
                }
                if (!i.m861b()) {
                    return 7;
                }
                if (((Integer) i.m858a()).intValue() == 0) {
                    return 7;
                }
                if (((Integer) i.m858a()).intValue() < 0) {
                    return 12;
                }
            }
            return 8;
        } else if (c == ICallback.THIRD_PART_LOGIN) {
            return 10;
        } else {
            return c >= 1000 ? c + 10000 : 6;
        }
    }

    /* renamed from: s */
    private String m13824s() {
        String b = m13828w().mo2359b(m13825t());
        return TextUtils.isEmpty(b) ? this.b.mo1992G().ay() : b;
    }

    /* renamed from: t */
    private long m13825t() {
        return m13828w().mo2355a((ba) this.c);
    }

    /* renamed from: u */
    private abd m13826u() {
        return (abd) this.b;
    }

    /* renamed from: v */
    private hy m13827v() {
        return (hy) this.b;
    }

    /* renamed from: w */
    private bm m13828w() {
        return (bm) this.b;
    }
}
