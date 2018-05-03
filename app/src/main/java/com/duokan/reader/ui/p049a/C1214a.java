package com.duokan.reader.ui.p049a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.ag;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.store.DkStoreAbsBook;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.ja;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.ui.a.a */
public class C1214a extends ActivatedController {
    /* renamed from: a */
    private final ag<JSONObject> f5696a;
    /* renamed from: b */
    private final ag<JSONObject> f5697b;
    /* renamed from: c */
    private final LinearScrollView f5698c;
    /* renamed from: d */
    private final EditText f5699d;
    /* renamed from: e */
    private final EditText f5700e;
    /* renamed from: f */
    private final LinkedList<DkStoreAbsBook> f5701f = new LinkedList();
    /* renamed from: g */
    private final LinkedList<String> f5702g = new LinkedList();
    /* renamed from: h */
    private final String f5703h;
    /* renamed from: i */
    private final String f5704i;
    /* renamed from: j */
    private final LinkedList<DkStoreAbsBook> f5705j;
    /* renamed from: k */
    private final LinkedList<String> f5706k;
    /* renamed from: l */
    private ja f5707l = null;

    public C1214a(IFeature mFeature, String str, String str2, LinkedList<DkStoreAbsBook> linkedList, LinkedList<String> linkedList2, ag<JSONObject> agVar, ag<JSONObject> agVar2) {
        super(mFeature);
        setContentView(C0256h.discovery__edit_feed_view);
        this.f5696a = agVar;
        this.f5697b = agVar2;
        ((BoxView) getContentView()).setResizeLayoutForSoftInput(true);
        this.f5698c = (LinearScrollView) findViewById(C0255g.discovery__edit_feed_view__feed);
        this.f5698c.setOnScrollListener(new C1215b(this));
        this.f5698c.setFocusable(true);
        this.f5698c.setFocusableInTouchMode(true);
        this.f5698c.setClickable(true);
        this.f5698c.setOnClickListener(new C1216c(this));
        ((PageHeaderView) findViewById(C0255g.discovery__edit_feed_view__header)).m10149a(getString(C0258j.discovery__edit_feed_view__header), C0258j.discovery__edit_feed_view__send, new C1217d(this), C0258j.general__shared__cancel, new C1219f(this));
        this.f5699d = (EditText) findViewById(C0255g.discovery__edit_feed_view__title);
        this.f5700e = (EditText) findViewById(C0255g.discovery__edit_feed_view__reason);
        ((TextView) findViewById(C0255g.discovery__edit_feed_view__add)).setOnClickListener(new C1220g(this));
        if (!TextUtils.isEmpty(str)) {
            this.f5699d.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f5700e.setText(str2);
        }
        this.f5701f.addAll(linkedList);
        this.f5702g.addAll(linkedList2);
        this.f5703h = this.f5699d.getText().toString();
        this.f5704i = this.f5700e.getText().toString();
        this.f5705j = (LinkedList) this.f5701f.clone();
        this.f5706k = (LinkedList) this.f5702g.clone();
        m8754b();
        AnimUtils.m1915a(this.f5699d);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        if (this.f5707l == null) {
            this.f5697b.run(m8752a(false));
        } else {
            this.f5707l.dismiss();
        }
        AnimUtils.m1909a(getContext());
    }

    /* renamed from: a */
    public void m8763a() {
        if (this.f5707l != null) {
            this.f5707l.dismiss();
            this.f5707l = null;
        }
    }

    /* renamed from: a */
    private JSONObject m8752a(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("modified", m8758d());
            jSONObject.put("title", this.f5699d.getText().toString());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("content", jSONObject2);
            JSONArray jSONArray = new JSONArray();
            jSONObject2.put("d", jSONArray);
            jSONObject2 = new JSONObject();
            jSONArray.put(jSONObject2);
            jSONObject2.put("t", "p");
            jSONObject2.put("c", this.f5700e.getText().toString());
            jSONObject.put("operation", z);
            for (int i = 0; i < this.f5701f.size(); i++) {
                jSONArray.put(m8750a(i));
            }
            if (!this.f5701f.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                Iterator it = this.f5701f.iterator();
                while (it.hasNext()) {
                    DkStoreAbsBook dkStoreAbsBook = (DkStoreAbsBook) it.next();
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("cover", dkStoreAbsBook.getCoverUri());
                    jSONObject4.put("title", dkStoreAbsBook.getTitle());
                    jSONObject3.put(dkStoreAbsBook.getBookUuid(), jSONObject4);
                }
                jSONObject.put("books", jSONObject3);
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    private JSONObject m8750a(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", "b");
            jSONObject.put("c", ((DkStoreAbsBook) this.f5701f.get(i)).getBookUuid());
            if (!TextUtils.isEmpty((CharSequence) this.f5702g.get(i))) {
                JSONArray jSONArray = new JSONArray();
                jSONObject.put("d", jSONArray);
                JSONObject jSONObject2 = new JSONObject();
                jSONArray.put(jSONObject2);
                jSONObject2.put("t", "p");
                jSONObject2.put("c", this.f5702g.get(i));
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }

    /* renamed from: b */
    private void m8754b() {
        LayoutInflater from = LayoutInflater.from(getContext());
        this.f5698c.removeViews(1, this.f5698c.getChildCount() - 1);
        for (int i = 0; i < this.f5701f.size(); i++) {
            DkStoreAbsBook dkStoreAbsBook = (DkStoreAbsBook) this.f5701f.get(i);
            View inflate = from.inflate(C0256h.discovery__edit_feed_item_view, this.f5698c, false);
            ((TextView) inflate.findViewById(C0255g.discovery__edit_feed_item_view__title)).setText(dkStoreAbsBook.getTitle());
            ((BookCoverView) inflate.findViewById(C0255g.discovery__edit_feed_item_view__cover)).setCoverUri(dkStoreAbsBook.getCoverUri());
            inflate.findViewById(C0255g.discovery__edit_feed_item_view__delete).setOnClickListener(new C1224j(this, dkStoreAbsBook, inflate));
            TextView textView = (TextView) inflate.findViewById(C0255g.discovery__edit_feed_item_view__desc);
            textView.setText((CharSequence) this.f5702g.get(i));
            textView.setGravity(TextUtils.isEmpty((CharSequence) this.f5702g.get(i)) ? 17 : 3);
            textView.setOnClickListener(new C1226l(this, textView, i, dkStoreAbsBook));
            this.f5698c.addView(inflate);
        }
    }

    /* renamed from: c */
    private void m8756c() {
        this.f5698c.requestFocus();
    }

    /* renamed from: d */
    private boolean m8758d() {
        if (!TextUtils.equals(this.f5703h, this.f5699d.getText().toString())) {
            return true;
        }
        if (!TextUtils.equals(this.f5704i, this.f5700e.getText().toString())) {
            return true;
        }
        if (this.f5705j.size() != this.f5701f.size()) {
            return true;
        }
        int i;
        for (i = 0; i < this.f5705j.size(); i++) {
            if (!((DkStoreAbsBook) this.f5705j.get(i)).equals(this.f5701f.get(i))) {
                return true;
            }
        }
        if (this.f5706k.size() != this.f5706k.size()) {
            return true;
        }
        for (i = 0; i < this.f5706k.size(); i++) {
            if (!((String) this.f5706k.get(i)).equals(this.f5702g.get(i))) {
                return true;
            }
        }
        return false;
    }
}
