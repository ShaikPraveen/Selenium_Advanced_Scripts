package com.handling.encoding.password;

import org.apache.commons.codec.binary.Base64;

public class Handling_Encode_And_Decode 
{
	public static void main(String[] args)
	{
		String s="123456";
		
		//Encoding
		byte[] encodedstring = Base64.encodeBase64(s.getBytes());
		//Converting bytes to String Format
		System.out.println("ENCODED VALUE IS  "+new String(encodedstring));
		
		//Decoding
		byte[] decodedstring = Base64.decodeBase64(encodedstring);
		System.out.println("DECODED VALUE IS  "+new String(decodedstring));	
	}
}
