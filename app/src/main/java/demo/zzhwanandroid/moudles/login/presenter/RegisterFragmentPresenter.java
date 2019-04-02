package demo.zzhwanandroid.moudles.login.presenter;

import org.simple.eventbus.EventBus;

import javax.inject.Inject;

import demo.zzhwanandroid.R;
import demo.zzhwanandroid.app.WanAndroidApp;
import demo.zzhwanandroid.base.presenter.BasePresenter;
import demo.zzhwanandroid.core.event.RegisterEvent;
import demo.zzhwanandroid.core.rx.BaseObserver;
import demo.zzhwanandroid.moudles.login.bean.LoginData;
import demo.zzhwanandroid.moudles.login.contract.RegisterFragmentContract;
import demo.zzhwanandroid.utils.RxUtils;

public class RegisterFragmentPresenter extends BasePresenter<RegisterFragmentContract.View>
        implements RegisterFragmentContract.Presenter{
    @Inject
    RegisterFragmentPresenter() {
    }
    @Override
    public void register(String username, String password, String password2) {
        addSubscribe(mDataManager.register(username, password, password2)
                .compose(RxUtils.SchedulerTransformer())
                .filter(loginData -> mView != null)
                .subscribeWith(new BaseObserver<LoginData>(mView,
                        WanAndroidApp.getContext().getString(R.string.register_fail),
                        true){
                    @Override
                    public void onSuccess(LoginData loginData) {
                        EventBus.getDefault().post(new RegisterEvent(loginData.getUsername(), loginData.getPassword()));
                        mView.registerSuccess();
                    }
                }));
    }
}
