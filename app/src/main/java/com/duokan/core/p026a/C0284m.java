package com.duokan.core.p026a;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;


public class C0284m implements Cursor {
    
    static final  boolean f473a = (!C0284m.class.desiredAssertionStatus());
    
    private final C0288t f474b;
    
    private final Cursor f475c;

    protected C0284m(C0288t c0288t, Cursor cursor) {
        if (!f473a && c0288t == null) {
            throw new AssertionError();
        } else if (f473a || cursor != null) {
            this.f474b = c0288t;
            this.f475c = cursor;
            this.f474b.mo382b();
        } else {
            throw new AssertionError();
        }
    }

    public void close() {
        if (!isClosed()) {
            this.f475c.close();
            this.f474b.mo383c();
        }
    }

    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        this.f475c.copyStringToBuffer(i, charArrayBuffer);
    }

    public void deactivate() {
        this.f475c.deactivate();
    }

    public byte[] getBlob(int i) {
        return this.f475c.getBlob(i);
    }

    public int getColumnCount() {
        return this.f475c.getColumnCount();
    }

    public int getColumnIndex(String str) {
        return this.f475c.getColumnIndex(str);
    }

    public int getColumnIndexOrThrow(String str) {
        return this.f475c.getColumnIndexOrThrow(str);
    }

    public String getColumnName(int i) {
        return this.f475c.getColumnName(i);
    }

    public String[] getColumnNames() {
        return this.f475c.getColumnNames();
    }

    public int getCount() {
        return this.f475c.getCount();
    }

    public double getDouble(int i) {
        return this.f475c.getDouble(i);
    }

    public Bundle getExtras() {
        return this.f475c.getExtras();
    }

    public float getFloat(int i) {
        return this.f475c.getFloat(i);
    }

    public int getInt(int i) {
        return this.f475c.getInt(i);
    }

    public long getLong(int i) {
        return this.f475c.getLong(i);
    }

    public int getPosition() {
        return this.f475c.getPosition();
    }

    public short getShort(int i) {
        return this.f475c.getShort(i);
    }

    public String getString(int i) {
        return this.f475c.getString(i);
    }

    @TargetApi(11)
    public int getType(int i) {
        return this.f475c.getType(i);
    }

    public boolean getWantsAllOnMoveCalls() {
        return this.f475c.getWantsAllOnMoveCalls();
    }

    @TargetApi(19)
    public Uri getNotificationUri() {
        return this.f475c.getNotificationUri();
    }

    public boolean isAfterLast() {
        return this.f475c.isAfterLast();
    }

    public boolean isBeforeFirst() {
        return this.f475c.isBeforeFirst();
    }

    public boolean isClosed() {
        return this.f475c.isClosed();
    }

    public boolean isFirst() {
        return this.f475c.isFirst();
    }

    public boolean isLast() {
        return this.f475c.isLast();
    }

    public boolean isNull(int i) {
        return this.f475c.isNull(i);
    }

    public boolean move(int i) {
        return this.f475c.move(i);
    }

    public boolean moveToFirst() {
        return this.f475c.moveToFirst();
    }

    public boolean moveToLast() {
        return this.f475c.moveToLast();
    }

    public boolean moveToNext() {
        return this.f475c.moveToNext();
    }

    public boolean moveToPosition(int i) {
        return this.f475c.moveToPosition(i);
    }

    public boolean moveToPrevious() {
        return this.f475c.moveToPrevious();
    }

    public void registerContentObserver(ContentObserver contentObserver) {
        this.f475c.registerContentObserver(contentObserver);
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f475c.registerDataSetObserver(dataSetObserver);
    }

    public boolean requery() {
        return false;
    }

    public Bundle respond(Bundle bundle) {
        return this.f475c.respond(bundle);
    }

    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        this.f475c.setNotificationUri(contentResolver, uri);
    }

    public void unregisterContentObserver(ContentObserver contentObserver) {
        this.f475c.unregisterContentObserver(contentObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f475c.unregisterDataSetObserver(dataSetObserver);
    }

    @TargetApi(23)
    public void setExtras(Bundle bundle) {
        this.f475c.setExtras(bundle);
    }

    public void finalize() {
        close();
    }
}
