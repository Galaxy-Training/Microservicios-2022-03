package pe.edu.galaxy.java.spring.boot.redis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.java.spring.boot.redis.model.Taller;

@Slf4j
@Repository

@SuppressWarnings("rawtypes")
public class TallerRepository {

	public static final String TALLER_KEY = "TALLER";

	private HashOperations hashOperations;// PreparedStatemnt

	private RedisTemplate redisTemplate;  // Connection

	public TallerRepository(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;

		this.hashOperations = this.redisTemplate.opsForHash(); //K,V
	}

	@SuppressWarnings("unchecked")
	public void save(Taller taller) {
		log.info("save...");
		hashOperations.put(TALLER_KEY, taller.getId(), taller);
	}

	@SuppressWarnings("unchecked")
	public List<Taller> findAll() {
		log.info("findAll...");
		return hashOperations.values(TALLER_KEY);
	}

	@SuppressWarnings("unchecked")
	public Taller findById(String id) {
		log.info("findById...");
		return (Taller) hashOperations.get(TALLER_KEY, id);
	}

	
	public void update(Taller taller) {
		log.info("update...");
		save(taller);
	}

	@SuppressWarnings("unchecked")
	public void delete(String id) {
		log.info("delete...");
		hashOperations.delete(TALLER_KEY, id);
	}

}
