package nguyenvankhanh.b1304491.ctu.socialsharing;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button shareFacebook;
    Button shareTwitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shareFacebook = (Button) findViewById(R.id.share_facebook);
        shareTwitter = (Button) findViewById(R.id.share_twitter);
        shareFacebook.setOnClickListener(this);
        shareTwitter.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.share_facebook:
                /*Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Content to share");
                PackageManager pm = v.getContext().getPackageManager();
                List<ResolveInfo> activityList = pm.queryIntentActivities(shareIntent, 0);
                for (final ResolveInfo app : activityList) {
                    if ((app.activityInfo.name).contains("facebook") && (app.activityInfo.name).contains("composer")) {
                        final ActivityInfo activity = app.activityInfo;
                        final ComponentName name = new ComponentName(activity.applicationInfo.packageName, activity.name);
                        //shareIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                        //shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |             Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                        shareIntent.setComponent(name);
                        this.startActivity(shareIntent);
                        break;
                    }
                }*/
                if(doShare("facebook")){
                    Toast.makeText(this, "Comple" , Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(this, "Don't find do app in device" , Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.share_twitter:
                if(doShare("twitter")){
                    Toast.makeText(this, "Comple" , Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(this, "Don't find do app in device" , Toast.LENGTH_LONG).show();
                }
                /*Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.facebook.katana",
                        "com.facebook.composer.shareintent.ImplicitShareIntentHandlerDefaultAlias"));
                intent.putExtra(Intent.EXTRA_TEXT, "add");
                this.startActivity(intent);*/
                break;
        }
    }

    private boolean doShare(String appName){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "#Eesty");


        PackageManager pm = this.getBaseContext().getPackageManager();
        List<ResolveInfo> activityList = pm.queryIntentActivities(intent, 0);
        for (final ResolveInfo app : activityList) {
            if ((app.activityInfo.name).contains(appName) && (app.activityInfo.name).contains("composer")) {
                ActivityInfo activity = app.activityInfo;
                intent.setComponent(new ComponentName(activity.applicationInfo.packageName, activity.name));
                this.startActivity(intent);
                return true;
            }
        }
        return false;
    }
}
