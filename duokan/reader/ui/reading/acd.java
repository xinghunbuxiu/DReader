package com.duokan.reader.ui.reading;

import android.os.AsyncTask;

import java.io.FileOutputStream;
import java.io.InputStream;

class acd extends AsyncTask {
    final /* synthetic */ acb a;

    private acd(acb com_duokan_reader_ui_reading_acb) {
        this.a = com_duokan_reader_ui_reading_acb;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((Integer) obj);
    }

    protected /* synthetic */ void onProgressUpdate(Object[] objArr) {
        a((Long[]) objArr);
    }

    protected Integer a(Void... voidArr) {
        Integer valueOf;
        synchronized (this.a.g) {
            try {
                this.a.e();
                InputStream inputStream = this.a.f.b()[0].b;
                inputStream.reset();
                FileOutputStream fileOutputStream = new FileOutputStream(this.a.g);
                byte[] bArr = new byte[1024];
                long j = 0;
                while (!isCancelled()) {
                    long read = (long) inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr);
                        j += read;
                        publishProgress(new Long[]{Long.valueOf(j), Long.valueOf((long) this.a.f.b()[0].d)});
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
        this.a.d();
    }

    protected void a(Integer num) {
        super.onPostExecute(num);
        if (this.a.e == null) {
            return;
        }
        if (num.intValue() == 0) {
            this.a.e.l();
            return;
        }
        this.a.e.k();
        this.a.d();
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected void a(Long... lArr) {
        if (this.a.e != null) {
            this.a.e.a((int) (((1.0f * ((float) lArr[0].longValue())) / ((float) lArr[1].longValue())) * 100.0f));
        }
    }
}
