package com.duokan.reader.ui.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.j;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.sys.ag;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.store.DkStoreAbsBook;
import com.duokan.reader.ui.general.BookCoverView;
import com.duokan.reader.ui.general.PageHeaderView;
import com.duokan.reader.ui.general.jq;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;

public class a extends ActivatedController {
    private final ag a;
    private final ag b;
    private final LinearScrollView c;
    private final EditText d;
    private final EditText e;
    private final LinkedList f = new LinkedList();
    private final LinkedList g = new LinkedList();
    private final String h;
    private final String i;
    private final LinkedList j;
    private final LinkedList k;
    private jq l = null;

    public a(IFeature featrue, String str, String str2, LinkedList linkedList, LinkedList linkedList2, ag agVar, ag agVar2) {
        super(featrue);
        setContentView(h.discovery__edit_feed_view);
        this.a = agVar;
        this.b = agVar2;
        ((BoxView) getContentView()).setResizeLayoutForSoftInput(true);
        this.c = (LinearScrollView) findViewById(g.discovery__edit_feed_view__feed);
        this.c.setOnScrollListener(new b(this));
        this.c.setFocusable(true);
        this.c.setFocusableInTouchMode(true);
        this.c.setClickable(true);
        this.c.setOnClickListener(new c(this));
        ((PageHeaderView) findViewById(g.discovery__edit_feed_view__header)).a(getString(j.discovery__edit_feed_view__header), j.discovery__edit_feed_view__send, new d(this), j.general__shared__cancel, new f(this));
        this.d = (EditText) findViewById(g.discovery__edit_feed_view__title);
        this.e = (EditText) findViewById(g.discovery__edit_feed_view__reason);
        ((TextView) findViewById(g.discovery__edit_feed_view__add)).setOnClickListener(new g(this));
        if (!TextUtils.isEmpty(str)) {
            this.d.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.e.setText(str2);
        }
        this.f.addAll(linkedList);
        this.g.addAll(linkedList2);
        this.h = this.d.getText().toString();
        this.i = this.e.getText().toString();
        this.j = (LinkedList) this.f.clone();
        this.k = (LinkedList) this.g.clone();
        b();
        UTools.addAnimation(this.d);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        if (this.l == null) {
            this.b.a(a(false));
        } else {
            this.l.dismiss();
        }
        UTools.hideSoftInputFromWindow(getContext());
    }

    public void a() {
        if (this.l != null) {
            this.l.dismiss();
            this.l = null;
        }
    }

    private JSONObject a(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("modified", d());
            jSONObject.put("title", this.d.getText().toString());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("content", jSONObject2);
            JSONArray jSONArray = new JSONArray();
            jSONObject2.put("getScaledTouchSlop", jSONArray);
            jSONObject2 = new JSONObject();
            jSONArray.put(jSONObject2);
            jSONObject2.put("TaskHandler", "p");
            jSONObject2.put("showAnimation", this.e.getText().toString());
            jSONObject.put("operation", z);
            for (int i = 0; i < this.f.size(); i++) {
                jSONArray.put(a(i));
            }
            if (!this.f.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                Iterator it = this.f.iterator();
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

    private JSONObject a(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("TaskHandler", "getVisible");
            jSONObject.put("showAnimation", ((DkStoreAbsBook) this.f.get(i)).getBookUuid());
            if (!TextUtils.isEmpty((CharSequence) this.g.get(i))) {
                JSONArray jSONArray = new JSONArray();
                jSONObject.put("getScaledTouchSlop", jSONArray);
                JSONObject jSONObject2 = new JSONObject();
                jSONArray.put(jSONObject2);
                jSONObject2.put("TaskHandler", "p");
                jSONObject2.put("showAnimation", this.g.get(i));
            }
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private void b() {
        LayoutInflater from = LayoutInflater.from(getContext());
        this.c.removeViews(1, this.c.getChildCount() - 1);
        for (int i = 0; i < this.f.size(); i++) {
            DkStoreAbsBook dkStoreAbsBook = (DkStoreAbsBook) this.f.get(i);
            View inflate = from.inflate(h.discovery__edit_feed_item_view, this.c, false);
            ((TextView) inflate.findViewById(g.discovery__edit_feed_item_view__title)).setText(dkStoreAbsBook.getTitle());
            ((BookCoverView) inflate.findViewById(g.discovery__edit_feed_item_view__cover)).setCoverUri(dkStoreAbsBook.getCoverUri());
            inflate.findViewById(g.discovery__edit_feed_item_view__delete).setOnClickListener(new j(this, dkStoreAbsBook, inflate));
            TextView textView = (TextView) inflate.findViewById(g.discovery__edit_feed_item_view__desc);
            textView.setText((CharSequence) this.g.get(i));
            textView.setGravity(TextUtils.isEmpty((CharSequence) this.g.get(i)) ? 17 : 3);
            textView.setOnClickListener(new l(this, textView, i, dkStoreAbsBook));
            this.c.addView(inflate);
        }
    }

    private void c() {
        this.c.requestFocus();
    }

    private boolean d() {
        if (!TextUtils.equals(this.h, this.d.getText().toString())) {
            return true;
        }
        if (!TextUtils.equals(this.i, this.e.getText().toString())) {
            return true;
        }
        if (this.j.size() != this.f.size()) {
            return true;
        }
        int i;
        for (i = 0; i < this.j.size(); i++) {
            if (!((DkStoreAbsBook) this.j.get(i)).equals(this.f.get(i))) {
                return true;
            }
        }
        if (this.k.size() != this.k.size()) {
            return true;
        }
        for (i = 0; i < this.k.size(); i++) {
            if (!((String) this.k.get(i)).equals(this.g.get(i))) {
                return true;
            }
        }
        return false;
    }
}
