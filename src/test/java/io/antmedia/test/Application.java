package io.antmedia.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.antmedia.AntMediaApplicationAdapter;
import io.antmedia.muxer.IAntMediaStreamHandler;

public class Application extends AntMediaApplicationAdapter implements IAntMediaStreamHandler {

	public static List<String> id = new ArrayList<>();
	public static List<File> file = new ArrayList<>();
	public static List<Long> duration = new ArrayList<>();

	public static List<String> notifyHookAction = new ArrayList<>();
	public static List<String> notitfyURL = new ArrayList<>();
	public static List<String> notifyId = new ArrayList<>();
	public static List<String> notifyStreamName = new ArrayList<>();
	public static List<String> notifyCategory = new ArrayList<>();
	public static List<String> notifyVodName = new ArrayList<>();

	public static boolean enableSourceHealthUpdate = false;
	public static List<String> notifyVodId = new ArrayList<>();;
	

	
	@Override
	public void muxingFinished(String id, File file, long duration, int resolution) {
		super.muxingFinished(id, file, duration, resolution);
		Application.id.add(id);
		Application.file.add(file);
		Application.duration.add(duration);
	}

	public static void resetFields() {
		Application.id.clear();
		Application.file.clear();
		Application.duration.clear();
		notifyHookAction.clear();
		notitfyURL.clear();
		notifyId.clear();
		notifyStreamName.clear();
		notifyCategory.clear();
		notifyVodName.clear();

	}

	public StringBuilder notifyHook(String url, String id, String action, String streamName, String category,
			String vodName, String vodId) {
		logger.info("notify hook action: {}", action);
		notifyHookAction.add(action);
		notitfyURL.add(url);
		notifyId.add(id);
		notifyStreamName.add(streamName);
		notifyCategory.add(category);
		notifyVodName.add(vodName);
		notifyVodId.add(vodId);

		return null;
	}

	@Override
	public void setQualityParameters(String id, String quality, double speed, int pendingPacketSize) {
		if (enableSourceHealthUpdate) {
			super.setQualityParameters(id, quality, speed, pendingPacketSize);
		}
	}
	
}
