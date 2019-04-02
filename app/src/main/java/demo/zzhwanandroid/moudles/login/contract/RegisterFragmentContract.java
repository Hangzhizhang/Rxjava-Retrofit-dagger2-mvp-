package demo.zzhwanandroid.moudles.login.contract;

import demo.zzhwanandroid.base.presenter.IPresenter;
import demo.zzhwanandroid.base.view.IView;

public interface RegisterFragmentContract {
    interface View extends IView {
        void registerSuccess();
    }
    interface Presenter extends IPresenter<View> {
        void register(String username, String password, String password2);
    }
}
