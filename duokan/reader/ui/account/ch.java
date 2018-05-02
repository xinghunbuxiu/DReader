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

import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.oauth.ThirdOAuth;
import com.duokan.reader.domain.account.oauth.TokenStore;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.cloud.DkCloudNoteBookInfo;
import com.duokan.reader.domain.store.DkStoreBook;
import com.duokan.reader.ui.account.ShareEntranceController.ShareType;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.PinView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.af;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.hm;
import com.duokan.reader.ui.general.jq;
import com.duokan.reader.ui.ITheme;

public class ch extends af {
    static final /* synthetic */ boolean a = (!ch.class.desiredAssertionStatus());
    private final Activity b;
    private final Context c;
    private final String d;
    private final bd e;
    private final be f;
    private ThirdOAuth g;
    private TokenStore h;
    private View i;
    private EditText j;
    private CheckBox k;
    private jq l;
    private boolean m = false;
    private boolean n;
    private final Handler o = new Handler(Looper.getMainLooper());
    private final cz p;

    public ch(Context context, Activity activity, String str, bd bdVar, be beVar, cz czVar) {
        super(activity);
        this.c = context;
        this.b = activity;
        this.p = czVar;
        this.d = str;
        this.e = bdVar;
        this.f = beVar;
        this.h = TokenStore.getInstance();
        this.g = ThirdOAuth.produceThird(activity, this.d);
        this.g.onActive();
        this.n = this.h.isBindAccessToken(activity, this.d);
        a();
        setCancelOnTouchOutside(false);
    }

    public void show() {
        if (n()) {
            super.dismiss();
        } else {
            super.show();
        }
        m();
    }

    public void dismiss() {
        if (!this.m) {
            if (this.l != null && this.l.isShowing()) {
                this.l.dismiss();
            }
            if (this.g != null) {
                this.g.onDeactive();
            }
            super.dismiss();
        }
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(h.account__third_share_view, null);
        if (ReaderEnv.get().forHd()) {
            inflate.setBackgroundDrawable(new hm(new ColorDrawable(getContext().getResources().getColor(d.general__shared__fefaf8)), (float) UTools.getMinimumHeight(getContext(), 8.0f)));
        }
        setContentView(inflate);
        inflate.findViewById(g.account__third_share_view__btns).setPadding(UTools.getMinimumHeight(getContext(), 15.0f), (ReaderEnv.get().forHd() ? 0 : ((ITheme) MyContextWrapper.getFeature(getContext()).queryFeature(ITheme.class)).getTheme().getHeaderPaddingTop()) + UTools.getMinimumHeight(getContext(), 10.0f), UTools.getMinimumHeight(getContext(), 15.0f), UTools.getMinimumHeight(getContext(), 10.0f));
        ((DkLabelView) inflate.findViewById(g.account__third_share_view__third_name)).setText(k());
        this.j = (EditText) inflate.findViewById(g.account__third_share_view__share_text);
        ((FrameLayout) inflate.findViewById(g.account__third_share_view__content)).addView(b(), new LayoutParams(-1, -2));
        Object j = j();
        if (!TextUtils.isEmpty(j)) {
            this.j.setText(j);
            this.j.setSelection(j.length());
        }
        inflate.findViewById(g.account__third_share_view__cancel).setOnClickListener(new ci(this));
        this.i = inflate.findViewById(g.account__third_share_view__send);
        this.i.setOnClickListener(new cp(this));
        this.l = new jq(getActivity());
        this.l.setCancelOnBack(false);
        this.l.setCancelOnTouchOutside(false);
        this.l.a(getActivity().getString(j.general__shared__sending));
        ShareType shareType = this.e.f;
        if ((shareType == ShareType.TEXT || shareType == ShareType.COMMENT || shareType == ShareType.NOTE) && (this.f.a() instanceof c)) {
            findViewById(g.account__third_share_view__bottom).setVisibility(0);
            CheckBox checkBox = (CheckBox) findViewById(g.account__third_share_view__check);
            checkBox.setChecked(ReaderEnv.get().getPrefBoolean(PrivatePref.READING, "pref_default_share_with_create_note", true));
            checkBox.setOnCheckedChangeListener(new cq(this));
        }
        this.k = (CheckBox) inflate.findViewById(g.account__third_share_view__check);
    }

    private View b() {
        ShareType shareType = this.e.f;
        if (shareType == ShareType.BOOK) {
            return d();
        }
        if (shareType == ShareType.TEXT || shareType == ShareType.COMMENT || shareType == ShareType.NOTE) {
            return c();
        }
        if (shareType != ShareType.STATISTICS && shareType != ShareType.BITMAP) {
            return new View(getActivity());
        }
        View boxView = new BoxView(getActivity(), null);
        View imageView = new ImageView(getActivity());
        imageView.setPadding(0, UTools.getMinimumHeight(getActivity(), 10.0f), 0, UTools.getMinimumHeight(getActivity(), 10.0f));
        imageView.setScaleType(ScaleType.CENTER_INSIDE);
        imageView.setImageBitmap(this.e.e);
        boxView.setMaxHeight(i.c(getActivity()) / 3);
        boxView.addView(imageView, new LayoutParams(-1, -1));
        return boxView;
    }

    private View c() {
        View inflate = LayoutInflater.from(getActivity()).inflate(h.account__third_share_text_view, null);
        PinView pinView = (PinView) inflate.findViewById(g.account__third_share_text_view__sample);
        if (this.e.d.length > 2) {
            pinView.setText(this.e.d[2]);
        }
        return inflate;
    }

    private View d() {
        View inflate = LayoutInflater.from(getActivity()).inflate(h.account__third_share_book_view, null);
        DkLabelView dkLabelView = (DkLabelView) inflate.findViewById(g.account__third_share_book_view__book_name);
        DkLabelView dkLabelView2 = (DkLabelView) inflate.findViewById(g.account__third_share_book_view__book_author);
        BookCoverView bookCoverView = (BookCoverView) inflate.findViewById(g.account__third_share_book_view__book_cover);
        Object a = this.f.a();
        if (a != null && (a instanceof c)) {
            c cVar = (c) a;
            bookCoverView.setCover(cVar);
            dkLabelView.setText(cVar.aw());
            dkLabelView2.setText(cVar.B());
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

    private void e() {
        if (i.a(getActivity())) {
            ReaderUi.a(getActivity(), this.j);
            ShareType shareType = this.e.f;
            if (this.d.equals("wenxin_friend")) {
                this.l.a(getActivity().getString(j.general__shared__wait_for_share));
                this.l.show();
                if (shareType == ShareType.TEXT || shareType == ShareType.COMMENT || shareType == ShareType.NOTE) {
                    a.k().b("share", "note", "weixin_session");
                }
                b(i(), new cs(this));
                return;
            } else if (this.d.equals("wenxin_friends")) {
                this.l.a(getActivity().getString(j.general__shared__wait_for_share));
                this.l.show();
                if (shareType == ShareType.TEXT || shareType == ShareType.COMMENT || shareType == ShareType.NOTE) {
                    a.k().b("share", "note", "weixin_timeline");
                }
                b(i(), new ct(this));
                return;
            } else if (this.n) {
                if (!this.l.isShowing()) {
                    this.l.show();
                }
                if (shareType == ShareType.TEXT || shareType == ShareType.COMMENT || shareType == ShareType.NOTE) {
                    a.k().b("share", "note", "weibo");
                }
                String h = h();
                if (h.length() > 140) {
                    h = h.substring(0, 136) + "...";
                }
                if (!TextUtils.isEmpty(this.e.a)) {
                    h = h + " " + this.e.a;
                }
                a(i(), new cu(this, h));
                this.i.setEnabled(false);
                return;
            } else {
                l();
                return;
            }
        }
        be.a(getActivity(), getActivity().getString(j.report_no_network_error), 0).show();
        if (n()) {
            this.o.post(new cr(this));
        }
    }

    private void a(String[] strArr, cy cyVar) {
        ShareType shareType = this.e.f;
        if (shareType == ShareType.STATISTICS || shareType == ShareType.BITMAP || shareType == ShareType.NORMAL) {
            this.o.post(new cw(this, cyVar));
            return;
        }
        com.duokan.reader.domain.account.a b = com.duokan.reader.domain.account.i.f().b(PersonalAccount.class);
        ai aiVar = new ai(getActivity(), this.d);
        aiVar.setAccount(b);
        aiVar.a(shareType, this.f.a(), strArr, this.e.c);
        aiVar.setLayoutParams(new LayoutParams(-2, -2));
        aiVar.measure(MeasureSpec.makeMeasureSpec(1080, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        aiVar.layout(0, 0, aiVar.getMeasuredWidth(), aiVar.getMeasuredHeight());
        try {
            Bitmap c = com.duokan.reader.common.bitmap.a.c(aiVar.getMeasuredWidth(), aiVar.getMeasuredHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(c);
            long currentTimeMillis = System.currentTimeMillis();
            this.m = true;
            this.o.post(new cx(this, aiVar, canvas, currentTimeMillis, cyVar, c));
        } catch (Throwable th) {
            this.o.post(new cj(this, cyVar));
        }
    }

    private void b(String[] strArr, cy cyVar) {
        if (this.e.f == ShareType.NORMAL) {
            this.m = true;
            new ck(this, cyVar).open();
        } else if (f()) {
            if (!this.l.isShowing()) {
                this.l.show();
            }
            this.m = true;
            new cl(this, g(), cyVar).open();
        } else {
            a(strArr, cyVar);
        }
    }

    private boolean f() {
        return (this.e.f != ShareType.BOOK || TextUtils.isEmpty(this.e.a) || TextUtils.isEmpty(g())) ? false : true;
    }

    private String g() {
        Object a = this.f.a();
        String str = "";
        if (a instanceof c) {
            return ((c) a).g();
        }
        if (a instanceof DkStoreBook) {
            return ((DkStoreBook) a).getCoverUri();
        }
        return a instanceof DkCloudNoteBookInfo ? ((DkCloudNoteBookInfo) a).getBookCoverUrl() : str;
    }

    private String h() {
        String obj = this.j.getEditableText().toString();
        switch (co.a[this.e.f.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return obj;
            case 4:
            case 5:
            case 6:
                Object obj2 = "";
                String str = this.e.d.length > 2 ? this.e.d[2] : "";
                if (this.e.d.length > 0) {
                    obj2 = this.e.d[0];
                }
                int length = (140 - getContext().getString(j.share__comment_template2).length()) - 7;
                if (!TextUtils.isEmpty(obj2)) {
                    length -= obj2.length();
                }
                length = Math.max(0, length);
                if (TextUtils.isEmpty(obj)) {
                    if (str.length() > length) {
                        str = str.substring(0, length) + "... ";
                    }
                    return String.format(getContext().getString(j.share__comment_template1), new Object[]{"“" + str + "”", obj2});
                } else if (obj.length() > length) {
                    str = obj.substring(0, length) + "... ";
                    return String.format(getContext().getString(j.share__comment_template3), new Object[]{str, obj2});
                } else {
                    length = Math.max(0, length - obj.length());
                    if (str.length() > length) {
                        str = str.substring(0, length) + "... ";
                    }
                    return String.format(getContext().getString(j.share__comment_template2), new Object[]{obj, "“" + str + "”", obj2});
                }
            default:
                return obj;
        }
    }

    private String[] i() {
        String obj = this.j.getEditableText().toString();
        String[] strArr;
        switch (co.a[this.e.f.ordinal()]) {
            case 1:
                CharSequence charSequence = "";
                if (this.e.d.length > 2) {
                    charSequence = this.e.d[2];
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
                strArr[1] = this.e.d.length > 2 ? this.e.d[2] : "";
                return strArr;
            default:
                if (a) {
                    return null;
                }
                throw new AssertionError();
        }
    }

    private String j() {
        String str = "";
        String str2 = "";
        if (this.e.d.length > 0) {
            str = this.e.d[0];
        }
        if (this.e.d.length > 1) {
            str2 = this.e.d[1];
        }
        switch (co.a[this.e.f.ordinal()]) {
            case 1:
                if (TextUtils.isEmpty(str2)) {
                    return String.format(getContext().getString(j.share__book_template2), new Object[]{str});
                }
                return String.format(getContext().getString(j.share__book_template1), new Object[]{str, str2});
            case 2:
                String string = getContext().getString(j.share__picture_template);
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

    private String k() {
        String[] stringArray = getActivity().getResources().getStringArray(com.duokan.c.c.share_title_array);
        if (this.d.equals("sina")) {
            return stringArray[0];
        }
        if (this.d.equals("wenxin_friend")) {
            return stringArray[2];
        }
        if (this.d.equals("wenxin_friends")) {
            return stringArray[3];
        }
        return "";
    }

    private void l() {
        this.g.oauth(new cm(this));
    }

    private void a(String str) {
        if (this.p != null) {
            ShareType shareType = this.e.f;
            if ((shareType == ShareType.TEXT || shareType == ShareType.COMMENT || shareType == ShareType.NOTE) && (this.f.a() instanceof c)) {
                this.p.a(this.d, this.j.getEditableText().toString(), this.k.isChecked());
            }
        }
    }

    private void m() {
        if (n()) {
            e();
        } else {
            this.o.postDelayed(new cn(this), 200);
        }
    }

    private boolean n() {
        return this.d.equals("wenxin_friend") || this.d.equals("wenxin_friends");
    }
}
