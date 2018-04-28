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
    /* renamed from: a */
    static final /* synthetic */ boolean f2697a = (!aa.class.desiredAssertionStatus());
    /* renamed from: b */
    private final ArrayList<an> f2698b = new ArrayList();
    /* renamed from: c */
    private an[] f2699c = null;
    /* renamed from: d */
    private C0800c[] f2700d = null;
    /* renamed from: e */
    private BookCategoryType f2701e = BookCategoryType.CUSTOM;
    /* renamed from: f */
    private String f2702f = "";

    protected aa(am amVar, long j, boolean z) {
        super(amVar, j, false, z);
    }

    /* renamed from: a */
    public final void m3752a() {
        try {
            aV().mo1091a(aH());
            aQ();
        } finally {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: b */
    public BookCategoryType m3759b() {
        try {
            aV().mo1091a(aH());
            aQ();
            BookCategoryType bookCategoryType = this.f2701e;
            return bookCategoryType;
        } finally {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: c */
    public boolean m3761c() {
        return m3765f() < 1;
    }

    /* renamed from: d */
    public C0800c[] m3763d() {
        try {
            aV().mo1091a(aH());
            aQ();
            if (this.f2700d == null) {
                ArrayList arrayList = new ArrayList(this.f2698b.size());
                Iterator it = this.f2698b.iterator();
                while (it.hasNext()) {
                    an anVar = (an) it.next();
                    if (anVar instanceof C0800c) {
                        arrayList.add((C0800c) anVar);
                    }
                }
                this.f2700d = (C0800c[]) arrayList.toArray(new C0800c[0]);
            }
            C0800c[] c0800cArr = this.f2700d;
            return c0800cArr;
        } finally {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: e */
    public an[] m3764e() {
        try {
            aV().mo1091a(aH());
            aQ();
            if (this.f2699c == null) {
                this.f2699c = (an[]) this.f2698b.toArray(new an[0]);
            }
            an[] anVarArr = this.f2699c;
            return anVarArr;
        } finally {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: f */
    public int m3765f() {
        try {
            aV().mo1091a(aH());
            aQ();
            int size = this.f2698b.size();
            return size;
        } finally {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: g */
    public int m3766g() {
        try {
            aV().mo1091a(aH());
            aQ();
            if (this.f2698b == null || this.f2698b.size() == 0) {
                aV().mo1097b(aH());
                return 0;
            }
            int i = 0;
            int i2 = 0;
            while (i < this.f2698b.size()) {
                int i3;
                if (((an) this.f2698b.get(i)).aA()) {
                    if (((an) this.f2698b.get(i)).aB()) {
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
            aV().mo1097b(aH());
            return i2;
        } catch (Throwable th) {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: h */
    public boolean m3767h() {
        return aH() == -9;
    }

    /* renamed from: a */
    public void m3756a(an anVar) {
        m3757a(anVar, 0);
    }

    /* renamed from: a */
    public void m3757a(an anVar, int i) {
        try {
            aV().mo1091a(aH());
            aQ();
            m3760b(anVar);
            m3753a(i, anVar);
            aN();
        } finally {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: i */
    public List<an> m3768i() {
        if (ReaderEnv.get().getBookShelfType() == BookShelfType.Simple) {
            return m3751l();
        }
        List<an> arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(m3764e()));
        return arrayList;
    }

    /* renamed from: l */
    private List<an> m3751l() {
        return this.D.mo1107j().listItemsByReadingOrder(this);
    }

    /* renamed from: a */
    protected void m3753a(int i, an anVar) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2698b.add(i, anVar);
            anVar.m3748h(aH());
            this.f2699c = null;
            this.f2700d = null;
            m3744b(65536);
            this.D.mo1107j().addCategory(this, anVar, i);
        } finally {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: b */
    protected boolean m3760b(an anVar) {
        try {
            aV().mo1091a(aH());
            aQ();
            boolean remove = this.f2698b.remove(anVar);
            if (remove) {
                anVar.aL();
                this.f2699c = null;
                this.f2700d = null;
                m3744b(65536);
                this.D.mo1107j().deleteFromCategory(this, anVar);
                aV().mo1097b(aH());
            }
            return remove;
        } finally {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: j */
    protected void m3769j() {
        try {
            aV().mo1091a(aH());
            aQ();
            Iterator it = this.f2698b.iterator();
            while (it.hasNext()) {
                ((an) it.next()).aL();
            }
            this.D.mo1107j().deleteFromCategory(this, this.f2698b);
            this.f2698b.clear();
            this.f2699c = null;
            this.f2700d = null;
            m3744b(65536);
        } finally {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: c */
    public boolean m3762c(an anVar) {
        try {
            aV().mo1091a(aH());
            aQ();
            boolean contains = this.f2698b.contains(anVar);
            return contains;
        } finally {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: a */
    public boolean m3758a(Collection<? extends an> collection) {
        try {
            aV().mo1091a(aH());
            aQ();
            boolean containsAll = this.f2698b.containsAll(collection);
            return containsAll;
        } finally {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: k */
    public final String m3770k() {
        try {
            aV().mo1091a(aH());
            aQ();
            String str = this.f2702f;
            return str;
        } finally {
            aV().mo1097b(aH());
        }
    }

    /* renamed from: p */
    protected final void mo955p(String str) {
        try {
            aV().mo1091a(aH());
            aQ();
            this.f2702f = str;
            m3744b(2);
        } finally {
            aV().mo1097b(aH());
        }
    }

    public boolean aA() {
        return false;
    }

    public boolean aB() {
        if (m3767h()) {
            C0800c[] d = m3763d();
            for (C0800c aB : d) {
                if (!aB.aB()) {
                    return false;
                }
            }
            return true;
        } else if (m3766g() == m3765f()) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    protected void mo951a(Cursor cursor) {
        this.f2702f = cursor.getString(cursor.getColumnIndex("category_name"));
        this.f2701e = BookCategoryType.valueOf(cursor.getString(cursor.getColumnIndex("category_type")));
        try {
            int[] iArr = (int[]) new ObjectInputStream(new ByteArrayInputStream(cursor.getBlob(cursor.getColumnIndex("category_items")))).readObject();
            this.f2698b.ensureCapacity(iArr.length);
            int i = 0;
            while (i < iArr.length) {
                an i2 = m3749i((long) iArr[i]);
                if (f2697a || i2 != null) {
                    if (i2 != null) {
                        i2.m3748h(aH());
                        this.f2698b.add(i2);
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

    /* renamed from: a */
    protected void mo950a(ContentValues contentValues) {
        if (m3747c(2)) {
            contentValues.put("category_name", m3770k());
            contentValues.put("category_type", m3759b().name());
        }
        if (m3747c(65536)) {
            Object obj = new int[this.f2698b.size()];
            for (int i = 0; i < obj.length; i++) {
                obj[i] = (int) ((an) this.f2698b.get(i)).aH();
            }
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            contentValues.put("category_items", byteArrayOutputStream.toByteArray());
        }
    }

    protected String aC() {
        return "book_categories";
    }
}
