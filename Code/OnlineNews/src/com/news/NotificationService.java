package com.news;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jerome.news.R;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class NotificationService extends Service {
	public static final String NOTHING = "nothing";
	// 获取消息线程
	private MessageThread messageThread = null;
	private List<String> Plist = new ArrayList<String>();
	// 点击查看
	private Intent messageIntent = null;
	private PendingIntent messagePendingIntent = null;

	// 通知栏消息
	private int messageNotificationID = 1000;
	private Notification messageNotification = null;
	private NotificationManager messageNotificatioManager = null;

	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// 初始化
		messageNotification = new Notification();
		messageNotification.icon = R.drawable.ic_launcher;
		messageNotification.tickerText = "新消息";
		messageNotification.defaults = Notification.DEFAULT_SOUND;
		messageNotificatioManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		messageIntent = new Intent(this, Main.class);
		messagePendingIntent = PendingIntent.getActivity(this, 0,
				messageIntent, 0);

		// 开启线程
		messageThread = new MessageThread();
		messageThread.isRunning = true;
		messageThread.start();

		return super.onStartCommand(intent, flags, startId);
	}

	/**
	 * 从服务器端获取消息
	 * 
	 */
	class MessageThread extends Thread {
		// 设置是否循环推送
		public boolean isRunning = true;

		public void run() {
			// while (isRunning) {
			try {
				// 间隔时间

				Thread.sleep(1000);
				Plist.add(getNewsContentByUrl("http://172.16.0.1:8080/HttpServer/tsToUserServlet?username=liucong"));
				// 获取服务器消息"
				String serverMessage = getServerMessage();
				if (serverMessage != null && !"".equals(serverMessage)) {
					// 更新通知栏
					messageNotification.setLatestEventInfo(
							getApplicationContext(), "新闻头条", Plist.toString(),
							messagePendingIntent);
					messageNotificatioManager.notify(messageNotificationID,
							messageNotification);
					// 每次通知完，通知ID递增一下，避免消息覆盖掉
					messageNotificationID++;
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// }
		}
	}

	public static String getNewsContentByUrl(String url) {// 取新闻内容
		String result = "";
		try {
			Document doc = Jsoup.connect(url).get();

			Elements ListDiv = doc.select("TS");
			result = ListDiv.html().toString();
			String contentString = parserContent(result);
			result = contentString;
			if (contentString.trim().length() == 0) {
				result = NOTHING;
			}
		} catch (IOException e) {
			result = "-1";
			e.printStackTrace();
		}
		return result;
	}

	private static String parserContent(String content) {

		String reslut = "";

		content = "<html>" + content + "</html>";
		NodeFilter contentFilter = new TagNameFilter("html");
		try {
			Parser imgParser = new Parser();
			imgParser.setResource(content);
			NodeList imgList = imgParser
					.extractAllNodesThatMatch(contentFilter);

			reslut = imgList.asString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reslut;
	}

	@Override
	public void onDestroy() {
		// System.exit(0);
		messageThread.isRunning = false;
		super.onDestroy();
	}

	/**
	 * 模拟发送消息
	 * 
	 * @return 返回服务器要推送的消息，否则如果为空的话，不推送
	 */
	public String getServerMessage() {
		return "NEWS!";
	}
}