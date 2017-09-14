package com.voole.trdpay.util.rsa;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @ClassName: RSACoder
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年7月20日 下午4:53:56
 * 
 */
public class RSASecurityUtil {
	private static final String KEY_ALGORITHM = "RSA";
	private static final int KEY_SIZE = 512;
	private static final int ENCRYPT_BlOCK_SIZE = KEY_SIZE / 8 - 11;
	private static final int DECRYPT_BLOCK_SIZE = KEY_SIZE / 8;

	public static KeyPair getKeyPair() throws Exception {
		KeyPairGenerator kpGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
		kpGenerator.initialize(KEY_SIZE);
		KeyPair keyPair = kpGenerator.generateKeyPair();
		return keyPair;
	}

	/**
	 * 加密
	 * 
	 * @param encryptStr
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String encryptStr, String publicKey) throws Exception {
		byte[] publicKeyBytes = Base64.getDecoder().decode(publicKey);
		byte[] encryptBytes = encryptStr.getBytes("UTF-8");

		if (encryptBytes.length <= ENCRYPT_BlOCK_SIZE) {
			return Base64.getEncoder().encodeToString(encrypt(encryptBytes, publicKeyBytes));
		} else {
			byte[] buffer = null;
			byte[] blockBytes = new byte[ENCRYPT_BlOCK_SIZE];

			int index = ((encryptBytes.length - 1) / ENCRYPT_BlOCK_SIZE) + 1;

			for (int i = 0; i < index; i++) {
				if (i == (index - 1)) {
					blockBytes = new byte[ENCRYPT_BlOCK_SIZE];
				}
				int startIndex = i * ENCRYPT_BlOCK_SIZE;
				int endIndex = startIndex + ENCRYPT_BlOCK_SIZE;
				blockBytes = ArrayUtils.subarray(encryptBytes, startIndex, endIndex);
				if (buffer == null) {
					buffer = encrypt(blockBytes, publicKeyBytes);
				} else {
					buffer = ArrayUtils.addAll(buffer, encrypt(blockBytes, publicKeyBytes));
				}

			}
			return Base64.getEncoder().encodeToString(buffer);
		}
	}

	/**
	 * 解密
	 * 
	 * @param decryptStr
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String decryptStr, String privateKey) throws Exception {
		byte[] privateKeyBytes = Base64.getDecoder().decode(privateKey);

		byte[] decryptBytes = Base64.getDecoder().decode(decryptStr);

		if (decryptBytes.length <= DECRYPT_BLOCK_SIZE) {
			return new String(decrypt(decryptBytes, privateKeyBytes), "UTF-8");
		} else {
			byte[] buffer = null;

			int index = ((decryptBytes.length - 1) / DECRYPT_BLOCK_SIZE) + 1;
			byte[] blockBytes = new byte[DECRYPT_BLOCK_SIZE];
			for (int i = 0; i < index; i++) {
				if (i == index - 1) {
					blockBytes = new byte[DECRYPT_BLOCK_SIZE];
				}
				int startIndex = i * DECRYPT_BLOCK_SIZE;
				int endIndex = startIndex + DECRYPT_BLOCK_SIZE;
				blockBytes = ArrayUtils.subarray(decryptBytes, startIndex,
						endIndex > decryptBytes.length ? decryptBytes.length : endIndex);
				if (buffer == null) {
					buffer = decrypt(blockBytes, privateKeyBytes);
				} else {
					buffer = ArrayUtils.addAll(buffer, decrypt(blockBytes, privateKeyBytes));
				}
			}
			return new String(buffer, "UTF-8");
		}
	}

	/**
	 * 加密
	 * 
	 * @param encryptStr
	 * @param publicKeyBytes
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] encryptBytes, byte[] publicKeyBytes) throws Exception {
		PublicKey publicKey = RSASecurityUtil.codeToPublicKey(publicKeyBytes);

		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] enBytes = cipher.doFinal(encryptBytes);
		return enBytes;
	}

	/**
	 * 解密
	 * 
	 * @param decryptStr
	 * @param privateKeyBytes
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] decrypt, byte[] privateKeyBytes) throws Exception {
		PrivateKey privateKey = RSASecurityUtil.codeToPrivateKey(privateKeyBytes);

		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] resultBytes = cipher.doFinal(decrypt);
		return resultBytes;
	}

	/**
	 * 解密
	 * 
	 * @param dncrypteStr
	 * @param privateKeyBytes
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String decryptStr, byte[] privateKeyBytes) throws Exception {
		PrivateKey privateKey = RSASecurityUtil.codeToPrivateKey(privateKeyBytes);
		// 加密/解密算法/工作模式/填充方式
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] decryptBytes = Base64.getDecoder().decode(decryptStr);
		byte[] resultBytes = cipher.doFinal(decryptBytes);
		return new String(resultBytes, "UTF-8");
	}

	public static PrivateKey codeToPrivateKey(String privateKeyStr) throws Exception {
		byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyStr);
		// PKCS#8：描述私有密钥信息格式，该信息包括公开密钥算法的私有密钥以及可选的属性集等。
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PrivateKey keyPrivate = keyFactory.generatePrivate(keySpec);
		return keyPrivate;
	}

	public static PublicKey codeToPublicKey(byte[] publicKey) throws Exception {
		// x.509,是x500那套网络协议（好像是目录协议吧）的一个子集，专门定义了在目录访问中需要身份认证的证书的格式。
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		return keyFactory.generatePublic(keySpec);
	}

	public static PrivateKey codeToPrivateKey(byte[] privateKey) throws Exception {
		// PKCS#8：描述私有密钥信息格式，该信息包括公开密钥算法的私有密钥以及可选的属性集等。
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PrivateKey keyPrivate = keyFactory.generatePrivate(keySpec);
		return keyPrivate;
	}

	public static void main(String[] args) throws Exception {
		KeyPair keyPair = RSASecurityUtil.getKeyPair();
		String pub = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
		String pri = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());

		pri = "MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAgtRWPZdFZQaZUxfvix+Oc8yjBpnkvnAftHZZLiXGTFHwaJpce9TFXtjJBxfEKvzRCKmgmC6BdneH+wq7UMDm8QIDAQABAkBGmRiUkd2zn3T7fu4XsAap/GJ4vHDQRycEtdx355BzO/e2TmPId6MQx72f1tg3omWVwD1R7ZBLa+j6NtO7gbfFAiEA2atxI5YC3dFlUo9wbVhWZ+JioXZ7ftw0ZAnGdq8ljSsCIQCZ3iIMR2GiWL1RODd6RmazVOV9US3qgxFTzfFZG39mUwIgOeyFjxK8cIroi6/gGzkGxV5ZIN6Gvpua1YREbBDvzUECIGRD3ggGU9cI4IUWjwA89BuUDN92kOcqdZYYs1cPlhtFAiBZREsgSDsxnJXxUe0Aw6JutsxNCgaxcnti+iBAU9i1VA==";
		pub = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAILUVj2XRWUGmVMX74sfjnPMowaZ5L5wH7R2WS4lxkxR8GiaXHvUxV7YyQcXxCr80QipoJgugXZ3h/sKu1DA5vECAwEAAQ==";
		System.out.println("公钥：" + pub);
		System.out.println("私钥：" + pri);

		String string = "{\"oemid\":\"100232\",\"hid\":\"88cc4589b5ab0000000000000000000000000000\",\"uid\":\"199394406\",\"order_name\":\"《战狼2》\",\"order_type\":\"1\",\"amt\":\"000000000001\",\"chcd\":\"WXP\"}";
		String jiami = RSASecurityUtil.encrypt(string, pub);
		System.out.println("加密串:" + jiami);
		String jiemi = RSASecurityUtil.decrypt(jiami, pri);
		System.out.println("解密串:" + jiemi);
	}
}
