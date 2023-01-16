package com.mycompany;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.list.Loop;
import org.apache.wicket.markup.html.list.LoopItem;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.List;

public class Listed<T> extends Panel {
    IModel<T> model;
    List<T> items;
    public Listed(String id, IModel<T> model, List<T> items) {
        super(id);
        this.model = model;
        this.items = items;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new Loop("items", items.size()) {
            @Override
            protected void populateItem(LoopItem loopItem) {
                int index = loopItem.getIndex();
                loopItem.add(new Button("option") {
                    @Override
                    protected void onInitialize() {
                        super.onInitialize();
                        add(new Label("label", Model.of("label" + index)));
                    }
                });
            }
        });
    }
}
