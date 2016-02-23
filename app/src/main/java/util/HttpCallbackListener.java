package util;

/**
 * Created by Keen on 02/22/2016.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
