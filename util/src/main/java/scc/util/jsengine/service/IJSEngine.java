package scc.util.jsengine.service;
/**
 * 
 * 敲每个点号时，考虑：
 * 会不会出现空指针？
 * 有没有异常抛出？
 * 是不是在热点区域？
 * 在哪个线程执行？
 * 有没有并发锁间隙？
 * 会不会并发修改不可见？
 * @author scc
 *
 */
public interface IJSEngine {
	String getStringReturn(String jsFile,String functionname);
	String getStringReturnByRealPath(String jsFile,String functionname);
}
