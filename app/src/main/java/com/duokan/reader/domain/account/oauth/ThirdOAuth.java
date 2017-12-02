package com.duokan.reader.domain.account.oauth;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;

import com.duokan.reader.common.webservices.duokan.a.a;
import com.duokan.reader.common.webservices.duokan.a.c;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

public abstract class ThirdOAuth {
    protected final Activity mActivity;
    protected final String mThirdName;
    protected final TokenStore mTokenStore = TokenStore.getInstance();

    public interface DeleteHandler {
        void onDeleteError();

        void onDeleteOk();
    }

    public interface FetchUserInfoHandler {
        void onFetchUserInfoFinished(boolean z);
    }

    public interface OAuthCallback {
        void onGetUserNameFailed();

        void onOauthFailed(String str);

        void onOauthSuccess();
    }

    public interface QueryAccountListener {
        void onQueryAccountError();

        void onQueryAccountOk(String... strArr);
    }

    public class ResponseHandleResult {
        public final boolean mNeedReauth;
        public final Object mValue;

        public ResponseHandleResult(Object obj) {
            this(obj, false);
        }

        public ResponseHandleResult(Object obj, boolean z) {
            this.mValue = obj;
            this.mNeedReauth = z;
        }
    }

    public interface UpdateHandler {
        void onUpdateCancel();

        void onUpdateError();

        void onUpdateOk();
    }

    protected abstract ResponseHandleResult handleUpdateResponse(String str);

    protected abstract boolean handleUserInfoResponse(String str);

    protected abstract a makeFetchUserInfoRequest();

    protected abstract a makeUpdateRequest(String str, Bitmap bitmap);

    public abstract void oauth(OAuthCallback oAuthCallback);

    public abstract void update(String str, Bitmap bitmap, String str2, UpdateHandler updateHandler);

    public ThirdOAuth(Activity activity, String str) {
        this.mActivity = activity;
        this.mThirdName = str;
    }

    public static ThirdOAuth produceThird(Activity activity, String str) {
        if (str.equals("sina")) {
            return new ThirdSina(activity);
        }
        return new ThirdYinxiang(activity, str);
    }

    public void onActive() {
    }

    public void onDeactive() {
    }

    protected a makePostRequest(String str, String str2, Bitmap bitmap, String... strArr) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--7cd4a6d158c").append("\r\n");
        stringBuilder.append("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"").append("news_image.jpg").append("\"\r\n");
        stringBuilder.append("Content-Type: ").append("image/jpeg").append("\r\n\r\n");
        byteArrayOutputStream.write(stringBuilder.toString().getBytes());
        bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        byteArrayOutputStream.write("\r\n".getBytes());
        for (int i = 0; i < strArr.length; i += 2) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("--7cd4a6d158c").append("\r\n");
            stringBuilder2.append("content-disposition: form-data; name=\"");
            stringBuilder2.append(strArr[i]).append("\"\r\n\r\n");
            stringBuilder2.append(strArr[i + 1]).append("\r\n");
            byteArrayOutputStream.write(stringBuilder2.toString().getBytes());
        }
        byteArrayOutputStream.write("\r\n--7cd4a6d158c--".getBytes());
        a a = new c().a(HttpPost.METHOD_NAME).b(str).a(byteArrayOutputStream.toByteArray()).a();
        a.a("Content-Type", "multipart/form-data; boundary=7cd4a6d158c");
        return a;
    }

    protected a makePostRequest(String str, String... strArr) {
        List linkedList = new LinkedList();
        for (int i = 0; i < strArr.length; i += 2) {
            linkedList.add(new BasicNameValuePair(strArr[i], strArr[i + 1]));
        }
        return new c().b(str).a(linkedList).a(HttpPost.METHOD_NAME).a();
    }

    protected String makeGetUrl(String str, String... strArr) {
        int i = 0;
        while (i < strArr.length) {
            StringBuilder append = new StringBuilder().append(str);
            String str2 = (i != 0 || str.endsWith("?")) ? "&" : "?";
            str = append.append(str2).toString() + strArr[i] + "=" + strArr[i + 1];
            i += 2;
        }
        return str;
    }

    protected Activity getActivity() {
        return this.mActivity;
    }
}
