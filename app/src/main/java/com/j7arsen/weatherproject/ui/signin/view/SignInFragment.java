package com.j7arsen.weatherproject.ui.signin.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.j7arsen.weatherproject.R;
import com.j7arsen.weatherproject.base.BaseActivity;
import com.j7arsen.weatherproject.base.BaseFragment;
import com.j7arsen.weatherproject.dataclassess.ValidationErrorType;
import com.j7arsen.weatherproject.progress.ErrorHandler;
import com.j7arsen.weatherproject.progress.ProgressDialogManager;
import com.j7arsen.weatherproject.ui.signin.ISignInContract;
import com.j7arsen.weatherproject.ui.signin.presenter.SignInPresenter;
import com.j7arsen.weatherproject.utils.FieldConverter;
import com.j7arsen.weatherproject.utils.Utils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by j7ars on 11.07.2017.
 */

public class SignInFragment extends BaseFragment implements ISignInContract.View {

    @BindView(R.id.cl_root)
    CoordinatorLayout mRoot;
    @BindView(R.id.rl_icon)
    RelativeLayout rlIcon;
    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.til_password)
    TextInputLayout tilPassword;
    @BindView(R.id.fl_password)
    FrameLayout flPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.til_email)
    TextInputLayout tilEmail;

    private ISignInContract.Presenter mPresenter;

    private Activity mActivity;

    public static SignInFragment newInstance() {
        SignInFragment signInFragment = new SignInFragment();
        return signInFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            mActivity = (Activity) context;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof BaseActivity) {
            mActivity = activity;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.attachView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void setupComponent() {
        fragmentComponent().inject(this);
    }

    @Inject
    void setupPresenter(SignInPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void startProgressDialog() {
        ProgressDialogManager.getInstance().startLoading(this);
    }

    @Override
    public void completeProgressDialog() {
        ProgressDialogManager.getInstance().completeLoading();
    }

    @Override
    public void errorProgressDialog(ErrorHandler errorHandler) {
        ProgressDialogManager.getInstance().errorLoading(errorHandler);
    }

    @OnClick({R.id.iv_icon, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_icon:
                Toast.makeText(getActivity(), FieldConverter.getString(R.string.sing_in_test), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_login:
                Utils.hideKeyboard(getActivity());
                mPresenter.getWeatherData(etEmail.getText().toString(), etPassword.getText().toString());
                break;
        }
    }

    @Override
    public void showWeatherData(String weatherData) {
        Snackbar.make(mRoot, weatherData, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setError(ValidationErrorType validationErrorType, boolean isError){
        switch (validationErrorType){
            case EMAIL:
                if(isError){
                    tilEmail.setError(FieldConverter.getString(R.string.auth_email_invalid));
                } else{
                    tilEmail.setErrorEnabled(false);
                }
                break;
            case PASSWORD:
                if(isError){
                    int px = (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_DIP,
                            30,
                            getActivity().getResources().getDisplayMetrics()
                    );
                    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    lp.setMargins(0, 0, 0, px);
                    ivIcon.setLayoutParams(lp);
                    tilPassword.setError(FieldConverter.getString(R.string.auth_password_invalid));
                } else{
                    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    lp.setMargins(0, 0, 0, 0);
                    ivIcon.setLayoutParams(lp);
                    tilPassword.setErrorEnabled(false);
                }
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

}
