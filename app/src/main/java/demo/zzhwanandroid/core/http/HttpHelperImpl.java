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

package demo.zzhwanandroid.core.http;

import javax.inject.Inject;

import demo.zzhwanandroid.core.http.api.ApiService;
import demo.zzhwanandroid.moudles.login.bean.LoginData;
import io.reactivex.Observable;


public class HttpHelperImpl implements HttpHelper {

    private ApiService mApiService;

    @Inject
    HttpHelperImpl(ApiService apiService) {
        mApiService = apiService;
    }

    @Override
    public Observable<BaseResponse<LoginData>> register(String username, String password, String repassword) {
        return mApiService.register(username,password ,repassword );
    }

    @Override
    public Observable<BaseResponse<LoginData>> login(String username, String password) {
        return mApiService.login(username,password );
    }
}
