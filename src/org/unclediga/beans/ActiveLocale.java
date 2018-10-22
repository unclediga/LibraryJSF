package org.unclediga.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Locale;

@Named
@SessionScoped
@FacesConfig
public class ActiveLocale implements Serializable {

    @Inject
    private FacesContext context;
    private Locale current;

    @PostConstruct
    public void init(){

        Application application = context.getApplication();
        current = application.getViewHandler().calculateLocale(context);


    }

    public Locale getCurrent() {
        return current;
    }

    public String getLanguageTag(){
        return current.toLanguageTag();
    }
}
