package personal.YouXianMing.Gson;

import com.google.gson.Gson;

public class GsonHelper {

	/**
	 * 直接从Json字符串获取到Model对象
	 * 
	 * @param jsonString
	 *            Json字符串
	 * @param objClass
	 *            Model对象对应的类
	 * @return Model对象
	 */
	public static <T> T ModelFromJsonString(String jsonString, Class<T> objClass) {

		Gson gson = new Gson();
		return gson.fromJson(jsonString, objClass);
	}

	/**
	 * 直接用Model转化成Json字符串
	 * 
	 * @param model
	 *            model对象
	 * @return 转换好的字符串
	 */
	public static <T> String ToJsonStringWithModel(T model) {

		Gson gson = new Gson();
		return gson.toJson(model);
	}
}
