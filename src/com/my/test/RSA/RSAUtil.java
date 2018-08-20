package com.my.test.RSA;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.UUID;

import javax.crypto.Cipher;

/**
 * 
 * @author carson
 *
 */
public class RSAUtil {
	/** 
	 * 2048位秘钥可加密的245个字节(81个汉字)的数据
	 */
	private static String PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCq1wnHO0mT2q5Y4EaZm+qEv0Q294CIsErz4P0aIysivhyfU1NGf3USezMp3XmjurEqQi1CNeuuJT+zA9VFhfvnSZsqGiZ3MgNz21Bbt7LNrjoP7H0s4qpKocFnMOpBZDGmP4QZo28WKVq65wz4cRGOH+rxlnM76THD05DLI6/rOmYJglRwnXEsDDzDOwcjoBPzeXqtMg/9rFEWfbzMmPbSSEOM69y5s6OmJXDGbDwiQvbHP1i7tzGmL6ybc2j8TQ9Ro4fsrzzirr2HFoFxORKvzubk4RB0+VfW6d0nP7QAfzm1Z2qKO0bEb5bC8KYxN4r3hCChOmkh2ns9cfaNUOdJAgMBAAECggEAGBQo76i+jRVUX3h02u+r1Tv0DF9EAX//gHIkmkt8p+/trtMauKP8RzeQFYV+wIHuuIsNP/jDmA7t9HhE1gC1aXrpYLzA0Sn+bJTrtZGlpPG6g0YMuofUAqLb1ISDb+YETW9EWiy72n7Hp/Iq1NVy6Po8rgJLiZUri3NFRCxqfhfJFVH05r18k+JpX3B8kQ37PfKmOeho18WANw94PrOgVx18U4Pr090VVCUr7OaJbyZhPRDhiA8a1SoYcydH6EoY77HQS2qMLdkTDzrEf5CJ7aYrzTw96hR8+zzDrC58lIgNEZ3DS/bIomKzQuNAtdx6nhC5EGWLsW/BdGggz5HsJQKBgQDVVMzrVN0TjegGEZEXBJwoidriilI0xrF2GBADJKcbnzAFgsraLXhI0LIHLNSsFAn1Zh/LG7Ck1DkTh9cOxcSEgEfbvaeQyy4fXYR7cSJEafD3fiyWcP9MZrQdKD2d6dNUw5qJWt8vp+a7kXdreH2zLOUzsDoVIQ/Y+aRWzJFCdwKBgQDNAo7TX+stDSqi5WIZ+6Lh6I41yg8k9VeWxcnlRivObijNrzfWWVKTCGBe31ZB/fywBkySq7syb3CUqb+TdKRHQVwdx5Nde28wGWPNkG0DJa//4VAzcfcFp1BNl3Y+sKLtBMocTtBH97hlh0OHkjKG4J3lgrU4ETbAafM6DHHUPwKBgGnFp+yuoQaG/5mysAuHn52B7GMSTfwY3/g7qgTE8Y4CeZ7h4I4YqWEBCKQCGFhRfzaLMgxUaFrxVnNWkMykRfGkYPyUpjZmZzHp/jvuNh1RocY0awsUb6CD853ZS+O2AbAvY7nisnJAf2hUka9ZiImEIwhjwgij4eWksVTQDN21AoGBAKOqRxu4l6d/u2oQdiEIIyD255FJno2C0Eot3OCNBKvohequ14ToCmQXa9hRtCs6+WANp1PwhaHeFaKZYbf2hq/cHg4oJh2bTUi4/FQ/2MeKbtd4qO5pLSv2RsWrBVtG6MsP58pxoRXTTgK/2cmBjZTf/S4dC0+Xbn5uFx9gj/9BAoGAEtL+zUo/nojnNnOFETAiek4svT50XyPWbCLqvGwVTDHHIuIVMPQ2QkjtoRqHoNFXnowVGTxPtgYOhswIS2wPmGN+2vskUsjCzGDIl1Kk7e2R0lJF2WTN33R8Zz9Fk6hIaZslAcTd1OsEQKwy/9/qrDc5fM8e9AK536tfjs+XFu4=";

	private static String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqtcJxztJk9quWOBGmZvqhL9ENveAiLBK8+D9GiMrIr4cn1NTRn91EnszKd15o7qxKkItQjXrriU/swPVRYX750mbKhomdzIDc9tQW7eyza46D+x9LOKqSqHBZzDqQWQxpj+EGaNvFilauucM+HERjh/q8ZZzO+kxw9OQyyOv6zpmCYJUcJ1xLAw8wzsHI6AT83l6rTIP/axRFn28zJj20khDjOvcubOjpiVwxmw8IkL2xz9Yu7cxpi+sm3No/E0PUaOH7K884q69hxaBcTkSr87m5OEQdPlX1undJz+0AH85tWdqijtGxG+WwvCmMTeK94QgoTppIdp7PXH2jVDnSQIDAQAB";

	public static String ENCODE = "UTF-8";
	/**
	 * 签名算法
	 */
	public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

	public static void main(String[] args) throws Exception {
		KeyPair keyPair = genKeyPair(1024);
		PublicKey publicKey = keyPair.getPublic();
		PUBLIC_KEY = new String(Base64.getEncoder().encode(publicKey.getEncoded()));
		System.out.println("public key\t" + PUBLIC_KEY);
		PrivateKey privateKey = keyPair.getPrivate();
		PRIVATE_KEY = new String(Base64.getEncoder().encode(privateKey.getEncoded()));
		System.out.println("private key\t" + PRIVATE_KEY);
		String testData = UUID.randomUUID().toString();
		System.out.println("content\t\t" + testData);
		String ciphertext = encrypt(testData);
		String plaintext = decrypt(ciphertext);
		System.out.println("ciphertext\t" + ciphertext);
		System.out.println("plaintext\t" + plaintext);
	}

	/**
	 * 将base64编码后的公钥字符串转成PublicKey实例
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public static PublicKey getPublicKey(String publicKey) throws Exception {
		byte[] keyBytes = Base64.getDecoder().decode(publicKey.getBytes());
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePublic(keySpec);
	}
 
	/**
	 * 将base64编码后的私钥字符串转成PrivateKey实例
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static PrivateKey getPrivateKey(String privateKey) throws Exception {
		byte[] keyBytes = Base64.getDecoder().decode(privateKey.getBytes());
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePrivate(keySpec);
	}

	// 公钥加密
	public static byte[] encrypt(byte[] content, PublicKey publicKey) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");// java默认"RSA"="RSA/ECB/PKCS1Padding"
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return cipher.doFinal(content);
	}

	/**
	 * 使用私钥加密
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String content) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");// java默认"RSA"="RSA/ECB/PKCS1Padding"
		// cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(PUBLIC_KEY));
//		cipher.init(Cipher.ENCRYPT_MODE, getPrivateKey(PRIVATE_KEY));
		cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(PUBLIC_KEY));
		return new String(Base64.getEncoder().encode(cipher.doFinal(content.getBytes())));
	}

	/**
	 * 使用公钥解密
	 * 
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String content) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
//		cipher.init(Cipher.DECRYPT_MODE, getPublicKey(PUBLIC_KEY));
		cipher.init(Cipher.DECRYPT_MODE, getPrivateKey(PRIVATE_KEY));
		return new String(cipher.doFinal(Base64.getDecoder().decode(content)));
	}

	// 私钥解密
	public static byte[] decrypt(byte[] content, PrivateKey privateKey) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		return cipher.doFinal(content);
	}

	/**
	 * 签名
	 * 
	 * @param content
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] sign(String content, String privateKey) throws Exception {
		PrivateKey priKey = getPrivateKey(privateKey);
		Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
		signature.initSign(priKey);
		signature.update(content.getBytes());
		byte[] signed = signature.sign();
		return Base64.getEncoder().encode(signed);
	}

	/**
	 * RSA验签名检查
	 * 
	 * @param content
	 *            待签名数据
	 * @param sign
	 *            签名值
	 * @param publicKey
	 *            分配给开发商公钥
	 * @param encode
	 *            字符集编码
	 * @return 布尔值
	 */
	public static boolean doCheck(String content, String sign, String publicKey, String encode) {
		try {
			PublicKey pubKey = getPublicKey(publicKey);

			Signature signature = Signature.getInstance(SIGN_ALGORITHMS);

			signature.initVerify(pubKey);
			signature.update(content.getBytes(encode));

			boolean bverify = signature.verify(Base64.getDecoder().decode(sign));
			return bverify;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
 
	/**
	 * 生成密钥对
	 * @param keyLength
	 * @return
	 * @throws Exception
	 */
	public static KeyPair genKeyPair(int keyLength) throws Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(keyLength);
		return keyPairGenerator.generateKeyPair();
	}

}