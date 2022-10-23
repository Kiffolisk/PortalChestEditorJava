package com.gamersunite.pceditor;

public class PortalChestItem {
	
	public PortalChestItem(String item) {
		itemName = item;
	}
	
	public PortalChestItem() {
		
	}
	
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	
	public byte[] BlockheadsItemData() {
		String resultData = "";
		for (int i = 0; i < pcEditorMain.my.normals.length; i++) {
			if (pcEditorMain.my.normals[i] == itemName) {
				String hexed = pcEditorMain.my.hexes[i].replace("0x", "");
				char[] resultHexChars = {'0', '0', '0', '0'};
				if (hexed.length() >= 3) {
					resultHexChars[3] = hexed.charAt(0);
					resultHexChars[0] = hexed.charAt(1);
					resultHexChars[1] = hexed.charAt(2);
				}
				if (hexed.length() == 2) {
					resultHexChars[0] = hexed.charAt(0);
					resultHexChars[1] = hexed.charAt(1);
				}
				if (hexed.length() == 1) {
					if ("0123456789".indexOf(hexed) != -1) {
						resultHexChars[3] = hexed.charAt(0);
					}else {
						resultHexChars[1] = hexed.charAt(0);
					}
				}
				String resultHex = "";
				for (char a : resultHexChars) {
					resultHex += a;
				}
				resultData = resultHex;
			}
		}
		resultData += "000000000000";
		return hexStringToByteArray(resultData);
	}
	
	public String itemName = "CLOTHING";
	public int count = 0;
}
