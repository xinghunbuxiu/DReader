package com.duokan.reader.ui.account;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.duokan.common.CommonUtils;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0251c;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.bitmap.C0544a;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.oauth.ThirdOAuth;
import com.duokan.reader.domain.account.oauth.TokenStore;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.domain.store.DkStoreBook;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.account.ShareEntranceController.ShareType;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.PinView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.af;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.hb;
import com.duokan.reader.ui.general.ja;

public class bx extends af {
    /* renamed from: a */
    static final /* synthetic */ boolean f5889a = (!bx.class.desiredAssertionStatus());
    /* renamed from: b */
    private final Activity f5890b;
    /* renamed from: c */
    private final Context f5891c;
    /* renamed from: d */
    private final String f5892d;
    /* renamed from: e */
    private final ap f5893e;
    /* renamed from: f */
    private final aq f5894f;
    /* renamed from: g */
    private ThirdOAuth f5895g;
    /* renamed from: h */
    private TokenStore f5896h;
    /* renamed from: i */
    private View f5897i;
    /* renamed from: j */
    private EditText f5898j;
    /* renamed from: k */
    private CheckBox f5899k;
    /* renamed from: l */
    private ja f5900l;
    /* renamed from: m */
    private boolean f5901m = false;
    /* renamed from: n */
    private boolean f5902n;
    /* renamed from: o */
    private final Handler f5903o = new Handler(Looper.getMainLooper());
    /* renamed from: p */
    private final cp f5904p;

    public bx(Context context, Activity activity, String str, ap apVar, aq aqVar, cp cpVar) {
        super(activity);
        this.f5891c = context;
        this.f5890b = activity;
        this.f5904p = cpVar;
        this.f5892d = str;
        this.f5893e = apVar;
        this.f5894f = aqVar;
        this.f5896h = TokenStore.getInstance();
        this.f5895g = ThirdOAuth.produceThird(activity, this.f5892d);
        this.f5895g.onActive();
        this.f5902n = this.f5896h.isBindAccessToken(activity, this.f5892d);
        m8950a();
        setCancelOnTouchOutside(false);
    }

    public void show() {
        if (m8978n()) {
            super.dismiss();
        } else {
            super.show();
        }
        m8977m();
    }

    public void dismiss() {
        if (!this.f5901m) {
            if (this.f5900l != null && this.f5900l.isShowing()) {
                this.f5900l.dismiss();
            }
            if (this.f5895g != null) {
                this.f5895g.onDeactive();
            }
            super.dismiss();
        }
    }

    /* renamed from: a */
    private void m8950a() {
        View inflate = LayoutInflater.from(getContext()).inflate(C0256h.account__third_share_view, null);
        if (ReaderEnv.get().forHd()) {
            inflate.setBackgroundDrawable(new hb(new ColorDrawable(getContext().getResources().getColor(C0252d.general__shared__fefaf8)), (float) AnimUtils.m1932b(getContext(), 8.0f)));
        }
        setContentView(inflate);
        inflate.findViewById(C0255g.account__third_share_view__btns).setPadding(AnimUtils.m1932b(getContext(), 15.0f), (ReaderEnv.get().forHd() ? 0 : ((C0435s) AppContext.getAppContext(getContext()).queryFeature(C0435s.class)).getTheme().getHeaderPaddingTop()) + AnimUtils.m1932b(getContext(), 10.0f), AnimUtils.m1932b(getContext(), 15.0f), AnimUtils.m1932b(getContext(), 10.0f));
        DkLabelView dkLabelView = (DkLabelView) inflate.findViewById(C0255g.account__third_share_view__third_name);
        CharSequence k = m8975k();
        dkLabelView.setText(k);
        dkLabelView.setContentDescription(k);
        this.f5898j = (EditText) inflate.findViewById(C0255g.account__third_share_view__share_text);
        ((FrameLayout) inflate.findViewById(C0255g.account__third_share_view__content)).addView(m8956b(), new LayoutParams(-1, -2));
        Object j = m8974j();
        if (!TextUtils.isEmpty(j)) {
            this.f5898j.setText(j);
            this.f5898j.setSelection(j.length());
        }
        inflate.findViewById(C0255g.account__third_share_view__cancel).setOnClickListener(new by(this));
        this.f5897i = inflate.findViewById(C0255g.account__third_share_view__send);
        this.f5897i.setOnClickListener(new cf(this));
        this.f5900l = new ja(getActivity());
        this.f5900l.setCancelOnBack(false);
        this.f5900l.setCancelOnTouchOutside(false);
        this.f5900l.m10843a(getActivity().getString(C0258j.general__shared__sending));
        ShareType shareType = this.f5893e.f5805f;
        if ((shareType == ShareType.TEXT || shareType == ShareType.COMMENT || shareType == ShareType.NOTE) && (this.f5894f.mo1569a() instanceof C0800c)) {
            findViewById(C0255g.account__third_share_view__bottom).setVisibility(0);
            CheckBox checkBox = (CheckBox) findViewById(C0255g.account__third_share_view__check);
            checkBox.setChecked(ReaderEnv.get().getPrefBoolean(PrivatePref.READING, "pref_default_share_with_create_note", true));
            checkBox.setOnCheckedChangeListener(new cg(this));
        }
        this.f5899k = (CheckBox) inflate.findViewById(C0255g.account__third_share_view__check);
    }

    /* renamed from: b */
    private View m8956b() {
        ShareType shareType = this.f5893e.f5805f;
        if (shareType == ShareType.BOOK) {
            return m8962d();
        }
        if (shareType == ShareType.TEXT || shareType == ShareType.COMMENT || shareType == ShareType.NOTE) {
            return m8960c();
        }
        if (shareType != ShareType.STATISTICS && shareType != ShareType.BITMAP) {
            return new View(getActivity());
        }
        View boxView = new BoxView(getActivity(), null);
        View imageView = new ImageView(getActivity());
        imageView.setPadding(0, AnimUtils.m1932b(getActivity(), 10.0f), 0, AnimUtils.m1932b(getActivity(), 10.0f));
        imageView.setScaleType(ScaleType.CENTER_INSIDE);
        imageView.setImageBitmap(this.f5893e.f5804e);
        boxView.setMaxHeight(CommonUtils.m609c(getActivity()) / 3);
        boxView.addView(imageView, new LayoutParams(-1, -1));
        return boxView;
    }

    /* renamed from: c */
    private View m8960c() {
        View inflate = LayoutInflater.from(getActivity()).inflate(C0256h.account__third_share_text_view, null);
        PinView pinView = (PinView) inflate.findViewById(C0255g.account__third_share_text_view__sample);
        if (this.f5893e.f5803d.length > 2) {
            pinView.setText(this.f5893e.f5803d[2]);
        }
        return inflate;
    }

    /* renamed from: d */
    private View m8962d() {
        View inflate = LayoutInflater.from(getActivity()).inflate(C0256h.account__third_share_book_view, null);
        DkLabelView dkLabelView = (DkLabelView) inflate.findViewById(C0255g.account__third_share_book_view__book_name);
        DkLabelView dkLabelView2 = (DkLabelView) inflate.findViewById(C0255g.account__third_share_book_view__book_author);
        BookCoverView bookCoverView = (BookCoverView) inflate.findViewById(C0255g.account__third_share_book_view__book_cover);
        Object a = this.f5894f.mo1569a();
        if (a != null && (a instanceof C0800c)) {
            C0800c c0800c = (C0800c) a;
            bookCoverView.setCover(c0800c);
            dkLabelView.setText(c0800c.ay());
            dkLabelView2.setText(c0800c.m4150C());
            return inflate;
        } else if (a == null || !(a instanceof DkStoreBook)) {
            return inflate;
        } else {
            DkStoreBook dkStoreBook = (DkStoreBook) a;
            bookCoverView.setCoverUri(dkStoreBook.getCoverUri());
            dkLabelView.setText(dkStoreBook.getTitle());
            dkLabelView2.setText(dkStoreBook.getAuthorLine());
            return inflate;
        }
    }

    /* renamed from: e */
    private void m8965e() {
        if (CommonUtils.m604a(getActivity())) {
            ReaderUi.m10161a(getActivity(), this.f5898j);
            ShareType shareType = this.f5893e.f5805f;
            if (this.f5892d.equals("weixin_friend")) {
                this.f5900l.m10843a(getActivity().getString(C0258j.general__shared__wait_for_share));
                this.f5900l.show();
                if (shareType == ShareType.TEXT || shareType == ShareType.COMMENT || shareType == ShareType.NOTE) {
                    C1163a.m8627k().m8655c("share", "note", "weixin_session");
                }
                m8958b(m8973i(), new ci(this));
                return;
            } else if (this.f5892d.equals("weixin_timeline")) {
                this.f5900l.m10843a(getActivity().getString(C0258j.general__shared__wait_for_share));
                this.f5900l.show();
                if (shareType == ShareType.TEXT || shareType == ShareType.COMMENT || shareType == ShareType.NOTE) {
                    C1163a.m8627k().m8655c("share", "note", "weixin_timeline");
                }
                m8958b(m8973i(), new cj(this));
                return;
            } else if (this.f5902n) {
                if (!this.f5900l.isShowing()) {
                    this.f5900l.show();
                }
                if (shareType == ShareType.TEXT || shareType == ShareType.COMMENT || shareType == ShareType.NOTE) {
                    C1163a.m8627k().m8655c("share", "note", "weibo");
                }
                String h = m8971h();
                if (h.length() > 140) {
                    h = h.substring(0, 136) + "...";
                }
                if (!TextUtils.isEmpty(this.f5893e.f5800a)) {
                    h = h + " " + this.f5893e.f5800a;
                }
                m8954a(m8973i(), new ck(this, h));
                this.f5897i.setEnabled(false);
                return;
            } else {
                m8976l();
                return;
            }
        }
        be.m10287a(getActivity(), getActivity().getString(C0258j.report_no_network_error), 0).show();
        if (m8978n()) {
            this.f5903o.post(new ch(this));
        }
    }

    /* renamed from: a */
    private void m8954a(String[] strArr, co coVar) {
        ShareType shareType = this.f5893e.f5805f;
        if (shareType == ShareType.STATISTICS || shareType == ShareType.BITMAP || shareType == ShareType.NORMAL) {
            this.f5903o.post(new cm(this, coVar));
            return;
        }
        C0672a b = C0709k.m3476a().m3502b(PersonalAccount.class);
        C1270v c1270v = new C1270v(getActivity(), this.f5892d);
        c1270v.setAccount(b);
        c1270v.m9022a(shareType, this.f5894f.mo1569a(), strArr, this.f5893e.f5802c);
        c1270v.setLayoutParams(new LayoutParams(-2, -2));
        c1270v.measure(MeasureSpec.makeMeasureSpec(1080, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        c1270v.layout(0, 0, c1270v.getMeasuredWidth(), c1270v.getMeasuredHeight());
        try {
            Bitmap c = C0544a.m2447c(c1270v.getMeasuredWidth(), c1270v.getMeasuredHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(c);
            long currentTimeMillis = System.currentTimeMillis();
            this.f5901m = true;
            this.f5903o.post(new cn(this, c1270v, canvas, currentTimeMillis, coVar, c));
        } catch (Throwable th) {
            this.f5903o.post(new bz(this, coVar));
        }
    }

    /* renamed from: b */
    private void m8958b(String[] strArr, co coVar) {
        if (this.f5893e.f5805f == ShareType.NORMAL) {
            this.f5901m = true;
            new ca(this, C0643q.f2173a, coVar).open();
        } else if (m8967f()) {
            if (!this.f5900l.isShowing()) {
                this.f5900l.show();
            }
            this.f5901m = true;
            new cb(this, C0643q.f2173a, m8969g(), coVar).open();
        } else {
            m8954a(strArr, coVar);
        }
    }

    /* renamed from: f */
    private boolean m8967f() {
        return (this.f5893e.f5805f != ShareType.BOOK || TextUtils.isEmpty(this.f5893e.f5800a) || TextUtils.isEmpty(m8969g())) ? false : true;
    }

    /* renamed from: g */
    private String m8969g() {
        Object a = this.f5894f.mo1569a();
        String str = "";
        if (a instanceof C0800c) {
            return ((C0800c) a).m4228g();
        }
        if (a instanceof DkStoreBook) {
            return ((DkStoreBook) a).getCoverUri();
        }
        return a instanceof DkCloudNoteBookInfo ? ((DkCloudNoteBookInfo) a).getBookCoverUrl() : str;
    }

    /* renamed from: h */
    private String m8971h() {
        String obj = this.f5898j.getEditableText().toString();
        switch (ce.f5920a[this.f5893e.f5805f.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return obj;
            case 4:
            case 5:
            case 6:
                Object obj2 = "";
                String str = this.f5893e.f5803d.length > 2 ? this.f5893e.f5803d[2] : "";
                if (this.f5893e.f5803d.length > 0) {
                    obj2 = this.f5893e.f5803d[0];
                }
                int length = (140 - getContext().getString(C0258j.share__comment_template2).length()) - 7;
                if (!TextUtils.isEmpty(obj2)) {
                    length -= obj2.length();
                }
                length = Math.max(0, length);
                if (TextUtils.isEmpty(obj)) {
                    if (str.length() > length) {
                        str = str.substring(0, length) + "... ";
                    }
                    return String.format(getContext().getString(C0258j.share__comment_template1), new Object[]{"“" + str + "”", obj2});
                } else if (obj.length() > length) {
                    str = obj.substring(0, length) + "... ";
                    return String.format(getContext().getString(C0258j.share__comment_template3), new Object[]{str, obj2});
                } else {
                    length = Math.max(0, length - obj.length());
                    if (str.length() > length) {
                        str = str.substring(0, length) + "... ";
                    }
                    return String.format(getContext().getString(C0258j.share__comment_template2), new Object[]{obj, "“" + str + "”", obj2});
                }
            default:
                return obj;
        }
    }

    /* renamed from: i */
    private String[] m8973i() {
        String obj = this.f5898j.getEditableText().toString();
        String[] strArr;
        switch (ce.f5920a[this.f5893e.f5805f.ordinal()]) {
            case 1:
                CharSequence charSequence = "";
                if (this.f5893e.f5803d.length > 2) {
                    charSequence = this.f5893e.f5803d[2];
                }
                strArr = new String[1];
                if (TextUtils.isEmpty(charSequence)) {
                    charSequence = "";
                }
                strArr[0] = charSequence;
                return strArr;
            case 4:
            case 5:
            case 6:
                strArr = new String[2];
                strArr[0] = obj;
                strArr[1] = this.f5893e.f5803d.length > 2 ? this.f5893e.f5803d[2] : "";
                return strArr;
            default:
                if (f5889a) {
                    return null;
                }
                throw new AssertionError();
        }
    }

    /* renamed from: j */
    private String m8974j() {
        String str = "";
        String str2 = "";
        if (this.f5893e.f5803d.length > 0) {
            str = this.f5893e.f5803d[0];
        }
        if (this.f5893e.f5803d.length > 1) {
            str2 = this.f5893e.f5803d[1];
        }
        switch (ce.f5920a[this.f5893e.f5805f.ordinal()]) {
            case 1:
                if (TextUtils.isEmpty(str2)) {
                    return String.format(getContext().getString(C0258j.share__book_template2), new Object[]{str});
                }
                return String.format(getContext().getString(C0258j.share__book_template1), new Object[]{str, str2});
            case 2:
                String string = getContext().getString(C0258j.share__picture_template);
                Object[] objArr = new Object[2];
                objArr[0] = !TextUtils.isEmpty(str2) ? str2 + "//" : "";
                objArr[1] = str;
                return String.format(string, objArr);
            case 4:
            case 5:
                return "";
            case 6:
                return str2;
            default:
                return str;
        }
    }

    /* renamed from: k */
    private String m8975k() {
        String[] stringArray = getActivity().getResources().getStringArray(C0251c.share_title_array);
        if (this.f5892d.equals("weibo")) {
            return stringArray[0];
        }
        if (this.f5892d.equals("weixin_friend")) {
            return stringArray[2];
        }
        if (this.f5892d.equals("weixin_timeline")) {
            return stringArray[3];
        }
        return "";
    }

    /* renamed from: l */
    private void m8976l() {
        this.f5895g.oauth(new cc(this));
    }

    /* renamed from: a */
    private void m8953a(String str) {
        if (this.f5904p != null) {
            ShareType shareType = this.f5893e.f5805f;
            if ((shareType == ShareType.TEXT || shareType == ShareType.COMMENT || shareType == ShareType.NOTE) && (this.f5894f.mo1569a() instanceof C0800c)) {
                this.f5904p.mo2506a(this.f5892d, this.f5898j.getEditableText().toString(), this.f5899k.isChecked());
            }
        }
    }

    /* renamed from: m */
    private void m8977m() {
        if (m8978n()) {
            m8965e();
        } else {
            this.f5903o.postDelayed(new cd(this), 200);
        }
    }

    /* renamed from: n */
    private boolean m8978n() {
        return this.f5892d.equals("weixin_friend") || this.f5892d.equals("weixin_timeline");
    }
}
