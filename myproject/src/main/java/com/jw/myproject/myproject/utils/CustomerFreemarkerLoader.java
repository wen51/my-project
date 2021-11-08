package com.jw.myproject.myproject.utils;

import freemarker.cache.URLTemplateLoader;

import java.net.URL;

/**
 * @author lijw
 * @date 2021/11/4 18:52
 */
public class CustomerFreemarkerLoader extends URLTemplateLoader {
    /**
     * Given a template name (plus potential locale decorations) retrieves
     * an URL that points the template source.
     *
     * @param name the name of the sought template, including the locale
     *             decorations.
     * @return an URL that points to the template source, or {@code null} if the template does not exist.
     */
    @Override
    protected URL getURL(String name) {
        return null;
    }
}
