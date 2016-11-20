package com.taxitrack.davidshalom.taxitrackapplication.login;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;

    public LoginPresenterImpl() {

    }

    @Override
    public void setView(LoginView loginView) {
        this.loginView = loginView;
    }


}
