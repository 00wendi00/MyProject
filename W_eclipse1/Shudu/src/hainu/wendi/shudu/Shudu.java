package hainu.wendi.shudu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;

public class Shudu extends Activity {
	//GridLayout gridLayout1,gridLayout2;
	//String[] s = new String[81];
	/*//获取屏幕尺寸大小，是程序能在不同大小的手机上有更好的兼容性
	  WindowManager wm=(WindowManager)getBaseContext().getSystemService(Context.WINDOW_SERVICE);
	  @SuppressWarnings("deprecation")
	  long wwidth=wm.getDefaultDisplay().getWidth();//手机屏幕的宽度
	  long hheight=wm.getDefaultDisplay().getHeight();//手机屏幕的高度
*/	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shudu);
		
	}
}
