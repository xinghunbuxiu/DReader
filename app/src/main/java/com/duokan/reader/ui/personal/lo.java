package com.duokan.reader.ui.personal;

import android.content.Context;
import android.text.TextUtils;

import com.duokan.reader.domain.cloud.DkCloudStoreBook;
import com.duokan.reader.domain.cloud.a;
import com.duokan.reader.ui.bookshelf.ho;

import java.util.ArrayList;
import java.util.List;

public class lo extends nm {
    private lq a;
    private mq k;
    private ke l;
    private List m = new ArrayList();

    public lo(Context context, a aVar, ho hoVar, ke keVar) {
        super(context, hoVar);
        this.b.setLeftTitle(aVar.a());
        this.l = keVar;
        this.a = new lq(this, getContext());
        this.k = new mq(context, hoVar);
        this.i = new lp(this);
        setAdapter(this.a);
        setSearchAdapter(this.k);
        setData(aVar);
        this.e.setPullDownRefreshEnabled(false);
    }

    public void d() {
        this.a.a(false);
    }

    public void setData(a aVar) {
        this.a.a(aVar);
    }

    private boolean a(DkCloudStoreBook dkCloudStoreBook, String str) {
        if (dkCloudStoreBook.getTitle().toLowerCase().contains(str.toLowerCase())) {
            return true;
        }
        Object authorLine = dkCloudStoreBook.getAuthorLine();
        if (!TextUtils.isEmpty(authorLine) && authorLine.toLowerCase().contains(str.toLowerCase())) {
            return true;
        }
        authorLine = dkCloudStoreBook.getEditorLine();
        if (TextUtils.isEmpty(authorLine) || !authorLine.toLowerCase().contains(str.toLowerCase())) {
            return false;
        }
        return true;
    }

    public void f() {
        super.f();
        this.e.setPullDownRefreshEnabled(false);
    }
}
