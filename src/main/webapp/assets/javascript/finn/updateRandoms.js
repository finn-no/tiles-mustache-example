/*global jQuery, bartefrans*/
var FINN = FINN || {};
(function($, bartefrans) {
    "use strict";

    $('[data-random-container]').on('click', '[data-random-control]', function(){
        var $container = $(this).closest('[data-random-container]');

        bartefrans.renderTemplateWithDataFromUrl('/tiles/template/page.random/body.updateable', '/random.json', function(err, content) {
            if (err) {
                console.error('Error while rendering Mustache template!', err);
                return;
            }

            $container.html(content);
        });
    });

})(jQuery, bartefrans);