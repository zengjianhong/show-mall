package com.szhengzhu.util;

import cn.hutool.extra.ftp.Ftp;
import com.szhengzhu.config.FtpConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Jehon Zeng
 */
@Slf4j
public class ImageDownloader {

	private static final String USER_AGENT = "Mozilla/5.0 Firefox/26.0";
	private static final int TIMEOUT_SECONDS = 120;
	private static final int POOL_SIZE = 120;
	private static CloseableHttpClient httpclient;

//	public static void main(String[] args) throws ClientProtocolException,
//			IOException {
//
//		ImageDownloader imageDownloader = new ImageDownloader();
//		imageDownloader.initApacheHttpClient();
//
//		String imageUrl = "http://wx.qlogo.cn/mmopen/zRoA9FhaiaibtQDZsXohO8wTvXSk8bOuHlfRRyF875ugGzKe8uvluyESH29neMEGBhkah9H0uMK7mmdS6OM4Stf7PkXWaia84MC/0";
//		imageDownloader.fetchContent(imageUrl,
//				"/usr/javaApplication/test111.png");
//
//		imageDownloader.destroyApacheHttpClient();
//	}

	public void initApacheHttpClient() {
		RequestConfig defaultRequestConfig = RequestConfig.custom()
				.setSocketTimeout(TIMEOUT_SECONDS * 1000)
				.setConnectTimeout(TIMEOUT_SECONDS * 1000).build();
		httpclient = HttpClients.custom().setUserAgent(USER_AGENT)
				.setMaxConnTotal(POOL_SIZE).setMaxConnPerRoute(POOL_SIZE)
				.setDefaultRequestConfig(defaultRequestConfig).build();
	}

	public void destroyApacheHttpClient() {
		try {
			httpclient.close();
		} catch (IOException e) {
			log.error("httpclient close fail", e);
		}
	}

	public void fetchContent(String imageUrl, String filePath, String fileName, FtpConfig ftpConfig)
			throws IOException {

		HttpGet httpget = new HttpGet(imageUrl);
		httpget.setHeader(
				"User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.79 Safari/537.1");
		httpget.setHeader("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		CloseableHttpResponse response = httpclient.execute(httpget);

		try {
			HttpEntity entity = response.getEntity();

			if (response.getStatusLine().getStatusCode() >= 400) {
				throw new IOException("Got bad response, error code = "
						+ response.getStatusLine().getStatusCode()
						+ " imageUrl: " + imageUrl);
			}
			if (entity != null) {
				InputStream input = entity.getContent();
				Ftp ftp = new Ftp(ftpConfig.getHostname(), ftpConfig.getPort(), ftpConfig.getUsername(), ftpConfig.getPassword());
				ftp.upload(ftpConfig.getBasePath() + filePath, fileName, input);
//				boolean result = FtpUtils.uploadFile(ftpServer, filePath, fileName, input);
//				OutputStream output = new FileOutputStream(new File(filePath));
//				IOUtils.copy(input, output);
//				output.flush();
			}
		} finally {
			response.close();
		}

	}
}
