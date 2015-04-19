package com.example.music.modle;

import java.util.ArrayList;
import java.util.List;

import android.text.TextUtils;
import android.util.Log;
/**
 * 每行歌词的实体类，实现了Comparable接口，方便List<LrcRow>的sort排序
 * @author Ligang  2014/8/19
 *
 */
public class LrcRow implements Comparable<LrcRow>{

	/**�?始时�? �?00:10:00***/
	private String timeStr;
	/**�?始时�? 毫米�?  00:10:00  �?10000**/
	private int time;
	/**歌词内容**/
	private String content;
	/**该行歌词显示的�?�时�?**/
	private int totalTime;
	
	public long getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	public String getTimeStr() {
		return timeStr;
	}
	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public LrcRow() {
		super();
	}
	public LrcRow(String timeStr, int time, String content) {
		super();
		this.timeStr = timeStr;
		this.time = time;
		this.content = content;
	}
	/**
	 * 将歌词文件中的某�?�? 解析成一个List<LrcRow> 
	 * 因为�?行中可能包含了多个LrcRow对象
	 * 比如  [03:33.02][00:36.37]当鸽子不再象征和�?  ，就包含�?2个对�?
	 * @param lrcLine
	 * @return
	 */
	public static final List<LrcRow> createRows(String lrcLine){
		if(!lrcLine.startsWith("[") || lrcLine.indexOf("]") != 9){
			return null;
		}
		//�?后一�?"]" 
		int lastIndexOfRightBracket = lrcLine.lastIndexOf("]");
		//歌词内容
		String content = lrcLine.substring(lastIndexOfRightBracket+1, lrcLine.length());
		//截取出歌词时间，并将"[" �?"]" 替换�?"-"   [offset:0]
		System.out.println("lrcLine="+lrcLine);
		// -03:33.02--00:36.37-
		String times = lrcLine.substring(0, lastIndexOfRightBracket+1).replace("[", "-").replace("]", "-");
		String[] timesArray = times.split("-");
		List<LrcRow> lrcRows = new ArrayList<LrcRow>();
		for (String tem : timesArray) {
			if(TextUtils.isEmpty(tem.trim())){
				continue;
			}
			//
			try{
				LrcRow lrcRow = new LrcRow(tem, formatTime(tem), content);
				lrcRows.add(lrcRow);
			}catch(Exception e){
				Log.w("LrcRow", e.getMessage());
			}
		}
		return lrcRows;
	}
	/****
	 * 把歌词时间转换为毫秒�?  �? �?00:10.00  转为10000
	 * @param tem
	 * @return
	 */
	private static int formatTime(String timeStr) {
		timeStr = timeStr.replace('.', ':');
		String[] times = timeStr.split(":");

		return Integer.parseInt(times[0])*60*1000
				+ Integer.parseInt(times[1])*1000 
				+ Integer.parseInt(times[2]);
	}
	@Override
	public int compareTo(LrcRow anotherLrcRow) {
		return (int) (this.time - anotherLrcRow.time);
	}
	@Override
	public String toString() {
		return "LrcRow [timeStr=" + timeStr + ", time=" + time + ", content="
				+ content + "]";
	} 


}
