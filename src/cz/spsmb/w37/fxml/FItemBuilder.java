package cz.spsmb.w37.fxml;

import javafx.util.Builder;

public class FItemBuilder implements Builder<EItem> {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public EItem build() {
        return new EItem(id, name);
    }
}