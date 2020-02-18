package org.vaadin.joacim;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.router.RouterLink;

@CssImport("./styles/shared-styles.css")
public class MainLayout extends AppLayout {

    public MainLayout() {
        ListItem home = new ListItem(new RouterLink("Home", HomeView.class));
        ListItem accounts = new ListItem(new RouterLink("Accounts", AccountsView.class));
        ListItem payments = new ListItem(new RouterLink("Payments", PaymentsView.class));
        UnorderedList list = new UnorderedList(home, accounts, payments);
        Nav navigation = new Nav(list);

        Header header = new Header();
        header.add(new DrawerToggle(), new RouterLink("MyApp", HomeView.class));

        addToDrawer(navigation);
        addToNavbar(header);
    }
}
