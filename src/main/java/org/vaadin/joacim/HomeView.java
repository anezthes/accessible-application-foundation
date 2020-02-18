package org.vaadin.joacim;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.VaadinIcon;
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

        A11yButton b1 = new A11yButton("Button");
        b1.setIcon(VaadinIcon.CHECK_CIRCLE);

        A11yButton b2 = new A11yButton("Button");
        b2.setIcon(VaadinIcon.CHECK_CIRCLE);
        b2.setIconAfterText(true);

        add(b1, b2);
    }
}
