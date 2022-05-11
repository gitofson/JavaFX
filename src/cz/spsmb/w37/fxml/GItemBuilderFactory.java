// ItemBuilderFactory.java
package cz.spsmb.w37.fxml;

import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;

public class GItemBuilderFactory implements BuilderFactory {
	private final JavaFXBuilderFactory fxFactory = new JavaFXBuilderFactory();

	@Override
	public Builder<?> getBuilder(Class<?> type) {
		// You supply a Builder only for Item type
		if (type == EItem.class) {
			return new FItemBuilder();
		}

		// Let the default Builder do the magic
		return fxFactory.getBuilder(type);
	}
}
