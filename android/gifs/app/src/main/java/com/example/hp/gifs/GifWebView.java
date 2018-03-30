package com.example.hp.gifs;

/**
 * Created by Hp on 3/30/2018.
 */

public class GifWebView extends WebView {

    public GifWebView(Context context, String path) {
        super(context);

        loadUrl(path);
    }
}
