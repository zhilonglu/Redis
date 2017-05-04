package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
/*
 * �򵥵�Java��ȡredis���� 
 */
public class redisRead {
	static Set<HostAndPort> clusterNodes;
	static JedisCluster jc;
	public static void init(){
		clusterNodes = new HashSet<HostAndPort>();
		clusterNodes.add(new HostAndPort("192.168.1.15",16381));
		jc = new JedisCluster(clusterNodes);
	}
	/* 
	 * ����redis���ݿ⣬�������ݲ���ȡ����
	 */
	public static void createAndGet(){
		init();
		jc.set("foo", "bar2");
		String value = jc.get("foo");
		System.out.println(value);
	}
	public static void main(String[] args) {
		createAndGet();
	}
}