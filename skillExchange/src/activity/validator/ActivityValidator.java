package activity.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import activity.bean.ActivityBean;

public class ActivityValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
//		System.out.println(clazz.getName());
		boolean b = ActivityBean.class.isAssignableFrom(clazz);
		return b;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ActivityBean activity = (ActivityBean) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "", "請填寫活動名稱");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "", "請選擇活動類別");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "beginDay", "", "請選擇活動開始日期");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "beginTime", "", "請選擇活動開始時間");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDay", "", "請選擇活動結束日期");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endTime", "", "請選擇活動結束時間");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "position", "", "請選擇活動地點");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dialog", "", "請勾選");

//		if (ActivityBean.getAccount().length() < 5) {
//			errors.rejectValue("account", "", "帳號欄不能小於五個字元");
//		}
////		Double d = member.getWeight();
//
//		if (ActivityBean.getCategory().getId() == -1) {
//			errors.rejectValue("category", "", "必須挑選分類欄的選項");
//		}
//		if (ActivityBean.getHobby().getId() == -1) {
//			errors.rejectValue("hobby", "", "必須挑選嗜好欄的選項");
//		}

	}

}
