package agiletool.msc.bme.hu.agiletoolandroidclient.helper;

import android.support.annotation.Nullable;
import android.util.Log;

public class MyLogger {
    public static void logme(){
        logme(null,null);
    }

    public static void logme(@Nullable String tag, @Nullable String msg){
        if(tag == null || tag.equals("")){
            tag = "EMAKAZI";
        }
        if(msg == null || msg.equals("")){
            msg = "";
            for (StackTraceElement item :
                    Thread.currentThread().getStackTrace()) {
                msg = msg.concat("\n " + item.toString());
            }
        }
        Log.wtf(tag,msg);
    }
}
