package org.vaadin.joacim;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Tag("button")
public class A11yButton extends NativeButton {

	private Icon icon;
	private boolean iconAfterText;

	public A11yButton() {
	}

	public A11yButton(String text) {
		add(new Span(text));
	}

	public A11yButton(String text, ComponentEventListener<ClickEvent<NativeButton>> clickListener) {
		add(new Span(text));
		addClickListener(clickListener);
	}

	public void setIcon(VaadinIcon icon) {
		if (this.icon != null) {
			remove(this.icon);
		}

		this.icon = icon.create();
		if (icon != null) {
			updateIconSlot();
		}

		updateThemeAttribute();
	}

	public void setIconAfterText(boolean iconAfterText) {
		this.iconAfterText = iconAfterText;
		if (icon != null) {
			updateIconSlot();
		}
	}

	private void updateIconSlot() {
		if (icon.getParent().isPresent()) {
			remove(icon);
		}

		if (iconAfterText) {
			getElement().insertChild(1, icon.getElement());
		} else {
			getElement().insertChild(0, icon.getElement());
		}
	}

	public void addThemeVariants(ButtonVariant... variants) {
		getClassNames().addAll(Stream.of(variants).map(ButtonVariant::getVariantName).collect(Collectors.toList()));
	}

	public void removeThemeVariants(ButtonVariant... variants) {
		getClassNames().removeAll(Stream.of(variants).map(ButtonVariant::getVariantName).collect(Collectors.toList()));
	}

	private void updateThemeAttribute() {
		if (getElement().getChildCount() == 1 && icon != null) {
			getClassNames().add(ButtonVariant.LUMO_ICON.getVariantName());
		} else {
			getClassNames().remove(ButtonVariant.LUMO_ICON.getVariantName());
		}
	}
}
