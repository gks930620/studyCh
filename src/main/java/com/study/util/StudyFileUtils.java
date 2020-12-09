package com.study.util;

public class StudyFileUtils {
	
	public static String fancySize(long size) {
		
		if (size < 1024) {
			return size + " Bytes";
		} else if( size < 1024*1024) {
			return String.format("%,.2f KB", size/1024.0);
		} else if( size < 1024*1024*1024) {
			return String.format("%,.2f MB", size/(1024.0*1024));
		} else {
			return String.format("%,.2f GB", size/(1024.0*1024*1024));
		}
	}
}
