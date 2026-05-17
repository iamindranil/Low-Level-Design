
public class Main {

	public static void main(String[] args) {
		LogProcessor logObj=new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
		logObj.log(LogProcessor.ERROR, "Err msg");
		logObj.log(LogProcessor.INFO, "Info msg");
		logObj.log(LogProcessor.DEBUG, "Debug msg");

	}

}
