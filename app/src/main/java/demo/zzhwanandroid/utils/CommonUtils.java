/*
 *     (C) Copyright 2019, ForgetSky.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package demo.zzhwanandroid.utils;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;

import demo.zzhwanandroid.R;
import demo.zzhwanandroid.app.WanAndroidApp;

public class CommonUtils {

    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) WanAndroidApp.getContext().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

//    public static void startArticleDetailActivity(Context context, int articleId, String articleTitle,
//                                                  String articleLink, boolean isCollected,
//                                                  boolean isShowCollectIcon, int articleItemPosition,
//                                                  String eventBusTag) {
//        Intent intent = new Intent(context, ArticleDetailActivity.class);
//        intent.putExtra(Constants.ARTICLE_ID, articleId);
//        intent.putExtra(Constants.ARTICLE_TITLE, articleTitle);
//        intent.putExtra(Constants.ARTICLE_LINK, articleLink);
//        intent.putExtra(Constants.IS_COLLECTED, isCollected);
//        intent.putExtra(Constants.IS_SHOW_COLLECT_ICON, isShowCollectIcon);
//        intent.putExtra(Constants.ARTICLE_ITEM_POSITION, articleItemPosition);
//        intent.putExtra(Constants.EVENT_BUS_TAG, eventBusTag);
//        context.startActivity(intent);
//
//    }

//    public static void startLoginActivity(Context context) {
//        Intent intent = new Intent(context, LoginActivity.class);
//        context.startActivity(intent);
//    }
//
//    public static void startFragmentInCommonActivity(Context context, int fragmet) {
//        Intent intent = new Intent(context, CommonActivity.class);
//        intent.putExtra(Constants.TYPE_FRAGMENT_KEY, fragmet);
//        context.startActivity(intent);
//    }

    public static int getRandomColor() {
        Random random = new Random();
        //0-190, 如果颜色值过大,就越接近白色,就看不清了,所以需要限定范围
        int red;
        int green;
        int blue;
        if (WanAndroidApp.isNightMode()) {
//            150-255
            red = random.nextInt(105) + 150;
            green = random.nextInt(105) + 150;
            blue = random.nextInt(105) + 150;
        } else {
            red = random.nextInt(190);
            green = random.nextInt(190);
            blue = random.nextInt(190);
        }
        //使用rgb混合生成一种新的颜色,Color.rgb生成的是一个int数
        return Color.rgb(red, green, blue);
    }

    public static AlertDialog getLoadingDialog(Context context, String message) {
        View view = LayoutInflater.from(context).inflate(R.layout.loading_progressbar, null, false);
        TextView loadingText = view.findViewById(R.id.loading_text);
        loadingText.setText(message);
        AlertDialog dialog = new AlertDialog.Builder(context).setView(view).create();
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        return dialog;
    }

    public static void hideKeyBoard(Context context, View view) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) context.getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

}
