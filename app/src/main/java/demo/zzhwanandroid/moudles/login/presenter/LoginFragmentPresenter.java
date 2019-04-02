package demo.zzhwanandroid.moudles.login.presenter;

import org.simple.eventbus.EventBus;

import javax.inject.Inject;

import demo.zzhwanandroid.R;
import demo.zzhwanandroid.app.WanAndroidApp;
import demo.zzhwanandroid.base.presenter.BasePresenter;
import demo.zzhwanandroid.core.event.LoginEvent;
import demo.zzhwanandroid.core.rx.BaseObserver;
import demo.zzhwanandroid.moudles.login.bean.LoginData;
import demo.zzhwanandroid.moudles.login.contract.LoginFragmentContract;
import demo.zzhwanandroid.utils.RxUtils;

public class LoginFragmentPresenter extends BasePresenter<LoginFragmentContract.View>
        implements LoginFragmentContract.Presenter{
    @Inject
    LoginFragmentPresenter() {
    }

    @Override
    public void registerEventBus() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void unregisterEventBus() {
        EventBus.getDefault().unregister(this);
    }
    //登录
    @Override
    public void login(String username, String password) {
        addSubscribe(mDataManager.login(username, password)
                .compose(RxUtils.SchedulerTransformer())
                .filter(loginData -> mView != null)
                .subscribeWith(new BaseObserver<LoginData>(mView,
                        WanAndroidApp.getContext().getString(R.string.login_fail),
                        true) {
                    @Override
                    public void onSuccess(LoginData loginData) {
                        setLoginStatus(true);
                        setLoginAccount(loginData.getUsername());
                        EventBus.getDefault().post(new LoginEvent());
                        mView.loginSuccess();
                    }

                    @Override
                    public void onFailure(int code, String message) {
                        super.onFailure(code, message);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                }));

    }
}
