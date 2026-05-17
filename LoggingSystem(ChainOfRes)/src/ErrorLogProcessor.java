
public class ErrorLogProcessor extends LogProcessor{

	ErrorLogProcessor(LogProcessor nextLogProcessor) {
		super(nextLogProcessor);
	}
	
	public void log(int logLevel,String msg) {
		if(logLevel==ERROR) {
			System.out.println("Err: "+msg);
		}else {
			super.log(logLevel, msg);
		}
	}

}
