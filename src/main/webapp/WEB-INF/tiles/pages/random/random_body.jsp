<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<p>This example renders a mustache template serverside on the initial pageload, then clientside for all subsequent updates.</p>
<p>Clicking the button below trigger these steps:</p>
<ol>
    <li>Retrieve JSON from server on URL: /random.json</li>
    <li>Retrieve content (mustache template) of Tiles attribute "body.updateable" defined in "page.random" from server on URL: /tiles/template/page.random/body.updateable</li>
    <li>Use mustache.js to render mustache template with retrieved JSON as data</li>
    <li>Insert the rendered content into the container div-element</li>
</ol>

<div data-random-container>
    <tiles:insertAttribute name="body.updateable" />
</div>