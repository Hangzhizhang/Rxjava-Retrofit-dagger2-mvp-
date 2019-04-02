package demo.zzhwanandroid.moudles.login.ui;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import demo.zzhwanandroid.R;
import demo.zzhwanandroid.base.activity.BaseActivity;
import demo.zzhwanandroid.moudles.login.contract.LoginContract;
import demo.zzhwanandroid.moudles.login.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mTitle;

    @Override
    protected void initView() {
        //加载同级 多个Fragment
        loadMultipleRootFragment(R.id.login_frame_layout, 0,
                LoginFragment.newInstance(), RegisterFragment.newInstance());
        setToolbarTitle(R.string.login);
    }
    public void setToolbarTitle(int resId){
        mTitle.setText(resId);
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        mToolbar.setNavigationOnClickListener(v -> onBackPressedSupport());
    }

    @Override
    protected void initEventAndData() {

    }
}
