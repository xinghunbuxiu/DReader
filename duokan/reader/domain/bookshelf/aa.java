package com.duokan.reader.domain.bookshelf;

import android.content.ContentValues;
import android.database.Cursor;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.BookShelfType;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class aa extends an {
    static final /* synthetic */ boolean a = (!aa.class.desiredAssertionStatus());
    private final ArrayList b = new ArrayList();
    private an[] c = null;
    private c[] d = null;
    private BookCategoryType e = BookCategoryType.CUSTOM;
    private String f = "";

    protected aa(am amVar, long j, boolean z) {
        super(amVar, j, false, z);
    }

    public final void a() {
        try {
            aT().a(aF());
            aO();
        } finally {
            aT().b(aF());
        }
    }

    public BookCategoryType b() {
        try {
            aT().a(aF());
            aO();
            BookCategoryType bookCategoryType = this.e;
            return bookCategoryType;
        } finally {
            aT().b(aF());
        }
    }

    public boolean c() {
        return f() < 1;
    }

    public c[] d() {
        try {
            aT().a(aF());
            aO();
            if (this.d == null) {
                ArrayList arrayList = new ArrayList(this.b.size());
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    an anVar = (an) it.next();
                    if (anVar instanceof c) {
                        arrayList.add((c) anVar);
                    }
                }
                this.d = (c[]) arrayList.toArray(new c[0]);
            }
            c[] cVarArr = this.d;
            return cVarArr;
        } finally {
            aT().b(aF());
        }
    }

    public an[] e() {
        try {
            aT().a(aF());
            aO();
            if (this.c == null) {
                this.c = (an[]) this.b.toArray(new an[0]);
            }
            an[] anVarArr = this.c;
            return anVarArr;
        } finally {
            aT().b(aF());
        }
    }

    public int f() {
        try {
            aT().a(aF());
            aO();
            int size = this.b.size();
            return size;
        } finally {
            aT().b(aF());
        }
    }

    public int g() {
        try {
            aT().a(aF());
            aO();
            if (this.b == null || this.b.size() == 0) {
                aT().b(aF());
                return 0;
            }
            int i = 0;
            int i2 = 0;
            while (i < this.b.size()) {
                int i3;
                if (((an) this.b.get(i)).ay()) {
                    if (((an) this.b.get(i)).az()) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    i3 += i2;
                } else {
                    i3 = i2;
                }
                i++;
                i2 = i3;
            }
            aT().b(aF());
            return i2;
        } catch (Throwable th) {
            aT().b(aF());
        }
    }

    public boolean h() {
        return aF() == -9;
    }

    public void a(an anVar) {
        a(anVar, 0);
    }

    public void a(an anVar, int i) {
        try {
            aT().a(aF());
            aO();
            b(anVar);
            a(i, anVar);
            aL();
        } finally {
            aT().b(aF());
        }
    }

    public List i() {
        if (ReaderEnv.get().getBookShelfType() == BookShelfType.Simple) {
            return l();
        }
        List arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(e()));
        return arrayList;
    }

    private List l() {
        return this.D.j().listItemsByReadingOrder(this);
    }

    protected void a(int i, an anVar) {
        try {
            aT().a(aF());
            aO();
            this.b.add(i, anVar);
            anVar.h(aF());
            this.c = null;
            this.d = null;
            b(65536);
            this.D.j().addCategory(this, anVar, i);
        } finally {
            aT().b(aF());
        }
    }

    protected boolean b(an anVar) {
        try {
            aT().a(aF());
            aO();
            boolean remove = this.b.remove(anVar);
            if (remove) {
                anVar.aJ();
                this.c = null;
                this.d = null;
                b(65536);
                this.D.j().deleteFromCategory(this, anVar);
                aT().b(aF());
            }
            return remove;
        } finally {
            aT().b(aF());
        }
    }

    protected void j() {
        try {
            aT().a(aF());
            aO();
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((an) it.next()).aJ();
            }
            this.D.j().deleteFromCategory(this, this.b);
            this.b.clear();
            this.c = null;
            this.d = null;
            b(65536);
        } finally {
            aT().b(aF());
        }
    }

    public boolean c(an anVar) {
        try {
            aT().a(aF());
            aO();
            boolean contains = this.b.contains(anVar);
            return contains;
        } finally {
            aT().b(aF());
        }
    }

    public boolean a(Collection collection) {
        try {
            aT().a(aF());
            aO();
            boolean containsAll = this.b.containsAll(collection);
            return containsAll;
        } finally {
            aT().b(aF());
        }
    }

    public final String k() {
        try {
            aT().a(aF());
            aO();
            String str = this.f;
            return str;
        } finally {
            aT().b(aF());
        }
    }

    protected final void o(String str) {
        try {
            aT().a(aF());
            aO();
            this.f = str;
            b(2);
        } finally {
            aT().b(aF());
        }
    }

    public boolean ay() {
        return false;
    }

    public boolean az() {
        if (h()) {
            c[] d = d();
            for (c az : d) {
                if (!az.az()) {
                    return false;
                }
            }
            return true;
        } else if (g() == f()) {
            return true;
        } else {
            return false;
        }
    }

    protected void a(Cursor cursor) {
        this.f = cursor.getString(cursor.getColumnIndex("category_name"));
        this.e = BookCategoryType.valueOf(cursor.getString(cursor.getColumnIndex("category_type")));
        try {
            int[] iArr = (int[]) new ObjectInputStream(new ByteArrayInputStream(cursor.getBlob(cursor.getColumnIndex("category_items")))).readObject();
            this.b.ensureCapacity(iArr.length);
            int i = 0;
            while (i < iArr.length) {
                an i2 = i((long) iArr[i]);
                if (a || i2 != null) {
                    if (i2 != null) {
                        i2.h(aF());
                        this.b.add(i2);
                    }
                    i++;
                } else {
                    throw new AssertionError();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void a(ContentValues contentValues) {
        if (c(2)) {
            contentValues.put("category_name", k());
            contentValues.put("category_type", b().name());
        }
        if (c(65536)) {
            Object obj = new int[this.b.size()];
            for (int i = 0; i < obj.length; i++) {
                obj[i] = (int) ((an) this.b.get(i)).aF();
            }
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            contentValues.put("category_items", byteArrayOutputStream.toByteArray());
        }
    }

    protected String aA() {
        return "book_categories";
    }
}
