package com.mycompany;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import java.util.Arrays;
import java.util.List;

public class Child extends Panel {
    public Child(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        Model<Integer> model = Model.of(0);
        Label label = new Label("count", model) {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                setOutputMarkupId(true);
            }
        };
        add(label);
        add(new AjaxLink("countUp") {

            @Override
            public void onClick(AjaxRequestTarget ajaxRequestTarget) {
                model.setObject(model.getObject() + 1);
                ajaxRequestTarget.add(label);
            }
        });
        List<String> list = Arrays.asList("foo", "bar", "hoge");
        add(new Listed("listed", Model.of("foo"), list));
    }

    class ListedItem {

    }
}
