package org.tio.im.common.ws;

import java.util.List;

import org.tio.im.common.ImSessionContext;
import org.tio.im.common.http.HttpRequest;
import org.tio.im.common.http.HttpResponse;
import org.tio.monitor.RateLimiterWrap;

/**
 *
 * @author tanyaowu
 *
 */
public class WsSessionContext extends ImSessionContext {
	/**
	 * @param args
	 *
	 * @author tanyaowu
	 * 2017年2月21日 上午10:27:54
	 *
	 */
	public static void main(String[] args) {

	}

	/**
	 * 消息请求频率控制器
	 */
	private RateLimiterWrap requestRateLimiter = null;

	/**
	 * 是否已经握过手
	 */
	private boolean isHandshaked = false;

	/**
	 * websocket 握手请求包
	 */
	private HttpRequest handshakeRequestPacket = null;

	/**
	 * websocket 握手响应包
	 */
	private HttpResponse handshakeResponsePacket = null;

	private String token = null;

	//websocket 协议用到的，有时候数据包是分几个到的，注意那个fin字段，本im暂时不支持
	private List<byte[]> lastParts = null;

	/**
	 *
	 *
	 * @author tanyaowu
	 * 2017年2月21日 上午10:27:54
	 *
	 */
	public WsSessionContext() {

	}

	/**
	 * @return the httpHandshakePacket
	 */
	public HttpRequest getHandshakeRequestPacket() {
		return handshakeRequestPacket;
	}

	/**
	 * @return the handshakeResponsePacket
	 */
	public HttpResponse getHandshakeResponsePacket() {
		return handshakeResponsePacket;
	}

	/**
	 * @return the lastPart
	 */
	public List<byte[]> getLastParts() {
		return lastParts;
	}

	/**
	 * @return the requestRateLimiter
	 */
	public RateLimiterWrap getRequestRateLimiter() {
		return requestRateLimiter;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @return the isHandshaked
	 */
	public boolean isHandshaked() {
		return isHandshaked;
	}

	/**
	 * @param isHandshaked the isHandshaked to set
	 */
	public void setHandshaked(boolean isHandshaked) {
		this.isHandshaked = isHandshaked;
	}

	/**
	 * @param httpHandshakePacket the httpHandshakePacket to set
	 */
	public void setHandshakeRequestPacket(HttpRequest handshakeRequestPacket) {
		this.handshakeRequestPacket = handshakeRequestPacket;
	}

	/**
	 * @param handshakeResponsePacket the handshakeResponsePacket to set
	 */
	public void setHandshakeResponsePacket(HttpResponse handshakeResponsePacket) {
		this.handshakeResponsePacket = handshakeResponsePacket;
	}

	/**
	 * @param lastParts the lastPart to set
	 */
	public void setLastParts(List<byte[]> lastParts) {
		this.lastParts = lastParts;
	}

	/**
	 * @param requestRateLimiter the requestRateLimiter to set
	 */
	public void setRequestRateLimiter(RateLimiterWrap requestRateLimiter) {
		this.requestRateLimiter = requestRateLimiter;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

}
