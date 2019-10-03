package com.zo0okadev.newspulse.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.zo0okadev.newspulse.R;
import com.zo0okadev.newspulse.utils.WebViewLoader;

public class PrivacyPolicy extends Fragment {


    public PrivacyPolicy() {

    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_privacy_policy, container, false);

        TextView subTitle = getActivity().findViewById(R.id.toolbar_sub_header);
        subTitle.setText(getString(R.string.privacy_policy));

        WebView webView = rootView.findViewById(R.id.privacy_policy_webView);
        WebViewLoader webViewLoader = new WebViewLoader(webView);
        webViewLoader.setSettings();
        webViewLoader.loadUrl("https://sites.google.com/view/news-pulse/");

        return rootView;
    }

}
