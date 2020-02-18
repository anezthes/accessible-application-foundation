package org.vaadin.joacim;

import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Home | MyApp")
@Route(value = "", layout = MainLayout.class)
public class HomeView extends Main {

    public HomeView() {
        add(
                new H1("Home"),
                new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
        );

        for (ButtonVariant variant : new ButtonVariant[] {
                ButtonVariant.LUMO_SMALL,
                ButtonVariant.LUMO_LARGE,
                ButtonVariant.LUMO_TERTIARY,
                ButtonVariant.LUMO_TERTIARY_INLINE,
                ButtonVariant.LUMO_PRIMARY,
                ButtonVariant.LUMO_SUCCESS,
                ButtonVariant.LUMO_ERROR,
                ButtonVariant.LUMO_CONTRAST,
                ButtonVariant.LUMO_ICON
        }) {
            NativeButton button = new NativeButton("Button");
            button.addClassName(variant.getVariantName());
            add(button);
        }
    }
}
