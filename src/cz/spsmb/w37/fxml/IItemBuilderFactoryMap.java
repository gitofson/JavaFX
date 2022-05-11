// ItemBuilderFactoryMap.java
package cz.spsmb.w37.fxml;

import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;

public class IItemBuilderFactoryMap implements BuilderFactory {
	private final JavaFXBuilderFactory fxFactory = new JavaFXBuilderFactory();

	@Override
	public Builder<?> getBuilder(Class<?> type) {
		if (type == EItem.class) {
			return new HItemBuilderMap();
		}
		return fxFactory.getBuilder(type);
	}
}
