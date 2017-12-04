package com.duokan.reader.ui.general.web;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duokan.c.d;
import com.duokan.c.e;
import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.b.UrlTools;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.sys.ah;
import com.duokan.core.ui.GridItemsView;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.iv;
import com.duokan.reader.domain.bookshelf.iw;
import com.duokan.reader.ui.bookshelf.ds;
import com.duokan.reader.ui.bookshelf.hn;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.general.bo;
import com.duokan.reader.ui.general.dk;
import com.duokan.reader.ui.s;
import com.duokan.reader.ui.surfing.af;

import java.util.LinkedList;

public class SearchController extends StorePageController implements iv, iw {
    private static final int HISTORY_SIZE = 5;
    private static final String KEY_SEARCH_HISTORY = "search_history";
    private static final String KEY_SEARCH_HOTWORD = "search_hotword";
    private static final int MAX_LOAD_TIME = 5;
    private View mClearView;
    private String mDefaultSearchWord = "";
    private EditText mEditText;
    private final LinkedList mHistory = new LinkedList();
    private String mHitWord = null;
    private final LinkedList mHotWord = new LinkedList();
    private boolean mIsHistoryLoaded = false;
    private boolean mLoadHistory = true;
    private boolean mLoadHotWord = true;
    private boolean mLoadingSucceed = false;
    private String mLoadingUrl;
    private int mLocalHintSize = getLocalHintSize();
    private int mLocalSearchLoadTime = 0;
    private View mLocalSearchResultView;
    private String mOpenFrom = null;
    private GridItemsView mPresenterResultView;
    private final LinkedList mSearchHint = new LinkedList();
    private DkWebListView mSearchHintView;
    private boolean mSearchOnTextChange = true;
    private hn mSearchPresenter = null;
    private String mSearchSource;
    private boolean mStartSearch = false;
    private Runnable mTimeoutRunnable;
    private final View mWebContentView;

    public SearchController(IFeature featrue) {
        super(featrue);
        ((TextView) this.mErrorView.findViewById(g.general__emtpy_view__line_1)).setText(j.general__shared__web_error);
        TextView textView = (TextView) this.mErrorView.findViewById(g.general__emtpy_view__line_3);
        textView.setText(j.general__shared__web_refresh);
        textView.setVisibility(0);
        textView.setOnClickListener(new p(this));
        this.mWebRootView.setPadding(0, 0, 0, 0);
        this.mWebContentView = this.mWebRootView.findViewById(g.general__web_core_view__content);
        View findViewById = findViewById(g.store__store_search_root_view__title);
        s sVar = (s) MyContextWrapper.getFeature(getContext()).queryFeature(s.class);
        if (sVar != null) {
            findViewById.setPadding(findViewById.getPaddingLeft(), sVar.getTheme().getHeaderPaddingTop() + findViewById.getPaddingTop(), findViewById.getPaddingRight(), findViewById.getPaddingBottom());
        }
        ReaderFeature readerFeature = (ReaderFeature) MyContextWrapper.getFeature(getContext()).queryFeature(ReaderFeature.class);
        if (readerFeature != null) {
            findViewById.setBackgroundDrawable(readerFeature.getHeaderBackground());
        }
        this.mClearView = findViewById(g.store__store_search_root_view__clear);
        this.mClearView.setOnClickListener(new z(this));
        this.mLocalSearchResultView = LayoutInflater.from(getContext()).inflate(h.bookshelf__local_search_hint_view, null);
        ImageView imageView = (ImageView) this.mLocalSearchResultView.findViewById(g.store__store_search_root_view__presenter_load_more);
        imageView.setOnClickListener(new aa(this));
        this.mPresenterResultView = (GridItemsView) this.mLocalSearchResultView.findViewById(g.store__store_search_root_view__presenter_result);
        this.mPresenterResultView.setBackgroundColor(getResources().getColor(d.general__shared__ffffff));
        this.mPresenterResultView.setAdapter(new ab(this, imageView));
        this.mPresenterResultView.setOnItemClickListener(new ac(this));
        this.mPresenterResultView.setOnItemLongPressListener(new ad(this));
        this.mPresenterResultView.setNumColumns(ds.a(getContext()));
        this.mPresenterResultView.setMaxOverScrollHeight(UTools.g(getContext()));
        this.mSearchHintView.setHatBodyView(this.mLocalSearchResultView);
        this.mEditText = (EditText) findViewById(g.store__store_search_root_view__edittext);
        this.mEditText.addTextChangedListener(new ae(this));
        this.mEditText.setOnEditorActionListener(new ah(this));
        int b = UTools.closeAnimation(getContext(), 15.0f);
        this.mSearchHintView.a(b, 0, b, sVar == null ? 0 : sVar.getTheme().getPagePaddingBottom());
        this.mSearchHintView.setPullDownRefreshEnabled(false);
        this.mSearchHintView.setOnItemClickListener(new ai(this));
        initViewForPh();
    }

    public void checkDefaultSearch() {
        if (!TextUtils.isEmpty(this.mDefaultSearchWord)) {
            this.mSearchOnTextChange = false;
            this.mEditText.setText(this.mDefaultSearchWord);
            this.mEditText.selectAll();
            if (this.mStartSearch) {
                search(this.mDefaultSearchWord, "");
                return;
            }
        }
        ReaderUi.a(getContext(), this.mEditText);
    }

    public void setSearchSource(String str) {
        this.mSearchSource = str;
    }

    public void setOpenFrom(String str) {
        this.mOpenFrom = str;
    }

    public void setDefaultSearchWord(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.mDefaultSearchWord = str2;
            this.mStartSearch = false;
            return;
        }
        this.mDefaultSearchWord = str;
        this.mStartSearch = true;
    }

    public void setBookshelfResultPresenter(hn hnVar) {
        this.mSearchPresenter = hnVar;
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.mSearchHintView.a();
            updateAllViews();
            checkDefaultSearch();
        }
        ai.a().a((iv) this);
        ai.a().a((iw) this);
        af afVar = (af) getContext().queryFeature(af.class);
        if (afVar != null) {
            afVar.n();
        }
    }

    protected void onDeactive() {
        af afVar = (af) getContext().queryFeature(af.class);
        if (afVar != null) {
            afVar.m();
        }
        ai.a().b((iv) this);
        ai.a().b((iw) this);
        UTools.hideSoftInputFromWindow(getContext());
        super.onDeactive();
    }

    protected aj newJavascriptImpl() {
        return new aj(this);
    }

    protected boolean onBack() {
        if (TextUtils.isEmpty(this.mEditText.getText())) {
            return false;
        }
        if (!isPageChanged(p.i().f()) && this.mWebRootView.getVisibility() == 0) {
            return false;
        }
        this.mEditText.getText().clear();
        return true;
    }

    public void onItemChanged(an anVar, int i) {
        refreshView();
    }

    public void onItemsChanged() {
        refreshView();
    }

    protected void initContentView() {
        View qVar = new q(this, getContext());
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(h.store__store_search_root_view, qVar, false);
        qVar.addView(linearLayout);
        View apVar = new ap(this, getContext());
        linearLayout.addView(apVar, new LayoutParams(-1, -1));
        this.mSearchHintView = new DkWebListView(getContext());
        apVar.addView(this.mSearchHintView, new LayoutParams(-1, -1));
        LayoutInflater.from(getContext()).inflate(h.general__web_core_view, apVar, true);
        setContentView(qVar);
    }

    protected void webPageError(boolean z) {
        this.mErrorView.setVisibility(z ? 0 : 4);
        if (z && TextUtils.isEmpty(this.mEditText.getText())) {
            hideWebView();
        }
    }

    protected void onPageCreated(int i, String str) {
        Uri a = a.a(getCurrentUrl());
        Uri a2 = a.a(this.mLoadingUrl);
        if (i == 0 && a != null && a2 != null) {
            if (a.getFragment() == null || a.getFragment().equals(a2.getFragment())) {
                this.mLoadingSucceed = true;
                this.mWebContentView.setVisibility(0);
                this.mWebView.g();
            }
        }
    }

    private void initViewForPh() {
        this.mPresenterResultView.setPadding(this.mPresenterResultView.getPaddingLeft(), 0, this.mPresenterResultView.getPaddingRight(), this.mPresenterResultView.getPaddingBottom());
        Drawable dkVar = new dk(getResources().getColor(d.general__shared__eeeeee));
        dkVar.a(1);
        this.mSearchHintView.setRowDivider(dkVar);
        this.mSearchHintView.a(UTools.closeAnimation(getContext(), 20.0f), 0, UTools.closeAnimation(getContext(), 20.0f), 0);
        this.mSearchHintView.setBackgroundColor(getResources().getColor(d.general__shared__ffffff));
        this.mSearchHintView.setAdapter(new r(this));
    }

    private void refreshView() {
        if (this.mSearchPresenter != null) {
            this.mSearchPresenter.a(this.mEditText.getText().toString().trim());
            ((bo) this.mPresenterResultView.getAdapter()).d();
            updateBookshelfResultVisibility();
        }
    }

    private int getLocalHintSize() {
        return ReaderUi.c(getContext(), UTools.getWidthPixels(getContext()) - (getResources().getDimensionPixelSize(e.general__shared__cover_grid_horz_padding) * 2));
    }

    private boolean hasHint() {
        if (TextUtils.isEmpty(this.mEditText.getText().toString()) || this.mSearchHint == null || this.mSearchHint.size() == 0) {
            return false;
        }
        return true;
    }

    private boolean hasHistory() {
        return this.mHistory.size() > 0;
    }

    private boolean hasHotWord() {
        return this.mHotWord.size() > 0;
    }

    private void setHotWordView(View view, int i, String str) {
        ((TextView) view.findViewById(g.store__hot_word_item_view__text)).setText(str);
        view.findViewById(g.store__hot_word_item_view__close).setVisibility(8);
        ((ImageView) view.findViewById(g.store__hot_word_item_view__icon)).setImageResource(f.search__hot_world_item_view__hint);
    }

    private void setHistoryView(View view, int i, String str) {
        TextView textView = (TextView) view.findViewById(g.store__hot_word_item_view__text);
        ((ImageView) view.findViewById(g.store__hot_word_item_view__icon)).setImageResource(f.search__hot_world_item_view__history);
        textView.setText(str);
        View findViewById = view.findViewById(g.store__hot_word_item_view__close);
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new s(this, i));
    }

    private void getHotWord() {
        if (this.mLoadHotWord) {
            this.mLoadHotWord = false;
            ah.b(new TaskHandler(this));
        }
    }

    private void querySearchHint(String str, Runnable runnable) {
        if (!TextUtils.isEmpty(str)) {
            com.duokan.reader.domain.store.a.a().a(str, new v(this, runnable));
        }
    }

    private void updateBookshelfResultVisibility() {
        if (this.mSearchPresenter.a() == 0) {
            this.mLocalSearchResultView.setVisibility(8);
        } else {
            this.mLocalSearchResultView.setVisibility(0);
        }
    }

    private void updateAllViews() {
        if (com.duokan.reader.common.c.f.b().e()) {
            String f = p.i().f();
            if (isPageChanged(f)) {
                startLoading();
                showWebView();
                this.mWebView.a("about:blank");
                this.mLoadingUrl = UrlTools.resetUrl(UrlTools.parse(f), "loadingStamp=" + System.currentTimeMillis() + (TextUtils.isEmpty(this.mOpenFrom) ? "" : "&from=" + this.mOpenFrom)).toString();
                loadUrl(this.mLoadingUrl);
                this.mTimeoutRunnable = new w(this);
                TaskHandler.postDelayed(this.mTimeoutRunnable, 3000);
                return;
            }
            showWebView();
            return;
        }
        hideWebView();
    }

    private void startLoading() {
        TaskHandler.removeCallbacks(this.mTimeoutRunnable);
        this.mLoadingSucceed = false;
        this.mWebContentView.setVisibility(4);
    }

    private void showWebView() {
        this.mWebRootView.setVisibility(0);
        this.mSearchHintView.setVisibility(8);
    }

    private void hideWebView() {
        this.mWebRootView.setVisibility(8);
        this.mSearchHintView.setVisibility(0);
    }

    private boolean isPageChanged(String str) {
        Object currentUrl = getCurrentUrl();
        if (!TextUtils.isEmpty(currentUrl) && currentUrl.startsWith(str + "#")) {
            return false;
        }
        return true;
    }

    private void showHint(String str, String[] strArr) {
        if (TextUtils.equals(str, this.mEditText.getText())) {
            this.mSearchHint.clear();
            this.mSearchHint.add(str);
            for (String str2 : strArr) {
                if (!str2.equals(str)) {
                    this.mSearchHint.add(str2);
                }
            }
            this.mSearchHintView.getAdapter().a(false);
        }
    }

    private void search(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            UTools.hideSoftInputFromWindow(getContext());
            this.mLocalSearchResultView.setVisibility(8);
            p i = p.i();
            if (!TextUtils.isEmpty(this.mSearchSource)) {
                str2 = this.mSearchSource;
            }
            String a = i.a(str, str2);
            this.mSearchSource = "";
            if (isPageChanged(a)) {
                startLoading();
                showWebView();
                addHistory(str);
                this.mWebView.a("about:blank");
                this.mLoadingUrl = a.a(a.a(a), "loadingStamp=" + System.currentTimeMillis() + (TextUtils.isEmpty(this.mOpenFrom) ? "" : "&from=" + this.mOpenFrom)).toString();
                loadUrl(this.mLoadingUrl);
                return;
            }
            showWebView();
        }
    }

    private void notifyHistoryChanged() {
        this.mSearchHintView.getAdapter().a(false);
    }

    private void addHistory(String str) {
        addHistoryToList(str, false);
        if (this.mIsHistoryLoaded) {
            writeHistory();
        }
        notifyHistoryChanged();
    }

    private void addHistoryToList(String str, boolean z) {
        if (this.mHistory.contains(str)) {
            this.mHistory.remove(str);
        } else if (this.mHistory.size() >= 5) {
            this.mHistory.removeLast();
        }
        if (z) {
            this.mHistory.addLast(str);
        } else {
            this.mHistory.addFirst(str);
        }
    }

    private void removeHistory(int i) {
        if (this.mHistory.size() > 0 && this.mHistory.size() >= i) {
            this.mHistory.remove(i);
            writeHistory();
            notifyHistoryChanged();
        }
    }

    private void writeHistory() {
        ReaderEnv.get().getDb().b(KEY_SEARCH_HISTORY, this.mHistory);
    }

    private void writeHotWords() {
        ReaderEnv.get().getDb().b(KEY_SEARCH_HOTWORD, this.mHotWord);
    }

    private void loadHistoryForPh() {
        this.mLoadHistory = false;
        ah.b(new MyContextWrapper(this));
    }
}
