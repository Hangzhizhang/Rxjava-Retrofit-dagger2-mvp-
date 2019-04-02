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
import demo.zzhwanandroid.di.component.BaseFragmentComponent;
import demo.zzhwanandroid.moudles.login.ui.LoginFragment;
import demo.zzhwanandroid.moudles.login.ui.RegisterFragment;

@Module(subcomponents = BaseFragmentComponent.class)
public abstract class AbstractAllFragmentModule {
    @ContributesAndroidInjector(modules = LoginFragmentModule.class)
    abstract LoginFragment contributesLoginFragmentInject();

    @ContributesAndroidInjector(modules = RegisterFragmentModule.class)
    abstract RegisterFragment contributesRegisterFragmentInject();

}
