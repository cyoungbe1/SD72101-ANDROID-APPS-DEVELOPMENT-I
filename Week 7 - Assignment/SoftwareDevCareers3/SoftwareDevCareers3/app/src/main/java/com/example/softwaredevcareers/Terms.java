package com.example.softwaredevcareers;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Terms extends Fragment {

    private TermsViewModel mViewModel;

    public static Terms newInstance() {
        return new Terms();
    }

    View root;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_terms, container, false);

        TextView termList = (TextView) root.findViewById(R.id.termList1);

        termList.setText( "Agile: A process based on requirements, discovery, improvements and solutions improvement through a collaborative effort between scrum teams and their end-users in a constantly improving effort to develop the best product possible  \n Front-end development: A development process by which the developer creates the part of the app or website that the user interacts with.  This involves the application of engineering languages such as Javascript, HTML and CSS in creating the part of website or app that the user can interact with. \n Back-end development: Development process involving the creation and maintenance of server-side software with a focus on databases, serverside logic, API's and architecture to ensure that the app or website fuctions properly. \n SASS:  A preprocessor scripting language that is compiled into Cascading Style Sheets. SASS employs the use of programming language fucndionality to make the writing of CSS much more powerful.\n  CMS:  Stands for Content Management System.  It helps create, manage and publish content on the web. Useful for organization and accessibility, CMS allows content to be repurposed effectivley.   \n GIS: Geographic Information Systems ued to store, visualize and interpret geographic data  \n Progressive Web App: Web apps that employs progressive enhancement along with service workers, manifests, and other web-platform functionality to enhance the user experience bringing it to a state comparable to native apps.  \n Javascript: A client-side/front-end scripting language used by developers all over the world to create dynamic, interactive web content including applications and browsers."
        );

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TermsViewModel.class);
        // TODO: Use the ViewModel
    }

}