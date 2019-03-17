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
    public static final String NEWS_API_URL = "http://content.guardianapis.com/";
    public static final String NEWS_LIST_FILTERS = "&order-by=newest&show-fields=thumbnail";
    public static final String NEWS_ARTICLE_FILTERS = "&show-fields=headline,body,hasStoryPackage,standfirst,shortUrl,thumbnail,byline,&show-tags=contributor,keyword,&show-elements=all&show-story-package=true&show-editors-picks=true&show-related=true&show-most-viewed=true";
    public static final int NETWORK_PAGE_SIZE = 50;
    public static final String ADMOB_APP_ID = "ca-app-pub-4040319527918836~6015658874";
    public static final String PRIVACY_POLICY = "<!DOCTYPE html>\n" +
            "    <html>\n" +
            "    <head>\n" +
            "      <meta charset='utf-8'>\n" +
            "      <meta name='viewport' content='width=device-width'>\n" +
            "      <title>Privacy Policy</title>\n" +
            "      <style> body { font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; padding:1em; } </style>\n" +
            "    </head>\n" +
            "    <body>\n" +
            "    <h2>Privacy Policy</h2> <p> Zo0okaDev built the World News app as an Ad Supported app. This SERVICE is provided by\n" +
            "                    Zo0okaDev at no cost and is intended for use as is. World News uses The Guardian News API to get the news headlines.\n" +
            "                  </p> <p>This page is used to inform visitors regarding our policies with the collection, use, and disclosure\n" +
            "                    of Personal Information if anyone decided to use our Service.\n" +
            "                  </p> <p>If you choose to use our Service, then you agree to the collection and use of information in\n" +
            "                    relation to this policy. The Personal Information that we collect is used for providing and improving\n" +
            "                    the Service. We will not use or share your information with anyone except as described\n" +
            "                    in this Privacy Policy.\n" +
            "                  </p> <p>The terms used in this Privacy Policy have the same meanings as in our Terms and Conditions, which is\n" +
            "                    accessible at World News unless otherwise defined in this Privacy Policy.\n" +
            "                  </p> <p><strong>Information Collection and Use</strong></p> <p>For a better experience, while using our Service, we may require you to provide us with certain\n" +
            "                    personally identifiable information. The information that we request will be retained by us and used as described in this privacy policy.\n" +
            "                  </p> <p>The app does use third party services that may collect information used to identify you.</p> <div><p>Link to privacy policy of third party service providers used by the app</p> <ul><li><a href=\"https://www.google.com/policies/privacy/\" target=\"_blank\">Google Play Services</a></li><!----><!----><!----><!----><!----><!----><!----></ul></div> <p><strong>Log Data</strong></p> <p> We want to inform you that whenever you use our Service, in a case of\n" +
            "                    an error in the app we collect data and information (through third party products) on your phone\n" +
            "                    called Log Data. This Log Data may include information such as your device Internet Protocol (“IP”) address,\n" +
            "                    device name, operating system version, the configuration of the app when utilizing our Service,\n" +
            "                    the time and date of your use of the Service, and other statistics.\n" +
            "                  </p> <p><strong>Cookies</strong></p> <p>Cookies are files with a small amount of data that are commonly used as anonymous unique identifiers.\n" +
            "                    These are sent to your browser from the websites that you visit and are stored on your device's internal\n" +
            "                    memory.\n" +
            "                  </p> <p>This Service does not use these “cookies” explicitly. However, the app may use third party code and\n" +
            "                    libraries that use “cookies” to collect information and improve their services. You have the option to\n" +
            "                    either accept or refuse these cookies and know when a cookie is being sent to your device. If you choose\n" +
            "                    to refuse our cookies, you may not be able to use some portions of this Service.\n" +
            "                  </p> <p><strong>Service Providers</strong></p> <p> We may employ third-party companies and individuals due to the following reasons:</p> <ul><li>To facilitate our Service;</li> <li>To provide the Service on our behalf;</li> <li>To perform Service-related services; or</li> <li>To assist us in analyzing how our Service is used.</li></ul> <p> We want to inform users of this Service that these third parties have access to\n" +
            "                    your Personal Information. The reason is to perform the tasks assigned to them on our behalf. However,\n" +
            "                    they are obligated not to disclose or use the information for any other purpose.\n" +
            "                  </p> <p><strong>Security</strong></p> <p> We value your trust in providing us your Personal Information, thus we are striving\n" +
            "                    to use commercially acceptable means of protecting it. But remember that no method of transmission over\n" +
            "                    the internet, or method of electronic storage is 100% secure and reliable, and we cannot guarantee\n" +
            "                    its absolute security.\n" +
            "                  </p> <p><strong>Links to Other Sites</strong></p> <p>This Service may contain links to other sites. If you click on a third-party link, you will be directed\n" +
            "                    to that site. Note that these external sites are not operated by us. Therefore, we strongly\n" +
            "                    advise you to review the Privacy Policy of these websites. We have no control over\n" +
            "                    and assume no responsibility for the content, privacy policies, or practices of any third-party sites\n" +
            "                    or services.\n" +
            "                  </p> <p><strong>Children’s Privacy</strong></p> <p>These Services do not address anyone under the age of 13. We do not knowingly collect\n" +
            "                    personally identifiable information from children under 13. In the case we discover that a child\n" +
            "                    under 13 has provided us with personal information, we immediately delete this from\n" +
            "                    our servers. If you are a parent or guardian and you are aware that your child has provided us with personal\n" +
            "                    information, please contact us so that we will be able to do necessary actions.\n" +
            "                  </p> <p><strong>Changes to This Privacy Policy</strong></p> <p> We may update our Privacy Policy from time to time. Thus, you are advised to review\n" +
            "                    this page periodically for any changes. We will notify you of any changes by posting\n" +
            "                    the new Privacy Policy on this page. These changes are effective immediately after they are posted on\n" +
            "                    this page.\n" +
            "                  </p> <p><strong>Contact Us</strong></p> <p>If you have any questions or suggestions about our Privacy Policy, do not hesitate to contact\n" +
            "                    us.\n" +
            "                  </p>\n" +
            "    </body>\n" +
            "    </html>";
}

