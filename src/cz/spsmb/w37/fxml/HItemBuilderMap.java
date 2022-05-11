// ItemBuilderMap.java
package cz.spsmb.w37.fxml;

import javafx.util.Builder;

import java.util.AbstractMap;
import java.util.Set;

public class HItemBuilderMap extends AbstractMap<String, Object> implements Builder<EItem> {
	private String name;
	private Long id;
	
	@Override
	public Object put(String key, Object value) {
		if ("name".equals(key)) {
			this.name = (String)value;
		} else if ("id".equals(key)) {
			this.id = Long.valueOf((String)value);
		} else {
			throw new IllegalArgumentException("Unknown Item property: " + key);
		}

		return null;
	}
	
	@Override
	public Set<Entry<String, Object>> entrySet() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EItem build() {
		return new EItem(id, name);
	}
}
