package com.duokan.reader.domain.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.SparseArray;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.p026a.C0285n;
import com.duokan.core.p026a.C0293u;
import com.duokan.reader.domain.bookshelf.BookCategoryType;
import com.duokan.reader.domain.bookshelf.ea;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public class BookshelfHelper {
    /* renamed from: a */
    public static final String f5442a = BookshelfHelper.class.getName();

    public class BooksTable {

        public enum Column {
            _ID,
            BOOK_URI,
            ONLINE_COVER_URI,
            BOOK_NAME,
            BOOK_TYPE,
            BOOK_FORMAT,
            BOOK_DETAIL,
            DRM,
            ADDED_DATE,
            ADDED_FROM,
            AUTHOR,
            CONTENT_ENCODING,
            FILE_SIZE,
            LAST_READING_POSITION,
            LAST_READING_DATE,
            READING_STATISTICS,
            CLOUD,
            ORDER_UUID,
            BOOK_UUID,
            BOOK_REVISION,
            BOOK_PRICE,
            TASK_PRIORITY,
            SERIAL_FETCHES,
            SERIAL_CHAPTERS,
            SERIAL_PRICES,
            SERIAL_DETAIL,
            BOOK_STATE,
            DOWNLOAD_INFO,
            FINISH_READING_DATE,
            BOOK_CONTENT,
            SERIAL_INVAILD,
            PACKAGE_TYPE,
            LIMIT_TYPE,
            TRANSFER_PROGRESS,
            SERIAL_INVALID,
            LAST_REVISION,
            SERIAL_MD5S,
            SERIAL_SHA1S,
            MICLOUD,
            SERIAL_UPDATES;

            public String toString() {
                return name().toLowerCase();
            }
        }

        public enum CommonColumn {
            _ID,
            PACKAGE_TYPE,
            LIMIT_TYPE,
            BOOK_FORMAT,
            BOOK_TYPE,
            BOOK_UUID,
            BOOK_URI,
            BOOK_NAME,
            BOOK_STATE,
            BOOK_CONTENT,
            BOOK_REVISION,
            LAST_REVISION,
            LAST_READING_POSITION,
            ONLINE_COVER_URI,
            MICLOUD,
            SERIAL_UPDATES,
            DRM;

            public String toString() {
                return name().toLowerCase();
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m8427a(C0285n c0285n) {
        synchronized (BookshelfHelper.class) {
            int d = c0285n.m679d();
            if (d < 15) {
                c0285n.m677b();
                if (d < 4) {
                    try {
                        WebLog.init().c(LogLevel.EVENT, "shelf", "begin creating the database...");
                        m8450x(c0285n);
                    } catch (Throwable th) {
                        WebLog.init().printStackTrace(LogLevel.DISASTER, "shelf", "a fatal exception occurs while creating or upgrading database!", th);
                    } finally {
                        c0285n.m678c();
                    }
                } else {
                    WebLog.init().a(LogLevel.EVENT, "shelf", "begin upgrading the database from v%d to v%d", Integer.valueOf(d), Integer.valueOf(15));
                    if (d < 5) {
                        m8428b(c0285n);
                        m8439m(c0285n);
                    }
                    if (d < 6) {
                        m8429c(c0285n);
                        m8440n(c0285n);
                    }
                    if (d < 7) {
                        m8430d(c0285n);
                        m8441o(c0285n);
                    }
                    if (d < 8) {
                        m8431e(c0285n);
                        m8442p(c0285n);
                    }
                    if (d < 9) {
                        m8432f(c0285n);
                        m8443q(c0285n);
                    }
                    if (d < 10) {
                        m8433g(c0285n);
                        m8444r(c0285n);
                    }
                    if (d < 11) {
                        m8434h(c0285n);
                        m8445s(c0285n);
                    }
                    if (d < 12) {
                        m8435i(c0285n);
                        m8446t(c0285n);
                    }
                    if (d < 13) {
                        m8436j(c0285n);
                        m8447u(c0285n);
                    }
                    if (d < 14) {
                        m8437k(c0285n);
                        m8448v(c0285n);
                    }
                    if (d < 15) {
                        m8438l(c0285n);
                        m8449w(c0285n);
                    }
                }
                c0285n.m672a(15);
                c0285n.m681f();
                c0285n.m678c();
            }
        }
    }

    /* renamed from: b */
    private static void m8428b(C0285n c0285n) {
        c0285n.m673a("ALTER TABLE books ADD COLUMN order_uuid TEXT");
        c0285n.m673a("ALTER TABLE books ADD COLUMN book_uuid TEXT");
        c0285n.m673a("ALTER TABLE books ADD COLUMN book_revision TEXT");
        c0285n.m673a("ALTER TABLE annotations ADD COLUMN annotation_uuid TEXT");
    }

    /* renamed from: c */
    private static void m8429c(C0285n c0285n) {
        c0285n.m673a("ALTER TABLE annotations ADD COLUMN modified_date LONG");
    }

    /* renamed from: d */
    private static void m8430d(C0285n c0285n) {
        c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s INTEGER", new Object[]{"books", Column.BOOK_PRICE}));
        c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s LONG", new Object[]{"books", Column.TASK_PRIORITY}));
        c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s BLOB", new Object[]{"books", Column.SERIAL_FETCHES}));
        c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s BLOB", new Object[]{"books", Column.SERIAL_CHAPTERS}));
        c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s BLOB", new Object[]{"books", Column.SERIAL_PRICES}));
        c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s TEXT", new Object[]{"books", Column.SERIAL_DETAIL}));
        c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s TEXT", new Object[]{"books", Column.BOOK_STATE}));
        c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s TEXT", new Object[]{"books", Column.DOWNLOAD_INFO}));
        c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s LONG", new Object[]{"books", Column.FINISH_READING_DATE}));
        c0285n.m673a(String.format("CREATE TABLE IF NOT EXISTS %s(%s INTEGER PRIMARY KEY,  %s TEXT,  %s BLOB,  %s TEXT);", new Object[]{"book_categories", "_id", "category_name", "category_items", "category_type"}));
    }

    /* renamed from: e */
    private static void m8431e(C0285n c0285n) {
        c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s TEXT", new Object[]{"books", Column.BOOK_CONTENT}));
    }

    /* renamed from: f */
    private static void m8432f(C0285n c0285n) {
        if (!c0285n.m676b("books").contains(Column.SERIAL_INVAILD.toString())) {
            c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s BLOB", new Object[]{"books", Column.SERIAL_INVAILD}));
        }
    }

    /* renamed from: g */
    private static void m8433g(C0285n c0285n) {
        List b = c0285n.m676b("books");
        if (!b.contains(Column.PACKAGE_TYPE.toString())) {
            c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s TEXT", new Object[]{"books", Column.PACKAGE_TYPE}));
        }
        if (!b.contains(Column.LIMIT_TYPE.toString())) {
            c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s TEXT", new Object[]{"books", Column.LIMIT_TYPE}));
        }
        if (!b.contains(Column.TRANSFER_PROGRESS.toString())) {
            c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s INTEGER", new Object[]{"books", Column.TRANSFER_PROGRESS}));
        }
    }

    /* renamed from: h */
    private static void m8434h(C0285n c0285n) {
        if (!c0285n.m676b("books").contains(Column.SERIAL_INVALID.toString())) {
            c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s BLOB", new Object[]{"books", Column.SERIAL_INVALID}));
        }
    }

    /* renamed from: i */
    private static void m8435i(C0285n c0285n) {
        if (!c0285n.m676b("books").contains(Column.LAST_REVISION.toString())) {
            c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s TEXT", new Object[]{"books", Column.LAST_REVISION}));
        }
    }

    /* renamed from: j */
    private static void m8436j(C0285n c0285n) {
        if (!c0285n.m676b("books").contains(Column.SERIAL_MD5S.toString())) {
            c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s BLOB", new Object[]{"books", Column.SERIAL_MD5S}));
        }
    }

    /* renamed from: k */
    private static void m8437k(C0285n c0285n) {
        if (!c0285n.m676b("books").contains(Column.SERIAL_SHA1S.toString())) {
            c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s BLOB", new Object[]{"books", Column.SERIAL_SHA1S}));
        }
    }

    /* renamed from: l */
    private static void m8438l(C0285n c0285n) {
        List b = c0285n.m676b("books");
        if (!b.contains(Column.MICLOUD.toString())) {
            c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s TEXT", new Object[]{"books", Column.MICLOUD}));
        }
        if (!b.contains(Column.SERIAL_UPDATES.toString())) {
            c0285n.m673a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s INTEGER", new Object[]{"books", Column.SERIAL_UPDATES}));
        }
    }

    /* renamed from: m */
    private static void m8439m(C0285n c0285n) {
        int i = 0;
        try {
            Cursor a = c0285n.m670a("SELECT _id FROM annotations", null);
            if (a != null && a.moveToFirst()) {
                long[] jArr = new long[a.getCount()];
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    jArr[i2] = a.getLong(0);
                    if (!a.moveToNext()) {
                        break;
                    }
                    i2 = i3;
                }
                a.close();
                while (i < jArr.length) {
                    c0285n.m674a("UPDATE annotations SET annotation_uuid = ? WHERE _id = ?", new String[]{UUID.randomUUID().toString(), Long.toString(jArr[i])});
                    i++;
                }
            }
        } catch (Throwable th) {
            WebLog.init().printStackTrace(LogLevel.ERROR, "shelf", "an exception occurs while upgrading data to v5.", th);
        }
    }

    /* renamed from: n */
    private static void m8440n(C0285n c0285n) {
        try {
            Cursor a = c0285n.m670a("SELECT _id,annotation_body FROM annotations WHERE length(annotation_body)>0;", null);
            if (a != null && a.moveToFirst()) {
                SparseArray sparseArray = new SparseArray();
                do {
                    sparseArray.put((int) a.getLong(0), a.getString(1));
                } while (a.moveToNext());
                a.close();
                for (int i = 0; i < sparseArray.size(); i++) {
                    int keyAt = sparseArray.keyAt(i);
                    c0285n.m674a("UPDATE annotations SET annotation_body = ? WHERE _id = ?", new String[]{ea.m4377g((String) sparseArray.get(keyAt)), Integer.toString(keyAt)});
                }
            }
        } catch (Throwable th) {
            WebLog.init().printStackTrace(LogLevel.ERROR, "shelf", "an exception occurs while upgrading data to v6.", th);
        }
    }

    /* renamed from: o */
    private static void m8441o(C0285n c0285n) {
        long j = 0;
        try {
            Cursor a = c0285n.m670a("SELECT MAX(_id) FROM books WHERE _id < ?", new String[]{"" + 2147483647L});
            if (a.moveToFirst() && !a.isNull(0)) {
                j = a.getLong(0);
            }
            a.close();
            a = c0285n.m670a("SELECT _id FROM books WHERE _id > ?", new String[]{"" + 2147483647L});
            ArrayList arrayList = new ArrayList(a.getCount());
            while (a.moveToNext()) {
                arrayList.add(Long.valueOf(a.getLong(0)));
            }
            a.close();
            for (int i = 0; i < arrayList.size(); i++) {
                long longValue = ((Long) arrayList.get(i)).longValue();
                j++;
                c0285n.m674a("UPDATE books SET _id = ? WHERE _id = ?", new String[]{"" + j, "" + longValue});
                c0285n.m674a("UPDATE annotations SET book_id = ? WHERE book_id = ?", new String[]{"" + j, "" + longValue});
                c0285n.m674a("UPDATE book_tag_map SET book_id = ? WHERE book_id = ?", new String[]{"" + j, "" + longValue});
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", Long.toString(-9));
            contentValues.put("category_name", "");
            contentValues.put("category_items", "");
            contentValues.put("category_type", BookCategoryType.PREDEFINED.toString());
            c0285n.m668a("book_categories", null, contentValues);
            m8451y(c0285n);
        } catch (Throwable th) {
            WebLog.init().printStackTrace(LogLevel.ERROR, "shelf", "an exception occurs while upgrading data to v7.", th);
        }
    }

    /* renamed from: p */
    private static void m8442p(C0285n c0285n) {
    }

    /* renamed from: q */
    private static void m8443q(C0285n c0285n) {
    }

    /* renamed from: r */
    private static void m8444r(C0285n c0285n) {
    }

    /* renamed from: s */
    private static void m8445s(C0285n c0285n) {
        try {
            if (c0285n.m676b("books").contains(Column.SERIAL_INVAILD.toString())) {
                c0285n.m673a(String.format("UPDATE OR IGNORE %s SET %s=%s", new Object[]{"books", Column.SERIAL_INVALID, Column.SERIAL_INVAILD}));
            }
        } catch (Throwable th) {
            WebLog.init().printStackTrace(LogLevel.ERROR, "shelf", "an exception occurs while upgrading data to v11.", th);
        }
    }

    /* renamed from: t */
    private static void m8446t(C0285n c0285n) {
    }

    /* renamed from: u */
    private static void m8447u(C0285n c0285n) {
    }

    /* renamed from: v */
    private static void m8448v(C0285n c0285n) {
    }

    /* renamed from: w */
    private static void m8449w(C0285n c0285n) {
        Cursor a;
        CharSequence charSequence;
        Cursor a2;
        try {
            a = c0285n.m670a("SELECT _id,book_content FROM books", null);
            while (a.moveToNext()) {
                CharSequence c;
                c = C0293u.m695c(a, 1);
                charSequence = TextUtils.equals(c, "COMICS") ? "FRAME_COMIC" : TextUtils.equals(c, "AUDIOBOOK") ? "AUDIO_TEXT" : TextUtils.equals(c, "CANVAS_COMIC") ? "PAGE_COMIC" : c;
                if (c != charSequence) {
                    c0285n.m674a("UPDATE books SET book_content = ? WHERE _id = ?", new String[]{charSequence, Long.toString(a.getLong(0))});
                }
            }
        } catch (Throwable th) {
            WebLog.init().printStackTrace(LogLevel.ERROR, "shelf", "an exception occurs while upgrading data to v15.", th);
        }
        try {
            a = c0285n.m670a("SELECT _id,book_state FROM books", null);
            while (a.moveToNext()) {
                c = C0293u.m695c(a, 1);
                charSequence = TextUtils.equals(c, "UPGRADING") ? "UPDATING" : TextUtils.equals(c, "CLOUDONLY") ? "CLOUD_ONLY" : c;
                if (c != charSequence) {
                    c0285n.m674a("UPDATE books SET book_state = ? WHERE _id = ?", new String[]{charSequence, Long.toString(a.getLong(0))});
                }
            }
        } catch (Throwable th2) {
            WebLog.init().printStackTrace(LogLevel.ERROR, "shelf", "an exception occurs while upgrading data to v15.", th2);
        }
        try {
            a2 = c0285n.m670a("SELECT _id,book_detail FROM books", null);
            while (a2.moveToNext()) {
                String c2 = C0293u.m695c(a2, 1);
                if (c2.contains("mi_cloud_item_info")) {
                    if (!TextUtils.isEmpty(new JSONObject(c2).getJSONObject("mi_cloud_item_info").toString())) {
                        c0285n.m674a("UPDATE books SET micloud = ? WHERE _id = ?", new String[]{new JSONObject(c2).getJSONObject("mi_cloud_item_info").toString(), Long.toString(a2.getLong(0))});
                    }
                }
            }
        } catch (Throwable th22) {
            WebLog.init().printStackTrace(LogLevel.ERROR, "shelf", "an exception occurs while upgrading data to v15.", th22);
        }
        try {
            a2 = c0285n.m670a("SELECT _id,serial_detail FROM books", null);
            while (a2.moveToNext()) {
                Object c3 = C0293u.m695c(a2, 1);
                if (!TextUtils.isEmpty(c3)) {
                    if (new JSONObject(c3).optInt("new_updates", 0) > 0) {
                        c0285n.m674a("UPDATE books SET serial_updates = ? WHERE _id = ?", new String[]{"" + new JSONObject(c3).optInt("new_updates", 0), Long.toString(a2.getLong(0))});
                    }
                }
            }
        } catch (Throwable th222) {
            WebLog.init().printStackTrace(LogLevel.ERROR, "shelf", "an exception occurs while upgrading data to v15.", th222);
        }
    }

    /* renamed from: x */
    private static void m8450x(C0285n c0285n) {
        c0285n.m673a(String.format("CREATE TABLE IF NOT EXISTS %1$s(%2$s INTEGER PRIMARY KEY,  %3$s TEXT UNIQUE,  %4$s TEXT,  %5$s TEXT,  %6$s TEXT,  %7$s TEXT,  %8$s TEXT,  %9$s TEXT,  %10$s LONG,  %11$s TEXT,  %12$s TEXT,  %13$s TEXT,  %14$s LONG,  %15$s TEXT,  %16$s LONG,  %17$s TEXT,  %18$s TEXT,  %19$s TEXT,  %20$s TEXT,  %21$s TEXT,  %22$s INTEGER,  %23$s LONG,  %24$s BLOB,  %25$s BLOB,  %26$s BLOB,  %27$s TEXT,  %28$s TEXT,  %29$s TEXT,  %30$s LONG,  %31$s TEXT,  %32$s BLOB,  %33$s TEXT,  %34$s TEXT,  %35$s INTEGER,  %36$s TEXT,  %37$s BLOB,  %38$s BLOB,  %39$s TEXT,  %40$s INTEGER);", new Object[]{"books", Column._ID, Column.BOOK_URI, Column.ONLINE_COVER_URI, Column.BOOK_NAME, Column.BOOK_TYPE, Column.BOOK_FORMAT, Column.BOOK_DETAIL, Column.DRM, Column.ADDED_DATE, Column.ADDED_FROM, Column.AUTHOR, Column.CONTENT_ENCODING, Column.FILE_SIZE, Column.LAST_READING_POSITION, Column.LAST_READING_DATE, Column.READING_STATISTICS, Column.CLOUD, Column.ORDER_UUID, Column.BOOK_UUID, Column.BOOK_REVISION, Column.BOOK_PRICE, Column.TASK_PRIORITY, Column.SERIAL_FETCHES, Column.SERIAL_CHAPTERS, Column.SERIAL_PRICES, Column.SERIAL_DETAIL, Column.BOOK_STATE, Column.DOWNLOAD_INFO, Column.FINISH_READING_DATE, Column.BOOK_CONTENT, Column.SERIAL_INVALID, Column.PACKAGE_TYPE, Column.LIMIT_TYPE, Column.TRANSFER_PROGRESS, Column.LAST_REVISION, Column.SERIAL_MD5S, Column.SERIAL_SHA1S, Column.MICLOUD, Column.SERIAL_UPDATES}));
        c0285n.m673a(String.format("CREATE TABLE IF NOT EXISTS annotations(%s INTEGER PRIMARY KEY,  %s INTEGER,  %s INTEGER,  %s TEXT,  %s TEXT,  %s TEXT,  %s TEXT,  %s TEXT,  %s INTEGER);", new Object[]{"_id", "book_id", "added_date", "annotation_type", "annotation_range", "annotation_body", "annotation_sample", "annotation_uuid", "modified_date"}));
        c0285n.m673a(String.format("CREATE TABLE IF NOT EXISTS book_tags(%s INTEGER PRIMARY KEY,  %s TEXT UNIQUE,  %s TEXT);", new Object[]{"_id", "tag_name", "tag_type"}));
        c0285n.m673a("REPLACE INTO book_tags(_id,tag_name,tag_type) values(8,\"我的下载\",\"PREDEFINED\");");
        c0285n.m673a("REPLACE INTO book_tags(_id,tag_name,tag_type) values(9,\"未分类\",\"PREDEFINED\");");
        c0285n.m673a(String.format("CREATE TABLE IF NOT EXISTS book_tag_map(%s INTEGER PRIMARY KEY,  %s INTEGER,  %s INTEGER);", new Object[]{"_id", "book_id", "tag_id"}));
        c0285n.m673a(String.format("CREATE TABLE IF NOT EXISTS %s(%s INTEGER PRIMARY KEY,  %s TEXT,  %s BLOB,  %s TEXT);", new Object[]{"book_categories", "_id", "category_name", "category_items", "category_type"}));
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.toString(-9));
        contentValues.put("category_name", "");
        contentValues.put("category_items", "");
        contentValues.put("category_type", BookCategoryType.PREDEFINED.toString());
        c0285n.m668a("book_categories", null, contentValues);
    }

    /* renamed from: y */
    private static void m8451y(C0285n c0285n) {
        List arrayList = new ArrayList();
        Cursor a = c0285n.m670a("SELECT * FROM books", null);
        if (a != null) {
            int i;
            C1130a c1130a;
            int columnIndex = a.getColumnIndex("_id");
            if (a.moveToFirst()) {
                do {
                    arrayList.add(Long.valueOf(a.getLong(columnIndex)));
                } while (a.moveToNext());
            }
            a.close();
            C1130a c1130a2 = new C1130a();
            c1130a2.f5443a = -9;
            c1130a2.f5445c = new ArrayList();
            c1130a2.f5444b = "";
            List arrayList2 = new ArrayList();
            for (columnIndex = 0; columnIndex < arrayList.size(); columnIndex++) {
                Cursor a2 = c0285n.m670a("SELECT book_tag_map.book_id,book_tag_map.tag_id, book_tags.tag_name from book_tag_map INNER JOIN book_tags on book_tag_map.tag_id = book_tags._id and tag_type = 'CUSTOM' and book_tag_map.book_id = '" + arrayList.get(columnIndex) + "'", null);
                if (a2 != null) {
                    if (a2.moveToFirst()) {
                        Object obj;
                        long j = a2.getLong(a2.getColumnIndex("tag_id"));
                        for (i = 0; i < arrayList2.size(); i++) {
                            if (j == ((C1130a) arrayList2.get(i)).f5443a) {
                                ((C1130a) arrayList2.get(i)).f5445c.add(arrayList.get(columnIndex));
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            c1130a = new C1130a();
                            c1130a.f5443a = j;
                            c1130a.f5444b = a2.getString(a2.getColumnIndex("tag_name"));
                            c1130a.f5445c = new ArrayList();
                            c1130a.f5445c.add(arrayList.get(columnIndex));
                            arrayList2.add(c1130a);
                            c1130a2.f5445c.add(Long.valueOf(-1));
                        }
                    } else {
                        c1130a2.f5445c.add(arrayList.get(columnIndex));
                    }
                    a2.close();
                } else {
                    c1130a2.f5445c.add(arrayList.get(columnIndex));
                }
            }
            for (i = 0; i < arrayList2.size(); i++) {
                c1130a = (C1130a) arrayList2.get(i);
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", Long.toString(c1130a2.f5443a - ((long) (i + 1))));
                contentValues.put("category_name", c1130a.f5444b);
                contentValues.put("category_type", BookCategoryType.CUSTOM.toString());
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                Object obj2 = new int[c1130a.f5445c.size()];
                for (int i2 = 0; i2 < obj2.length; i2++) {
                    obj2[i2] = (int) ((Long) c1130a.f5445c.get(i2)).longValue();
                }
                objectOutputStream.writeObject(obj2);
                contentValues.put("category_items", byteArrayOutputStream.toByteArray());
                c0285n.m668a("book_categories", null, contentValues);
                for (columnIndex = 0; columnIndex < c1130a2.f5445c.size(); columnIndex++) {
                    if (((Long) c1130a2.f5445c.get(columnIndex)).longValue() == -1) {
                        c1130a2.f5445c.set(columnIndex, Long.valueOf(c1130a2.f5443a - ((long) (i + 1))));
                        break;
                    }
                }
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("_id", Long.toString(c1130a2.f5443a));
            contentValues2.put("category_name", c1130a2.f5444b);
            contentValues2.put("category_type", BookCategoryType.PREDEFINED.toString());
            OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream2);
            Object obj3 = new int[c1130a2.f5445c.size()];
            for (columnIndex = 0; columnIndex < obj3.length; columnIndex++) {
                obj3[columnIndex] = (int) ((Long) c1130a2.f5445c.get(columnIndex)).longValue();
            }
            objectOutputStream2.writeObject(obj3);
            contentValues2.put("category_items", byteArrayOutputStream2.toByteArray());
            c0285n.m666a("book_categories", contentValues2, "_id = ?", new String[]{"" + c1130a2.f5443a});
        }
    }
}
