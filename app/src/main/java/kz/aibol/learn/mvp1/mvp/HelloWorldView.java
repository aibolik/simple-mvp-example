package kz.aibol.learn.mvp1.mvp;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by aibol on 5/10/16.
 */

// View Interface
public interface HelloWorldView extends MvpView {

    // displays "Hello" greeting text in red text color
    void showHello(String greetingText);

    // displays "Goodbye" greeting text in blue text color
    void showGoodbye(String greetingText);

}
