package com.wiseasy.pds.security;


/**
 * <p>
 * Title: HouJUtil
 * </p>

 * @author houj
 * @version 1.0
 */
public class Base64{
	private Base64() {
	}

	static public String encodeToString(byte[] data) {
		return new String(encode(data));
	}

	static public char[] encode(byte[] data) {
		char[] out = new char[((data.length + 2) / 3) * 4];
		char[] alphabet = Base64.alphabet;
		for(int i = 0,index = 0; i < data.length; i += 3,index += 4){
			boolean quad = false;
			boolean trip = false;

			int val = (0xFF & (int)data[i]);
			val <<= 8;
			if((i + 1) < data.length){
				val |= (0xFF & (int)data[i + 1]);
				trip = true;
			}
			val <<= 8;
			if((i + 2) < data.length){
				val |= (0xFF & (int)data[i + 2]);
				quad = true;
			}
			out[index + 3] = alphabet[(quad ? (val & 0x3F) : 64)];
			val >>= 6;
			out[index + 2] = alphabet[(trip ? (val & 0x3F) : 64)];
			val >>= 6;
			out[index + 1] = alphabet[val & 0x3F];
			val >>= 6;
			out[index + 0] = alphabet[val & 0x3F];
		}
		return out;
	}

	public static byte[] decode(String s) {
		return decode(s.toCharArray());
	}

	static public byte[] decode(char[] data) {
		int tempLen = data.length;
		int clen = data.length;
		byte[] codes = Base64.codes;
		for(int ix = 0; ix < clen; ix++){
			if((data[ix] > 255) || codes[data[ix]] < 0) --tempLen; // ignore
																	// non-valid
																	// chars and
																	// padding
		}

		int len = (tempLen >> 2) * 3;
		if((tempLen & 3) == 3){
			len += 2;
		}
		else if((tempLen & 3) == 2){
			len++;
		}
		byte[] out = new byte[len];

		int shift = 0; // # of excess bits stored in accum
		int accum = 0; // excess bits
		int index = 0;

		// we now go through the entire array (NOT using the 'tempLen' value)
		for(int ix = 0; ix < clen; ix++){
			int value = (data[ix] > 255) ? -1 : codes[data[ix]];

			if(value >= 0){ // skip over non-code
				accum <<= 6; // bits shift up by 6 each time thru
				shift += 6; // loop, with new bits being put in
				accum |= value; // at the bottom.
				if(shift >= 8){ // whenever there are 8 or more shifted in,
					shift -= 8; // write them out (from the top, leaving any
					out[index++] = // excess at the bottom for next iteration.
					(byte)((accum >> shift) & 0xff);
				}
			}
		}

		// if there is STILL something wrong we just have to throw up now!
		if(index != out.length){
			throw new Error("Miscalculated data length (wrote " + index
					+ " instead of " + out.length + ")");
		}

		return out;
	}

	final static private char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/="
			.toCharArray();

	final static private byte[] codes = new byte[256];
	static{
		for(int i = 0; i < 256; i++)
			codes[i] = -1;
		for(int i = 'A'; i <= 'Z'; i++)
			codes[i] = (byte)(i - 'A');
		for(int i = 'a'; i <= 'z'; i++)
			codes[i] = (byte)(26 + i - 'a');
		for(int i = '0'; i <= '9'; i++)
			codes[i] = (byte)(52 + i - '0');
		codes['+'] = 62;
		codes['/'] = 63;
	}

}
