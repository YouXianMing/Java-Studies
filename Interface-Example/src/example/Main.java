package example;

public class Main {

	public static void main(String args[]) {
		
		MessageView view = new MessageView();
		
		view.setMessageInfo(new MessageInfo() {
			
			String name = "MessageInfoObject";
			
			@Override
			public String errorMessage() {

				return name;
			}
		});
				
		System.out.println(view.errorMessage());
		System.out.println(view.getMessageInfo().errorMessage());
	}
}



