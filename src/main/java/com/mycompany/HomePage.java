package com.mycompany;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestHandler;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);
		add(new WebMarkupContainer("test") {
			Label label;

			@Override
			protected void onInitialize() {
				WebMarkupContainer it = this;
				super.onInitialize();
				Model<Integer> model = Model.of(0);
				add(label = new Label("count", model) {
					@Override
					protected void onConfigure() {
						super.onConfigure();
						System.out.println("onConfigureLabel");
					}
				});
				label.setOutputMarkupId(true);
				add(new Button("testBtn") {
					@Override
					protected String getOnClickScript() {
						super.getOnClickScript();
						return "alert(\"Hello World\")";
					}
				});

				add(new AjaxLink("countUpBtn") {
					@Override
					public void onClick(AjaxRequestTarget target) {
						System.out.println("onClick" + model.getObject());
						model.setObject(model.getObject() + 1);
						target.add(label);
					}
				});


				System.out.println("onInitialize");
			}

			@Override
			protected void onConfigure() {
				super.onConfigure();
				System.out.println("onConfigure");
			}

			@Override
			protected void checkHierarchyChange(Component component) {
				super.checkHierarchyChange(component);
				System.out.println("checkHierarchyChange");
			}
		});

		add(new Child("child"));
	}
}
