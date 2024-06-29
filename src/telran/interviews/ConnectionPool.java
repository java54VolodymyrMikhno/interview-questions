package telran.interviews;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConnectionPool {
	 int size;
   LinkedHashMap<Long, Connection> map;

	public ConnectionPool(int size) {
		this.size = size;
		map = new LinkedHashMap<Long, Connection>(size, 0.75f, true) {

			@Override
			protected boolean removeEldestEntry(Map.Entry<Long, Connection> e) {
				return size() > ConnectionPool.this.size;
			}
		};
	}

	public Connection getConnection(Connection connection) {
		return map.computeIfAbsent(connection.id(), k -> connection);
	}

	public boolean isInPool(long id) {
		return map.containsKey(id);
	}

	
}
