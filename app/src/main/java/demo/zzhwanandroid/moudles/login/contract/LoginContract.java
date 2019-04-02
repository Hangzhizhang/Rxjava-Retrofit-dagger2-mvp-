package demo.zzhwanandroid.moudles.login.contract;

import demo.zzhwanandroid.base.presenter.IPresenter;
import demo.zzhwanandroid.base.view.IView;

public interface LoginContract {
    interface View extends IView{
    }
    interface  Presenter extends IPresenter<View>{
    }
}
