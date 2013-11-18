package no.finntech.example.controller;

import org.apache.commons.io.IOUtils;
import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.ListAttribute;
import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.ApplicationResource;
import org.apache.tiles.request.servlet.ServletRequest;
import org.apache.tiles.request.servlet.ServletUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/tiles")
public final class TilesController {

    @RequestMapping(value = "template/{definitionName}/{attributeName:.+}", method = RequestMethod.GET)
    public static void fetchTemplateDefinition(
            @PathVariable("definitionName") final String definitionName,
            @PathVariable("attributeName") final String attributeName,
            final HttpServletRequest request,
            final HttpServletResponse response) throws ServletException, IOException {

        final ApplicationContext tilesContext = ServletUtil.getApplicationContext(request.getSession().getServletContext());
        final TilesContainer tilesContainer = getTilesContainer(tilesContext);
        final ServletRequest servletRequest = new ServletRequest(tilesContext, request, response);
        final String templatePath = getTemplatePath(definitionName, attributeName, tilesContainer, servletRequest);
        final InputStream templateStream = loadResourceInputStream(templatePath, tilesContext);
        IOUtils.copy(templateStream, response.getOutputStream());
    }

    private static TilesContainer getTilesContainer(ApplicationContext tilesContext) throws ServletException {
        TilesContainer container = TilesAccess.getContainer(tilesContext);
        if (container == null) {
            throw new ServletException("Tiles container is not initialized. "
                    + "Have you added a TilesConfigurer to your web application context?");
        }
        return container;
    }

    private static String getTemplatePath(
            final String definitionName,
            final String attributeName,
            final TilesContainer container,
            final ServletRequest request) {

        final Definition definition = container.getDefinition(definitionName, request);
        final Attribute attribute = definition.getAttribute(attributeName);
        return (String) attribute.getValue();
    }

    private static InputStream loadResourceInputStream(final String templatePath, final ApplicationContext tilesContext)
            throws IOException {

        final ApplicationResource resource = tilesContext.getResource(templatePath);
        return resource.getInputStream();
    }

}
