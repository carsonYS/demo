package com.my.test.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpUtils {
	
	
	//Cookie: wx_577576_noId=752ebTEfSTMUwPmsaWH%2FOp40DFJzPhlAIx%2FcV4ubWLJ2R1U%2BVbMKgEZ16fmNbQ; wx_577576_fwopenid=oVBPm1XwAz4FYbhc8RooKWn5oawo; wx_577576_fw_j=46b7H%2FzOjB%2F0izIWfg6Hxf2wXJPb%2FPJFf4xVWVntIBaJLxirNwfaWrd5jj%2Ft%2FN98hhRRPNNA0fKpEA; wx_577576_mt_j=7b30zYI7HbQKUAW2lrtGzTD0otRNzQvPeFDdkvprnTGTVpBfxw; Hm_lvt_1ebb21b9145c3ff2459b7a03366008a7=1533974170; Hm_lpvt_1ebb21b9145c3ff2459b7a03366008a7=1533975711

	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url_ = "https://s1.eqxiu.com/eqs/scene/count?code=rINA5si8";
		URL url__ = new URL(url_);
		URLConnection conn_ = url__.openConnection();
		conn_.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		conn_.setRequestProperty("Accept-Encoding", "gzip, deflate");
		conn_.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
		conn_.setRequestProperty("Cache-Control", "no-cache");
		conn_.setRequestProperty("Host", "w011.sd44.cn");
		conn_.setRequestProperty("Pragma", "no-cache");
		conn_.setRequestProperty("Proxy-Connection", "keep-alive");
		conn_.setRequestProperty("Upgrade-Insecure-Requests", "1");
		conn_.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Mobile Safari/537.36");
		 Map<String, List<String>> map = conn_.getHeaderFields();
		
		 for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//             System.out.println("Key : " + entry.getKey() + 
//                     " ,Value : " + entry.getValue());
         }
		
		conn_.getHeaderField("Set-Cookie");
//		System.out.println(conn_.getHeaderField("Set-Cookie"));
		
		
		
		
		
		
		
		String urlPath = "https://s1.eqxiu.com/eqs/scene/count?code=rINA5si8";
//		String openid = "oVBPm1XwAz4FYbhc8RooKWn5oawo";
		String openid = "oNXAU0xMJAjb7xaorEKYiaCeJLhk";
		String noId = "752ebTEfSTMUwPmsaWH%2FOp40DFJzPhlAIx%2FcV4ubWLJ2R1U%2BVbMKgEZ16fmNbQ";
		//String noId = "9dc968ak51UeSIZ%2B5X66NEtn5KdwtkAmcsqxCGnoolAUkbKakrg6XwJoX0kpPQ";
		
		String cookie = "";
		
		String param = "sceneId=132820174&elementId=5288025341&pageId=1222970813";
		URL url = new URL(urlPath);
		URLConnection conn = url.openConnection();
		conn.setRequestProperty("Accept", "*/*");
		conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
//		conn.setRequestProperty("Cookie", cookie);
		conn.setRequestProperty("Accept-Language", "zh-CN,en-US;q=0.8");
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 8.0; ALP-AL00 Build/HUAWEIALP-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/48.0.2564.116 Mobile Safari/537.36 T7/10.10 baiduboxapp/10.10.0.12 (Baidu; P1 8.0.0)");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		conn.setRequestProperty("Referer", "https://h.eqxiu.com/s/rINA5si8?eqrcode=1&amp;share_level=6&amp;from_user=ee53baed-c38d-4781-94f1-b24054600e58&amp;from_id=5732cd17-1fb9-40ed-a513-e65ecf38ad06&amp;share_time=1534401023005&amp;from=timeline&amp;isappinstalled=0");
//		conn.setRequestProperty("vote-id", "324");
//		conn.setRequestProperty("vote-version", "2.3");
		conn.setRequestProperty("Connection", "keep-alive");
		conn.setRequestProperty("Origin", "https://h.eqxiu.com");
		conn.setRequestProperty("Host", "s1.eqxiu.com");
		
		// Content-Type: application/x-www-form-urlencoded
		conn.setDoOutput(true);
        conn.setDoInput(true);
        
        PrintWriter out = new PrintWriter(conn.getOutputStream());
        out.print(param);
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
		    sb.append(line);
		}
		String result = sb.toString();
		
		System.out.println(result);
//		System.out.println(new String(result.getBytes(""), "UTF-8"));

		
	}
}
