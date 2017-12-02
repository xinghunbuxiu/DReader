package com.duokan.reader.domain.provider;

public class BookshelfHelper {
    public static final String a = BookshelfHelper.class.getName();

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

    public static synchronized void a(n nVar) {
        synchronized (BookshelfHelper.class) {
            int d = nVar.d();
            if (d < 15) {
                nVar.b();
                if (d < 4) {
                    try {
                        a.c().c(LogLevel.EVENT, "shelf", "begin creating the database...");
                        x(nVar);
                    } catch (Throwable th) {
                        a.c().a(LogLevel.DISASTER, "shelf", "a fatal exception occurs while creating or upgrading database!", th);
                    } finally {
                        nVar.c();
                    }
                } else {
                    a.c().a(LogLevel.EVENT, "shelf", "begin upgrading the database from v%d to v%d", Integer.valueOf(d), Integer.valueOf(15));
                    if (d < 5) {
                        b(nVar);
                        m(nVar);
                    }
                    if (d < 6) {
                        c(nVar);
                        n(nVar);
                    }
                    if (d < 7) {
                        d(nVar);
                        o(nVar);
                    }
                    if (d < 8) {
                        e(nVar);
                        p(nVar);
                    }
                    if (d < 9) {
                        f(nVar);
                        q(nVar);
                    }
                    if (d < 10) {
                        g(nVar);
                        r(nVar);
                    }
                    if (d < 11) {
                        h(nVar);
                        s(nVar);
                    }
                    if (d < 12) {
                        i(nVar);
                        t(nVar);
                    }
                    if (d < 13) {
                        j(nVar);
                        u(nVar);
                    }
                    if (d < 14) {
                        k(nVar);
                        v(nVar);
                    }
                    if (d < 15) {
                        l(nVar);
                        w(nVar);
                    }
                }
                nVar.a(15);
                nVar.f();
                nVar.c();
            }
        }
    }

    private static void b(n nVar) {
        nVar.a("ALTER TABLE books ADD COLUMN order_uuid TEXT");
        nVar.a("ALTER TABLE books ADD COLUMN book_uuid TEXT");
        nVar.a("ALTER TABLE books ADD COLUMN book_revision TEXT");
        nVar.a("ALTER TABLE annotations ADD COLUMN annotation_uuid TEXT");
    }

    private static void c(n nVar) {
        nVar.a("ALTER TABLE annotations ADD COLUMN modified_date LONG");
    }

    private static void d(n nVar) {
        nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s INTEGER", new Object[]{"books", Column.BOOK_PRICE}));
        nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s LONG", new Object[]{"books", Column.TASK_PRIORITY}));
        nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s BLOB", new Object[]{"books", Column.SERIAL_FETCHES}));
        nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s BLOB", new Object[]{"books", Column.SERIAL_CHAPTERS}));
        nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s BLOB", new Object[]{"books", Column.SERIAL_PRICES}));
        nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s TEXT", new Object[]{"books", Column.SERIAL_DETAIL}));
        nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s TEXT", new Object[]{"books", Column.BOOK_STATE}));
        nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s TEXT", new Object[]{"books", Column.DOWNLOAD_INFO}));
        nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s LONG", new Object[]{"books", Column.FINISH_READING_DATE}));
        nVar.a(String.format("CREATE TABLE IF NOT EXISTS %s(%s INTEGER PRIMARY KEY,  %s TEXT,  %s BLOB,  %s TEXT);", new Object[]{"book_categories", "_id", "category_name", "category_items", "category_type"}));
    }

    private static void e(n nVar) {
        nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s TEXT", new Object[]{"books", Column.BOOK_CONTENT}));
    }

    private static void f(n nVar) {
        if (!nVar.b("books").contains(Column.SERIAL_INVAILD.toString())) {
            nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s BLOB", new Object[]{"books", Column.SERIAL_INVAILD}));
        }
    }

    private static void g(n nVar) {
        List b = nVar.b("books");
        if (!b.contains(Column.PACKAGE_TYPE.toString())) {
            nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s TEXT", new Object[]{"books", Column.PACKAGE_TYPE}));
        }
        if (!b.contains(Column.LIMIT_TYPE.toString())) {
            nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s TEXT", new Object[]{"books", Column.LIMIT_TYPE}));
        }
        if (!b.contains(Column.TRANSFER_PROGRESS.toString())) {
            nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s INTEGER", new Object[]{"books", Column.TRANSFER_PROGRESS}));
        }
    }

    private static void h(n nVar) {
        if (!nVar.b("books").contains(Column.SERIAL_INVALID.toString())) {
            nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s BLOB", new Object[]{"books", Column.SERIAL_INVALID}));
        }
    }

    private static void i(n nVar) {
        if (!nVar.b("books").contains(Column.LAST_REVISION.toString())) {
            nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s TEXT", new Object[]{"books", Column.LAST_REVISION}));
        }
    }

    private static void j(n nVar) {
        if (!nVar.b("books").contains(Column.SERIAL_MD5S.toString())) {
            nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s BLOB", new Object[]{"books", Column.SERIAL_MD5S}));
        }
    }

    private static void k(n nVar) {
        if (!nVar.b("books").contains(Column.SERIAL_SHA1S.toString())) {
            nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s BLOB", new Object[]{"books", Column.SERIAL_SHA1S}));
        }
    }

    private static void l(n nVar) {
        List b = nVar.b("books");
        if (!b.contains(Column.MICLOUD.toString())) {
            nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s TEXT", new Object[]{"books", Column.MICLOUD}));
        }
        if (!b.contains(Column.SERIAL_UPDATES.toString())) {
            nVar.a(String.format("ALTER TABLE %1$s ADD COLUMN %2$s INTEGER", new Object[]{"books", Column.SERIAL_UPDATES}));
        }
    }

    private static void m(n nVar) {
        int i = 0;
        try {
            Cursor a = nVar.a("SELECT _id FROM annotations", null);
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
                    nVar.a("UPDATE annotations SET annotation_uuid = ? WHERE _id = ?", new String[]{UUID.randomUUID().toString(), Long.toString(jArr[i])});
                    i++;
                }
            }
        } catch (Throwable th) {
            a.c().a(LogLevel.ERROR, "shelf", "an exception occurs while upgrading data to v5.", th);
        }
    }

    private static void n(n nVar) {
        try {
            Cursor a = nVar.a("SELECT _id,annotation_body FROM annotations WHERE length(annotation_body)>0;", null);
            if (a != null && a.moveToFirst()) {
                SparseArray sparseArray = new SparseArray();
                do {
                    sparseArray.put((int) a.getLong(0), a.getString(1));
                } while (a.moveToNext());
                a.close();
                for (int i = 0; i < sparseArray.size(); i++) {
                    int keyAt = sparseArray.keyAt(i);
                    nVar.a("UPDATE annotations SET annotation_body = ? WHERE _id = ?", new String[]{ef.g((String) sparseArray.get(keyAt)), Integer.toString(keyAt)});
                }
            }
        } catch (Throwable th) {
            a.c().a(LogLevel.ERROR, "shelf", "an exception occurs while upgrading data to v6.", th);
        }
    }

    private static void o(n nVar) {
        long j = 0;
        try {
            Cursor a = nVar.a("SELECT MAX(_id) FROM books WHERE _id < ?", new String[]{"" + 2147483647L});
            if (a.moveToFirst() && !a.isNull(0)) {
                j = a.getLong(0);
            }
            a.close();
            a = nVar.a("SELECT _id FROM books WHERE _id > ?", new String[]{"" + 2147483647L});
            ArrayList arrayList = new ArrayList(a.getCount());
            while (a.moveToNext()) {
                arrayList.add(Long.valueOf(a.getLong(0)));
            }
            a.close();
            for (int i = 0; i < arrayList.size(); i++) {
                long longValue = ((Long) arrayList.get(i)).longValue();
                j++;
                nVar.a("UPDATE books SET _id = ? WHERE _id = ?", new String[]{"" + j, "" + longValue});
                nVar.a("UPDATE annotations SET book_id = ? WHERE book_id = ?", new String[]{"" + j, "" + longValue});
                nVar.a("UPDATE book_tag_map SET book_id = ? WHERE book_id = ?", new String[]{"" + j, "" + longValue});
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", Long.toString(-9));
            contentValues.put("category_name", "");
            contentValues.put("category_items", "");
            contentValues.put("category_type", BookCategoryType.PREDEFINED.toString());
            nVar.a("book_categories", null, contentValues);
            y(nVar);
        } catch (Throwable th) {
            a.c().a(LogLevel.ERROR, "shelf", "an exception occurs while upgrading data to v7.", th);
        }
    }

    private static void p(n nVar) {
    }

    private static void q(n nVar) {
    }

    private static void r(n nVar) {
    }

    private static void s(n nVar) {
        try {
            if (nVar.b("books").contains(Column.SERIAL_INVAILD.toString())) {
                nVar.a(String.format("UPDATE OR IGNORE %s SET %s=%s", new Object[]{"books", Column.SERIAL_INVALID, Column.SERIAL_INVAILD}));
            }
        } catch (Throwable th) {
            a.c().a(LogLevel.ERROR, "shelf", "an exception occurs while upgrading data to v11.", th);
        }
    }

    private static void t(n nVar) {
    }

    private static void u(n nVar) {
    }

    private static void v(n nVar) {
    }

    private static void w(n nVar) {
        Cursor a;
        CharSequence c;
        CharSequence charSequence;
        Cursor a2;
        try {
            a = nVar.a("SELECT _id,book_content FROM books", null);
            while (a.moveToNext()) {
                c = u.c(a, 1);
                charSequence = TextUtils.equals(c, "COMICS") ? "FRAME_COMIC" : TextUtils.equals(c, "AUDIOBOOK") ? "AUDIO_TEXT" : TextUtils.equals(c, "CANVAS_COMIC") ? "PAGE_COMIC" : c;
                if (c != charSequence) {
                    nVar.a("UPDATE books SET book_content = ? WHERE _id = ?", new String[]{charSequence, Long.toString(a.getLong(0))});
                }
            }
        } catch (Throwable th) {
            a.c().a(LogLevel.ERROR, "shelf", "an exception occurs while upgrading data to v15.", th);
        }
        try {
            a = nVar.a("SELECT _id,book_state FROM books", null);
            while (a.moveToNext()) {
                c = u.c(a, 1);
                charSequence = TextUtils.equals(c, "UPGRADING") ? "UPDATING" : TextUtils.equals(c, "CLOUDONLY") ? "CLOUD_ONLY" : c;
                if (c != charSequence) {
                    nVar.a("UPDATE books SET book_state = ? WHERE _id = ?", new String[]{charSequence, Long.toString(a.getLong(0))});
                }
            }
        } catch (Throwable th2) {
            a.c().a(LogLevel.ERROR, "shelf", "an exception occurs while upgrading data to v15.", th2);
        }
        try {
            a2 = nVar.a("SELECT _id,book_detail FROM books", null);
            while (a2.moveToNext()) {
                String c2 = u.c(a2, 1);
                if (c2.contains("mi_cloud_item_info")) {
                    if (!TextUtils.isEmpty(new JSONObject(c2).getJSONObject("mi_cloud_item_info").toString())) {
                        nVar.a("UPDATE books SET micloud = ? WHERE _id = ?", new String[]{new JSONObject(c2).getJSONObject("mi_cloud_item_info").toString(), Long.toString(a2.getLong(0))});
                    }
                }
            }
        } catch (Throwable th22) {
            a.c().a(LogLevel.ERROR, "shelf", "an exception occurs while upgrading data to v15.", th22);
        }
        try {
            a2 = nVar.a("SELECT _id,serial_detail FROM books", null);
            while (a2.moveToNext()) {
                Object c3 = u.c(a2, 1);
                if (!TextUtils.isEmpty(c3)) {
                    if (new JSONObject(c3).optInt("new_updates", 0) > 0) {
                        nVar.a("UPDATE books SET serial_updates = ? WHERE _id = ?", new String[]{"" + new JSONObject(c3).optInt("new_updates", 0), Long.toString(a2.getLong(0))});
                    }
                }
            }
        } catch (Throwable th222) {
            a.c().a(LogLevel.ERROR, "shelf", "an exception occurs while upgrading data to v15.", th222);
        }
    }

    private static void x(n nVar) {
        nVar.a(String.format("CREATE TABLE IF NOT EXISTS %1$s(%2$s INTEGER PRIMARY KEY,  %3$s TEXT UNIQUE,  %4$s TEXT,  %5$s TEXT,  %6$s TEXT,  %7$s TEXT,  %8$s TEXT,  %9$s TEXT,  %10$s LONG,  %11$s TEXT,  %12$s TEXT,  %13$s TEXT,  %14$s LONG,  %15$s TEXT,  %16$s LONG,  %17$s TEXT,  %18$s TEXT,  %19$s TEXT,  %20$s TEXT,  %21$s TEXT,  %22$s INTEGER,  %23$s LONG,  %24$s BLOB,  %25$s BLOB,  %26$s BLOB,  %27$s TEXT,  %28$s TEXT,  %29$s TEXT,  %30$s LONG,  %31$s TEXT,  %32$s BLOB,  %33$s TEXT,  %34$s TEXT,  %35$s INTEGER,  %36$s TEXT,  %37$s BLOB,  %38$s BLOB,  %39$s TEXT,  %40$s INTEGER);", new Object[]{"books", Column._ID, Column.BOOK_URI, Column.ONLINE_COVER_URI, Column.BOOK_NAME, Column.BOOK_TYPE, Column.BOOK_FORMAT, Column.BOOK_DETAIL, Column.DRM, Column.ADDED_DATE, Column.ADDED_FROM, Column.AUTHOR, Column.CONTENT_ENCODING, Column.FILE_SIZE, Column.LAST_READING_POSITION, Column.LAST_READING_DATE, Column.READING_STATISTICS, Column.CLOUD, Column.ORDER_UUID, Column.BOOK_UUID, Column.BOOK_REVISION, Column.BOOK_PRICE, Column.TASK_PRIORITY, Column.SERIAL_FETCHES, Column.SERIAL_CHAPTERS, Column.SERIAL_PRICES, Column.SERIAL_DETAIL, Column.BOOK_STATE, Column.DOWNLOAD_INFO, Column.FINISH_READING_DATE, Column.BOOK_CONTENT, Column.SERIAL_INVALID, Column.PACKAGE_TYPE, Column.LIMIT_TYPE, Column.TRANSFER_PROGRESS, Column.LAST_REVISION, Column.SERIAL_MD5S, Column.SERIAL_SHA1S, Column.MICLOUD, Column.SERIAL_UPDATES}));
        nVar.a(String.format("CREATE TABLE IF NOT EXISTS annotations(%s INTEGER PRIMARY KEY,  %s INTEGER,  %s INTEGER,  %s TEXT,  %s TEXT,  %s TEXT,  %s TEXT,  %s TEXT,  %s INTEGER);", new Object[]{"_id", "book_id", "added_date", "annotation_type", "annotation_range", "annotation_body", "annotation_sample", "annotation_uuid", "modified_date"}));
        nVar.a(String.format("CREATE TABLE IF NOT EXISTS book_tags(%s INTEGER PRIMARY KEY,  %s TEXT UNIQUE,  %s TEXT);", new Object[]{"_id", "tag_name", "tag_type"}));
        nVar.a("REPLACE INTO book_tags(_id,tag_name,tag_type) values(8,\"我的下载\",\"PREDEFINED\");");
        nVar.a("REPLACE INTO book_tags(_id,tag_name,tag_type) values(9,\"未分类\",\"PREDEFINED\");");
        nVar.a(String.format("CREATE TABLE IF NOT EXISTS book_tag_map(%s INTEGER PRIMARY KEY,  %s INTEGER,  %s INTEGER);", new Object[]{"_id", "book_id", "tag_id"}));
        nVar.a(String.format("CREATE TABLE IF NOT EXISTS %s(%s INTEGER PRIMARY KEY,  %s TEXT,  %s BLOB,  %s TEXT);", new Object[]{"book_categories", "_id", "category_name", "category_items", "category_type"}));
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.toString(-9));
        contentValues.put("category_name", "");
        contentValues.put("category_items", "");
        contentValues.put("category_type", BookCategoryType.PREDEFINED.toString());
        nVar.a("book_categories", null, contentValues);
    }

    private static void y(n nVar) {
        List arrayList = new ArrayList();
        Cursor a = nVar.a("SELECT * FROM books", null);
        if (a != null) {
            int i;
            a aVar;
            int columnIndex = a.getColumnIndex("_id");
            if (a.moveToFirst()) {
                do {
                    arrayList.add(Long.valueOf(a.getLong(columnIndex)));
                } while (a.moveToNext());
            }
            a.close();
            a aVar2 = new a();
            aVar2.a = -9;
            aVar2.c = new ArrayList();
            aVar2.b = "";
            List arrayList2 = new ArrayList();
            for (columnIndex = 0; columnIndex < arrayList.size(); columnIndex++) {
                Cursor a2 = nVar.a("SELECT book_tag_map.book_id,book_tag_map.tag_id, book_tags.tag_name from book_tag_map INNER JOIN book_tags on book_tag_map.tag_id = book_tags._id and tag_type = 'CUSTOM' and book_tag_map.book_id = '" + arrayList.get(columnIndex) + "'", null);
                if (a2 != null) {
                    if (a2.moveToFirst()) {
                        Object obj;
                        long j = a2.getLong(a2.getColumnIndex("tag_id"));
                        for (i = 0; i < arrayList2.size(); i++) {
                            if (j == ((a) arrayList2.get(i)).a) {
                                ((a) arrayList2.get(i)).c.add(arrayList.get(columnIndex));
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            aVar = new a();
                            aVar.a = j;
                            aVar.b = a2.getString(a2.getColumnIndex("tag_name"));
                            aVar.c = new ArrayList();
                            aVar.c.add(arrayList.get(columnIndex));
                            arrayList2.add(aVar);
                            aVar2.c.add(Long.valueOf(-1));
                        }
                    } else {
                        aVar2.c.add(arrayList.get(columnIndex));
                    }
                    a2.close();
                } else {
                    aVar2.c.add(arrayList.get(columnIndex));
                }
            }
            for (i = 0; i < arrayList2.size(); i++) {
                aVar = (a) arrayList2.get(i);
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", Long.toString(aVar2.a - ((long) (i + 1))));
                contentValues.put("category_name", aVar.b);
                contentValues.put("category_type", BookCategoryType.CUSTOM.toString());
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                Object obj2 = new int[aVar.c.size()];
                for (int i2 = 0; i2 < obj2.length; i2++) {
                    obj2[i2] = (int) ((Long) aVar.c.get(i2)).longValue();
                }
                objectOutputStream.writeObject(obj2);
                contentValues.put("category_items", byteArrayOutputStream.toByteArray());
                nVar.a("book_categories", null, contentValues);
                for (columnIndex = 0; columnIndex < aVar2.c.size(); columnIndex++) {
                    if (((Long) aVar2.c.get(columnIndex)).longValue() == -1) {
                        aVar2.c.set(columnIndex, Long.valueOf(aVar2.a - ((long) (i + 1))));
                        break;
                    }
                }
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("_id", Long.toString(aVar2.a));
            contentValues2.put("category_name", aVar2.b);
            contentValues2.put("category_type", BookCategoryType.PREDEFINED.toString());
            OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream2);
            Object obj3 = new int[aVar2.c.size()];
            for (columnIndex = 0; columnIndex < obj3.length; columnIndex++) {
                obj3[columnIndex] = (int) ((Long) aVar2.c.get(columnIndex)).longValue();
            }
            objectOutputStream2.writeObject(obj3);
            contentValues2.put("category_items", byteArrayOutputStream2.toByteArray());
            nVar.a("book_categories", contentValues2, "_id = ?", new String[]{"" + aVar2.a});
        }
    }
}
