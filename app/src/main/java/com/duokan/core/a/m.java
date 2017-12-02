package com.duokan.core.a;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

public class m implements Cursor {
    static final /* synthetic */ boolean a = (!m.class.desiredAssertionStatus());
    private final t b;
    private final Cursor c;

    protected m(t tVar, Cursor cursor) {
        if (!a && tVar == null) {
            throw new AssertionError();
        } else if (a || cursor != null) {
            this.b = tVar;
            this.c = cursor;
            this.b.b();
        } else {
            throw new AssertionError();
        }
    }

    public void close() {
        if (!isClosed()) {
            this.c.close();
            this.b.c();
        }
    }

    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        this.c.copyStringToBuffer(i, charArrayBuffer);
    }

    public void deactivate() {
        this.c.deactivate();
    }

    public byte[] getBlob(int i) {
        return this.c.getBlob(i);
    }

    public int getColumnCount() {
        return this.c.getColumnCount();
    }

    public int getColumnIndex(String str) {
        return this.c.getColumnIndex(str);
    }

    public int getColumnIndexOrThrow(String str) {
        return this.c.getColumnIndexOrThrow(str);
    }

    public String getColumnName(int i) {
        return this.c.getColumnName(i);
    }

    public String[] getColumnNames() {
        return this.c.getColumnNames();
    }

    public int getCount() {
        return this.c.getCount();
    }

    public double getDouble(int i) {
        return this.c.getDouble(i);
    }

    public Bundle getExtras() {
        return this.c.getExtras();
    }

    public float getFloat(int i) {
        return this.c.getFloat(i);
    }

    public int getInt(int i) {
        return this.c.getInt(i);
    }

    public long getLong(int i) {
        return this.c.getLong(i);
    }

    public int getPosition() {
        return this.c.getPosition();
    }

    public short getShort(int i) {
        return this.c.getShort(i);
    }

    public String getString(int i) {
        return this.c.getString(i);
    }

    @TargetApi(11)
    public int getType(int i) {
        return this.c.getType(i);
    }

    public boolean getWantsAllOnMoveCalls() {
        return this.c.getWantsAllOnMoveCalls();
    }

    @TargetApi(19)
    public Uri getNotificationUri() {
        return this.c.getNotificationUri();
    }

    public boolean isAfterLast() {
        return this.c.isAfterLast();
    }

    public boolean isBeforeFirst() {
        return this.c.isBeforeFirst();
    }

    public boolean isClosed() {
        return this.c.isClosed();
    }

    public boolean isFirst() {
        return this.c.isFirst();
    }

    public boolean isLast() {
        return this.c.isLast();
    }

    public boolean isNull(int i) {
        return this.c.isNull(i);
    }

    public boolean move(int i) {
        return this.c.move(i);
    }

    public boolean moveToFirst() {
        return this.c.moveToFirst();
    }

    public boolean moveToLast() {
        return this.c.moveToLast();
    }

    public boolean moveToNext() {
        return this.c.moveToNext();
    }

    public boolean moveToPosition(int i) {
        return this.c.moveToPosition(i);
    }

    public boolean moveToPrevious() {
        return this.c.moveToPrevious();
    }

    public void registerContentObserver(ContentObserver contentObserver) {
        this.c.registerContentObserver(contentObserver);
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.c.registerDataSetObserver(dataSetObserver);
    }

    public boolean requery() {
        return false;
    }

    public Bundle respond(Bundle bundle) {
        return this.c.respond(bundle);
    }

    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        this.c.setNotificationUri(contentResolver, uri);
    }

    public void unregisterContentObserver(ContentObserver contentObserver) {
        this.c.unregisterContentObserver(contentObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.c.unregisterDataSetObserver(dataSetObserver);
    }

    public void finalize() {
        close();
    }
}
