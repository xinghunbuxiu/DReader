package com.duokan.kernel;

import android.util.Log;
import java.io.InputStream;

public class DkBufferStream extends InputStream {
    private InputStream mDkStream;
    private long mSkip = 0;

    public DkBufferStream(InputStream inputStream) {
        this.mDkStream = inputStream;
    }

    public int available() {
        return this.mDkStream.available();
    }

    public void close() {
    }

    public void mark(int i) {
    }

    public boolean markSupported() {
        return false;
    }

    public synchronized int read() {
        int read;
        synchronized (this.mDkStream) {
            this.mDkStream.reset();
            this.mDkStream.skip(this.mSkip);
            read = this.mDkStream.read();
            if (read < 0) {
                this.mSkip = -1;
                Log.i("", "readbyte: " + read);
            } else {
                this.mSkip++;
            }
        }
        return read;
    }

    public synchronized int read(byte[] bArr, int i, int i2) {
        int read;
        synchronized (this.mDkStream) {
            this.mDkStream.reset();
            this.mDkStream.skip(this.mSkip);
            read = this.mDkStream.read(bArr, i, i2);
            if (read < 0) {
                this.mSkip = -1;
                Log.i("", "readbyte: " + read);
            } else {
                this.mSkip += (long) read;
            }
        }
        return read;
    }

    public synchronized int read(byte[] bArr) {
        int read;
        synchronized (this.mDkStream) {
            this.mDkStream.reset();
            this.mDkStream.skip(this.mSkip);
            read = this.mDkStream.read(bArr);
            if (read < 0) {
                this.mSkip = -1;
                Log.i("", "readbyte: " + read);
            } else {
                this.mSkip += (long) read;
            }
        }
        return read;
    }

    public synchronized void reset() {
        synchronized (this.mDkStream) {
            this.mSkip = 0;
            this.mDkStream.reset();
        }
    }

    public long skip(long j) {
        long skip;
        synchronized (this.mDkStream) {
            this.mDkStream.reset();
            this.mDkStream.skip(this.mSkip);
            Log.i("", "mSkip: " + j);
            skip = this.mDkStream.skip(j);
            this.mSkip += skip;
        }
        return skip;
    }
}
