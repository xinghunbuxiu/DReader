package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duokan.b.g;
import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.ui.bookshelf.gw;
import com.duokan.reader.ui.bookshelf.ho;

import java.util.ArrayList;
import java.util.List;

public class mq extends gw {
    private final Context a;
    private final ho c;
    private final ke d;
    private List e = new ArrayList();
    private String f;

    public mq(Context context, ho hoVar) {
        this.a = context;
        this.c = hoVar;
        this.d = new ke(this.a);
    }

    public void a(List list, String str) {
        if (list != this.e) {
            this.e.clear();
        }
        this.e = list;
        this.f = str;
        a(false);
    }

    public void a(List list) {
        this.e.removeAll(list);
        a(false);
    }

    protected int k() {
        return 1;
    }

    protected int f(int i) {
        return c();
    }

    public int c() {
        return this.e.size();
    }

    public Object d(int i) {
        return this.e.get(i);
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        View a = this.d.a((DkCloudStoreBook) d(i), view, viewGroup, this, 0, i, this.f);
        a.setOnClickListener(new mr(this, i));
        a.setOnLongClickListener(new ms(this, i));
        return a;
    }

    public View a(View view, ViewGroup viewGroup) {
        return LayoutInflater.from(this.a).inflate(g.personal__search_empty_view, viewGroup, false);
    }

    protected void b() {
        this.e.clear();
    }

    protected void e(int i) {
    }
}
