package demo.zzhwanandroid.moudles.login.contract;

import demo.zzhwanandroid.base.presenter.IPresenter;
import demo.zzhwanandroid.base.view.IView;
import demo.zzhwanandroid.core.event.RegisterEvent;

public interface LoginFragmentContract {
    interface View extends IView{
        void loginSuccess();
        void registerSuccess(RegisterEvent registerEvent);
    }
    interface Presenter extends IPresenter<View> {

        void login(String username, String password);
    }
}
