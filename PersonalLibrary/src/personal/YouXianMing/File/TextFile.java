package personal.YouXianMing.File;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import personal.YouXianMing.Debug.DebugMessage;

/**
 * 以文本流的形式读取文件
 * 
 * @author YouXianMing1987@iCloud.com
 */
public class TextFile {

	/**
	 * 文件路径
	 */
	private String path = null;

	/**
	 * 文本内容(执行了startConvert之后才能够读取)
	 */
	private String content = null;

	public TextFile(String path) {

		this.setPath(path);
	}

	/**
	 * 直接获取文件文本
	 * 
	 * @param path
	 *            文件路径
	 * @return 成功则返回文本,失败返回空
	 */
	public static String withFilePath(String path) {

		TextFile file = new TextFile(path);

		if (file.startConvert()) {

			return file.content;

		} else {

			return null;
		}
	}

	/**
	 * 给定文件路径后开始转换数据
	 * 
	 * @return 成功或者失败
	 */
	public boolean startConvert() {

		boolean result = true;
		BufferedReader bufferReader = null;

		if (/* 文件路径为空 */ path == null) {

			result = false;
			DebugMessage.output(DebugMessage.stack(), "给定的文件路径为空");

		} /* 文件路径不为空 */ else {

			boolean ioOperationIsSuccess = true;

			// 读取文件
			try {

				bufferReader = new BufferedReader(new FileReader(this.path));

			} catch (FileNotFoundException e) {

				result = false;
				ioOperationIsSuccess = false;
				e.printStackTrace();
			}

			// 如果读取文件成功,则开始读取文本
			if (ioOperationIsSuccess == true) {

				StringBuffer buffer = new StringBuffer();

				try {

					String contentLine = null;

					while ((contentLine = bufferReader.readLine()) != null) {

						buffer.append(contentLine);
					}

					this.content = buffer.toString();

				} catch (IOException e) {

					result = false;
					ioOperationIsSuccess = false;
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	public String getPath() {

		return path;
	}

	public void setPath(String path) {

		this.path = path;
	}

	public String getContent() {

		return content;
	}
}
