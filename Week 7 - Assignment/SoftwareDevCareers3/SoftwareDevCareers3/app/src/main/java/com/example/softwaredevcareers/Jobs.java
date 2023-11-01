package com.example.softwaredevcareers;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class Jobs extends Fragment {

    private JobsViewModel mViewModel;

    public static Jobs newInstance() {
        return new Jobs();
    }
    View root;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_jobs, container, false);

        WebView webView1 = (WebView) root.findViewById(R.id.webview1);
        webView1.loadUrl("https://www.indeed.com/jobs?q=&l=30039&vjk=cd3ac9dfb295ad96https://www.indeed.com/jobs?q=&l=30039&vjk=cd3ac9dfb295ad96");

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(JobsViewModel.class);
        // TODO: Use the ViewModel
    }

}