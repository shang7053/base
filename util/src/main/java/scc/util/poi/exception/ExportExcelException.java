package scc.util.poi.exception;

/**
 * 
 * @ClassName: ExportExcelException 
 * @Description: poi导出异常
 * @author scc
 * @date 2014年11月6日 下午12:42:58 
 *
 */
public class ExportExcelException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8680545016797100897L;
	public ExportExcelException(){
		super();
	}
	public ExportExcelException(Throwable e) {
		super(e);
	}
	public ExportExcelException(String msg){
		super(msg);
	}
	public ExportExcelException(String msg, Throwable e){
		super(msg, e);
	}
}
