package org.crazyit.uiProject2_4_3;

import android.os.Bundle;
import android.widget.QuickContactBadge;
import android.app.Activity;

public class QuickContactBadgeTest extends Activity 
{
	QuickContactBadge badge;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // 获取QuickContactBadge组件
        badge = (QuickContactBadge) findViewById(R.id.badge);
        // 将QuickContactBadge组件与特定电话号码对应的联系人建立关联
        badge.assignContactFromPhone("15595967595", false);
    }
}
