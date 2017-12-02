package com.duokan.reader.ui.personal;

import android.view.View;
import android.view.ViewGroup;

import com.duokan.reader.ui.bookshelf.hn;

import java.util.LinkedList;
import java.util.List;

class et implements hn {
    final /* synthetic */ eq a;

    et(eq eqVar) {
        this.a = eqVar;
    }

    public int a() {
        return 0;
    }

    public void a(String str) {
        if (str == null || str.length() == 0) {
            this.a.f();
            return;
        }
        List<CustomCloudItem> cloudItem = this.a.getCloudItem();
        List linkedList = new LinkedList();
        for (CustomCloudItem customCloudItem : cloudItem) {
            if (customCloudItem.g().toLowerCase().contains(str.toLowerCase())) {
                linkedList.add(customCloudItem);
            }
        }
        this.a.k.a(linkedList, str);
        this.a.e();
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public void a(int i, View view) {
    }

    public boolean b(int i, View view) {
        return false;
    }
}
