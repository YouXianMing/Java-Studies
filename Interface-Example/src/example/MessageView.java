
package example;

public class MessageView implements MessageInfo {

	private MessageInfo messageInfo;
	
	@Override
	public String errorMessage() {
		
		return getClass().getName();
	}

	public MessageInfo getMessageInfo() {
		
		return messageInfo;
	}

	public void setMessageInfo(MessageInfo messageInfo) {
		
		this.messageInfo = messageInfo;
	}
}



