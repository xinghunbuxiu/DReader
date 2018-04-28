package com.duokan.reader.domain.account.oauth.evernote;

import com.evernote.thrift.transport.TTransport;
import com.evernote.thrift.transport.TTransportException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

public class TEvernoteHttpClient extends TTransport {
    private static final int MEMORY_BUFFER_SIZE = 524288;
    private Map<String, String> customHeaders_ = null;
    private HttpParams httpParameters = new BasicHttpParams();
    private InputStream inputStream_ = null;
    private ClientConnectionManager mConnectionManager;
    private DefaultHttpClient mHttpClient;
    private HttpRequestBase request = null;
    private final DiskBackedByteStore requestBuffer_;
    private URL url_ = null;
    private String userAgent = null;

    /* renamed from: com.duokan.reader.domain.account.oauth.evernote.TEvernoteHttpClient$1 */
    class C07321 implements ConnectionKeepAliveStrategy {
        C07321() {
        }

        public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
            return 120000;
        }
    }

    /* renamed from: com.duokan.reader.domain.account.oauth.evernote.TEvernoteHttpClient$2 */
    class C07332 implements ConnectionReuseStrategy {
        C07332() {
        }

        public boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext) {
            return true;
        }
    }

    public TEvernoteHttpClient(String str, String str2, File file) {
        getHTTPClient();
        this.userAgent = str2;
        try {
            this.url_ = new URL(str);
            this.requestBuffer_ = new DiskBackedByteStore(file, HttpHost.DEFAULT_SCHEME_NAME, MEMORY_BUFFER_SIZE);
        } catch (Throwable e) {
            throw new TTransportException(e);
        }
    }

    public void setConnectTimeout(int i) {
        HttpConnectionParams.setConnectionTimeout(this.httpParameters, i);
    }

    public void setReadTimeout(int i) {
        HttpConnectionParams.setSoTimeout(this.httpParameters, i);
    }

    public void setCustomHeaders(Map<String, String> map) {
        this.customHeaders_ = map;
    }

    public void setCustomHeader(String str, String str2) {
        if (this.customHeaders_ == null) {
            this.customHeaders_ = new HashMap();
        }
        this.customHeaders_.put(str, str2);
    }

    public void open() {
    }

    public void close() {
        if (this.inputStream_ != null) {
            try {
                this.inputStream_.close();
            } catch (IOException e) {
            }
            this.inputStream_ = null;
        }
        if (this.mConnectionManager != null) {
            this.mConnectionManager.shutdown();
            this.mConnectionManager = null;
        }
    }

    public boolean isOpen() {
        return true;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.inputStream_ == null) {
            throw new TTransportException("Response buffer is empty, no request.");
        }
        try {
            int read = this.inputStream_.read(bArr, i, i2);
            if (read != -1) {
                return read;
            }
            throw new TTransportException("No more data available.");
        } catch (Throwable e) {
            throw new TTransportException(e);
        }
    }

    private DefaultHttpClient getHTTPClient() {
        try {
            if (this.mConnectionManager != null) {
                this.mConnectionManager.closeExpiredConnections();
                this.mConnectionManager.closeIdleConnections(1, TimeUnit.SECONDS);
            } else {
                HttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
                ConnManagerParams.setMaxTotalConnections(basicHttpParams, 20);
                ConnManagerParams.setTimeout(basicHttpParams, 10000);
                ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(18));
                SchemeRegistry schemeRegistry = new SchemeRegistry();
                schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
                schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
                this.mConnectionManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient(this.mConnectionManager, basicHttpParams);
                defaultHttpClient.setKeepAliveStrategy(new C07321());
                defaultHttpClient.setReuseStrategy(new C07332());
                this.mHttpClient = defaultHttpClient;
            }
            return this.mHttpClient;
        } catch (Exception e) {
            return null;
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        this.requestBuffer_.write(bArr, i, i2);
    }

    public void flush() {
        System.currentTimeMillis();
        try {
            HttpUriRequest httpPost = new HttpPost(this.url_.toExternalForm());
            this.request = httpPost;
            httpPost.addHeader("Content-Type", "application/x-thrift");
            httpPost.addHeader("Cache-Control", "no-transform");
            if (this.customHeaders_ != null) {
                for (Entry entry : this.customHeaders_.entrySet()) {
                    httpPost.addHeader((String) entry.getKey(), (String) entry.getValue());
                }
            }
            httpPost.setEntity(new InputStreamEntity(this.requestBuffer_.getInputStream(), (long) this.requestBuffer_.getSize()));
            httpPost.addHeader("Accept", "application/x-thrift");
            httpPost.addHeader(HTTP.USER_AGENT, this.userAgent == null ? "Java/THttpClient" : this.userAgent);
            httpPost.getParams().setBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, false);
            HttpResponse execute = getHTTPClient().execute(httpPost);
            HttpEntity entity = execute.getEntity();
            int statusCode = execute.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                if (entity != null) {
                    entity.consumeContent();
                }
                throw new TTransportException("HTTP Response code: " + statusCode);
            }
            this.requestBuffer_.reset();
            this.inputStream_ = execute.getEntity().getContent();
            try {
                this.requestBuffer_.reset();
            } catch (IOException e) {
            }
            this.request = null;
        } catch (Throwable e2) {
            throw new TTransportException(e2);
        } catch (Throwable e22) {
            throw new TTransportException(e22);
        } catch (Throwable th) {
            try {
                this.requestBuffer_.reset();
            } catch (IOException e3) {
            }
            this.request = null;
        }
    }

    public void cancel() {
        try {
            if (this.request != null) {
                this.request.abort();
            }
        } catch (Exception e) {
        }
        close();
    }

    public void reset() {
    }
}
