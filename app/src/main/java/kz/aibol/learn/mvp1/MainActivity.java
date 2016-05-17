package kz.aibol.learn.mvp1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.MvpActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kz.aibol.learn.mvp1.mvp.HelloWorldPresenter;
import kz.aibol.learn.mvp1.mvp.HelloWorldView;

public class MainActivity extends MvpActivity<HelloWorldView, HelloWorldPresenter> implements HelloWorldView{


    @Bind(R.id.greetingTextView)
    TextView greetingTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @NonNull
    @Override
    public HelloWorldPresenter createPresenter() {
        return new HelloWorldPresenter();
    }

    @OnClick(R.id.helloButton) void onHelloButtonClicked() {
        Log.d("ClickEvent", "Hello");
        presenter.greetHello();
    }

    @OnClick(R.id.goodbyeButton) void onGoodbyeButtonClicked() {
        Log.d("ClickEvent", "Goodbye");
        presenter.greetGoodbye();
    }


    @Override
    public void showHello(String greetingText) {
        greetingTextView.setTextColor(Color.RED);
        greetingTextView.setText(greetingText);
    }

    @Override
    public void showGoodbye(String greetingText) {
        greetingTextView.setTextColor(Color.BLUE);
        greetingTextView.setText(greetingText);
    }
}
