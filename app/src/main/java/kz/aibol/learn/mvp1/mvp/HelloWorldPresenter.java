package kz.aibol.learn.mvp1.mvp;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import kz.aibol.learn.mvp1.GreetingGeneratorTask;

/**
 * Created by aibol on 5/10/16.
 */

// The presenter that coordinates HelloWorldView and business logic (GreetingGeneratorTask)
public class HelloWorldPresenter extends MvpBasePresenter<HelloWorldView> {

    private GreetingGeneratorTask greetingTask;

    private void cancelGreetingTaskIfRunning() {
        if (greetingTask != null) {
            greetingTask.cancel(true);
        }
    }

    public void greetHello() {
        cancelGreetingTaskIfRunning();

        greetingTask = new GreetingGeneratorTask("Hello",
                new GreetingGeneratorTask.GreetingTaskListener() {
                    @Override
                    public void onGreetingGenerated(String greetingText) {
                        if (isViewAttached()) {
                            getView().showHello(greetingText);
                        }
                    }
                });
        greetingTask.execute();
    }

    public void greetGoodbye() {
        cancelGreetingTaskIfRunning();

        greetingTask = new GreetingGeneratorTask("Goodbye",
                new GreetingGeneratorTask.GreetingTaskListener() {
                    @Override
                    public void onGreetingGenerated(String greetingText) {
                        if (isViewAttached()) {
                            getView().showGoodbye(greetingText);
                        }
                    }
                });
        greetingTask.execute();
    }

    // Called when Activity gets destroyed, so cancel running background task
    public void detachView(boolean retainPresenterInstance){
        super.detachView(retainPresenterInstance);
        if (!retainPresenterInstance){
            cancelGreetingTaskIfRunning();
        }
    }


}
