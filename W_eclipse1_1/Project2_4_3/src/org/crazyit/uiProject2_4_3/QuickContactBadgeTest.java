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
        // ��ȡQuickContactBadge���
        badge = (QuickContactBadge) findViewById(R.id.badge);
        // ��QuickContactBadge������ض��绰�����Ӧ����ϵ�˽�������
        badge.assignContactFromPhone("15595967595", false);
    }
}
