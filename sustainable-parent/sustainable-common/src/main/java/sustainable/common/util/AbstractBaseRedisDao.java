/**   
* @Title: AbstractBaseRedisDao.java 
* @Package sustainable.common.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月22日 下午5:07:37   
*/
package sustainable.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @ClassName: AbstractBaseRedisDao
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年1月22日 下午5:07:37
 * 
 */
public abstract class AbstractBaseRedisDao<K, V> {

    @Autowired
    protected RedisTemplate<K, V> redisTemplate;

    /**
     * 设置redisTemplate
     * 
     * @param redisTemplate the redisTemplate to set
     */
    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 获取 RedisSerializer
     * <br>
     * ------------------------------<br>
     */
    protected RedisSerializer<String> getRedisSerializer() {
        return this.redisTemplate.getStringSerializer();
    }
}
