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


import demo.zzhwanandroid.moudles.login.bean.LoginData;
import io.reactivex.Observable;

public interface HttpHelper {


    // 注册
    Observable<BaseResponse<LoginData>> register(String username, String password, String repassword);
    // 登录
    Observable<BaseResponse<LoginData>> login(String username, String password);
}
