package com.duokan.reader.ui.personal;

import android.os.AsyncTask;

import com.duokan.c.j;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.iy;
import com.duokan.reader.domain.bookshelf.iz;
import com.duokan.reader.ui.general.jq;
import com.duokan.reader.ui.personal.BooksUploadController.UploadBookStatus;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class q extends AsyncTask {
    final /* synthetic */ BooksUploadController a;
    private int b;
    private jq c;
    private ArrayList d;
    private List e;

    private q(BooksUploadController booksUploadController) {
        this.a = booksUploadController;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Integer) obj);
    }

    protected void onPreExecute() {
        this.c = new jq(this.a.getContext());
        this.c.a(this.a.getContext().getString(j.organizebooks));
        this.c.setCancelOnBack(false);
        this.c.setCancelOnTouchOutside(false);
        this.c.show();
        this.d = new ArrayList(this.a.c);
        super.onPreExecute();
    }

    protected Integer a(String... strArr) {
        a();
        b();
        return null;
    }

    protected void a(Integer num) {
        super.onPostExecute(num);
        this.c.dismiss();
        this.a.b.a(this.b, this.a.d);
    }

    private void a() {
        List arrayList = new ArrayList();
        List linkedList = new LinkedList();
        ArrayList arrayList2 = new ArrayList();
        for (an anVar : ai.a().l().e()) {
            if (anVar instanceof c) {
                c cVar = (c) anVar;
                if (b(cVar)) {
                    linkedList.add(a(cVar));
                }
            } else if (anVar instanceof aa) {
                arrayList2.add((aa) anVar);
            }
        }
        if (linkedList.size() > 0) {
            arrayList.add(new s("/", this.a.getContext().getResources().getString(j.bookshelf__shared__main_category), linkedList));
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            aa aaVar = (aa) it.next();
            List linkedList2 = new LinkedList();
            for (c cVar2 : aaVar.d()) {
                if (b(cVar2)) {
                    linkedList2.add(a(cVar2));
                }
            }
            if (linkedList2.size() > 0) {
                arrayList.add(new s("/" + aaVar.k(), aaVar.k(), linkedList2));
            }
        }
        this.e = arrayList;
    }

    private void a(s sVar) {
        List<r> b = sVar.b();
        sVar.a(UploadBookStatus.UPLOADED);
        for (r rVar : b) {
            if (a(rVar)) {
                rVar.a(UploadBookStatus.UPLOADED);
            } else if (new File(rVar.a()).exists()) {
                rVar.a(UploadBookStatus.UNSELECTED);
                sVar.a(UploadBookStatus.UNSELECTED);
            } else {
                rVar.a(UploadBookStatus.NOTEXIST);
            }
        }
    }

    private void b() {
        List<s> list = this.e;
        if (list != null && list.size() != 0) {
            this.b = 0;
            for (s sVar : list) {
                a(sVar);
                this.b = sVar.d.size() + this.b;
            }
            this.a.d = list;
        }
    }

    private r a(c cVar) {
        if (!cVar.am() || cVar.ak() == null) {
            return new r(cVar.e(), new File(cVar.e()).getName(), cVar.C());
        }
        return new r(cVar.e(), cVar.ak().b(), cVar.C());
    }

    private boolean a(r rVar) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            if (((CustomCloudItem) it.next()).g().equals(rVar.b())) {
                return true;
            }
        }
        return false;
    }

    private boolean b(c cVar) {
        Collection linkedList = new LinkedList();
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            CustomCloudItem customCloudItem = (CustomCloudItem) it.next();
            if (customCloudItem.c()) {
                linkedList.add((iy) customCloudItem.a());
            }
        }
        return iz.a(cVar, linkedList);
    }
}
