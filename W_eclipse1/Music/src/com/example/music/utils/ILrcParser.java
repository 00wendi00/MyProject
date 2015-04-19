package com.example.music.utils;

import java.util.List;

import com.example.music.modle.LrcRow;

/**
 * 歌词解析�?
 * @author Ligang  2014/8/19
 *
 */
public interface ILrcParser {

	List<LrcRow> getLrcRows(String str);
}
