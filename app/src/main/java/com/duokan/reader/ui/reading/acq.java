package com.duokan.reader.ui.reading;

import android.os.AsyncTask;
import java.io.FileOutputStream;
import java.io.InputStream;

class acq extends AsyncTask<Void, Long, Integer> {
    /* renamed from: a */
    final /* synthetic */ aco f9479a;

    private acq(aco aco) {
        this.f9479a = aco;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m13324a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m13325a((Integer) obj);
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        m13326a((Long[]) objArr);
    }

    /* renamed from: a */
    protected Integer m13324a(Void... voidArr) {
        Integer valueOf;
        synchronized (this.f9479a.f9475g) {
            try {
                this.f9479a.m13320e();
                InputStream inputStream = this.f9479a.f9474f.mo1411b()[0].f4401b;
                inputStream.reset();
                FileOutputStream fileOutputStream = new FileOutputStream(this.f9479a.f9475g);
                byte[] bArr = new byte[1024];
                long j = 0;
                while (!isCancelled()) {
                    long read = (long) inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr);
                        j += read;
                        publishProgress(new Long[]{Long.valueOf(j), Long.valueOf((long) this.f9479a.f9474f.mo1411b()[0].f4403d)});
                    }
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                valueOf = Integer.valueOf(0);
            } catch (Exception e) {
                e.printStackTrace();
                valueOf = Integer.valueOf(-1);
            }
        }
        return valueOf;
    }

    protected void onCancelled() {
        super.onCancelled();
        this.f9479a.m13317d();
    }

    /* renamed from: a */
    protected void m13325a(Integer num) {
        super.onPostExecute(num);
        if (this.f9479a.f9473e == null) {
            return;
        }
        if (num.intValue() == 0) {
            this.f9479a.f9473e.mo2264l();
            return;
        }
        this.f9479a.f9473e.mo2263k();
        this.f9479a.m13317d();
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    /* renamed from: a */
    protected void m13326a(Long... lArr) {
        if (this.f9479a.f9473e != null) {
            this.f9479a.f9473e.mo2266a((int) (((1.0f * ((float) lArr[0].longValue())) / ((float) lArr[1].longValue())) * 100.0f));
        }
    }
}
