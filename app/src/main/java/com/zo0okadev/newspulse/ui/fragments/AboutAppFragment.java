package com.zo0okadev.newspulse.ui.fragments;


import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.zo0okadev.newspulse.R;

import static com.zo0okadev.newspulse.utils.Utils.getAppVersionName;


public class AboutAppFragment extends Fragment {


    public AboutAppFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about_app, container, false);

        TextView appVersion = rootView.findViewById(R.id.about_app_version);
        try {
            appVersion.setText(getAppVersionName(getContext()));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        TextView about = rootView.findViewById(R.id.about_app_text);
        about.setText("World news, live updates & opinion - take your news feed with you, wherever you are. Explore stories, US headlines, content and media on a whole range of topics; from business to music, politics, sport, culture & much more.\n" +
                "\n" +
                "BREAKING NEWS & LIVE REPORTING\n" +
                "• Be the first to know about today’s headlines with live news\n" +
                "• Follow stories as they unfold with breaking news alerts\n" +
                "\n" +
                "US HEADLINES & WORLD NEWS\n" +
                "• Read the latest US headlines in politics, business and sport\n" +
                "• Stay up-to-date with world news stories & media coverage\n" +
                "\n" +
                "CONTENT & TOP STORIES\n" +
                "• Read top stories & the full range of The Guardian journalism\n" +
                "• Access audio, video and interactive content straight from your phone\n" +
                "\n" +
                "SPORTS NEWS\n" +
                "• Access the latest news in sport from our experts\n" +
                "• Watch media coverage & key moments\n" +
                "\n" +
                "Read top stories, breaking news & opinion on the go. News Pulse App gives you access to the latest politics, business and sports news through award-winning journalism provided by The Guardian.\n" +
                "\n" +
                "News that matters - 5 reasons to download News Pulse App:\n" +
                "1. Breaking news alerts, straight to your phone.\n" +
                "2. Top stories & award-winning journalism\n" +
                "3. News feed & customizable content\n" +
                "4. World news & US updates in business, politics and more\n" +
                "5. Sports news & updates, from NFL to F1\n" +
                "\n" +
                "\n" +
                "\n" +
                "Note: Please consider that it includes advertising, some of which may be targeted to your interests. You may choose to control targeted advertising within mobile applications by using your mobile device settings (for example, by re-setting your device's advertising identifier and/or opting out of interest-based ads)\n" +
                "\n" +
                "Note: News Pulse is powered by The Guardian Open-Platform API.");

        return rootView;
    }

}
