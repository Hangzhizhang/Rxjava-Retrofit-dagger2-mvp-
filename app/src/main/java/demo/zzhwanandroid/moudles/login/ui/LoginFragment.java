package demo.zzhwanandroid.moudles.login.ui;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import demo.zzhwanandroid.R;
import demo.zzhwanandroid.base.fragment.BaseFragment;
import demo.zzhwanandroid.core.event.RegisterEvent;
import demo.zzhwanandroid.moudles.login.contract.LoginFragmentContract;
import demo.zzhwanandroid.moudles.login.presenter.LoginFragmentPresenter;
import demo.zzhwanandroid.moudles.main.ui.activity.MainActivity;
import demo.zzhwanandroid.utils.CommonUtils;
import demo.zzhwanandroid.utils.ToastUtils;

public class LoginFragment extends BaseFragment<LoginFragmentPresenter> implements LoginFragmentContract.View {
    @BindView(R.id.et_username)
    EditText mUsernameEdit;
    @BindView(R.id.et_password)
    EditText mPasswordEdit;

    private AlertDialog mDialog;

    @OnClick({R.id.btn_login, R.id.tv_sign_up})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.tv_sign_up:
                goToRegister();
                break;
            default:
                break;
        }
    }
    public static LoginFragment newInstance(){
        return new LoginFragment();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initEventAndData() {

    }

    private void login() {
        String username = mUsernameEdit.getText().toString();
        String password = mPasswordEdit.getText().toString();
        if (TextUtils.isEmpty(username)) {
            ToastUtils.showToast(_mActivity, getString(R.string.username_not_empty));
        } else if (TextUtils.isEmpty(password)) {
            ToastUtils.showToast(_mActivity, getString(R.string.password_not_empty));
        } else {
            mPresenter.login(username, password);
        }
    }
    private void goToRegister() {
        RegisterFragment registerFragment = findFragment(RegisterFragment.class);
        if (registerFragment == null) {
            registerFragment = RegisterFragment.newInstance();
        }
        getSupportDelegate().showHideFragment(registerFragment, LoginFragment.this);
        LoginActivity loginActivity = (LoginActivity) _mActivity;
        loginActivity.setToolbarTitle(R.string.register);
    }
    @Override
    public void loginSuccess() {
        ToastUtils.showToast(_mActivity, getString(R.string.login_success));
        Intent intent = new Intent(_mActivity, MainActivity.class);
        startActivity(intent);
        _mActivity.finish();
    }

    @Override
    public void registerSuccess(RegisterEvent registerEvent) {
        mUsernameEdit.setText(registerEvent.getUsername());
        mPasswordEdit.setText(registerEvent.getPassword());
    }
    @Override
    public void showLoading() {
        if (mDialog == null) {
            mDialog = CommonUtils.getLoadingDialog(_mActivity, getString(R.string.logging_in));
        }
        mDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mDialog != null) {
            mDialog.dismiss();
            mDialog = null;
        }
    }
}
