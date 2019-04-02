package demo.zzhwanandroid.moudles.login.presenter;

import javax.inject.Inject;

import demo.zzhwanandroid.base.presenter.BasePresenter;
import demo.zzhwanandroid.moudles.login.contract.LoginContract;

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter{
    @Inject
    LoginPresenter(){}
}
