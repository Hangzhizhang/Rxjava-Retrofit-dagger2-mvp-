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

package demo.zzhwanandroid.di.moulde;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import demo.zzhwanandroid.di.component.BaseActivityComponent;
import demo.zzhwanandroid.moudles.login.ui.LoginActivity;
import demo.zzhwanandroid.moudles.main.ui.activity.MainActivity;

@Module(subcomponents = {BaseActivityComponent.class})
public abstract class AbstractAllActivityModule {
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributesMainActivityInjector();
    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity contributesLoginActivityInject();

}
