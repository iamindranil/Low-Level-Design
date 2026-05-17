
public class InfoLogProcessor extends LogProcessor{

	InfoLogProcessor(LogProcessor nextLogProcessor) {
		super(nextLogProcessor);
	}
	
	public void log(int logLevel,String msg) {
		if(logLevel==INFO) {
			System.out.println("Info: "+msg);
		}else {
			super.log(logLevel, msg);
		}
	}

}
