package com.joyworks.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.joyworks.entity.Consignee;
import com.joyworks.finalmessage.ErrorHintMessage;

public class VerifyFieldUtil {

	public static String verifyConsigneeMessage(Consignee consignee) {
		// 验证用户名称是否为空
		if (consignee.getName() == null || "".equals(consignee.getName())) {
			return ErrorHintMessage.CONSIGNEE_NAME_EMPTY;
		}
		// 验证收货地址是否为空
		if (consignee.getAddress() == null || "".equals(consignee.getAddress())) {
			return ErrorHintMessage.CONSIGNEE_ADDRESS_EMPTY;
		}
		boolean flag = true;
		Pattern pattern = null;
		// 验证电话号码格式是否正确
		String tel = consignee.getTel();
		if (tel == null) {
			flag = false;
		} else {

			pattern = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");

			Matcher matcher = pattern.matcher(tel);

			flag = matcher.matches();
		}
		if (!flag) {
			return ErrorHintMessage.TEL_FORMAY_ERROR;
		}
		// 验证邮箱格式是否正确
		String email = consignee.getEmail();
		flag = true;
		if (email == null) {
			flag = false;
		} else {
			pattern = Pattern.compile(
					"^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");

			Matcher matcher = pattern.matcher(email);

			flag = matcher.matches();
		}
		if (!flag) {
			return ErrorHintMessage.EMAIL_FORMAY_ERROR;
		}
		// 验证邮编是否正确

		flag = true;
		String postcode = consignee.getPostcode();
		if (postcode == null) {
			flag = false;
		} else {
			pattern = Pattern.compile("[1-9]\\d{5}");
			flag = pattern.matcher(postcode).matches();
		}
		if (!flag) {
			return ErrorHintMessage.POSTCODE_FORMAY_ERROR;
		}
		return null;
	}
}
