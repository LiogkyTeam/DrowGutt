package org.test.ui;

import com.vaadin.annotations.Push;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.*;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.*;
import com.vaadin.*;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;
import org.test.Canvas;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;

import java.awt.*;

@Theme("demo")
@SuppressWarnings("serial")
@Push
public class UI extends com.vaadin.ui.UI
{
    public static Rooms rooms = new Rooms();
    public static Authentication AUTH;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = UI.class)
    public static class Servlet extends VaadinServlet {
    }


    @Override
    protected void init(VaadinRequest request) {
        AUTH = new Authentication();

	    new Navigator(this, this);
	    getNavigator().addView(LoginPage.NAME, LoginPage.class);
	    getNavigator().setErrorView(LoginPage.class);
	/*
	Page.getCurrent().addUriFragmentChangedListener(new Page.UriFragmentChangedListener() {
		@Override
        	public void uriFragmentChanged(Page.UriFragmentChangedEvent event) {
                 	router(event.getUriFragment());
	        }
	});

	router(""); */
    }
    /*
    private void router(String route){
		Notification.show(route);
		if(getSession().getAttribute("user") != null){
			getNavigator().addView(SecurePage.NAME, SecurePage.class);
			getNavigator().addView(OtherSecurePage.NAME, OtherSecurePage.class);
			if(route.equals("!OtherSecure")){
				getNavigator().navigateTo(OtherSecurePage.NAME);
			}else{
				getNavigator().navigateTo(SecurePage.NAME);
			}
		}else{
			getNavigator().navigateTo(LoginPage.NAME);
		}
	} */
}
