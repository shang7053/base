package com.voole.datasync.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @ProjectName ：data_sync_admin   
 * @ClassName：DateUtils   
 * @Description：   时间工具类
 * @author：Ma Zhen   
 * @date：2017-5-18       
 * @version
 */
public class DateUtils {
  
  /**
   * 
   * @param time
   * @return
   * @throws ParseException 
   * @Description: 时间格式转换到小时
   * @author： Ma Zhen
   * @createTime： 2017-5-18
   */
  public static String convertDateStringHour(String time) throws ParseException{
    
    Date date=null;  
    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH");  
    date=formatter.parse(time);  
    
    SimpleDateFormat myFmt=new SimpleDateFormat("yyyyMMddHH");        
    return myFmt.format(date);
  }
  
  /**
   * 
   * @param dt
   * @return
   * @Description: 时间格式转换到小时
   * @author： Ma Zhen
   * @createTime： 2017-5-18
   */
  public static String converLongDateStringHour(Date dt){
    SimpleDateFormat myFmt=new SimpleDateFormat("yyyyMMddHH");        
    return myFmt.format(dt);
  }
  
  
  /**
   * 
   * @param time
   * @return
   * @throws ParseException 
   * @Description: 时间格式转换到天
   * @author： Ma Zhen
   * @createTime： 2017-5-18
   */
  public static String convertDateStringDay(String time) throws ParseException{
    
    Date date=null;  
    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");  
    date=formatter.parse(time);  
    
    SimpleDateFormat myFmt=new SimpleDateFormat("yyyyMMdd");        
    return myFmt.format(date);
  }
  
  /**
   * 
   * @param dt
   * @return
   * @Description: 时间格式转换到天
   * @author： Ma Zhen
   * @createTime： 2017-5-18
   */
  public static String converLongDateStringDay(Date dt){
    SimpleDateFormat myFmt=new SimpleDateFormat("yyyyMMdd");        
    return myFmt.format(dt);
  }
  
  
  
  

}
