package com.timerchina.spider.MainTest;

import org.apache.log4j.Logger;

import com.timerchina.spider.bean.SpiderParams;
import com.timerchina.spider.bean.SpiderResult;
import com.timerchina.spider.factory.SpiderFactory;

/**
 * @author jason.lin@timerchina.com 2014-12-3 下午4:55:53
 *
 */
public class TestClient implements Runnable{

	@SuppressWarnings("unused")
	private int num;
	private Logger logger = Logger.getLogger(TestClient.class);
	
	public TestClient(int num){
		this.num = num;
	}
	
	static String[] url = {
//		"http://club.she.tom.com/forum_100_0_0_0_0.htm",
		"http://www.sina.com.cn",
		"http://www.weibo.com",
		"http://zc.qq.com/chs/index.html",
		"http://www.baidu.com",
		"http://www.sina.com.cn",
		"http://www.weibo.com",
		"http://zc.qq.com/chs/index.html",
		"http://www.baidu.com",
		"http://www.sina.com.cn",
		"http://www.weibo.com",
		"http://zc.qq.com/chs/index.html"
	};
	
	public static void main(String[] args) throws InterruptedException {
		while(true){
			for (int i = 0; i < 10; i++) {
				TestClient client = new TestClient(i%10);
				Thread thead = new Thread(client);
				thead.start();
//				client.run();
			}
			Thread.sleep(1500);
		}
//			NettyClient.stop();
		
	}

	public void run() {
		
		SpiderParams spiderParams = new SpiderParams();
		
//		spiderParams.setUrl(url[num]);
		
		spiderParams.setUrl("http://www.baidu.com");
		
		spiderParams.setLocal(false);
		
		spiderParams.setGzip(false);
		
//		spiderParams.setGzip(true);
		
		SpiderResult spiderResult = (SpiderResult) SpiderFactory.executeCaptain(spiderParams);
		
		
		
		
		
		if(spiderResult!=null && spiderResult.getHtml().length()>1000){
			
			logger.info("源码："+spiderResult.getHtml().substring(0,100));
			
			logger.info("状态码："+spiderResult.getResponseCode());
			
		}
		if(spiderResult!=null && spiderResult.getERRORMsg().length()>0){
			logger.info("状态码："+spiderResult.getERRORMsg());
		}
	}
}
