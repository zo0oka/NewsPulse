package com.zo0okadev.newspulse.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final List<String> ignoredSections = Arrays.asList("about", "animals-farmed",
            "better-business", "business-to-business", "cardiff", "childrens-books-site", "community",
            "crosswords", "culture-network", "culture-professionals-network", "edinburgh",
            "enterprise-network", "extra", "global-development-professionals-network",
            "government-computing-network", "guardian-professional", "healthcare-network",
            "help", "higher-education-network", "housing-network", "info", "jobsadvice",
            "katine", "leeds", "local", "local-government-network", "media-network", "membership",
            "public-leaders-network", "search", "small-business-network", "social-care-network",
            "social-enterprise-network", "society-professionals", "teacher-network", "theguardian",
            "theobserver", "travel/offers", "voluntary-sector-network", "weather", "women-in-leadership",
            "working-in-development");

    public static final String API_KEY = "103f2591-6a1a-43ab-a349-d7a887c336c3";
    public static final String NEWS_API_URL = "https://content.guardianapis.com/";
    public static final String NEWS_LIST_FILTERS = "&order-by=newest&show-fields=thumbnail";
    public static final String NEWS_ARTICLE_FILTERS = "&show-fields=headline,body,hasStoryPackage,standfirst,shortUrl,thumbnail,byline,&show-tags=contributor,keyword,&show-elements=all&show-story-package=true&show-editors-picks=true&show-related=true&show-most-viewed=true";
    public static final int NETWORK_PAGE_SIZE = 50;
    public static final String ADMOB_APP_ID = "ca-app-pub-4040319527918836~6015658874";
}

